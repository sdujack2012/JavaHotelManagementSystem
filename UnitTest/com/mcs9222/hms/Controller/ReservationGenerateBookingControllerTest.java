/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcs9222.hms.Controller;

import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author kl438
 */
public class ReservationGenerateBookingControllerTest {
    
    private ReservationGenerateBookingController instance;
    private JTextField reservationCustomerNameTextField;
    private JTextField reservationPhoneTextField;
    private JComboBox reservationMemberBox;
    private String roomNo;
    private Date startDate;
    private Date endDate;
    
    public ReservationGenerateBookingControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.reservationCustomerNameTextField = new JTextField("jiangka");
        this.reservationPhoneTextField = new JTextField("123456");
        this.reservationMemberBox = new JComboBox(new String[] {"VIP"});
        this.roomNo = "1-101";
        this.startDate = new Date();
        this.endDate = new Date();
        this.instance = new ReservationGenerateBookingController(this.reservationCustomerNameTextField,this.reservationPhoneTextField,this.reservationMemberBox,this.roomNo,this.startDate,this.endDate);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of generateBooking method, of class ReservationGenerateBookingController.
     */
    @Test
    public void testGenerateBooking() {
        System.out.println("generateBooking");
        instance.generateBooking();
        // TODO review the generated test code and remove the default call to fail.
         
    }
}