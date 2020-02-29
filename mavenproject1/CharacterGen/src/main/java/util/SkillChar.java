/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author dezilius
 */
public class SkillChar {
    
    private static javax.swing.JLabel skillPointsLabel;
    private static javax.swing.JTextField intelligenceField;
    private static ArrayList<javax.swing.JTextField> skillFields;
    private static int defaultSkillPointsSum;
    
    public static void initSkillChar(javax.swing.JLabel skillPointsLabelInit, javax.swing.JTextField intelligence, ArrayList<javax.swing.JTextField> skillFieldsInit) {
        skillPointsLabel = skillPointsLabelInit;
        intelligenceField = intelligence;
        skillFields = new ArrayList<>();
        
        for (javax.swing.JTextField iter : skillFieldsInit) {
            skillFields.add(iter);
        }
    }
    
    public static void setDefaultValues(ArrayList<javax.swing.JTextField> skillFields, javax.swing.JTextField education, javax.swing.JTextField dexterity) {
            
            String edu = education.getText();
            String dodge = Integer.toString(Integer.parseInt(dexterity.getText())/2);
            int creditRating = randomCreditRating();
            
            skillFields.get(0).setText("5");
            skillFields.get(1).setText("1");
            skillFields.get(2).setText("5");
            skillFields.get(3).setText("1");
            skillFields.get(4).setText("5");
            skillFields.get(5).setText("0");
            skillFields.get(6).setText("0");
            skillFields.get(7).setText("15");
            skillFields.get(8).setText("20");
            skillFields.get(9).setText(Integer.toString(creditRating));
            skillFields.get(10).setText("0");
            skillFields.get(11).setText("5");
            skillFields.get(12).setText(dodge);
            skillFields.get(13).setText("20");
            skillFields.get(14).setText("10");
            skillFields.get(15).setText("5");
            skillFields.get(16).setText("25");
            skillFields.get(17).setText("0");
            skillFields.get(18).setText("0");
            skillFields.get(19).setText("20");
            skillFields.get(20).setText("25");
            skillFields.get(21).setText("0");
            skillFields.get(22).setText("30");
            skillFields.get(23).setText("5");
            skillFields.get(24).setText("15");
            skillFields.get(25).setText("20");
            skillFields.get(26).setText("1");
            skillFields.get(27).setText("0");
            skillFields.get(28).setText("0");
            skillFields.get(29).setText(edu);
            skillFields.get(30).setText("5");
            skillFields.get(31).setText("20");
            skillFields.get(32).setText("20");
            skillFields.get(33).setText("1");
            skillFields.get(34).setText("10");
            skillFields.get(35).setText("1");
            skillFields.get(36).setText("10");
            skillFields.get(37).setText("10");
            skillFields.get(38).setText("5");
            skillFields.get(39).setText("1");
            skillFields.get(40).setText("10");
            skillFields.get(41).setText("1");
            skillFields.get(42).setText("10");
            skillFields.get(43).setText("1");
            skillFields.get(44).setText("5");
            skillFields.get(45).setText("1");
            skillFields.get(46).setText("0");
            skillFields.get(47).setText("0");
            skillFields.get(48).setText("10");
            skillFields.get(49).setText("25");
            skillFields.get(50).setText("20");
            skillFields.get(51).setText("10");
            skillFields.get(52).setText("20");
            skillFields.get(53).setText("20");
            skillFields.get(54).setText("10");
            skillFields.get(55).setText("10");
            skillFields.get(56).setText("10");
            skillFields.get(57).setText("10");
            skillFields.get(58).setText("10");
            skillFields.get(59).setText("10");
            
            calculateDefaultSkillPoints();
    }
    
    private static int randomCreditRating() {
        int value = 0;
        for (int i = 0; i < 3; i++) {
            value += Tools.roll(1,5);
        }
        return value;
    }
    
    private static void calculateDefaultSkillPoints() {
        defaultSkillPointsSum = 0;
        for (int i = 0; i < 60; i++) {
            defaultSkillPointsSum += Integer.parseInt(skillFields.get(i).getText());
        }
    }
    
    public static void setSkillPoints() {
        int skillPoints = calculateSkillPoints();
        String skillPointsText = "Available skill points: " + skillPoints;
        skillPointsLabel.setText(skillPointsText);
    }
    
    private static int calculateSkillPoints() {
        return Integer.parseInt(intelligenceField.getText()) * 2;
    }
    
    public static void availableSkillPoints() {
            int skillPointsToDistribute = defaultSkillPointsSum + calculateSkillPoints() - calculateCurrentSkillPointsSum();
            skillPointsLabel.setText("Available skill points: " + skillPointsToDistribute);
    }
    
    public static boolean isSkillPointAvailable() {
        int currentMaxSkillPoints = calculateSkillPoints() + defaultSkillPointsSum;
        return (currentMaxSkillPoints < calculateCurrentSkillPointsSum());
    }
    
    private static int calculateCurrentSkillPointsSum() {
        int currentSkillPointsSum = 0;    
        for (javax.swing.JTextField iter : skillFields) {
            currentSkillPointsSum += Integer.parseInt(iter.getText());
        }
        return currentSkillPointsSum;
    }
    
    public static void setEditableOnSkillFields() {
        for (javax.swing.JTextField iter : skillFields) {
            iter.setEditable(true);
        }
        setColorGreen();
    }
    private static void setColorGreen() {
        for (javax.swing.JTextField iter : skillFields) {
            
            iter.setBackground(Color.green);
        }
    }
    
    public static void setEditableOffSkillFields() {
        for (javax.swing.JTextField iter : skillFields) {
            iter.setEditable(false);
        }
        setColorWhite();
    }
    private static void setColorWhite() {
        for (javax.swing.JTextField iter : skillFields) {
            iter.setBackground(Color.white);
        }
    }
    
    public static void fieldsProperCheck() {
        for (javax.swing.JTextField iter : skillFields) {
            if (!isProperInteger(iter.getText())) {
                iter.setText("0");
            }
            if (Integer.parseInt(iter.getText()) > 99) {
                iter.setText("99");
            }
            if (Integer.parseInt(iter.getText()) < 0) {
                iter.setText("0");
            }
        }
    }
    
    private static boolean isProperInteger(String text) {
        char[] charArr = text.toCharArray();
        boolean firstChecked = false;
        
        for (char iter: charArr) {
            if (!firstChecked && isFirstChar0(iter) && charArr.length > 1) {
                firstChecked = true;
                return false;
            } else firstChecked = true;
            
            if (!isNumber(iter)) {
                return false;
            }
        }
        return true;
    }
    
    private static boolean isNumber(char c) {
        if (c == '0' || c == '1' || c == '2' ||
            c == '3' || c == '4' || c == '5' ||
            c == '6' || c == '7' || c == '8' || 
            c == '9') {
            return true;
        }
        return false;
    }
    
    private static boolean isFirstChar0(char c) {
        if (c == '0') {
            return true;
        }
        return false;
    }
}
