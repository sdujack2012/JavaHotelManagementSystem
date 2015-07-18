/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcs9222.hms.Entity;

import java.math.BigDecimal;
import java.util.Collection;
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
public class OrdersTest {
    
    public OrdersTest() {
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
     * Test of getId method, of class Orders.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Orders instance = new Orders();
        Integer expResult = null;
        Integer result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of setId method, of class Orders.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Integer id = null;
        Orders instance = new Orders();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of getBookingTime method, of class Orders.
     */
    @Test
    public void testGetBookingTime() {
        System.out.println("getBookingTime");
        Orders instance = new Orders();
        Date expResult = null;
        Date result = instance.getBookingTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of setBookingTime method, of class Orders.
     */
    @Test
    public void testSetBookingTime() {
        System.out.println("setBookingTime");
        Date bookingTime = null;
        Orders instance = new Orders();
        instance.setBookingTime(bookingTime);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of getExpectedCheckinTime method, of class Orders.
     */
    @Test
    public void testGetExpectedCheckinTime() {
        System.out.println("getExpectedCheckinTime");
        Orders instance = new Orders();
        Date expResult = null;
        Date result = instance.getExpectedCheckinTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of setExpectedCheckinTime method, of class Orders.
     */
    @Test
    public void testSetExpectedCheckinTime() {
        System.out.println("setExpectedCheckinTime");
        Date expectedCheckinTime = null;
        Orders instance = new Orders();
        instance.setExpectedCheckinTime(expectedCheckinTime);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of getActualCheckinTime method, of class Orders.
     */
    @Test
    public void testGetActualCheckinTime() {
        System.out.println("getActualCheckinTime");
        Orders instance = new Orders();
        Date expResult = null;
        Date result = instance.getActualCheckinTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of setActualCheckinTime method, of class Orders.
     */
    @Test
    public void testSetActualCheckinTime() {
        System.out.println("setActualCheckinTime");
        Date actualCheckinTime = null;
        Orders instance = new Orders();
        instance.setActualCheckinTime(actualCheckinTime);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of getExpectedCheckoutTime method, of class Orders.
     */
    @Test
    public void testGetExpectedCheckoutTime() {
        System.out.println("getExpectedCheckoutTime");
        Orders instance = new Orders();
        Date expResult = null;
        Date result = instance.getExpectedCheckoutTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of setExpectedCheckoutTime method, of class Orders.
     */
    @Test
    public void testSetExpectedCheckoutTime() {
        System.out.println("setExpectedCheckoutTime");
        Date expectedCheckoutTime = null;
        Orders instance = new Orders();
        instance.setExpectedCheckoutTime(expectedCheckoutTime);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of getActualCheckoutTime method, of class Orders.
     */
    @Test
    public void testGetActualCheckoutTime() {
        System.out.println("getActualCheckoutTime");
        Orders instance = new Orders();
        Date expResult = null;
        Date result = instance.getActualCheckoutTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of setActualCheckoutTime method, of class Orders.
     */
    @Test
    public void testSetActualCheckoutTime() {
        System.out.println("setActualCheckoutTime");
        Date actualCheckoutTime = null;
        Orders instance = new Orders();
        instance.setActualCheckoutTime(actualCheckoutTime);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of getTotalPrice method, of class Orders.
     */
    @Test
    public void testGetTotalPrice() {
        System.out.println("getTotalPrice");
        Orders instance = new Orders();
        BigDecimal expResult = null;
        BigDecimal result = instance.getTotalPrice();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of setTotalPrice method, of class Orders.
     */
    @Test
    public void testSetTotalPrice() {
        System.out.println("setTotalPrice");
        BigDecimal totalPrice = null;
        Orders instance = new Orders();
        instance.setTotalPrice(totalPrice);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of getOccupantsNum method, of class Orders.
     */
    @Test
    public void testGetOccupantsNum() {
        System.out.println("getOccupantsNum");
        Orders instance = new Orders();
        Integer expResult = null;
        Integer result = instance.getOccupantsNum();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of setOccupantsNum method, of class Orders.
     */
    @Test
    public void testSetOccupantsNum() {
        System.out.println("setOccupantsNum");
        Integer occupantsNum = null;
        Orders instance = new Orders();
        instance.setOccupantsNum(occupantsNum);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of getOrderStatus method, of class Orders.
     */
    @Test
    public void testGetOrderStatus() {
        System.out.println("getOrderStatus");
        Orders instance = new Orders();
        String expResult = "";
        String result = instance.getOrderStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of setOrderStatus method, of class Orders.
     */
    @Test
    public void testSetOrderStatus() {
        System.out.println("setOrderStatus");
        String orderStatus = "";
        Orders instance = new Orders();
        instance.setOrderStatus(orderStatus);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of getPaymentStatus method, of class Orders.
     */
    @Test
    public void testGetPaymentStatus() {
        System.out.println("getPaymentStatus");
        Orders instance = new Orders();
        String expResult = "";
        String result = instance.getPaymentStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of setPaymentStatus method, of class Orders.
     */
    @Test
    public void testSetPaymentStatus() {
        System.out.println("setPaymentStatus");
        String paymentStatus = "";
        Orders instance = new Orders();
        instance.setPaymentStatus(paymentStatus);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of getPaymentType method, of class Orders.
     */
    @Test
    public void testGetPaymentType() {
        System.out.println("getPaymentType");
        Orders instance = new Orders();
        String expResult = "";
        String result = instance.getPaymentType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of setPaymentType method, of class Orders.
     */
    @Test
    public void testSetPaymentType() {
        System.out.println("setPaymentType");
        String paymentType = "";
        Orders instance = new Orders();
        instance.setPaymentType(paymentType);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of getPayerName method, of class Orders.
     */
    @Test
    public void testGetPayerName() {
        System.out.println("getPayerName");
        Orders instance = new Orders();
        String expResult = "";
        String result = instance.getPayerName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of setPayerName method, of class Orders.
     */
    @Test
    public void testSetPayerName() {
        System.out.println("setPayerName");
        String payerName = "";
        Orders instance = new Orders();
        instance.setPayerName(payerName);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of getPayerAddress method, of class Orders.
     */
    @Test
    public void testGetPayerAddress() {
        System.out.println("getPayerAddress");
        Orders instance = new Orders();
        String expResult = "";
        String result = instance.getPayerAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of setPayerAddress method, of class Orders.
     */
    @Test
    public void testSetPayerAddress() {
        System.out.println("setPayerAddress");
        String payerAddress = "";
        Orders instance = new Orders();
        instance.setPayerAddress(payerAddress);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of getPayerCcard method, of class Orders.
     */
    @Test
    public void testGetPayerCcard() {
        System.out.println("getPayerCcard");
        Orders instance = new Orders();
        String expResult = "";
        String result = instance.getPayerCcard();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of setPayerCcard method, of class Orders.
     */
    @Test
    public void testSetPayerCcard() {
        System.out.println("setPayerCcard");
        String payerCcard = "";
        Orders instance = new Orders();
        instance.setPayerCcard(payerCcard);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of getPayerCcardType method, of class Orders.
     */
    @Test
    public void testGetPayerCcardType() {
        System.out.println("getPayerCcardType");
        Orders instance = new Orders();
        String expResult = "";
        String result = instance.getPayerCcardType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of setPayerCcardType method, of class Orders.
     */
    @Test
    public void testSetPayerCcardType() {
        System.out.println("setPayerCcardType");
        String payerCcardType = "";
        Orders instance = new Orders();
        instance.setPayerCcardType(payerCcardType);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of getServiceCollection method, of class Orders.
     */
    @Test
    public void testGetServiceCollection() {
        System.out.println("getServiceCollection");
        Orders instance = new Orders();
        Collection expResult = null;
        Collection result = instance.getServiceCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of setServiceCollection method, of class Orders.
     */
    @Test
    public void testSetServiceCollection() {
        System.out.println("setServiceCollection");
        Collection<Service> serviceCollection = null;
        Orders instance = new Orders();
        instance.setServiceCollection(serviceCollection);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of getRoomNo method, of class Orders.
     */
    @Test
    public void testGetRoomNo() {
        System.out.println("getRoomNo");
        Orders instance = new Orders();
        Room expResult = null;
        Room result = instance.getRoomNo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of setRoomNo method, of class Orders.
     */
    @Test
    public void testSetRoomNo() {
        System.out.println("setRoomNo");
        Room roomNo = null;
        Orders instance = new Orders();
        instance.setRoomNo(roomNo);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of getCustomerId method, of class Orders.
     */
    @Test
    public void testGetCustomerId() {
        System.out.println("getCustomerId");
        Orders instance = new Orders();
        Customer expResult = null;
        Customer result = instance.getCustomerId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of setCustomerId method, of class Orders.
     */
    @Test
    public void testSetCustomerId() {
        System.out.println("setCustomerId");
        Customer customerId = null;
        Orders instance = new Orders();
        instance.setCustomerId(customerId);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of hashCode method, of class Orders.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Orders instance = new Orders();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of equals method, of class Orders.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Orders instance = new Orders();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of toString method, of class Orders.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Orders instance = new Orders();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         
    }
}