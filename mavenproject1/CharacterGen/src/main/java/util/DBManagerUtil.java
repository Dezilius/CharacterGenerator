/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Vector;

/**
 *
 * @author dezilius
 */
public class DBManagerUtil {
    
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
}
