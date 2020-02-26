/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.List;

/**
 *
 * @author dezilius
 */
public class InfoChar {
    
    private static int randomAge(callofcthulhuDB.entity.Profession profession) {
        int ageMin = profession.getMinAge();
        int ageMax = profession.getMaxAge();
        if (ageMin < 15 || ageMin > 90) ageMin = 15;
        if (ageMax < 15 || ageMax > 90) ageMax = 90;
        if (ageMin > ageMax) ageMax = 90;
        return util.Tools.roll(ageMin, ageMax);
    }
    
    public static void setHP(javax.swing.JTextField hpField, javax.swing.JTextField condition, javax.swing.JTextField size) {
        int con = Integer.parseInt(condition.getText());
        int siz = Integer.parseInt(size.getText());
        int hp = (con + siz) / 10;
        hpField.setText(Integer.toString(hp));
    }
    
    public static void setMagicPoints(javax.swing.JTextField MPField, javax.swing.JTextField power) {
        int MP = Integer.parseInt(power.getText()) / 5;
        MPField.setText(Integer.toString(MP));
    }
    
    public static void setSanity(javax.swing.JTextField sanityField, javax.swing.JTextField power) {
        sanityField.setText(power.getText());
    }
    
    public static void setLuck(javax.swing.JTextField luckField) {
        int luck = 0;
        for (int i = 0; i < 3; i++) {
            luck += util.Tools.roll(1, 6);
        }
        luckField.setText(Integer.toString(luck));
    }
    
    public static void displayResultFirstName(javax.swing.JTextField firstNameField, javax.swing.JTextField sexField, List result) {

        for (Object o : result) {
            callofcthulhuDB.entity.FirstName name = (callofcthulhuDB.entity.FirstName)o;
            firstNameField.setText(name.getFirstName());
            sexField.setText(name.getSex());
        }
    }
    
    public static void displayResultLastName(javax.swing.JTextField lastNameField, List result) {
       
        for (Object o : result) {
            callofcthulhuDB.entity.LastName name = (callofcthulhuDB.entity.LastName)o;
            lastNameField.setText(name.getLastName());
        }
    }
    
    public static void displayResultProfession(javax.swing.JTextField ageField, javax.swing.JTextField professionField, List result) {
            
        for (Object o : result) {
            callofcthulhuDB.entity.Profession profession = (callofcthulhuDB.entity.Profession)o;
            int age = randomAge(profession);
            ageField.setText(Integer.toString(age));
            professionField.setText(profession.getProfession());
        }
    }

}
