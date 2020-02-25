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
public class SkillChar {
    
    public static void mapSkillFields(callofcthulhuDB.entity.Profession profession, ArrayList<javax.swing.JTextField> skillFields) {
        skillFields.get(60).setText(profession.getProfession());
    }
}
