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
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author kl438
 */
public class ProfilePersonalController extends Controller {
    
    private JTextField tfName;
    private JTable profileTable;
    private ProfileTableModel profileTableModel;
    
    public ProfilePersonalController(JTextField name, JTable table) {
        tfName = name;
        profileTable = table;
    }
    
    public void setTableModelByDefault() {
        profileTableModel = new ProfileTableModel();
        profileTable.setModel(profileTableModel);
    }
    public void setTableModelByName() {
        if (tfName.getText().equals("")) {
            profileTableModel = new ProfileTableModel();
        } else {
            profileTableModel = new ProfileTableModel(tfName.getText()); 
        }
        profileTable.setModel(profileTableModel);
    }
    
    public void doDelete() {
        
        try {
            // the selected customer id
            int row = profileTable.getSelectedRow();
            int id = profileTableModel.getSelectedCustomerId(row);
            Customer customer = em.find(Customer.class, id);
            em.getTransaction().begin();
            Collection<Orders> orders = customer.getOrdersCollection();
            for (Orders o : orders) {
                o.setCustomerId(null);
                em.persist(o);
            }
            em.remove(customer);
            em.getTransaction().commit();
            profileTableModel.deleteSelectedRow(row);
            
        } catch (Exception e) {}
        
    }
    
    public void doAdd() {
        ((ProfileTableModel)profileTable.getModel()).addRow();
    }
    
    private class ProfileTableModel extends AbstractTableModel {
        
        Collection<Customer> profiles = null;
        
        private ArrayList<Integer> ids = new ArrayList<>();
        private ArrayList<String> identifications = new ArrayList<>();
        private ArrayList<String> names = new ArrayList<>();
        private ArrayList<String> addresses = new ArrayList<>();
        private ArrayList<String> phones = new ArrayList<>();
        private ArrayList<String> emails = new ArrayList<>();
        private ArrayList<String> types = new ArrayList<>();
        private ArrayList<String> ccards = new ArrayList<>();
        private ArrayList<String> ccardtypes = new ArrayList<>();
        
        public ProfileTableModel() {

        
            Query q = em.createQuery("select c from Customer c where c.type != :Type");

            q.setParameter("Type", "Agency");
            
            try {
                profiles = q.getResultList();
            } catch (Exception e) {
                //System.err.println(e);
            }
            
            // to get orders
            
            for (Customer c : profiles) {
                ids.add(c.getId());
                identifications.add(c.getIdentification());
                names.add(c.getName());
                addresses.add(c.getAddress());
                phones.add(c.getPhone());
                emails.add(c.getEmail());
                types.add(c.getType());
                ccards.add(c.getCcard());
                ccardtypes.add(c.getCcardtype());
            }
        }
        public ProfileTableModel(String name) {

            // to find the customer
            Query q = em.createNamedQuery("Customer.findByName");
            q.setParameter("name", name);
            
            try {
                profiles = q.getResultList();
            } catch (Exception e) {
                //System.err.println(e);
            }
            // to get orders
            
            for (Customer c : profiles) {
                if (!c.getType().equals("Agency")) {
                    ids.add(c.getId());
                    identifications.add(c.getIdentification());
                    names.add(c.getName());
                    addresses.add(c.getAddress());
                    phones.add(c.getPhone());
                    emails.add(c.getEmail());
                    types.add(c.getType());
                    ccards.add(c.getCcard());
                    ccardtypes.add(c.getCcardtype());
                }
            }
        }
        
        @Override
        public int getRowCount() {
            return ids.size();
        }
        
        @Override
        public int getColumnCount() {
            return 8;
        }
        
        @Override
        public String getColumnName(int col) {
            switch (col) {
                case 0:
                    return "Identification";
                case 1:
                    return "Name";
                case 2:
                    return "Phone";
                case 3:
                    return "Email";
                case 4:
                    return "Type";
                case 5:
                    return "Address";
                case 6:
                    return "Credit Card";
                case 7:
                    return "Credit Card Type";
            }
            // to get rid of NetBeans "Missing Return Value" error
            return null;
        }
        
        @Override
        public Object getValueAt(int row, int col) {
            switch (col) {
                case 0:
                    return identifications.get(row);
                case 1:
                    return names.get(row);
                case 2:
                    return phones.get(row);
                case 3:
                    return emails.get(row);
                case 4:
                    return types.get(row);
                case 5:
                    return addresses.get(row);
                case 6:
                    return ccards.get(row);
                case 7:
                    return ccardtypes.get(row);
            }
            return null;
        }
      
        @Override
        public void setValueAt(Object value, int row, int col) {
            
            // to update the table
            if (col == 0) 
                identifications.set(row, (String)value);
            else if (col == 1)
                names.set(row, (String)value);
            else if (col == 2) 
                phones.set(row, (String)value);
            else if (col == 3) 
                emails.set(row, (String)value);
            else if (col == 4)
                types.set(row, (String)value);
            else if (col == 5)
                addresses.set(row, (String)value);
            else if (col == 6)
                ccards.set(row, (String)value);
            else if (col == 7)
                ccards.set(row, (String)value);
            else if (col == 8)
                ccardtypes.set(row, (String)value);
            else
                return;
            
            // to update the database
            if (ids.get(row) == -1) { // a newly added customer
                // the service
                em.getTransaction().begin();
                Customer c = new Customer();
                
                c.setIdentification(identifications.get(row));
                c.setName(names.get(row));
                c.setPhone((phones.get(row).equals("")) ? null : phones.get(row));
                c.setEmail(emails.get(row));
                c.setType(types.get(row));
                c.setAddress(addresses.get(row));
                c.setCcard(ccards.get(row));
                c.setCcardtype(ccardtypes.get(row));
                em.persist(c);
                em.getTransaction().commit();
                em.refresh(c);
                ids.set(row, c.getId());
                
            } else { // an existing customer
                updateProfile(row);
            }
        }
        @Override
        public boolean isCellEditable(int row, int col) {
            return true;
        }
        
        public void updateProfile(int row) {
            // the selected customer id
            int id = ids.get(row);
            // to get the order
            Customer customer = em.find(Customer.class, id);
            
            em.getTransaction().begin();
            customer.setIdentification(identifications.get(row));
            customer.setName(names.get(row));
            customer.setPhone((phones.get(row).equals("")) ? null : phones.get(row));
            customer.setEmail(emails.get(row));
            customer.setType(types.get(row));
            customer.setAddress(addresses.get(row));
            customer.setCcard(ccards.get(row));
            customer.setCcardtype(ccardtypes.get(row));
            em.getTransaction().commit();
            
        }
        
        public void addRow() {
            ids.add(-1);
            identifications.add("");
            names.add("");
            phones.add("");
            emails.add("");
            types.add("");
            addresses.add("");
            ccards.add("");
            ccardtypes.add("");
            fireTableDataChanged();
        }
        
        public int getSelectedCustomerId(int row) {
            return ids.get(row);
        }
        
        public void deleteSelectedRow(int row) {
            ids.remove(row);
            identifications.remove(row);
            names.remove(row);
            phones.remove(row);
            emails.remove(row);
            types.remove(row);
            addresses.remove(row);
            ccards.remove(row);
            ccardtypes.remove(row);
            fireTableDataChanged();
        }
        
    }
}
