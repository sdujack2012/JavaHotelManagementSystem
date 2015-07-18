/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcs9222.hms.Controller;

import java.lang.reflect.Method;
import javax.swing.JTable;
import javax.swing.JTextField;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kl438
 */
public class ProfilePersonalControllerTest {
    
    ProfilePersonalController instance;
    
    private JTextField tfPhone;
    private JTable profileTable;
    
    public ProfilePersonalControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        tfPhone = new JTextField("");
        profileTable = new JTable();
        instance = new ProfilePersonalController(tfPhone, profileTable);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setTableModelByDefault method, of class ProfilePersonalController.
     */
    @Test
    public void testSetTableModelByDefault() {
        System.out.println("setTableModelByDefault");
        
        instance.setTableModelByDefault();
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of setTableModelByPhone method, of class ProfilePersonalController.
     */
    @Test
    public void testSetTableModelByPhone() {
        System.out.println("setTableModelByPhone");
        
      //  instance.setTableModelByPhone();
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of doDelete method, of class ProfilePersonalController.
     */
    @Test
    public void testDoDelete() {
        System.out.println("doDelete");
        
        instance.doDelete();
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of doAdd method, of class ProfilePersonalController.
     */
    @Test
    public void testDoAdd() {
        System.out.println("doAdd");
        
        try {
            Method m = ClassLoader.class.getDeclaredMethod("findLoadedClass", new Class[] {String.class});
            m.setAccessible(true);
            ClassLoader cl = ClassLoader.getSystemClassLoader();
            Object obj = m.invoke(cl, "ProfileTableModel");
            if (obj == null)
                return;
        } catch (Exception e) {
            return;
        }
        instance.doAdd();
        // TODO review the generated test code and remove the default call to fail.
         
    }
}