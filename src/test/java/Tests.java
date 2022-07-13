import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class Tests {
    private static Properties prop;
    private static Connection conn;
    @BeforeClass
    public static void setUpDB() throws SQLException {
        try (InputStream input = new FileInputStream("./src/test/resources/settings.properties")) {

            prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println(prop.getProperty("jdbcUrl"));
            System.out.println(prop.getProperty("username"));
            System.out.println(prop.getProperty("password"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        conn = DriverManager.getConnection(prop.getProperty("jdbcUrl"), prop.getProperty("username"), prop.getProperty("password"));
    }

    @AfterClass
    public static void tearDownDB() throws SQLException {
        conn.close();
    }

    @Test
    public void createDatabase() throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = "CREATE DATABASE STUDENTS";
        stmt.executeUpdate(sql);
        System.out.println("Database created successfully...");

        //Students students = new Students(1,"Ivan", "Petrov");

        String createStudents = "CREATE TABLE students.students (StudentID int,FirstName varchar(255),LastName varchar(255));";
        stmt.executeUpdate(createStudents);
        String insertDB = "INSERT INTO students.students VALUES (1, 'Ivan', 'Petrov');" ;

        long i = stmt.executeUpdate(insertDB);
        assertThat(i, equalTo(1L));
        System.out.println("Record is created successfully...");

        String selectAllStudents = "SELECT * FROM students.students Where students.Firstname = 'Ivan';";
        var allStudents = stmt.execute(selectAllStudents);
        assertTrue(allStudents);
    }

    @Test
    public void deleteDatabase() throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = "DROP DATABASE STUDENTS";
        stmt.executeUpdate(sql);
        System.out.println("Database deleted successfully...");
    }

    @Test
    public void countRecords() throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = "Select COUNT(id) FROM students.students;";
        stmt.executeUpdate(sql);
    }

}
