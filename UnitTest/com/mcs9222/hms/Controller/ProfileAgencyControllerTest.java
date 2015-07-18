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
public class ProfileAgencyControllerTest {
    
    private JTextField tfName;
    private JTable profileTable;
    ProfileAgencyController instance;
    public ProfileAgencyControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        tfName = new JTextField("");
        profileTable = new JTable();
        instance = new ProfileAgencyController(tfName, profileTable);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setTableModelByDefault method, of class ProfileAgencyController.
     */
    @Test
    public void testSetTableModelByDefault() {
        System.out.println("setTableModelByDefault");

        instance.setTableModelByDefault();
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of setTableModelByName method, of class ProfileAgencyController.
     */
    @Test
    public void testSetTableModelByName() {
        System.out.println("setTableModelByName");

        instance.setTableModelByName();
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of doDelete method, of class ProfileAgencyController.
     */
    @Test
    public void testDoDelete() {
        System.out.println("doDelete");

        instance.doDelete();
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of doAdd method, of class ProfileAgencyController.
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