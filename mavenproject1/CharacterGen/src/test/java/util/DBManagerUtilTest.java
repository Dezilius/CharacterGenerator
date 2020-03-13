/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import callofcthulhuDB.entity.FirstName;
import callofcthulhuDB.entity.LastName;
import callofcthulhuDB.entity.Profession;
import java.util.Vector;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dezilius
 */
public class DBManagerUtilTest {
    
    public DBManagerUtilTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of fillRowFirstName method, of class DBManagerUtil.
     */
    @Test
    public void testFillRowFirstName() {
        System.out.println("fillRowFirstName");
        Vector<Object> result = new Vector<>();
        FirstName firstName = new callofcthulhuDB.entity.FirstName("Mirek", "male");
        firstName.setId(1);
        Vector<Object> expResult = new Vector<>();
        expResult.add("1");
        expResult.add("Mirek");
        expResult.add("male");                
        result = DBManagerUtil.fillRowFirstName(result, firstName);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of mapTableFirstName method, of class DBManagerUtil.
     */
    @Test
    public void testMapTableFirstName() {
        System.out.println("mapTableFirstName");
        Vector<String> result = new Vector<>();
        Vector<String> expResult = new Vector<>();
        expResult.add("idFirstName");
        expResult.add("FirstName");
        expResult.add("Sex");
        result = DBManagerUtil.mapTableFirstName(result);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of fillRowLastName method, of class DBManagerUtil.
     */
    @Test
    public void testFillRowLastName() {
        System.out.println("fillRowLastName");
        Vector<Object> result = new Vector<>();
        LastName lastName = new callofcthulhuDB.entity.LastName("Kowalski");
        lastName.setId(1);
        Vector<Object> expResult = new Vector<>();
        expResult.add("1");
        expResult.add("Kowalski");                
        result = DBManagerUtil.fillRowLastName(result, lastName);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of mapTableLastName method, of class DBManagerUtil.
     */
    @Test
    public void testMapTableLastName() {
        System.out.println("mapTableLastName");
        Vector<String> result = new Vector<>();
        Vector<String> expResult = new Vector<>();
        expResult.add("idLastName");
        expResult.add("LastName");
        result = DBManagerUtil.mapTableLastName(result);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of fillRowProfession method, of class DBManagerUtil.
     */
    @Test
    public void testFillRowProfession() {
        System.out.println("fillRowProfession");
        Vector<Object> result = new Vector<>();
        Profession profession = new callofcthulhuDB.entity.Profession("Spawacz", 20, 50);
        profession.setId(1);
        Vector<Object> expResult = new Vector<>();
        expResult.add("1");
        expResult.add("Spawacz");   
        expResult.add("20");     
        expResult.add("50");     
        result = DBManagerUtil.fillRowProfession(result, profession);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of mapTableProfession method, of class DBManagerUtil.
     */
    @Test
    public void testMapTableProfession() {
        System.out.println("mapTableProfession");
        Vector<String> result = new Vector<>();
        Vector<String> expResult = new Vector<>();
        expResult.add("idProfession");
        expResult.add("Profession");
        expResult.add("minAge");
        expResult.add("maxAge");
        
        result = DBManagerUtil.mapTableProfession(result);
        assertEquals(expResult, result);
    }
    
}
