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
    
    public static void remove2Args(javax.swing.JTextField field1, javax.swing.JTextField field2, int times) {
        for (int i = 0; i < times; i ++) {
            int flag = roll(1,2);
            if (flag == 1) {
                removePoint(field1);
            }
            else if (flag == 2) {
                removePoint(field2);
            }
        }
    }
    
    public static void remove3Args(javax.swing.JTextArea log, javax.swing.JTextField field1, javax.swing.JTextField field2, javax.swing.JTextField field3, int times) {
        for (int i = 0; i < times; i ++) {
            int flag = roll(1,3);
            if (flag == 1) {
                removePoint(field1);
                String logMessage = "1 point removed from strength.";
                appendLog(log, logMessage);
            }
            else if (flag == 2) {
                removePoint(field2);
                String logMessage = "1 point removed from condition";
                appendLog(log, logMessage);
            }
            else if (flag == 3) {
                removePoint(field3);
                String logMessage = "1 point removed from dexterity";
                appendLog(log, logMessage);
            }
        }
    }
    
    
}
