/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcs9222.hms.Boundary;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author kl438
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({com.mcs9222.hms.Boundary.ObservingTextFieldTest.class, com.mcs9222.hms.Boundary.SysWindowTest.class, com.mcs9222.hms.Boundary.CustomerInfoBookingWindowTest.class, com.mcs9222.hms.Boundary.DatePickerTest.class, com.mcs9222.hms.Boundary.LoginWindowTest.class})
public class BoundarySuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}