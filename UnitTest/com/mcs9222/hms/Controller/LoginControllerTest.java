/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcs9222.hms.Controller;

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
public class LoginControllerTest {
    
    public LoginControllerTest() {
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
     * Test of login method, of class LoginController.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        String name = "";
        String pwd = "";
        LoginController instance = new LoginController();
        boolean expResult = false;
        boolean result = instance.login(name, pwd);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         
    }
}