package pl.alex.app.hibernate.crud;

import org.hibernate.Session;
import pl.alex.app.entity.Student;
import pl.alex.app.hibernate.factory.SessionFactoryUtil;

import java.util.List;

public class CreateStudentDemo {
    public static void main(String[] args) {
        Student student2 = new Student("Baba", "Slavka", "babaslavka@email.com");
        // create session factory & session
        Session session = SessionFactoryUtil.getCurrentSessionFromConfig(List.of(student2));
            session.beginTransaction();
            session.save(student2);
            session.getTransaction().commit();

    }
}
