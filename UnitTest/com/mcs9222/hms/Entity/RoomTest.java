/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcs9222.hms.Entity;

import java.math.BigDecimal;
import java.util.Collection;
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
public class RoomTest {
    
    public RoomTest() {
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
     * Test of getRoomNo method, of class Room.
     */
    @Test
    public void testGetRoomNo() {
        System.out.println("getRoomNo");
        Room instance = new Room();
        String expResult = "";
        String result = instance.getRoomNo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of setRoomNo method, of class Room.
     */
    @Test
    public void testSetRoomNo() {
        System.out.println("setRoomNo");
        String roomNo = "";
        Room instance = new Room();
        instance.setRoomNo(roomNo);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of getType method, of class Room.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        Room instance = new Room();
        String expResult = "";
        String result = instance.getType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of setType method, of class Room.
     */
    @Test
    public void testSetType() {
        System.out.println("setType");
        String type = "";
        Room instance = new Room();
        instance.setType(type);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of getPrice method, of class Room.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        Room instance = new Room();
        BigDecimal expResult = null;
        BigDecimal result = instance.getPrice();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of setPrice method, of class Room.
     */
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        BigDecimal price = null;
        Room instance = new Room();
        instance.setPrice(price);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of getOrdersCollection method, of class Room.
     */
    @Test
    public void testGetOrdersCollection() {
        System.out.println("getOrdersCollection");
        Room instance = new Room();
        Collection expResult = null;
        Collection result = instance.getOrdersCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of setOrdersCollection method, of class Room.
     */
    @Test
    public void testSetOrdersCollection() {
        System.out.println("setOrdersCollection");
        Collection<Orders> ordersCollection = null;
        Room instance = new Room();
        instance.setOrdersCollection(ordersCollection);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of hashCode method, of class Room.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Room instance = new Room();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of equals method, of class Room.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Room instance = new Room();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of toString method, of class Room.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Room instance = new Room();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         
    }
}