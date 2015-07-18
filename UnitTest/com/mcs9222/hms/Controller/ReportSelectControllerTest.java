/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcs9222.hms.Controller;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kj847
 */
public class ReportSelectControllerTest {
    private JList reportTypesList = new JList();
    private JTable reportTable;
    private JLabel reportSummary;
    private ReportSelectController instance;
    public ReportSelectControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
       
        reportTypesList = new JList();
        DefaultListModel listModel = new DefaultListModel();
        listModel.addElement("Checkin Report");
        listModel.addElement("Checkout Report");
        listModel.addElement("Revenue Summary");
        listModel.addElement("Booking Activity");
        instance = new ReportSelectController(reportTable,reportTypesList,reportSummary);
        reportTable = new JTable();
        reportTypesList.setModel(listModel);
        reportSummary = new JLabel();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of doChangeType method, of class ReportSelectController.
     */
    @Test
    public void testDoChangeType() {
        System.out.println("doChangeType");
        ReportSelectController instance = new ReportSelectController(reportTable,reportTypesList,reportSummary);
        reportTypesList.setSelectedIndex(0);
        instance.doChangeType();
        DefaultTableModel tlist1=(DefaultTableModel)reportTable.getModel();
        reportTypesList.setSelectedIndex(1);
        instance.doChangeType();
        DefaultTableModel tlist2=(DefaultTableModel)reportTable.getModel();
        assertTrue(tlist1!=tlist2);
    }
}