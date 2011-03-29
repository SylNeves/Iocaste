package org.iocaste.protocol;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateListener implements ServletContextListener {
    private static SessionFactory sessionFactory;

    public static final SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        sessionFactory.close();
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

}
