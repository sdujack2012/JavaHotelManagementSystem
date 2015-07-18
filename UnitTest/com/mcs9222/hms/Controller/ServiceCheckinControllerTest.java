/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcs9222.hms.Controller;

import javax.swing.JComboBox;
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
public class ServiceCheckinControllerTest {

    private ServiceCheckinController scc;
    
    public ServiceCheckinControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        JTextField tfName = new JTextField("");
        JTextField tfID = new JTextField("");
        JTextField tfCCard = new JTextField("");
        JComboBox cbCType = new JComboBox(new String[] {"Visa", "Master"});
        JTextField tfExpiry = new JTextField("");
        JTable tblOrders = new JTable();
        scc = new ServiceCheckinController(tfName, tfID, tfCCard, cbCType, tfExpiry, tblOrders);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of doSearch method, of class ServiceCheckinController.
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
     * Test of doCheckin method, of class ServiceCheckinController.
     */
    @Test
    public void testDoCheckin() {
        System.out.println("doCheckin");
        boolean expResult = false;
        boolean result = scc.doCheckin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         
    }
}