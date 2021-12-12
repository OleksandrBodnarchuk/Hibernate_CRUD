package pl.alex.app.hibernate.factory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class SessionFactoryUtil {
    public static Session getCurrentSessionFromConfig(List<Object> objects) {
        Configuration configuration = addConfiguration(objects);
        SessionFactory factory = configuration.buildSessionFactory();
        return factory.getCurrentSession();
    }

    private static Configuration addConfiguration(List<Object> objects) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        objects.forEach(o -> configuration.addAnnotatedClass(o.getClass()));
        return configuration;
    }
}
