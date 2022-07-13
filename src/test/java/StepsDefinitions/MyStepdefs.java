package StepsDefinitions;

import interfaces.MySQLQueries;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class MyStepdefs implements MySQLQueries {
    private static Properties prop;
    private static Connection conn;
    private static Statement stmt;

    @Given("connect to database")
    public void connect_to_database() throws SQLException {
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

    @When("create five records")
    public void create_five_records() throws SQLException {
         stmt = conn.createStatement();

        stmt.execute(createDatabase());
        createTable();
        for (int i = 0; i <5 ; i++ ) {
            stmt.execute(insert(1, "Ivan", "Petrov"));
        }
    }
    @Override
    public void createTable() {
        try {
            stmt.executeQuery("CREATE TABLE students.students (StudentID int,FirstName varchar(255),LastName varchar(255));");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Then("verify created records")
    public void verify_created_records() throws SQLException {
        ResultSet r = stmt.executeQuery(countIds());
        r.next();
        int countedIDs = r.getInt("count(StudentID)");
        stmt.getMaxRows();
        Assert.assertEquals(countedIDs,5);

        ResultSet firstnameRes = stmt.executeQuery(selectDistinctFirstname());
        firstnameRes.next();
        String fName = firstnameRes.getString("Firstname");
        createTable();
        System.out.println("FirstName is " + fName);

        ResultSet lastnameRes = stmt.executeQuery(selectDistinctLastname());
        lastnameRes.next();
        String lName = lastnameRes.getString("Lastname");
        System.out.println("Lastname is " + lName);

        Assert.assertEquals(fName + " " + lName ,"Ivan Petrov");

        stmt.executeUpdate(dropDB());
        System.out.println("Database deleted successfully...");
    }
}
