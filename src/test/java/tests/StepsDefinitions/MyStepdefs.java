package tests.StepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.drivers.MySQLDriver;
import tests.interfaces.MySQLQueries;
import org.junit.Assert;

import javax.xml.crypto.Data;
import java.sql.*;


public class MyStepdefs {
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

        stmt.execute(MySQLQueries.CREATE_DATABASE);
        stmt.execute(String.format(MySQLQueries.CREATE_TABLE, "students"));
        for (int i = 0; i <5 ; i++ ) {
            stmt.execute(String.format(MySQLQueries.INSERT_QUERY, "students",1, "Ivan", "Petrov"));
        }
    }

    @Then("verify created records")
    public void verify_created_records() throws SQLException {
        ResultSet r = stmt.executeQuery(String.format(MySQLQueries.COUNT_IDS, "students"));
        r.next();
        int countedIDs = r.getInt("count(StudentID)");
        stmt.getMaxRows();
        Assert.assertEquals(countedIDs,5);

        ResultSet firstnameRes = stmt.executeQuery(String.format(MySQLQueries.SELECT_DISTINCT_FIRSTNAME, "students"));
        firstnameRes.next();
        String fName = firstnameRes.getString("Firstname");
        System.out.println("FirstName is " + fName);

        ResultSet lastnameRes = stmt.executeQuery(String.format(MySQLQueries.SELECT_DISTINCT_LASTNAME, "students"));
        lastnameRes.next();
        String lName = lastnameRes.getString("Lastname");
        System.out.println("Lastname is " + lName);

        Assert.assertEquals(fName + " " + lName ,"Ivan Petrov");

        stmt.executeUpdate(MySQLQueries.DROP_DATABASE);
        System.out.println("Database deleted successfully...");
    }
}
