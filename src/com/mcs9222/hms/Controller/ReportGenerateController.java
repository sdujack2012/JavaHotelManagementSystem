/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcs9222.hms.Controller;

import com.mcs9222.hms.Entity.Customer;
import com.mcs9222.hms.Entity.Orders;
import com.mcs9222.hms.Entity.Room;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class ReportGenerateController extends Controller {
     private JTextField StartDateField;
     private JTextField EndDateField;
     private JList reportTypesList;
     private String q;
     private String[] summary;
     public ReportGenerateController(JTextField StartDateField,JTextField EndDateField,JList reportTypesList){
        try {
            this.StartDateField = StartDateField;
            this.EndDateField=EndDateField;
            this.reportTypesList=reportTypesList;
            this.summary=new String[5];
        } catch (Exception ex) {
            ex.printStackTrace();
            
        }
        
    }
    public List<Orders> getArrivalCollection(){
            String reportType =(String) reportTypesList.getSelectedValue();
            Date StartDate;
            Date EndDate;
            List<Orders> orders=null;
            try {
                StartDate= new SimpleDateFormat("dd/MM/yy").parse(StartDateField.getText());
                EndDate=new SimpleDateFormat("dd/MM/yy").parse(EndDateField.getText());
                if(StartDate.compareTo(EndDate)>0)
                    throw new Exception(); 
                if(reportType.equals("Expected Arrivals")){
                    q="select o from Orders o where o.expectedCheckinTime>=:StartDate and o.expectedCheckinTime<=:EndDate";
                }
                else if(reportType.equals("Checkin Report")){
                    q="select o from Orders o where o.actualCheckinTime>=:StartDate and o.actualCheckinTime<=:EndDate";
                }
                else if(reportType.equals("Checkout Report")){
                    q="select o from Orders o where o.actualCheckoutTime>=:StartDate and o.actualCheckoutTime<=:EndDate";
                }
                else if(reportType.equals("Revenue Summary")){
                    q="select o from Orders o where o.actualCheckinTime>=:StartDate and o.actualCheckinTime<=:EndDate";
                }
                else if(reportType.equals("Booking Activity")){
                    q="SELECT o FROM Orders o WHERE o.bookingTime >= :StartDate AND o.bookingTime <= :EndDate";
                }
        
                Query query = em.createQuery(q);
                query.setParameter("StartDate", StartDate);
                query.setParameter("EndDate", EndDate);
                orders = query.getResultList();
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Please enter start date and end date");
            }
            return orders;
            
    } 
    
    public void doRetrieveTableData(JTable reportTable,JLabel reportSummary){
        reportTable.setVisible(true);
        String reportType =(String) reportTypesList.getSelectedValue();
        List<Orders> orders = getArrivalCollection();
        DefaultTableModel tableModel = (DefaultTableModel) reportTable.getModel();
        tableModel.setNumRows(0);
        if(reportType==null) return;
         if(reportType.equals("Expected Arrivals")){
               int number=0;
                for(Orders order : orders ){
                    try{
                        Object[] Revenue = new Object[3];
                        Room r = order.getRoomNo();
                        Customer CustomerNumber = order.getCustomerId();
            
                        Revenue[0]=new SimpleDateFormat("dd/MM/yyyy").format(order.getExpectedCheckinTime());
                        Revenue[1]=CustomerNumber.getName();
                        Revenue[2]=r.getRoomNo();
                        tableModel.insertRow(0,Revenue);
                        number++;
                    }catch(Exception e){
                        //e.printStackTrace();
                    }
                }
                reportSummary.setText("Total number of Expected Arriva: "+number);
                summary[0]= reportSummary.getText();
            }
            else if(reportType.equals("Checkin Report")){
                int number=0;
                for(Orders order : orders ){
                    try{
                        Object[] Revenue = new Object[3];
                        Room r = order.getRoomNo();
                        Customer CustomerNumber = order.getCustomerId();
           
                        Revenue[0]=new SimpleDateFormat("dd/MM/yyyy").format(order.getActualCheckinTime());
                        Revenue[1]=CustomerNumber.getName();
                        Revenue[2]=r.getRoomNo();
                        tableModel.insertRow(0,Revenue);
                        number++;
                    }catch(Exception e){
                        e.printStackTrace();
                
                    }
                    reportSummary.setText("Total number of checkin: "+number);
                    summary[1]= reportSummary.getText();
                }  
            }
            else if(reportType.equals("Checkout Report")){
                int number=0;
                for(Orders order : orders ){
                    Object[] Revenue = new Object[3];
                    try{
                        Room r = order.getRoomNo();
                        Customer CustomerNumber = order.getCustomerId();
                        Revenue[0]=new SimpleDateFormat("dd/MM/yyyy").format(order.getActualCheckoutTime());
                        Revenue[1]=CustomerNumber.getName();
                        Revenue[2]=r.getRoomNo();
                        tableModel.insertRow(0,Revenue);
                        number++;
                    }catch(Exception e){
                        e.printStackTrace();   
                    }
                } 
                reportSummary.setText("Total number of checkout: "+number);
                summary[2]= reportSummary.getText();
            }
            else if(reportType.equals("Revenue Summary")){
                long totalRevenue= 0;
                for(Orders order : orders ){
                    Object[] Revenue = new Object[3];
                    try{
                        Revenue[0]=new Integer(order.getId());
                        Revenue[1]=new SimpleDateFormat("dd/MM/yyyy").format(order.getActualCheckinTime());
                        Revenue[2]=order.getTotalPrice().longValueExact();
                        tableModel.insertRow(0,Revenue);
                        totalRevenue+=order.getTotalPrice().longValueExact();
                    }catch(Exception e){
                        e.printStackTrace();
                
                    }
                }
                reportSummary.setText("Total revenue: "+totalRevenue);
                summary[3]= reportSummary.getText();
            }
            else if(reportType.equals("Booking Activity")){
                int number=0;
                for(Orders order : orders ){
                    Object[] Revenue = new Object[3];
                    try{
                        Room r = order.getRoomNo();
                        Customer CustomerNumber = order.getCustomerId();
                        Revenue[0]=new SimpleDateFormat("dd/MM/yyyy").format(order.getBookingTime());
                        Revenue[1]=CustomerNumber.getName();
                        Revenue[2]=r.getRoomNo();
                        tableModel.insertRow(0,Revenue);
                        number++;
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                    reportSummary.setText("Total number of Booking: "+number);
                    summary[4]= reportSummary.getText();
                }
            }
        
        
    }
     public void doChangeSummary(JLabel reportSummary){
         String reportType =(String) reportTypesList.getSelectedValue();
         if(reportType.equals("Expected Arrivals")){
                reportSummary.setText(summary[0]);
            }
            else if(reportType.equals("Checkin Report")){
                reportSummary.setText(summary[1]);
            }
            else if(reportType.equals("Checkout Report")){
                reportSummary.setText(summary[2]);
            }
            else if(reportType.equals("Revenue Summary")){
                reportSummary.setText(summary[3]);
            }
            else if(reportType.equals("Booking Activity")){
                reportSummary.setText(summary[4]);
            }
         
     }
}
