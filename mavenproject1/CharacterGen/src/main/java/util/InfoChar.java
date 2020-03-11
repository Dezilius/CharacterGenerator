/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dezilius
 */
public class InfoChar {
    
    private static javax.swing.JTextField firstNameField;
    private static javax.swing.JTextField lastNameField;
    private static javax.swing.JTextField professionField;
    private static javax.swing.JTextField ageField;
    private static javax.swing.JTextField sexField;
    private static javax.swing.JTextField HPField;
    private static javax.swing.JTextField MPField;
    private static javax.swing.JTextField sanityField;
    private static javax.swing.JTextField luckField;
    private static javax.swing.JTextField conditionField;
    private static javax.swing.JTextField sizeField;
    private static javax.swing.JTextField powerField;
    
    public static void initInfoChar(ArrayList<javax.swing.JTextField> characterFields, javax.swing.JTextField conditionFieldInit, javax.swing.JTextField sizeFieldInit, javax.swing.JTextField powerFieldInit) {
        firstNameField = characterFields.get(0);
        lastNameField = characterFields.get(1);
        sexField = characterFields.get(2);
        ageField = characterFields.get(3);
        professionField = characterFields.get(4);
        HPField = characterFields.get(5);
        MPField = characterFields.get(6);
        sanityField = characterFields.get(7);
        luckField = characterFields.get(8);
        conditionField = conditionFieldInit;
        sizeField = sizeFieldInit;
        powerField = powerFieldInit;
    }
    
    private static int randomAge(callofcthulhuDB.entity.Profession profession) {
        int ageMin = profession.getMinAge();
        int ageMax = profession.getMaxAge();
        if (ageMin < 15 || ageMin > 90) ageMin = 15;
        if (ageMax < 15 || ageMax > 90) ageMax = 90;
        if (ageMin > ageMax) ageMax = 90;
        return util.Tools.roll(ageMin, ageMax);
    }
    
    public static void setHP() {
        int con = Integer.parseInt(conditionField.getText());
        int siz = Integer.parseInt(sizeField.getText());
        int hp = (con + siz) / 10;
        HPField.setText(Integer.toString(hp));
    }
    
    public static void setMagicPoints() {
        int MP = Integer.parseInt(powerField.getText()) / 5;
        MPField.setText(Integer.toString(MP));
    }
    
    public static void setSanity() {
        sanityField.setText(powerField.getText());
    }
    
    public static void setLuck() {
        int luck = 0;
        for (int i = 0; i < 3; i++) {
            luck += util.Tools.roll(1, 6);
        }
        luckField.setText(Integer.toString(luck));
    }
    
    public static void displayResultFirstName(List result) {

        for (Object o : result) {
            callofcthulhuDB.entity.FirstName name = (callofcthulhuDB.entity.FirstName)o;
            firstNameField.setText(name.getFirstName());
            sexField.setText(name.getSex());
        }
    }
    
    public static void displayResultLastName(List result) {
       
        for (Object o : result) {
            callofcthulhuDB.entity.LastName name = (callofcthulhuDB.entity.LastName)o;
            lastNameField.setText(name.getLastName());
        }
    }
    
    public static void displayResultProfession(List result) {
            
        for (Object o : result) {
            callofcthulhuDB.entity.Profession profession = (callofcthulhuDB.entity.Profession)o;
            int age = randomAge(profession);
            ageField.setText(Integer.toString(age));
            professionField.setText(profession.getProfession());
        }
    }

}
