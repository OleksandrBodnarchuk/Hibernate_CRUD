package pl.alex.app.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.alex.app.entity.Student;

public class ReadStudentDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession(); // create NEW session
            Student tempStudent = new Student("Daffy", "Duck", "dduck@email.com");
            session.beginTransaction();// begin transaction
            // save the objects into DB
            session.save(tempStudent);
            session.getTransaction().commit(); // commit transaction

            session = sessionFactory.getCurrentSession(); // create NEW session
            session.beginTransaction();
            Student studentFromDB = session.get(Student.class, tempStudent.getId());
            System.out.println("\nStudent from DB -> " + studentFromDB);
            session.getTransaction().commit(); // commit transaction

        }
    }
}
