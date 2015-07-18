/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcs9222.hms.Boundary;

import java.awt.Component;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Observer;
import javax.swing.JDialog;
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
public class DatePickerTest {
    
    public DatePickerTest() {
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
     * Test of start method, of class DatePicker.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        Component c = null;
        DatePicker instance = null;
        instance.start(c);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of run method, of class DatePicker.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        DatePicker instance = null;
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of parseDate method, of class DatePicker.
     */
    @Test
    public void testParseDate() {
        System.out.println("parseDate");
        String date = "";
        DatePicker instance = null;
        Date expResult = null;
        Date result = instance.parseDate(date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of formatDate method, of class DatePicker.
     */
    @Test
    public void testFormatDate_Date() {
        System.out.println("formatDate");
        Date date = null;
        DatePicker instance = null;
        String expResult = "";
        String result = instance.formatDate(date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of formatDate method, of class DatePicker.
     */
    @Test
    public void testFormatDate_Date_String() {
        System.out.println("formatDate");
        Date date = null;
        String pattern = "";
        DatePicker instance = null;
        String expResult = "";
        String result = instance.formatDate(date, pattern);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of formatDate method, of class DatePicker.
     */
    @Test
    public void testFormatDate_Calendar() {
        System.out.println("formatDate");
        Calendar date = null;
        DatePicker instance = null;
        String expResult = "";
        String result = instance.formatDate(date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of formatDate method, of class DatePicker.
     */
    @Test
    public void testFormatDate_Calendar_String() {
        System.out.println("formatDate");
        Calendar date = null;
        String pattern = "";
        DatePicker instance = null;
        String expResult = "";
        String result = instance.formatDate(date, pattern);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of setLocale method, of class DatePicker.
     */
    @Test
    public void testSetLocale() {
        System.out.println("setLocale");
        Locale l = null;
        DatePicker instance = null;
        instance.setLocale(l);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of getLocale method, of class DatePicker.
     */
    @Test
    public void testGetLocale() {
        System.out.println("getLocale");
        DatePicker instance = null;
        Locale expResult = null;
        Locale result = instance.getLocale();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of register method, of class DatePicker.
     */
    @Test
    public void testRegister() {
        System.out.println("register");
        Observer observer = null;
        DatePicker instance = null;
        instance.register(observer);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of unregister method, of class DatePicker.
     */
    @Test
    public void testUnregister() {
        System.out.println("unregister");
        Observer observer = null;
        DatePicker instance = null;
        instance.unregister(observer);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of setSelectedDate method, of class DatePicker.
     */
    @Test
    public void testSetSelectedDate() {
        System.out.println("setSelectedDate");
        Date d = null;
        DatePicker instance = null;
        instance.setSelectedDate(d);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of updateScreen method, of class DatePicker.
     */
    @Test
    public void testUpdateScreen() {
        System.out.println("updateScreen");
        Calendar c = null;
        DatePicker instance = null;
        instance.updateScreen(c);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of setMonthPanel method, of class DatePicker.
     */
    @Test
    public void testSetMonthPanel() {
        System.out.println("setMonthPanel");
        Calendar calendar = null;
        DatePicker instance = null;
        instance.setMonthPanel(calendar);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of dayPicked method, of class DatePicker.
     */
    @Test
    public void testDayPicked() {
        System.out.println("dayPicked");
        int day = 0;
        DatePicker instance = null;
        instance.dayPicked(day);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of getString method, of class DatePicker.
     */
    @Test
    public void testGetString() {
        System.out.println("getString");
        String key = "";
        String dv = "";
        DatePicker instance = null;
        String expResult = "";
        String result = instance.getString(key, dv);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of isCloseOnSelect method, of class DatePicker.
     */
    @Test
    public void testIsCloseOnSelect() {
        System.out.println("isCloseOnSelect");
        DatePicker instance = null;
        boolean expResult = false;
        boolean result = instance.isCloseOnSelect();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of windowGainedFocus method, of class DatePicker.
     */
    @Test
    public void testWindowGainedFocus() {
        System.out.println("windowGainedFocus");
        WindowEvent e = null;
        DatePicker instance = null;
        instance.windowGainedFocus(e);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of windowLostFocus method, of class DatePicker.
     */
    @Test
    public void testWindowLostFocus() {
        System.out.println("windowLostFocus");
        WindowEvent e = null;
        DatePicker instance = null;
        instance.windowLostFocus(e);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of getScreen method, of class DatePicker.
     */
    @Test
    public void testGetScreen() {
        System.out.println("getScreen");
        DatePicker instance = null;
        JDialog expResult = null;
        JDialog result = instance.getScreen();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of setCloseOnSelect method, of class DatePicker.
     */
    @Test
    public void testSetCloseOnSelect() {
        System.out.println("setCloseOnSelect");
        boolean closeOnSelect = false;
        DatePicker instance = null;
        instance.setCloseOnSelect(closeOnSelect);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of main method, of class DatePicker.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] argv = null;
        DatePicker.main(argv);
        // TODO review the generated test code and remove the default call to fail.
         
    }
}