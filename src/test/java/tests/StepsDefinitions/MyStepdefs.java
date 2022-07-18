package tests.StepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.drivers.DatabaseDriver;
import tests.drivers.MySQLDriver;
import tests.interfaces.MySQLQueries;
import org.junit.Assert;

import java.sql.*;


public class MyStepdefs implements MySQLQueries {
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

        stmt.execute(CREATE_DATABASE);
        stmt.execute(CREATE_TABLE);
        for (int i = 0; i <5 ; i++ ) {
            stmt.execute(String.format(INSERT_QUERY, 1, "Ivan", "Petrov"));
        }
    }

    @Then("verify created records")
    public void verify_created_records() throws SQLException {
        ResultSet r = stmt.executeQuery(COUNT_IDS);
        r.next();
        int countedIDs = r.getInt("count(StudentID)");
        stmt.getMaxRows();
        Assert.assertEquals(countedIDs,5);

        ResultSet firstnameRes = stmt.executeQuery(String.format(SELECT_DISTINCT_FIRSTNAME));
        firstnameRes.next();
        String fName = firstnameRes.getString("Firstname");
        System.out.println("FirstName is " + fName);

        ResultSet lastnameRes = stmt.executeQuery(String.format(SELECT_DISTINCT_LASTNAME));
        lastnameRes.next();
        String lName = lastnameRes.getString("Lastname");
        System.out.println("Lastname is " + lName);

        Assert.assertEquals(fName + " " + lName ,"Ivan Petrov");

        stmt.executeUpdate(DROP_DATABASE);
        System.out.println("Database deleted successfully...");
    }
}
