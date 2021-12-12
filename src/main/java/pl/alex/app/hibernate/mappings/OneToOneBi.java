package pl.alex.app.hibernate.mappings;

import org.hibernate.Session;
import pl.alex.app.entity.Instructor;
import pl.alex.app.entity.InstructorDetail;
import pl.alex.app.hibernate.factory.SessionFactoryUtil;

import java.util.List;

public class OneToOneBi {
    public static void main(String[] args) {
        // Create session
        Session session = SessionFactoryUtil.getCurrentSessionFromConfig(List.of(new Instructor(), new InstructorDetail()));
        session.beginTransaction();
        InstructorDetail tempInstructorDetail = getInstructorFromDb(7,session);
        deleteInstructorDetailFromDb(tempInstructorDetail,session);
        session.getTransaction().commit();
    }

    private static InstructorDetail getInstructorFromDb(int theId, Session session) {
        InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
        System.out.println("Instructor Details --> " + tempInstructorDetail);
        System.out.println("Instructor --> "+tempInstructorDetail.getInstructor().shortInfo());
        return tempInstructorDetail;
    }
    private static void deleteInstructorDetailFromDb(InstructorDetail instructorDetail,Session session) {
        session.delete(instructorDetail);
    }


}
