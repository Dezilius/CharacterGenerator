/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author dezilius
 */
public final class Tools {
    
    public static int roll(int from, int to) {
        return (short) ((short) (Math.random() * ((to - from) + 1)) + from);
    }
    
    public static javax.swing.JTextField removePoint(javax.swing.JTextField field) {
        short currentValue = Short.parseShort(field.getText());
        currentValue -= 1;
        field.setText(Short.toString(currentValue));
        return field;
    }
    
    public static javax.swing.JTextField removePoint(javax.swing.JTextField field, int value) {
        short currentValue = Short.parseShort(field.getText());
        currentValue -= value;
        field.setText(Short.toString(currentValue));
        return field;
    }
    
    
    

    

}
