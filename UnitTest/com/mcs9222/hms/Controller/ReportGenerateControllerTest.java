/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcs9222.hms.Controller;

import java.util.List;
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
 * @author Administrator
 */
public class ReportGenerateControllerTest {
    private JTextField StartDateField=new JTextField();
    private JTextField EndDateField=new JTextField();
    private JList reportTypesList = new JList();
    private DefaultListModel listModel = new DefaultListModel();
    private ReportGenerateController instance;
    private JTable reportTable;
    private JLabel reportSummary;
    public ReportGenerateControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        StartDateField=new JTextField();
        EndDateField=new JTextField();
        reportTypesList = new JList();
        DefaultListModel listModel = new DefaultListModel();
        listModel.addElement("Checkin Report");
        listModel.addElement("Checkout Report");
        listModel.addElement("Revenue Summary");
        listModel.addElement("Booking Activity");
        
        reportTable = new JTable();
        reportTypesList.setModel(listModel);
        reportTypesList.setSelectedIndex(0);
        reportSummary = new JLabel();
        instance = new ReportGenerateController(StartDateField,EndDateField,reportTypesList);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getArrivalCollection method, of class ReportGenerateController.
     */
    @Test
    public void testGetArrivalCollection() {
        System.out.println("getArrivalCollection");
        
        StartDateField.setText("01/02/13");
        EndDateField.setText("01/03/13");
        listModel.addElement("Checkin Report");
        listModel.addElement("Checkout Report");
        listModel.addElement("Revenue Summary");
        listModel.addElement("Booking Activity");
        
        
        reportTypesList.setSelectedIndex(1);
        List result = instance.getArrivalCollection();
        assertFalse(result==null);
        reportTypesList.setSelectedIndex(2);
        result = instance.getArrivalCollection();
        assertFalse(result==null);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of doRetrieveTableData method, of class ReportGenerateController.
     */
    @Test(expected=NullPointerException.class)
    public void testDoRetrieveTableData() {
        System.out.println("doRetrieveTableData");
        
        instance.doRetrieveTableData(reportTable, reportSummary);
        DefaultTableModel tlist= (DefaultTableModel)reportTable.getModel();
        assertTrue(tlist.getRowCount()!=0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of doChangeSummary method, of class ReportGenerateController.
     */
    @Test
    public void testDoChangeSummary() {
        System.out.println("doChangeSummary");
        reportSummary.setText("");
        instance.doChangeSummary(reportSummary);
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(!(reportSummary.equals("")));
    }
}