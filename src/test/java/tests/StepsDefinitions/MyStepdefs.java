package tests.StepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.drivers.DatabaseDriver;
import tests.drivers.MySQLDriver;
import tests.interfaces.MySQLQueries;
import org.junit.Assert;

import java.sql.*;


public class MyStepdefs extends DatabaseDriver implements MySQLQueries {
    private Connection conn;
    private static Statement stmt;

    @Given("connect to database")
    public void connect_to_database() throws SQLException {
        MySQLDriver mySQLDriver = new MySQLDriver();
        conn = mySQLDriver.connectToMysql();
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
            stmt.execute("CREATE TABLE students.students (StudentID int,FirstName varchar(255),LastName varchar(255));");
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
