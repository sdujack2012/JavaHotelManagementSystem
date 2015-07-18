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
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author hz957
 */
public class ServiceCheckinController extends Controller{
    
    private JTextField tfName = null;
    private JTextField tfID = null;
    private JTextField tfCCard = null;
    private JComboBox cbCType = null;
    private JTextField tfExpiry = null;
    private JTable tblOrders = null;
    
    public ServiceCheckinController(JTextField name, JTextField id, JTextField ccard,
            JComboBox ctype, JTextField expiry, JTable orders) {
        tfName = name;
        tfID = id;
        tfCCard = ccard;
        cbCType = ctype;
        tfExpiry = expiry;
        tblOrders = orders;
    }
    
    public boolean doSearch() {
        if (tfName.getText().length() == 0)
            return false;
        tblOrders.setModel(new CheckinTableModel(tfName.getText()));
        boolean bHasData = ((CheckinTableModel)tblOrders.getModel()).hasData();
        if (bHasData == true) {
            tfID.setEnabled(true);
            tfCCard.setEnabled(true);
            cbCType.setEnabled(true);
            tfExpiry.setEnabled(true);
        } else {
            tfID.setEnabled(false);
            tfCCard.setEnabled(false);
            cbCType.setEnabled(false);
            tfExpiry.setEnabled(false);
        }
        return bHasData;
    }
    
    public boolean doCheckin() {
        if (tfName.getText().length() == 0 ||
                tfID.getText().length() == 0 ||
                tfCCard.getText().length() == 0)
            return false;
        int nSel = tblOrders.getSelectedRow();
        Integer orderID = ((CheckinTableModel)tblOrders.getModel()).getSelectedID(nSel);
        // to get the customer
        Orders order = em.find(Orders.class, orderID);
        Customer customer = order.getCustomerId();
        // to update the customer
        tblOrders.getModel().setValueAt(tfName.getName(), nSel, 0);
        em.getTransaction().begin();;
        customer.setName(tfName.getText());
        customer.setIdentification(tfID.getText());
        customer.setCcard(tfCCard.getText());
        customer.setCcardtype((String)cbCType.getSelectedItem());
        em.persist(customer);
        em.getTransaction().commit();
        // to update the order
        BigDecimal price = ((CheckinTableModel)tblOrders.getModel()).getSelectedPrice(nSel);
        em.getTransaction().begin();
        order.setActualCheckinTime(new Date());
        order.setTotalPrice(price);
        order.setOrderStatus("Checked-in");
        em.persist(order);
        em.getTransaction().commit();
        // to remove the checked-in order
        ((CheckinTableModel)tblOrders.getModel()).removeCheckedin(nSel);
        // to clear the text fields
        tfName.setText("");
        tfID.setText("");
        tfCCard.setText("");
        tfExpiry.setText("");
        return true;
    }
    
    private class CheckinTableModel extends AbstractTableModel {
        
        private ArrayList<Integer> alOrderID = new ArrayList<>();
        private ArrayList<String> alName = new ArrayList<>();
        private ArrayList<Date> alCheckin = new ArrayList<>();
        private ArrayList<String> alRoom = new ArrayList<>();
        private ArrayList<String> alType = new ArrayList<>();
        private ArrayList<BigDecimal> alPrice = new ArrayList<>();
        private ArrayList<Date> alCheckout = new ArrayList<>();
        
        private boolean hasData = false;
        
        public CheckinTableModel(String name) {
            em.getEntityManagerFactory().getCache().evictAll();
            // to find the customer
            Query q = em.createNamedQuery("Customer.findByName");
            q.setParameter("name", name);
            List<Customer> customers = null;
            try {
                customers = q.getResultList();
            } catch (Exception e) {
                hasData = false;
            }
            // the orders
            if (customers != null) {
                for (Customer customer : customers) {
                    Collection<Orders> orders = customer.getOrdersCollection();
                    for (Orders o : orders) {
                        if (o.getOrderStatus().equals("Booked")) {
                            hasData = true;
                            alOrderID.add(o.getId());
                            alName.add(o.getCustomerId().getName());
                            alCheckin.add(o.getExpectedCheckinTime());
                            alRoom.add(o.getRoomNo().getRoomNo());
                            alType.add(o.getRoomNo().getType());
                            alPrice.add(o.getRoomNo().getPrice());
                            alCheckout.add(o.getExpectedCheckoutTime());
                        }
                    }
                }
            }
            System.out.println(hasData);
        }
        
        @Override
        public int getRowCount() {
            return hasData == true ? alCheckin.size() : 0;
        }
        
        @Override
        public int getColumnCount() {
            return 5;
        }
        
        @Override
        public String getColumnName(int col) {
            switch (col) {
                case 0:
                    return "Name";
                case 1:
                    return "Expected Checkin";
                case 2:
                    return "Room Number";
                case 3:
                    return  "Room Type";
                case 4:
                    return "Expected Checkout";
                case 5:
                    return "Price";
            }
            return null;
        }
        
        @Override
        public Object getValueAt(int row, int col) {
            switch (col) {
                case 0:
                    return alName.get(row);
                case 1:
                    return alCheckin.get(row);
                case 2:
                    return alRoom.get(row);
                case 3:
                    return alType.get(row);
                case 4:
                    return alCheckout.get(row);
                case 5:
                    return alPrice.get(row);
            }
            return null;
        }
        
        public Integer getSelectedID(int row) {
            return alOrderID.get(row);
        }
        
        public BigDecimal getSelectedPrice(int row) {
            return alPrice.get(row);
        }
        
        public void removeCheckedin(int row) {
            alOrderID.remove(row);
            alName.remove(row);
            alCheckin.remove(row);
            alRoom.remove(row);
            alType.remove(row);
            alPrice.remove(row);
            alCheckout.remove(row);
            fireTableDataChanged();
        }
        
        public boolean hasData() {
            return hasData;
        }
    }
}
