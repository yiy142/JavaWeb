package util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateSessionFactory {

    private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
    private static SessionFactory sessionFactory;

    private static Configuration configuration = new Configuration();
    private static ServiceRegistry serviceRegistry;

    static {
        try {
            configuration.configure();
            serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
            try {
                sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
            } catch (Exception e) {
                StandardServiceRegistryBuilder.destroy(serviceRegistry);
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.err.println("%%%% Error Creating SessionFactory %%%%");
            e.printStackTrace();
        }
    }

    public HibernateSessionFactory() {

    }

    public static Session getSession() throws HibernateException {
        Session session = threadLocal.get();

        if (session == null || !session.isOpen()) {
            if (sessionFactory == null) {
                rebuildSessionFactory();
            }
            session = (sessionFactory != null) ? sessionFactory.openSession() : null;
            threadLocal.set(session);
        }

        return session;
    }

    public static void closeSession() throws HibernateException {
        Session session = threadLocal.get();
        threadLocal.set(null);

        if (session != null) {
            session.close();
        }
    }

    public static void rebuildSessionFactory() {
        try {
            configuration.configure();
            serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
            try {
                sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
            } catch (Exception e) {
                StandardServiceRegistryBuilder.destroy(serviceRegistry);
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.err.println("%%%% Error Creating SessionFactory %%%%");
            e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Configuration getConfiguration() {
        return configuration;
    }

}