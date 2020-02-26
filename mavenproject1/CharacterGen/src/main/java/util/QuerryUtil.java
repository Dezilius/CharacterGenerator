/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import callofcthulhuDB.util.HibernateUtil;
import java.util.List;
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

    public static List executeHQLQueryNumberOfFirstName(String hql) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery(hql);
            List result = q.list();
            List ans = readNumberOfFirstName(result);
            session.getTransaction().commit();
            return ans;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return null;
    }
    private static List readNumberOfFirstName(List result) {

        for (Object o : result) {
            callofcthulhuDB.entity.FirstName name = (callofcthulhuDB.entity.FirstName) o;
            List ans = randomFirstName(name.getId());
            return ans;
        }
        return null;
    }
    private static List randomFirstName(Integer number) {
            int numberOfFirstName = (int) (Math.random() * (number)) + 1;
            List result = executeHQLQueryFirstName(QUERY_FIRST_NAME + " " + numberOfFirstName);
            return result;
    }
    private static List executeHQLQueryFirstName(String hql) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery(hql);
            List result = q.list();
            session.getTransaction().commit();
            return result;
        } catch (HibernateException he) {
            he.printStackTrace();
        } 
            return null;
    }

    public static List executeHQLQueryNumberOfLastName(String hql) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery(hql);
            List result = q.list();
            List ans = readNumberOfLastName(result);
            session.getTransaction().commit();
            return ans;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return null;
    }
    private static List readNumberOfLastName(List result) {

        for (Object o : result) {
            callofcthulhuDB.entity.LastName name = (callofcthulhuDB.entity.LastName) o;
            List ans = randomLastName(name.getId());
            return ans;
        }
        return null;
    }
    private static List randomLastName(Integer number) {
            int numberOfLastName = (int) (Math.random() * (number)) + 1;
            List result = executeHQLQueryLastName(QUERY_LAST_NAME + " " + numberOfLastName);
            return result;
    }
    private static List executeHQLQueryLastName(String hql) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery(hql);
            List result = q.list();
            session.getTransaction().commit();
            return result;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return null;
    }

    public static List executeHQLQueryNumberOfProfession(String hql) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery(hql);
            List result = q.list();
            List ans = readNumberOfProfession(result);
            session.getTransaction().commit();
            return ans;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return null;
    }
    private static List readNumberOfProfession(List result) {

        for (Object o : result) {
            callofcthulhuDB.entity.Profession profession = (callofcthulhuDB.entity.Profession) o;
            List ans = randomProfession(profession.getId());
            return ans;
        }
        return null;
    }
    private static List randomProfession(Integer number) {
            int numberOfProfession = (int) (Math.random() * (number)) + 1;
            List result = executeHQLQueryProfession(QUERY_PROFESSION + " " + numberOfProfession);
            return result;
    }
    private static List executeHQLQueryProfession(String hql) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery(hql);
            List result = q.list();
            session.getTransaction().commit();
            return result;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return null;
}
}
