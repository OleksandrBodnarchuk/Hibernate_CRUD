package pl.alex.app.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.alex.app.entity.Student;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession(); // create session

        try (sessionFactory; session) {
            Student student1 = new Student("Vlad", "Liashko", "vliashko@email.com");
            Student student2 = new Student("Ramesh", "Jitesh", "rameshJitesh@email.com");
            Student student3 = new Student("Bonita", "Applebum", "bonita@email.com");
            session.beginTransaction();// begin transaction
            // save the objects into DB
            session.save(student1);
            session.save(student2);
            session.save(student3);
            session.getTransaction().commit(); // commit transaction
        }
    }
}
