package com.shoc.domain.repository;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.FileInputStream;
import java.util.Properties;
import org.apache.log4j.Logger;
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

    private static Logger logger = Logger.getLogger(HibernateUtil.class);

    static {

        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            Properties dbConnectionProperties = new Properties();

            //the base folder is ./, the root of the main.properties file  
            String path = "./app.properties";

            //load the file handle for main.properties

            dbConnectionProperties.load(new FileInputStream(path));

            //Properties dbConnectionProperties = System.getProperties();
            sessionFactory = new Configuration().mergeProperties(dbConnectionProperties).configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            logger.fatal("Error tratando de conectar con la base", ex);

            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
