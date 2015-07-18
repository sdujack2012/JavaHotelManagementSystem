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
public class ReservationAddControllerTest {
    private JComboBox reservationRoomTypeComboBox;
    private JTextField reservationStartDateTextField;
    private JTextField reservationEndDateTextField;
    private JTable reservationResultsTable;
    private ReservationAddController instance;

    public ReservationAddControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.reservationRoomTypeComboBox = new JComboBox();
        this.reservationStartDateTextField = new JTextField("12/11/2014");
        this.reservationEndDateTextField = new JTextField("13/11/2014");
        this.reservationResultsTable = new JTable();
        this.instance = new ReservationAddController(this.reservationRoomTypeComboBox,this.reservationStartDateTextField,this.reservationEndDateTextField,this.reservationResultsTable);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of searchRoom method, of class ReservationAddController.
     */
    @Test
    public void testSearchRoom() throws Exception {
        System.out.println("searchRoom");      
        instance.searchRoom();
        // TODO review the generated test code and remove the default call to fail.
         
    }
}