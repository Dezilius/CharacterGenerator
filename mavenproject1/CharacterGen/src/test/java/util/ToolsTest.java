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
     */
    @Test
    public void testRemovePoint_JTextField() {
        System.out.println("removePoint");
        JTextField field = new JTextField();
        field.setText("50");
        JTextField expResult = new JTextField();
        expResult.setText("49");
        JTextField result = Tools.removePoint(field);
        assertEquals(expResult.getText(), result.getText());
        
        field.setText("0");
        expResult.setText("0");
        result = Tools.removePoint(field);
        assertEquals(expResult.getText(), result.getText());
    }

    /**
     * Test of removePoint method, of class Tools.
     */
    @Test
    public void testRemovePoint_JTextField_int() {
        System.out.println("removePointTimes");
        JTextField field = new JTextField();
        field.setText("50");
        int times = 5;
        JTextField expResult = new JTextField();
        expResult.setText("45");
        JTextField result = Tools.removePoint(field, times);
        assertEquals(expResult.getText(), result.getText());
        
        field.setText("0");
        expResult.setText("0");
        result = Tools.removePoint(field, times);
        assertEquals(expResult.getText(), result.getText());
        
        field.setText("3");
        expResult.setText("3");
        result = Tools.removePoint(field, times);
        assertEquals(expResult.getText(), result.getText());
        
        field.setText("2");
        expResult.setText("1");
        times = 1;
        result = Tools.removePoint(field, times);
        assertEquals(expResult.getText(), result.getText());
    }
    
}
