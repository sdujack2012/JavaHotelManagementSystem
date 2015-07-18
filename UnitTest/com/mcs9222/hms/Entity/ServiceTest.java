/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcs9222.hms.Entity;

import java.math.BigDecimal;
import java.util.Date;
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
public class ServiceTest {
    
    public ServiceTest() {
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
     * Test of getSid method, of class Service.
     */
    @Test
    public void testGetSid() {
        System.out.println("getSid");
        Service instance = new Service();
        Integer expResult = null;
        Integer result = instance.getSid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of setSid method, of class Service.
     */
    @Test
    public void testSetSid() {
        System.out.println("setSid");
        Integer sid = null;
        Service instance = new Service();
        instance.setSid(sid);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of getName method, of class Service.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Service instance = new Service();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of setName method, of class Service.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Service instance = new Service();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of getPrice method, of class Service.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        Service instance = new Service();
        BigDecimal expResult = null;
        BigDecimal result = instance.getPrice();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of setPrice method, of class Service.
     */
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        BigDecimal price = null;
        Service instance = new Service();
        instance.setPrice(price);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of getTime method, of class Service.
     */
    @Test
    public void testGetTime() {
        System.out.println("getTime");
        Service instance = new Service();
        Date expResult = null;
        Date result = instance.getTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of setTime method, of class Service.
     */
    @Test
    public void testSetTime() {
        System.out.println("setTime");
        Date time = null;
        Service instance = new Service();
        instance.setTime(time);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of getOid method, of class Service.
     */
    @Test
    public void testGetOid() {
        System.out.println("getOid");
        Service instance = new Service();
        Orders expResult = null;
        Orders result = instance.getOid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of setOid method, of class Service.
     */
    @Test
    public void testSetOid() {
        System.out.println("setOid");
        Orders oid = null;
        Service instance = new Service();
        instance.setOid(oid);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of hashCode method, of class Service.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Service instance = new Service();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of equals method, of class Service.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Service instance = new Service();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of toString method, of class Service.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Service instance = new Service();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         
    }
}