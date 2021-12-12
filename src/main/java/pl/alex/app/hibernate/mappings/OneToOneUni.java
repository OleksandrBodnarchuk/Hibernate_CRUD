package pl.alex.app.hibernate.mappings;

import pl.alex.app.entity.Instructor;
import pl.alex.app.entity.InstructorDetail;
import pl.alex.app.hibernate.factory.SessionFactoryUtil;
import org.hibernate.Session;

import java.util.List;

public class OneToOneUni {
    public static void main(String[] args) {
        //        Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@luv2code.com");
        //        InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "Luv 2 code!");
        Instructor tempInstructor = new Instructor("Alex", "Bod", "alexbod@email.com");
        InstructorDetail tempInstructorDetail = new InstructorDetail("https://youtube.com", "Boxing & Coding");
        tempInstructor.setDetail(tempInstructorDetail); // associate objects
        // Create session
        Session session = SessionFactoryUtil.getCurrentSessionFromConfig(List.of(tempInstructor, tempInstructorDetail));
        saveInstructor(tempInstructor, session);

        //   deleteInstructor(tempInstructor, session);

    }

    private static void deleteInstructor(Instructor tempInstructor, Session session) {
        System.out.println(tempInstructor);
        session.beginTransaction();
        try {
            Instructor forDelete = (Instructor) session.createQuery(" from Instructor i where i.email='"
                    + tempInstructor.getEmail()
                    + "' and i.lastName='" + tempInstructor.getLastName() + "'").getResultList().get(0);
            session.delete(forDelete);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Instructor " + tempInstructor.shortInfo() + " not found in DataBase.");
        }

        session.getTransaction().commit();
    }

    private static void saveInstructor(Instructor tempInstructor, Session session) {
        session.beginTransaction(); // begin transaction
        session.save(tempInstructor); // save instructor + ALL instructor detail object -> CascadeType.ALL
        session.getTransaction().commit(); // commit transaction
    }


}
