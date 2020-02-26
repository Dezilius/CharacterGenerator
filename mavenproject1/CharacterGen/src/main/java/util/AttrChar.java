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
    
    private static void appendLog(javax.swing.JTextArea log,String message) {
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
        for (int i = 0; i < times; i ++) {
            int flag = roll(1,3);
            if (flag == 1) {
                removePoint(field1);
                totalStrRemoved++;
            }
            else if (flag == 2) {
                removePoint(field2);
                totalConRemoved++;
            }
            else if (flag == 3) {
                removePoint(field3);
                totalDexRemoved++;
            }
        }
        logMessage = "" + totalStrRemoved + " point(s) removed from strength.";
        appendLog(log, logMessage);
        
        logMessage = "" + totalConRemoved + " point(s) removed from condition";
        appendLog(log, logMessage);
        
        logMessage = "" + totalDexRemoved + " point(s) removed from dexterity\n";
        appendLog(log, logMessage);
    }
    
    
}
