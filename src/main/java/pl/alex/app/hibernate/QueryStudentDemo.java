package pl.alex.app.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.alex.app.entity.Student;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession(); // create session
            session.beginTransaction();
            List<Student> from_student = session.createQuery("from Student").getResultList();
            printStudentList(from_student);
            session.getTransaction().commit();
            printLineSeparator();
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            List<Student> students = session.createQuery("from Student s where s.lastName='Liashko'").getResultList();
            printStudentList(students);
            session.getTransaction().commit();
            printLineSeparator();
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            List<Student> studentList = session.createQuery("from Student s where s.lastName='Jitesh' or s.lastName='Duck'").getResultList();
            printStudentList(studentList);
            session.getTransaction().commit();
            printLineSeparator();
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            List<Student> studentList1 = session.createQuery("from Student s where s.email like '%gmail.com'").getResultList();
            printStudentList(studentList1);
            session.getTransaction().commit();
            printLineSeparator();
        }
    }

    private static void printLineSeparator() {
        System.out.println("____________________________________________________________________");
    }

    private static void printStudentList(List<Student> students) {
        students.forEach(System.out::println);
    }
}
