/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.ArrayList;

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
    
    public static void mapSkillFields(callofcthulhuDB.entity.Profession profession, ArrayList<javax.swing.JTextField> skillFields) {
        skillFields.get(0).setText(Integer.toString(profession.getAccounting()));
        skillFields.get(1).setText(Integer.toString(profession.getAnthropology()));
        skillFields.get(2).setText(Integer.toString(profession.getAppraise()));
        skillFields.get(3).setText(Integer.toString(profession.getArcheology()));
        skillFields.get(4).setText(Integer.toString(profession.getCraft()));
        skillFields.get(5).setText(Integer.toString(profession.getCraft2nd()));
        skillFields.get(6).setText(Integer.toString(profession.getCraft3rd()));
        skillFields.get(7).setText(Integer.toString(profession.getCharm()));
        skillFields.get(8).setText(Integer.toString(profession.getClimb()));
        skillFields.get(9).setText(Integer.toString(profession.getCreditRating()));
        skillFields.get(10).setText(Integer.toString(profession.getCthulhuMythos()));
        skillFields.get(11).setText(Integer.toString(profession.getDisguise()));
        skillFields.get(12).setText(Integer.toString(profession.getDodge()));
        skillFields.get(13).setText(Integer.toString(profession.getDrive()));
        skillFields.get(14).setText(Integer.toString(profession.getElectricalRepair()));
        skillFields.get(15).setText(Integer.toString(profession.getFastTalk()));
        skillFields.get(16).setText(Integer.toString(profession.getFighting()));
        skillFields.get(17).setText(Integer.toString(profession.getFighting2nd()));
        skillFields.get(18).setText(Integer.toString(profession.getFighting3rd()));
        skillFields.get(19).setText(Integer.toString(profession.getHandgun()));
        skillFields.get(20).setText(Integer.toString(profession.getRifle()));
        skillFields.get(21).setText(Integer.toString(profession.getRifle2nd()));
        skillFields.get(22).setText(Integer.toString(profession.getFirstAid()));
        skillFields.get(23).setText(Integer.toString(profession.getHistory()));
        skillFields.get(24).setText(Integer.toString(profession.getIntimidate()));
        skillFields.get(25).setText(Integer.toString(profession.getJump()));
        skillFields.get(26).setText(Integer.toString(profession.getLanguageOther()));
        skillFields.get(27).setText(Integer.toString(profession.getLanguageOther2nd()));
        skillFields.get(28).setText(Integer.toString(profession.getLanguageOther3rd()));
        skillFields.get(29).setText(Integer.toString(profession.getLanguageOwn()));
        skillFields.get(30).setText(Integer.toString(profession.getLaw()));
        skillFields.get(31).setText(Integer.toString(profession.getLibraryUse()));
        skillFields.get(32).setText(Integer.toString(profession.getListen()));
        skillFields.get(33).setText(Integer.toString(profession.getLocksmithing()));
        skillFields.get(34).setText(Integer.toString(profession.getMechanicalRepair()));
        skillFields.get(35).setText(Integer.toString(profession.getMedicine()));
        skillFields.get(36).setText(Integer.toString(profession.getNaturalWorld()));
        skillFields.get(37).setText(Integer.toString(profession.getNavigate()));
        skillFields.get(38).setText(Integer.toString(profession.getOccult()));
        skillFields.get(39).setText(Integer.toString(profession.getOpHvMachine()));
        skillFields.get(40).setText(Integer.toString(profession.getPersuade()));
        skillFields.get(41).setText(Integer.toString(profession.getPilot()));
        skillFields.get(42).setText(Integer.toString(profession.getPsychology()));
        skillFields.get(43).setText(Integer.toString(profession.getPsychoanalysis()));
        skillFields.get(44).setText(Integer.toString(profession.getRiding()));
        skillFields.get(45).setText(Integer.toString(profession.getScience()));
        skillFields.get(46).setText(Integer.toString(profession.getScience2nd()));
        skillFields.get(47).setText(Integer.toString(profession.getScience3rd()));
        skillFields.get(48).setText(Integer.toString(profession.getSleightOfHand()));
        skillFields.get(49).setText(Integer.toString(profession.getSpotHidden()));
        skillFields.get(50).setText(Integer.toString(profession.getStealth()));
        skillFields.get(51).setText(Integer.toString(profession.getSurvival()));
        skillFields.get(52).setText(Integer.toString(profession.getSwim()));
        skillFields.get(53).setText(Integer.toString(profession.getThrow_()));
        skillFields.get(54).setText(Integer.toString(profession.getTrack()));
        skillFields.get(55).setText(Integer.toString(profession.getOther1st()));
        skillFields.get(56).setText(Integer.toString(profession.getOther2nd()));
        skillFields.get(57).setText(Integer.toString(profession.getOther3rd()));
        skillFields.get(58).setText(Integer.toString(profession.getOther4th()));
        skillFields.get(59).setText(Integer.toString(profession.getOther5th()));
        skillFields.get(60).setText(profession.getProfession());
    }
}
