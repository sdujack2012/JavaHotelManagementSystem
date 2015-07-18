/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcs9222.hms.Controller;

import com.mcs9222.hms.Entity.Customer;
import com.mcs9222.hms.Entity.Orders;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author hz957
 */
public class ServiceCheckoutController extends Controller {
    
    private JTextField tfName = null;
    private JTable tblCheckout = null;
    
    public ServiceCheckoutController(JTextField name, JTable checkout) {
        tfName = name;
        tblCheckout = checkout;
    }
    
    public boolean doSearch() {
        if (tfName.getText().length() == 0)
            return false;
        tblCheckout.setModel(new CheckoutTableModel(tfName.getText()));
        tfName.setText("");
        return ((CheckoutTableModel)tblCheckout.getModel()).hasData();
    }
    
    public BigDecimal doCheckout() {
        return ((CheckoutTableModel)tblCheckout.getModel()).checkout(tblCheckout.getSelectedRow());
    }
    
    public class CheckoutTableModel extends AbstractTableModel {
        
        private String strName = null;
        private ArrayList<String> alRoomNo = new ArrayList<>();
        private ArrayList<Date> alCheckinDate = new ArrayList<>();
        private ArrayList<String> alCheckoutDate = new ArrayList<>();
        private ArrayList<BigDecimal> alPrice = new ArrayList<>();
        private ArrayList<Integer> alOrderID = new ArrayList<>();
        
        public CheckoutTableModel(String name) {
            strName = name;
            em.getEntityManagerFactory().getCache().evictAll();
            // to find the customer
            Query q = em.createNamedQuery("Customer.findByName");
            q.setParameter("name", strName);
            List<Customer> customers = null;
            try {
                customers = q.getResultList();
            } catch (Exception e) {}
            // to get orders
            if (customers != null) {
                for (Customer customer : customers) {
                    Collection<Orders> ordersCollection = customer.getOrdersCollection();
                    if (ordersCollection != null) {
                        Date dateNow = new Date();
                        for (Orders order : ordersCollection) {
                            em.refresh(order);
                            if (order.getOrderStatus().equals("Checked-in")) {
                                alRoomNo.add(order.getRoomNo().getRoomNo());
                                alCheckinDate.add(order.getActualCheckinTime());
                                alCheckoutDate.add("");
                                alPrice.add(order.getTotalPrice());
                                alOrderID.add(order.getId());
                            }
                        }
                    }
                }
            }
        }
        
        @Override
        public int getRowCount() {
            return alRoomNo.size();
        }
        public void removeRow(int row) {
            if(row>alRoomNo.size()) return;
            alRoomNo.remove(row);
            alCheckinDate.remove(row);
            alCheckoutDate.remove(row);
            alPrice.remove(row);
            alOrderID.remove(row);
        }
        @Override
        public int getColumnCount() {
            return 4;
        }
        
        @Override
        public String getColumnName(int col) {
            switch (col) {
                case 0:
                    return "Room Number";
                case 1:
                    return "Checkin Date";
                case 2:
                    return "Checkout Date";
                case 3:
                    return "Price";
            }
            // to get rid of NetBeans "Missing Return Value" error
            return null;
        }
        
        @Override
        public Object getValueAt(int row, int col) {
            switch (col) {
                case 0:
                    return alRoomNo.get(row);
                case 1:
                    return alCheckinDate.get(row);
                case 2:
                    return alCheckoutDate.get(row);
                case 3:
                    return alPrice.get(row);
            }
            return null;
        }
        
        public BigDecimal checkout(int row) {
            // the selected order id
            int id = alOrderID.get(row);
            // to get the order
            Orders order = em.find(Orders.class, id);
            // to update the order
            Date dateCheckout = new Date();
            em.getTransaction().begin();
            order.setActualCheckoutTime(dateCheckout);
            order.setOrderStatus("Checked-out");
            order.setPaymentStatus("Paid");
            em.persist(order);
            em.getTransaction().commit();
            em.refresh(order);
            // table data
            alCheckoutDate.set(row, dateCheckout.toString());
            removeRow(row);
            fireTableDataChanged();
            // the total price
            return order.getTotalPrice();
        }
        
        public boolean hasData() {
            return !alRoomNo.isEmpty();
        }
    }
}
