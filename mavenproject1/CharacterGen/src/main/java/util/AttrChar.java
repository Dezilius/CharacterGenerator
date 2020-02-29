/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.ArrayList;
import static util.Tools.removePoint;
import static util.Tools.roll;

/**
 *
 * @author dezilius
 */
public class AttrChar {
    
    private static javax.swing.JTextArea log;
    private static javax.swing.JTextField strengthField;
    private static javax.swing.JTextField sizeField;
    private static javax.swing.JTextField conditionField;
    private static javax.swing.JTextField dexterityField;
    private static javax.swing.JTextField educationField;
    
    public static void initAttrChar(ArrayList<javax.swing.JTextField> attrCharFields, javax.swing.JTextArea logInit) {
        log = logInit;
        strengthField = attrCharFields.get(0);
        sizeField = attrCharFields.get(1);
        conditionField = attrCharFields.get(2);
        dexterityField = attrCharFields.get(3);
        educationField = attrCharFields.get(4);
    }
    
    public static void appendLog(String message) {
        log.append(message + "\n");
    }
    
    public static void reduceStrSiz(int times) {
        short totalStrRemoved = 0;
        short totalSizRemoved = 0;
        String logMessage = "";
        for (int i = 0; i < times; i ++) {
            int flag = roll(1,2);
            if (flag == 1) {
                removePoint(strengthField);
                totalStrRemoved++;
            }
            else if (flag == 2) {
                removePoint(sizeField);
                totalSizRemoved++;
            }
        }
        logMessage = "" + totalStrRemoved + " point(s) removed from strength.";
        appendLog(logMessage);
        
        logMessage = "" + totalSizRemoved + " point(s) removed from size\n";
        appendLog(logMessage);
    }
    
    public static void removeStrConDex(int times) {
        short totalStrRemoved = 0;
        short totalConRemoved = 0;
        short totalDexRemoved = 0;
        String logMessage = "";
        for (int i = 0; i < times;) {
            int flag = roll(1,3);
            if (flag == 1 && (Integer.parseInt(strengthField.getText())) > 10) {
                removePoint(strengthField);
                totalStrRemoved++;
                i++;
            }
            else if (flag == 2 && (Integer.parseInt(conditionField.getText())) > 10) {
                removePoint(conditionField);
                totalConRemoved++;
                i++;
            }
            else if (flag == 3 && (Integer.parseInt(dexterityField.getText())) > 10) {
                removePoint(dexterityField);
                totalDexRemoved++;
                i++;
            }
        }
        logMessage = totalStrRemoved + " point(s) removed from strength.";
        appendLog(logMessage);
        
        logMessage = totalConRemoved + " point(s) removed from condition";
        appendLog(logMessage);
        
        logMessage = totalDexRemoved + " point(s) removed from dexterity";
        appendLog(logMessage);
    }
    
    public static void improvementCheckForEdu(int times) {
        short currentEdu = (short) Short.parseShort(educationField.getText());
        short rollValue = 0;
        String message = "";
        if (checkIfPassed(currentEdu)) {
            rollValue += roll(1,10);
            currentEdu += rollValue;
            message = rollValue + " point(s) added to education!";
            appendLog(message);
            
            if (currentEdu > 99) {
                currentEdu = 99;
            }
            educationField.setText(Short.toString(currentEdu));
        }
    }
    
    private static boolean checkIfPassed(short value) {
        return roll(1,100) > value;
    }
}
