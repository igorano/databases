package tests.drivers;

import org.junit.Assert;
import tests.interfaces.iDatabaseHelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public abstract class DatabaseDriver implements iDatabaseHelper {

    Connection driver;

/*    public Integer getTableCount(String statement) {
        ResultSet rs;

        try {
            rs = driver.createStatement().executeQuery(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //TODO: extract from ResultSet and return required object
        return null;
    }

    public String getByFullName(String statement, String firstName, String lastName){
        ResultSet rs;

        try {
            rs = driver.createStatement().executeQuery(String.format(statement, firstName, lastName));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //TODO: extract from ResultSet and return required object
        return null;
    }*/

    public String getFirstName(String statement, String firstName) throws SQLException {
        ResultSet rs = null;

        try {
            rs = driver.createStatement().executeQuery(String.format(statement, firstName));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        rs.next();
        String fName = rs.getString("Firstname");

        return fName;
    }

    public String getLastName(String statement, String lastName) throws SQLException {
        ResultSet rs = null;

        try {
            rs = driver.createStatement().executeQuery(String.format(statement, lastName));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        rs.next();
        String lName = rs.getString("Lastname");

        return lName;
    }
    public void insertRecord(String statement,String tableName, String id, String firstName, String lastName){
        try {
            driver.createStatement().execute(String.format(statement,tableName, id, firstName, lastName));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable(String statement, String tableName){
        try {
            driver.createStatement().execute(String.format(statement,tableName));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Integer countId(String statement, String tableName) throws SQLException {
        ResultSet rs = null;

        try {
            rs = driver.createStatement().executeQuery(String.format(statement,tableName));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        rs.next();
        int countedID = rs.getInt("count(StudentID)");
        return  countedID;
    }

    public void dropDb(String statement,String dbName) {
        try {
            driver.createStatement().executeUpdate(String.format(statement,dbName));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createDB(String statement, String dbName) throws SQLException {
        driver.createStatement().executeUpdate(String.format(statement,dbName));
    }

    public Connection getConnection(String dbType) {
        Properties prop = new Properties();

        try (
            InputStream input = new FileInputStream("./src/test/resources/settings.properties")) {
            prop.load(input);
            // get the property value and print it out
            switch (dbType){
                case "mySQL":
                    return DriverManager.getConnection(
                            prop.getProperty("jdbcURL"),
                            prop.getProperty("username"),
                            prop.getProperty("password"));
                case "Oracle":
                    return DriverManager.getConnection(
                            prop.getProperty("oracleJdbcURL"),
                            prop.getProperty("oracleUsername"),
                            prop.getProperty("oraclePassword"));
            }
        } catch (
                IOException | SQLException ex) {
            ex.printStackTrace();
        }
        driver = getConnection(dbType);
        return driver;
    }
}
