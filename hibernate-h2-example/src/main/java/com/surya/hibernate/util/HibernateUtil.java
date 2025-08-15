package com.surya.hibernate.util;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil { 
	
	// Create a single (static and final) SessionFactory object for the whole app
    private static final SessionFactory sessionFactory;
 
    // Static block runs only once when the class is loaded into memory
    static {
        try {
            // Step 1: Read hibernate.cfg.xml from classpath
            // Step 2: Build SessionFactory from the config file
            sessionFactory = new Configuration().configure()
                    .buildSessionFactory();
        } catch (Throwable ex) {
            // If there's any error while building the SessionFactory, throw an error
            throw new ExceptionInInitializerError("Initial SessionFactory creation failed: " + ex);
        }
    }
 
    // Public method to give access to the SessionFactory
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
	

    
}
