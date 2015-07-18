/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcs9222.hms.Controller;

import java.io.File;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import junit.framework.Assert;
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
public class ReportExportControllerTest {
    
    public ReportExportControllerTest() {
    }
    private JTable reportTable;
    private JLabel reportSummary;
    private DefaultTableModel model;
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        reportTable =new JTable();
        reportSummary =new JLabel();
        model = (DefaultTableModel)reportTable.getModel();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of saveFile method, of class ReportExportController.
     */
    @Test
    public void testSaveFile() {
        System.out.println("saveFile");
        ReportExportController instance = new ReportExportController(reportTable,reportSummary);
        instance.saveFile("outputtest.txt");
        File file = new File("outputtest.txt");
        Assert.assertTrue(file.isFile());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}