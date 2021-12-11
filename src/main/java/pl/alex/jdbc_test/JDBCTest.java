package pl.alex.jdbc_test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTest {
    public static void main(String[] args) {

        try(Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/hb_student_tracker","root","root");) {
            System.out.println("CONNECTED SUCCESSFULLY");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
