package pl.alex.app.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.alex.app.entity.Student;

public class DeleteStudentDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session;
        try (sessionFactory) {
            session = sessionFactory.getCurrentSession(); // create session
            int studentId = 2;
            session.beginTransaction();// begin transaction
            session.createQuery("delete from Student where id="+studentId).executeUpdate();
            session.getTransaction().commit(); // commit transaction
        }
    }
}
