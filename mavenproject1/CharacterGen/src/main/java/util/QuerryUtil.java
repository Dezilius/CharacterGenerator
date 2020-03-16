/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import callofcthulhuDB.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author dezilius
 */
public class QuerryUtil {
    
private static final String QUERY_FIRST_NAME="from FirstName where id =";
private static final String QUERY_LAST_NAME="from LastName where id =";
private static final String QUERY_PROFESSION="from Profession where id =";
private static final String QUERY_READ_ALL_FIRST_NAME="from FirstName";
private static final String QUERY_READ_ALL_LAST_NAME="from LastName";
private static final String QUERY_READ_ALL_PROFESSION="from Profession";

    public static List executeHQLQueryNumberOfFirstName(String hql) {
        List ans = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery(hql);
            List result = q.list();
            ans = readNumberOfFirstName(result);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return ans;
    }
    private static List readNumberOfFirstName(List result) {
        List ans = new ArrayList<>();
        for (Object o : result) {
            callofcthulhuDB.entity.FirstName name = (callofcthulhuDB.entity.FirstName) o;
            ans = randomFirstName(name.getId());
        }
        return ans;
    }
    private static List randomFirstName(Integer number) {
            int numberOfFirstName = (int) (Math.random() * (number)) + 1;
            List result = executeHQLQueryFirstName(QUERY_FIRST_NAME + " " + numberOfFirstName);
            return result;
    }
    private static List executeHQLQueryFirstName(String hql) {
        List result = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery(hql);
            result = q.list();
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        } 
        return result;
    }

    public static List executeHQLQueryNumberOfLastName(String hql) {
        List ans = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery(hql);
            List result = q.list();
            ans = readNumberOfLastName(result);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return ans;
    }
    private static List readNumberOfLastName(List result) {
        List ans = new ArrayList<>();
        for (Object o : result) {
            callofcthulhuDB.entity.LastName name = (callofcthulhuDB.entity.LastName) o;
            ans = randomLastName(name.getId());
        }
        return ans;
    }
    private static List randomLastName(Integer number) {
            int numberOfLastName = (int) (Math.random() * (number)) + 1;
            List result = executeHQLQueryLastName(QUERY_LAST_NAME + " " + numberOfLastName);
            return result;
    }
    private static List executeHQLQueryLastName(String hql) {
        List result = new ArrayList<>();    
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery(hql);
            result = q.list();
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return result;
    }

    public static List executeHQLQueryNumberOfProfession(String hql) {
        List ans = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery(hql);
            List result = q.list();
            ans = readNumberOfProfession(result);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return ans;
    }
    private static List readNumberOfProfession(List result) {
        List ans = new ArrayList<>();
        for (Object o : result) {
            callofcthulhuDB.entity.Profession profession = (callofcthulhuDB.entity.Profession) o;
            ans = randomProfession(profession.getId());
        }
        return ans;
    }
    private static List randomProfession(Integer number) {
            int numberOfProfession = (int) (Math.random() * (number)) + 1;
            List result = executeHQLQueryProfession(QUERY_PROFESSION + " " + numberOfProfession);
            return result;
    }
    private static List executeHQLQueryProfession(String hql) {
        List result = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery(hql);
            result = q.list();
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return result;
}
    
    public static void runQueryBasedOnReadAllFirstName(javax.swing.JTable DbTable) {
        executeHQLQueryReadAllFirstName(QUERY_READ_ALL_FIRST_NAME, DbTable);
    }
    private static void executeHQLQueryReadAllFirstName(String hql, javax.swing.JTable DbTable) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery(hql);
            List resultList = q.list();
            displayResultReadAllFirstName(resultList, DbTable);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
    }
    private static void displayResultReadAllFirstName(List resultList, javax.swing.JTable DbTable) {
    Vector<String> tableHeaders = new Vector<String>();
    Vector tableData = new Vector();
    tableHeaders = DBManagerUtil.mapTableFirstName(tableHeaders);

    for(Object o : resultList) {
        callofcthulhuDB.entity.FirstName name = (callofcthulhuDB.entity.FirstName)o;
        Vector<Object> oneRow = new Vector<Object>();
        DBManagerUtil.fillRowFirstName(oneRow, name);
        tableData.add(oneRow);
    }
    DbTable.setModel(new DefaultTableModel(tableData, tableHeaders));
    DbTable.setDefaultEditor(Object.class, null);
    }
    
    public static void runQueryBasedOnReadAllLastName(javax.swing.JTable DbTable) {
    executeHQLQueryReadAllLastName(QUERY_READ_ALL_LAST_NAME, DbTable);
    }
    private static void executeHQLQueryReadAllLastName(String hql, javax.swing.JTable DbTable) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery(hql);
            List resultList = q.list();
            displayResultReadAllLastName(resultList, DbTable);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
    }
    private static void displayResultReadAllLastName(List resultList, javax.swing.JTable DbTable) {
        Vector<String> tableHeaders = new Vector<String>();
        Vector tableData = new Vector();
        tableHeaders = DBManagerUtil.mapTableLastName(tableHeaders);

        for(Object o : resultList) {
            callofcthulhuDB.entity.LastName name = (callofcthulhuDB.entity.LastName)o;
            Vector<Object> oneRow = new Vector<Object>();
            DBManagerUtil.fillRowLastName(oneRow, name);
            tableData.add(oneRow);
        }
        DbTable.setModel(new DefaultTableModel(tableData, tableHeaders));
        DbTable.setDefaultEditor(Object.class, null);
    }
    
    public static void runQueryBasedOnReadAllProfession(javax.swing.JTable DbTable) {
    executeHQLQueryReadAllProfession(QUERY_READ_ALL_PROFESSION, DbTable);
    }
    private static void executeHQLQueryReadAllProfession(String hql, javax.swing.JTable DbTable) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery(hql);
            List resultList = q.list();
            displayResultReadAllProfession(resultList, DbTable);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
    }
    private static void displayResultReadAllProfession(List resultList, javax.swing.JTable DbTable) {
        Vector<String> tableHeaders = new Vector<String>();
        Vector tableData = new Vector();
        tableHeaders = DBManagerUtil.mapTableProfession(tableHeaders);

        for(Object o : resultList) {
            callofcthulhuDB.entity.Profession name = (callofcthulhuDB.entity.Profession)o;
            Vector<Object> oneRow = new Vector<Object>();
            DBManagerUtil.fillRowProfession(oneRow, name);
            tableData.add(oneRow);
        }
        DbTable.setModel(new DefaultTableModel(tableData, tableHeaders));
        DbTable.setDefaultEditor(Object.class, null);
    }
}
