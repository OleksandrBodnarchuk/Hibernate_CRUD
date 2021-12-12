package pl.alex.app.hibernate.factory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MySessionFactory {
    public static Session getCurrentSessionFromConfig(Object obj) {
        Configuration configuration = addConfiguration(obj);
        SessionFactory factory = configuration.buildSessionFactory();
        return factory.getCurrentSession();
    }

    private static Configuration addConfiguration(Object obj) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(obj.getClass());
        return configuration;
    }
}
