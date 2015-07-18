/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcs9222.hms.Controller;

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
public class ReservationModifyControllerTest {
    
    private JTextField reservationPhoneTextField;
    private JTable reservationOrderTable;
    private ReservationModifyController instance;
    
    public ReservationModifyControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.reservationPhoneTextField = new JTextField("123456");
        this.reservationOrderTable = new JTable();
        this.instance = new ReservationModifyController(this.reservationPhoneTextField,this.reservationOrderTable);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of searchOrder method, of class ReservationModifyController.
     */
    @Test
    public void testSearchOrder() {
        System.out.println("searchOrder");
        instance.searchOrder();
        // TODO review the generated test code and remove the default call to fail.      
    }

    /**
     * Test of deleteRoom method, of class ReservationModifyController.
     */
    @Test
    public void testDeleteRoom() {
        System.out.println("deleteRoom");
        try{
            instance.deleteRoom();
        }
        catch(Exception e){
            
        }
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of modifyOrder method, of class ReservationModifyController.
     */
    @Test
    public void testModifyOrder() {
        System.out.println("modifyOrder");
        try{
            instance.modifyOrder();
        }
        catch(Exception e){
            
        }
        // TODO review the generated test code and remove the default call to fail.
         
    }
}