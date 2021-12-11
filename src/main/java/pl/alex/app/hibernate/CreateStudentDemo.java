package pl.alex.app.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.alex.app.entity.Student;

public class CreateStudentDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        // create session
        Session session = sessionFactory.getCurrentSession();

        try (sessionFactory; session) {
            Student student1 = new Student("Alex", "Bod", "alexbod@email.com");
            Student student2 = new Student("Baba", "Slavka", "babaslavka@email.com");
            session.beginTransaction();
            session.save(student2);
            session.getTransaction().commit();
        }
    }
}
