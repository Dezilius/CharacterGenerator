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
    
    public static Vector<Object> fillRowFirstName(Vector<Object> row, callofcthulhuDB.entity.FirstName firstName) {
        row.add(Integer.toString(firstName.getId()));
        row.add(firstName.getFirstName());
        row.add(firstName.getSex());

        return row;
    }
    public static Vector<String> mapTableFirstName(Vector<String> headers) {
        headers.add("idFirstName");
        headers.add("FirstName");
        headers.add("Sex");

        return headers;
    }
    
    public static Vector<Object> fillRowLastName(Vector<Object> row, callofcthulhuDB.entity.LastName lastName) {
        row.add(Integer.toString(lastName.getId()));
        row.add(lastName.getLastName());

        return row;
    }
    public static Vector<String> mapTableLastName(Vector<String> headers) {
        headers.add("idLastName");
        headers.add("LastName");

        return headers;
    }
    
    public static Vector<Object> fillRowProfession(Vector<Object> row, callofcthulhuDB.entity.Profession profession) {
        row.add(Integer.toString(profession.getId()));
        row.add(profession.getProfession());
        row.add(Integer.toString(profession.getMinAge()));
        row.add(Integer.toString(profession.getMaxAge()));

        return row;
    }
    public static Vector<String> mapTableProfession(Vector<String> headers) {
        headers.add("idProfession");
        headers.add("Profession");
        headers.add("minAge");
        headers.add("maxAge");

        return headers;
    }

}
