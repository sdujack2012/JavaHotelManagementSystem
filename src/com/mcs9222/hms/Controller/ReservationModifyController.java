/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcs9222.hms.Controller;

import com.mcs9222.hms.Entity.Customer;
import com.mcs9222.hms.Entity.Orders;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author YEXIAO
 */
public class ReservationModifyController extends Controller{
    private JTextField reservationPhoneTextField;
    private JTable reservationOrderTable;
    
    public ReservationModifyController(JTextField reservationPhoneTextField, JTable reservationOrderTable){
        this.reservationPhoneTextField = reservationPhoneTextField;
        this.reservationOrderTable = reservationOrderTable;
        
    }
    
    public void searchOrder(){
        if(!this.reservationPhoneTextField.getText().equals("") && this.reservationPhoneTextField != null){
            this.reservationOrderTable.setModel(new ModifyTableModel(this.reservationPhoneTextField.getText()));
        }
        else{
            JOptionPane.showMessageDialog(null, "No name entered", "Warning", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void deleteRoom(){
        if(this.reservationOrderTable.getModel().getRowCount()==0) return;
        Query q = this.em.createNamedQuery("Orders.findById");
        ModifyTableModel mtd=(ModifyTableModel)this.reservationOrderTable.getModel();
        Integer oid = (Integer)mtd.getOrderID(this.reservationOrderTable.getSelectedRow());
        mtd.removeRow(this.reservationOrderTable.getSelectedRow());
        mtd.fireTableDataChanged();
        q.setParameter("id", oid);
        Orders order = (Orders)q.getSingleResult();
        em.getTransaction().begin();
        em.remove(order);
        em.getTransaction().commit();
        
    }
    public void modifyOrder(){
        if(this.reservationOrderTable.getModel()==null) return;
        int col=this.reservationOrderTable.getSelectedColumn();
        int row=this.reservationOrderTable.getSelectedRow();

        ModifyTableModel mtd=(ModifyTableModel)this.reservationOrderTable.getModel();
        if(col!=4&&col!=5)
            return;
        Date value;
        try{
            value = new SimpleDateFormat("dd/MM/yy hh:mm:ss").parse((String)mtd.getValueAt(row, col));
        }
        catch(Exception e){
            e.printStackTrace();
            return;
        }
        Query q = this.em.createNamedQuery("Orders.findById");
        
        Integer oid = (Integer)mtd.getOrderID(this.reservationOrderTable.getSelectedRow());
        q.setParameter("id", oid);
        Orders order = (Orders)q.getSingleResult();
        switch (col) {
                case 4:
                    order.setExpectedCheckinTime(value);
                    break;
                case 5:
                    order.setExpectedCheckoutTime(value);
                    break;
        }
        em.getTransaction().begin();
        em.persist(order);
        em.getTransaction().commit();
        em.refresh(order);
    }
       
   
    private class ModifyTableModel extends AbstractTableModel {
        
        private String strPhone = null;
        private ArrayList<String> alRoomNo = new ArrayList<>();
        private ArrayList<String> alRoomType = new ArrayList<>();
        private ArrayList<String> alStartDate = new ArrayList<>();
        private ArrayList<String> alEndDate = new ArrayList<>();
        private ArrayList<BigDecimal> alPrice = new ArrayList<>();
        private ArrayList<Integer> alOrderID = new ArrayList<>();
        private ArrayList<String> alCustomer = new ArrayList<>();
        private ArrayList<String> alCustomerPhone = new ArrayList<>();
        
        public ModifyTableModel(String phone) {
            strPhone = phone;
            // to find the customer
            Query q = em.createNamedQuery("Customer.findByName");
            q.setParameter("name", strPhone);
            Collection<Customer> cusCollection;
            try {
                cusCollection = q.getResultList();
            } catch (NoResultException e) {
                JOptionPane.showMessageDialog(null, "No order Found", "Warning", JOptionPane.ERROR_MESSAGE);
                System.err.println(e);
                return;
            }
 
        
            for(Customer c : cusCollection){
                Query query = em.createQuery("select o from Orders o where o.customerId = :Customer and o.orderStatus = :OrderStatus");

                query.setParameter("Customer", c);
                query.setParameter("OrderStatus","booked");
                // to get orders
                Collection<Orders> ordersCollection = query.getResultList();

                if (ordersCollection != null) {
                    for (Orders order : ordersCollection){  
                        try{
                            alCustomer.add(order.getCustomerId().getName());
                            alCustomerPhone.add(order.getCustomerId().getPhone());
                            alRoomNo.add(order.getRoomNo().getRoomNo());
                            alRoomType.add(order.getRoomNo().getType());
                            alStartDate.add(new SimpleDateFormat("dd/MM/yy hh:mm:ss").format(order.getExpectedCheckinTime()));
                            alEndDate.add(new SimpleDateFormat("dd/MM/yy hh:mm:ss").format(order.getExpectedCheckoutTime()));
                            alPrice.add(order.getRoomNo().getPrice());
                            alOrderID.add(order.getId());
                        }
                        catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                }  
            }
            if(alCustomer.isEmpty()){
                JOptionPane.showMessageDialog(null, "No order Found", "Warning", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        @Override
        public int getRowCount() {
            return alRoomNo.size();
        }
        
        @Override
        public int getColumnCount() {
            return 7;
        }
        
        @Override
        public String getColumnName(int col) {
            switch (col) {
                case 0:
                    return "Customer";
                case 1:
                    return "Phone";
                case 2:
                    return "Room Number";
                case 3:
                    return "Room Type";
                case 4:
                    return "Start Date";
                case 5:
                    return "End Date";
                case 6:
                    return "Price";
                
            }
            // to get rid of NetBeans "Missing Return Value" error
            return null;
        }
        
        @Override
        public Object getValueAt(int row, int col) {
            switch (col) {
                case 0:
                    return this.alCustomer.get(row);
                case 1:
                    return this.alCustomerPhone.get(row);
                case 2:
                    return alRoomNo.get(row);
                case 3:
                    return alRoomType.get(row);
                case 4:
                    return alStartDate.get(row);
                case 5:
                    return alEndDate.get(row);
                case 6:
                    return alPrice.get(row);    
            }
            return null;
        }
        public Integer getOrderID(int row){
            return alOrderID.get(row);
        }
        public void removeRow(int row) {
            alCustomer.remove(row);
            alCustomerPhone.remove(row);
            alRoomNo.remove(row);
            alRoomType.remove(row);
            alStartDate.remove(row);
            alEndDate.remove(row);
            alPrice.remove(row);
            alOrderID.remove(row);
            
        }
        @Override
        public boolean isCellEditable(int row, int col) {
            if(col==4||col==5)
                return true;
            return false;

        }
        @Override
        public void setValueAt(Object value, int row, int col) {
            if(col==0){
                alCustomer.set(row,(String)value);
            }
            else if(col==1){
                alCustomerPhone.set(row,(String)value);
            }
            else if(col==2){
                alRoomNo.set(row,(String)value);
            }
            else if(col==3){
                alRoomType.set(row,(String)value);  
            }
            else if(col==4){
                    alStartDate.set(row,(String)value);
            }
            else if(col==5){
                    alEndDate.set(row,(String)value);             
            }
            else if(col==6){
                alPrice.set(row,(BigDecimal)value);
            }  
        }
    }
}
