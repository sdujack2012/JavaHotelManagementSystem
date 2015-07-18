/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcs9222.hms.Boundary;

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
public class SysWindowTest {
    
    public SysWindowTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setPermissionByRole method, of class SysWindow.
     */
    @Test
    public void testSetPermissionByRole() {
        System.out.println("setPermissionByRole");
        String name = "";
        String role = "";
        SysWindow instance = new SysWindow();
        instance.setPermissionByRole(name, role);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of main method, of class SysWindow.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        SysWindow.main(args);
        // TODO review the generated test code and remove the default call to fail.
         
    }
}