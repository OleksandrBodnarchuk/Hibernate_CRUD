package pl.alex.app.hibernate.crud;

import org.hibernate.Session;
import pl.alex.app.entity.Student;
import pl.alex.app.hibernate.factory.MySessionFactory;

public class CreateStudentDemo {
    public static void main(String[] args) {
        Student student2 = new Student("Baba", "Slavka", "babaslavka@email.com");
        // create session factory & session
        Session session = MySessionFactory.getCurrentSessionFromConfig(student2);
            session.beginTransaction();
            session.save(student2);
            session.getTransaction().commit();

    }
}
