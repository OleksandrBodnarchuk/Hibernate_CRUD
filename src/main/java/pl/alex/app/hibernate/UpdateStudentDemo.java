package pl.alex.app.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.alex.app.entity.Student;

public class UpdateStudentDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session;
        try (sessionFactory) {
            session = sessionFactory.getCurrentSession(); // create session
            int studentId =4;
            session.beginTransaction();// begin transaction
            Student myStudent = session.get(Student.class,studentId);
            myStudent.setLastName("Buck");
            session.getTransaction().commit(); // commit transaction

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("update Student set email='boob@gmail.com'").executeUpdate();
            session.getTransaction().commit();
        }
    }
}
