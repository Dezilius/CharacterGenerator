/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import static util.Tools.removePoint;
import static util.Tools.roll;

/**
 *
 * @author dezilius
 */
public class AttrChar {
    
    public static void appendLog(javax.swing.JTextArea log,String message) {
        log.append(message + "\n");
    }
    
    public static void remove2Attr(javax.swing.JTextArea log, javax.swing.JTextField field1, javax.swing.JTextField field2, int times) {
        short totalStrRemoved = 0;
        short totalSizRemoved = 0;
        String logMessage = "";
        for (int i = 0; i < times; i ++) {
            int flag = roll(1,2);
            if (flag == 1) {
                removePoint(field1);
                totalStrRemoved++;
            }
            else if (flag == 2) {
                removePoint(field2);
                totalSizRemoved++;
            }
        }
        logMessage = "" + totalStrRemoved + " point(s) removed from strength.";
        appendLog(log, logMessage);
        
        logMessage = "" + totalSizRemoved + " point(s) removed from condition\n";
        appendLog(log, logMessage);
    }
    
    public static void remove3Attr(javax.swing.JTextArea log, javax.swing.JTextField field1, javax.swing.JTextField field2, javax.swing.JTextField field3, int times) {
        short totalStrRemoved = 0;
        short totalConRemoved = 0;
        short totalDexRemoved = 0;
        String logMessage = "";
        short noProgress = 0;
        for (int i = 0; i < times;) {
            int flag = roll(1,3);
            if (flag == 1 && (Integer.parseInt(field1.getText())) > 10) {
                removePoint(field1);
                totalStrRemoved++;
                i++;
                noProgress = 0;
            }
            else if (flag == 2 && (Integer.parseInt(field2.getText())) > 10) {
                removePoint(field2);
                totalConRemoved++;
                i++;
                noProgress = 0;
            }
            else if (flag == 3 && (Integer.parseInt(field3.getText())) > 10) {
                removePoint(field3);
                totalDexRemoved++;
                i++;
                noProgress = 0;
            }
            noProgress++;
            if (noProgress == 5) break;
        }
        logMessage = "" + totalStrRemoved + " point(s) removed from strength.";
        appendLog(log, logMessage);
        
        logMessage = "" + totalConRemoved + " point(s) removed from condition";
        appendLog(log, logMessage);
        
        logMessage = "" + totalDexRemoved + " point(s) removed from dexterity";
        appendLog(log, logMessage);
    }
    
    public static javax.swing.JTextField improvementValue(javax.swing.JTextArea log, javax.swing.JTextField field, int times) {
        short fieldValue = (short) Short.parseShort(field.getText());
        short rollValue = 0;
        String message = "";
        if (checkIfPassed(fieldValue)) {
            rollValue += roll(1,10);
            fieldValue += rollValue;
            message = rollValue + " point(s) added to education!";
            appendLog(log, message);
            if (fieldValue > 99) {
                fieldValue = 99;
            }
            
            field.setText(Short.toString(fieldValue));
        }
        return field;
    }
    
    private static boolean checkIfPassed(short value) {
        return roll(1,100) > value;
    }
}
