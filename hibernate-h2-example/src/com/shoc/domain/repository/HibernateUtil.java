package com.shoc.domain.repository;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author diego
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    //private static Logger logger = Logger.getGlobal();
    static {

        try {
            
            Properties dbConnectionProperties = System.getProperties();
            
            sessionFactory = new Configuration().mergeProperties(dbConnectionProperties).configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);

            //logger.severe( ex.getMessage() );
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
