/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcs9222.hms.Entity;

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
@Suite.SuiteClasses({com.mcs9222.hms.Entity.CustomerTest.class, com.mcs9222.hms.Entity.RoomTest.class, com.mcs9222.hms.Entity.ServiceTest.class, com.mcs9222.hms.Entity.EmployeeTest.class, com.mcs9222.hms.Entity.OrdersTest.class})
public class EntitySuite {

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