package pl.alex.app.hibernate.crud;

import org.hibernate.Session;
import pl.alex.app.entity.Student;
import pl.alex.app.hibernate.factory.SessionFactoryUtil;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {
        // create session factory
            Session session = SessionFactoryUtil.getCurrentSessionFromConfig(List.of(new Student())); // create session
            session.beginTransaction();
            List<Student> from_student = session.createQuery("from Student").getResultList();
            printStudentList(from_student);
            session.getTransaction().commit();
            printLineSeparator();
    }

    private static void printLineSeparator() {
        System.out.println("____________________________________________________________________");
    }

    private static void printStudentList(List<Student> students) {
        students.forEach(System.out::println);
    }
}
