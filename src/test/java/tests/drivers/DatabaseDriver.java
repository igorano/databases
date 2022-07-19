package tests.drivers;

import tests.interfaces.iDatabaseHelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public abstract class DatabaseDriver implements iDatabaseHelper {

    Connection driver;

    public Integer getTableCount(String statement) {
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
    }

    public Connection getConnection(String dbType) {
        Properties prop = new Properties();

        try (
            InputStream input = new FileInputStream("./src/test/resources/settings.properties")) {
            prop.load(input);
            // get the property value and print it out
            switch (dbType){
                case "Oracle":
                    return DriverManager.getConnection(
                            prop.getProperty("jdbcURL"),
                            prop.getProperty("username"),
                            prop.getProperty("password"));
                case "mySQL":
                    return DriverManager.getConnection(
                            prop.getProperty("oracleJdbcURL"),
                            prop.getProperty("oracleUsername"),
                            prop.getProperty("oraclePassword"));
            }
        } catch (
                IOException ex) {
            ex.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //TODO: handle this
        return null;
    }
}
