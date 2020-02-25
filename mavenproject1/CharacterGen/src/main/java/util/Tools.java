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
    
    public static javax.swing.JTextField improvementValue(javax.swing.JTextField field, int times) {
        short fieldValue = (short) Short.parseShort(field.getText());
        if (checkIfPassed(fieldValue)) {
            fieldValue += roll(1,10);
            field.setText(Short.toString(fieldValue));
        }
        return field;
    }
    
    private static boolean checkIfPassed(short value) {
        return roll(1,100) > value;
    }
    
    private static void appendLog(javax.swing.JTextArea log,String message) {
        log.append(message + "\n");
    }
    
    public static Vector<Object> fillRow(Vector<Object> row, callofcthulhuDB.entity.Profession profession) {
        row.add(Integer.toString(profession.getId()));
        row.add(profession.getProfession());
        row.add(Integer.toString(profession.getMinAge()));
        row.add(Integer.toString(profession.getMaxAge()));

        return row;
    }
    
    public static Vector<String> mapTable(Vector<String> headers) {
        headers.add("idProfession");
        headers.add("Profession");
        headers.add("minAge");
        headers.add("maxAge");

        return headers;
    }
    
    public static void mapSkillFields(callofcthulhuDB.entity.Profession profession, ArrayList<javax.swing.JTextField> skillFields) {
        skillFields.get(60).setText(profession.getProfession());
    }
    
    public static int randomAge(callofcthulhuDB.entity.Profession profession) {
        int ageMin = profession.getMinAge();
        int ageMax = profession.getMaxAge();
        if (ageMin < 15 && ageMin > 90) ageMin = 15;
        if (ageMax < 15 && ageMax > 90) ageMax = 90;
        if (ageMin > ageMax) ageMax = ageMin;
        return util.Tools.roll(ageMin, ageMax);
    }
    
    public static int setAge(callofcthulhuDB.entity.Profession profession) {
        int ageMin = profession.getMinAge();
        int ageMax = profession.getMaxAge();
        if (ageMin < 15 && ageMin > 90) ageMin = 15;
        if (ageMax < 15 && ageMax > 90) ageMax = 90;
        if (ageMin > ageMax) ageMax = ageMin;
        return util.Tools.roll(ageMin, ageMax);
    }
}
