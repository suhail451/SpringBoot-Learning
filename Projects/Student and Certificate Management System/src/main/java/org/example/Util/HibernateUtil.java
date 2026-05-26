package org.example.Util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    public static SessionFactory sessionFactory;

    static {
        try{
//           Configuration con = new Configuration();
//           sessionFactory = con.configure("hibernate.cfg.xml").buildSessionFactory();
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error in Creating Session Factory!");
        }

    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
