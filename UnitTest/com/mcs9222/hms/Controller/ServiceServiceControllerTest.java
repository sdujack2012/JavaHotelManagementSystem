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
public class ServiceServiceControllerTest {
    
    private ServiceServiceController ssc;
    
    public ServiceServiceControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        JTextField tfRoomNo = new JTextField("");
        JTable tblService = new JTable();
        ssc = new ServiceServiceController(tfRoomNo, tblService);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of doSearch method, of class ServiceServiceController.
     */
    @Test
    public void testDoSearch() {
        System.out.println("doSearch");
        boolean expResult = false;
        boolean result = ssc.doSearch();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of doAdd method, of class ServiceServiceController.
     */
    @Test
    public void testDoAdd() {
        System.out.println("doAdd");
        
        try {
            Method m = ClassLoader.class.getDeclaredMethod("findLoadedClass", new Class[] {String.class});
            m.setAccessible(true);
            ClassLoader cl = ClassLoader.getSystemClassLoader();
            Object obj = m.invoke(cl, "TestLoaded$ServiceCheckoutTableModel");
            if (obj == null)
                return;
        } catch (Exception e) {
            return;
        }
        
        ssc.doAdd();
        // TODO review the generated test code and remove the default call to fail.
         
    }
}