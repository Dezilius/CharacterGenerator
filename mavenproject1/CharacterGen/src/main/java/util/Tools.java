/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

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

        try {
            currentValue -= 1;
            if (currentValue <= 0) {
                throw new fieldValueLessOrEqualZero("Field value less or equal zero");
            }
        } catch (fieldValueLessOrEqualZero e) {
            return field;
        }        
        field.setText(Short.toString(currentValue));
        return field;
    }
    
    public static javax.swing.JTextField removePoint(javax.swing.JTextField field, int value) {
        short currentValue = Short.parseShort(field.getText());
        
        try {
            currentValue -= value;
            if (currentValue <= 0) {
                throw new fieldValueLessOrEqualZero("Field value less or equal zero");
            }
        } catch (fieldValueLessOrEqualZero e) {
            return field;
        } 
        field.setText(Short.toString(currentValue));
        return field;
    }
    
    static class fieldValueLessOrEqualZero extends Exception {
        fieldValueLessOrEqualZero(String message) {
            super(message);
        }
    }
    

    

}
