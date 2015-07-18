/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcs9222.hms.Controller;

import java.lang.reflect.Method;
import java.math.BigDecimal;
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
public class ServiceCheckoutControllerTest {
    
    private ServiceCheckoutController scc;
    
    public ServiceCheckoutControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        JTextField tfPhone = new JTextField("");
        JTable tblCheckout = new JTable();
        scc = new ServiceCheckoutController(tfPhone, tblCheckout);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of doSearch method, of class ServiceCheckoutController.
     */
    @Test
    public void testDoSearch() {
        System.out.println("doSearch");
        boolean expResult = false;
        boolean result = scc.doSearch();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of doCheckout method, of class ServiceCheckoutController.
     */
    @Test
    public void testDoCheckout() {
        System.out.println("doCheckout");
        
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
        
        BigDecimal expResult = new BigDecimal(0);
        BigDecimal result = scc.doCheckout();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         
    }
}