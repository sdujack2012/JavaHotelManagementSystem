/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcs9222.hms.Controller;

import com.mcs9222.hms.Entity.Orders;
import com.mcs9222.hms.Entity.Room;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Query;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author YEXIAO
 */
public class ReservationAddController extends Controller{
    private JComboBox roomTypeComboBox = null;
    private JTextField startDateTextField = null;
    private JTextField endDateTextField = null;
    private JTable reservationResultsTable = null;
    
    public ReservationAddController(JComboBox roomTypeComboBox, JTextField startDateTextField, JTextField endDateTextField, JTable reservationResultsTable){
        this.roomTypeComboBox = roomTypeComboBox;
        this.startDateTextField = startDateTextField;
        this.endDateTextField = endDateTextField;
        this.reservationResultsTable = reservationResultsTable;
    }
    
    public void searchRoom() throws ParseException{   
        if(this.startDateTextField.getText().equals("") || this.endDateTextField.getText().equals("")){
            JOptionPane.showMessageDialog(null, "No date selected", "Warning", JOptionPane.ERROR_MESSAGE);
        }
        else{
            Date startDate = new SimpleDateFormat("dd/MM/yy").parse(this.startDateTextField.getText());
            Date endDate = new SimpleDateFormat("dd/MM/yy").parse(this.endDateTextField.getText());
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, -1);
            Date currentDate = cal.getTime();
            if(startDate.before(currentDate) || endDate.before(currentDate) || startDate.after(endDate)){
                JOptionPane.showMessageDialog(null, "Start Date or End date is wrong!", "Warning", JOptionPane.ERROR_MESSAGE);
            }
            else{
                String roomType = (String)this.roomTypeComboBox.getSelectedItem();

                Query q = this.em.createNamedQuery("Room.findByType");
                q.setParameter("type", roomType);
                Collection<Room> room = q.getResultList();

                ArrayList<Room> result = new ArrayList<>();
                q = this.em.createQuery("SELECT o FROM Orders o WHERE (o.expectedCheckinTime <= :expectedCheckinTime AND o.expectedCheckoutTime >= :expectedCheckinTime) OR (o.expectedCheckinTime <= :expectedCheckoutTime AND o.expectedCheckoutTime >= :expectedCheckoutTime) OR (o.expectedCheckinTime > :expectedCheckinTime AND o.expectedCheckoutTime < :expectedCheckoutTime)");
                q.setParameter("expectedCheckinTime", startDate);
                q.setParameter("expectedCheckoutTime", endDate);

                Collection<Orders> orders = q.getResultList();

                for(Room r : room){
                    String roomNo = r.getRoomNo();

                    boolean flag = true;
                    for(Orders o : orders) {
                        try{
                            if (roomNo.equals(o.getRoomNo().getRoomNo())) {
                                flag = false;
                            }
                        }
                        catch(Exception e){

                        }
                    }
                    if (flag == true) {
                        result.add(r);
                    }            
                }  
                this.reservationResultsTable.setModel(new ResultTableModel(result));
            }
        }
    }
     public String getRoomNo(int row) {
            return ((ResultTableModel)reservationResultsTable.getModel()).getRoomNo(row);
    }
      public void removeRow(int row) {
            ((ResultTableModel)reservationResultsTable.getModel()).removeRow(row);
            
       }
    public class ResultTableModel extends AbstractTableModel {
        
        private ArrayList<Room> result = new ArrayList<>();
        private ArrayList<String> alRoomNo = new ArrayList<>();
        private ArrayList<String> alRoomType = new ArrayList<>();
        private ArrayList<BigDecimal> alPrice = new ArrayList<>();
        public ResultTableModel(ArrayList<Room> result) {
            this.result = result;
            if(this.result != null){
                for(Room r : result){
                    try{
                        alRoomNo.add(r.getRoomNo());
                        alRoomType.add(r.getType());
                        alPrice.add(r.getPrice());
                    }
                    catch(Exception e){
                        
                    }
                }
            }
        }
        
        @Override
        public String getColumnName(int col) {
            switch (col) {
                case 0:
                    return "Room Number";
                case 1:
                    return "Room Type";
                case 2:
                    return "Price";
            }
            // to get rid of NetBeans "Missing Return Value" error
            return null;
        }
        
        @Override
        public int getRowCount() {
            return result.size();
        }
        
        @Override
        public int getColumnCount() {
            return 3;
        }
        public String getRoomNo(int row) {
            return alRoomNo.get(row);
        }
        @Override
        public Object getValueAt(int row, int col) {
            switch (col) {
                case 0:
                    return alRoomNo.get(row);
                case 1:
                    return alRoomType.get(row);
                case 2:
                    return alPrice.get(row);
            }
            return null;
        } 
        public void removeRow(int row) {
            if(alRoomNo.size()==0) return;
            alRoomNo.remove(row);
            alRoomType.remove(row);
            alPrice.remove(row);
            this.fireTableDataChanged();
        }
    }
}
