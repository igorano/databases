package tests.StepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.database.StudentsDAO;
import tests.drivers.DatabaseDriver;
import tests.drivers.MySQLDriver;
import tests.drivers.OracleDriver;
import tests.interfaces.iMySQLQueries;
import org.junit.Assert;

import java.sql.*;


public class MyStepdefs {

    public StudentsDAO students;
    public StudentsDAO students2;

    @Given("connect to database")
    public void connect_to_database(){
        students = new StudentsDAO(new MySQLDriver());

        //another db type example
        //students2 = new StudentsDAO(new OracleDriver());
    }

    @Then("I can retrieve students data")
    public void count_tables(){
        System.out.println(students.getTableCount());
        System.out.println(students.getByFullName("Ivaylo", "Goranovskiy"));

    }
}
