/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcs9222.hms.Boundary;

import java.util.Observable;
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
public class ObservingTextFieldTest {
    
    public ObservingTextFieldTest() {
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
     * Test of update method, of class ObservingTextField.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Observable o = null;
        Object arg = null;
        ObservingTextField instance = new ObservingTextField();
        instance.update(o, arg);
        // TODO review the generated test code and remove the default call to fail.
         
    }
}