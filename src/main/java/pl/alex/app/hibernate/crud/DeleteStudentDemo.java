package pl.alex.app.hibernate.crud;

import org.hibernate.Session;
import pl.alex.app.entity.Student;
import pl.alex.app.hibernate.factory.SessionFactoryUtil;

import java.util.List;

public class DeleteStudentDemo {
    public static void main(String[] args) {
        // create session factory & session
        Session session = SessionFactoryUtil.getCurrentSessionFromConfig(List.of(new Student()));
            int studentId = 7;
            session.beginTransaction();// begin transaction
            session.createQuery("delete from Student where id="+studentId).executeUpdate();
            session.getTransaction().commit(); // commit transaction

    }
}
