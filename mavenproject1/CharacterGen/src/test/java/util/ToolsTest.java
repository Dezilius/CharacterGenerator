/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.swing.JTextField;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dezilius
 */
public class ToolsTest {
    
    public ToolsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of roll method, of class Tools.
     */
    @Test
    public void testRoll() {
        System.out.println("roll");
        int from = 0;
        int to = 10;
        int result = Tools.roll(from, to);
        assertTrue(result >= from && result <= to);
        
        from = 5;
        to = 0;
        assertFalse(result >= from && result <= to);
    }

    /**
     * Test of removePoint method, of class Tools.
     *
    @Test
    public void testRemovePoint_JTextField() {
        System.out.println("removePoint");
        JTextField field = null;
        JTextField expResult = null;
        JTextField result = Tools.removePoint(field);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removePoint method, of class Tools.
     *
    @Test
    public void testRemovePoint_JTextField_int() {
        System.out.println("removePoint");
        JTextField field = null;
        int value = 0;
        JTextField expResult = null;
        JTextField result = Tools.removePoint(field, value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
    
}
