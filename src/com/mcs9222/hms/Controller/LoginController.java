/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcs9222.hms.Controller;

import com.mcs9222.hms.Entity.Employee;
import com.mcs9222.hms.Boundary.SysWindow;
import java.math.BigInteger;
import java.security.MessageDigest;
import javax.persistence.NoResultException;
import javax.persistence.Query;
/**
 *
 * @author Kun LIU
 */
public class LoginController extends Controller {
    private Employee employee = null;
    
    public boolean login(String name, String pwd) {
        
        Query q = em.createNamedQuery("Employee.findByName");
        q.setParameter("name", name);
        try {
            employee = (Employee)q.getSingleResult();
        } catch (NoResultException e) {
            return false;
        } catch (Exception e) {
            System.err.println(e);
        }
        String s = pwd;//md5(pwd);
        if (s.equals(employee.getPassword()) == true) {
            SysWindow sw = new SysWindow();
            sw.setPermissionByRole(employee.getName(), employee.getRole());
            sw.setVisible(true);
             
            return true;
        }
        return false;
    }
    
    private String md5(String pwd) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(pwd.getBytes());
        } catch (Exception e) {
            System.err.println(e);
        }
        return new BigInteger(1, md.digest()).toString(16);
    }
}
