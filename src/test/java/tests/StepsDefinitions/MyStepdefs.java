package tests.StepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.database.StudentsDAO;
import tests.drivers.MySQLDriver;

import java.sql.SQLException;

import org.junit.Assert;


public class MyStepdefs {
    public StudentsDAO students;

    @Given("connect to database")
    public void connect_to_database(){
        students = new StudentsDAO(new MySQLDriver());
    }

    @Then("I can retrieve students data")
    public void count_tables(){
        System.out.println(students.getTableCount());
        System.out.println(students.getByFullName("Ivaylo", "Petrov"));

    }

    @When("create five records")
    public void createFiveRecords() throws SQLException {
        students.createDB("students");
        students.createTable("students");
        for (int i = 0; i <5 ; i++ ) {
            students.insertRecord("students","1", "Ivan", "Petrov");
        }
    }

    @Then("verify created records")
    public void verifyCreatedRecords() throws SQLException {
        Assert.assertTrue( students.countId("students") == 5 );
        Assert.assertEquals(students.getFirstname("students"),"Ivan");
        Assert.assertEquals(students.getLastname("students"),"Petrov");
        students.dropDb("students");
        System.out.println("Database deleted successfully...");
    }
}
