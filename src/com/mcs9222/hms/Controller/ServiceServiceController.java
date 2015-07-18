/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcs9222.hms.Controller;

import com.mcs9222.hms.Entity.Orders;
import com.mcs9222.hms.Entity.Room;
import com.mcs9222.hms.Entity.Service;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Query;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author hz957
 */
public class ServiceServiceController extends Controller {
    
    private JTextField tfRoomNo;
    private JTable tblService;
    
    public ServiceServiceController(JTextField roomNo, JTable service) {
        tfRoomNo = roomNo;
        tblService = service;
    }
    
    public boolean doSearch() {
        if (tfRoomNo.getText().length() == 0)
            return false;
        tblService.setModel(new ServiceTableModel(tfRoomNo.getText()));
        tfRoomNo.setText("");
        return ((ServiceTableModel)tblService.getModel()).isCheckedin();
    }
    
    public void doAdd() {
        ((ServiceTableModel)tblService.getModel()).addRow();
    }
    
    private class ServiceTableModel extends AbstractTableModel {
        
        private ArrayList<Integer> alServiceID = new ArrayList<>();
        private Orders order = null;
        private ArrayList<String> alName = new ArrayList<>();
        private ArrayList<BigDecimal> alPrice = new ArrayList<>();
        private ArrayList<Date> alTime = new ArrayList<>();
        
        private boolean hasData = false;
        private boolean checkedin= false;
        
        public ServiceTableModel(String roomNo) {
            em.getEntityManagerFactory().getCache().evictAll();
            // to find the room
            Room room = em.find(Room.class, roomNo);
            // to find the order
            Query q = em.createQuery("SELECT o FROM Orders o WHERE o.orderStatus = :status AND o.roomNo = :room_no");
            q.setParameter("status", "Checked-in");
            q.setParameter("room_no", room);
            try {
                order = (Orders)q.getSingleResult();
            } catch (Exception e) {}
            // the service order association
            if (order != null) {
                checkedin = true;
                Collection<Service> services = order.getServiceCollection();
                if (services.isEmpty() == false) {
                    hasData = true;
                    for (Service service : services) {
                        alServiceID.add(service.getSid());
                        alName.add(service.getName());
                        alPrice.add(service.getPrice());
                        alTime.add(service.getTime());
                    }
                }
            }
        }
        
        @Override
        public int getRowCount() {
            return hasData == true ? alName.size() : 0;
        }
        
        @Override
        public int getColumnCount() {
            return 3;
        }
        
        @Override
        public String getColumnName(int col) {
            switch (col) {
                case 0:
                    return "Name";
                case 1:
                    return "Price";
                case 2:
                    return "Time";
            }
            return null;
        }
        
        @Override
        public Object getValueAt(int row, int col) {
            switch (col) {
                case 0:
                    return alName.get(row);
                case 1:
                    return alPrice.get(row);
                case 2:
                    return alTime.get(row);
            }
            return null;
        }
        
        @Override
        public void setValueAt(Object value, int row, int col) {
            // to get the order id
            Integer id = -1;
            try {
                id = alServiceID.get(row);
            } catch (Exception e) {}
            // to update the table
            if (col == 0)
                alName.set(row, (String)value);
            else if (col == 1) {
                alPrice.set(row, new BigDecimal((String)value));
            }
            else
                return;
            // to update the database
            // the service
            if (id == -1) { // a newly added service
                em.getTransaction().begin();
                Service service = new Service();
                service.setOid(order);
                service.setName(alName.get(row));
                service.setPrice(alPrice.get(row));
                service.setTime(new Date());
                em.persist(service);
                em.getTransaction().commit();
                em.refresh(service);
                alServiceID.add(service.getSid());
                // the order
                em.getTransaction().begin();
                BigDecimal price = order.getTotalPrice();
                order.setTotalPrice(price.add(alPrice.get(row)));
                em.persist(order);
                em.getTransaction().commit();
                em.refresh(order);
            } else { // an existing service
                // to update the service
                Service service = em.find(Service.class, id);
                BigDecimal pastPrice = service.getPrice();
                em.getTransaction().begin();
                service.setName(alName.get(row));
                service.setPrice(alPrice.get(row));
                service.setTime(new Date());
                em.getTransaction().commit();
                // the order
                em.getTransaction().begin();
                BigDecimal price = order.getTotalPrice();
                order.setTotalPrice(price.subtract(pastPrice).add(alPrice.get(row)));
                em.persist(order);
                em.getTransaction().commit();
                em.refresh(order);
            }
        }
        
        @Override
        public boolean isCellEditable(int row, int col) {
            if (col == 0 || col == 1)
                return true;
            return false;
        }
        
        public void addRow() {
            alName.add("");
            alPrice.add(new BigDecimal(0));
            alTime.add(new Date());
            hasData = true;
            fireTableDataChanged();
        }
        
        public boolean isCheckedin() {
            return checkedin;
        }
    }
}
