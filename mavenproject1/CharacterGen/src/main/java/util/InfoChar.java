/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author dezilius
 */
public class InfoChar {
    
    public static int randomAge(callofcthulhuDB.entity.Profession profession) {
        int ageMin = profession.getMinAge();
        int ageMax = profession.getMaxAge();
        if (ageMin < 15 || ageMin > 90) ageMin = 15;
        if (ageMax < 15 || ageMax > 90) ageMax = 90;
        if (ageMin > ageMax) ageMax = 90;
        return util.Tools.roll(ageMin, ageMax);
    }

}
