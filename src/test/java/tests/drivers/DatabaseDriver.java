package tests.drivers;

import tests.interfaces.DatabaseHelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseDriver implements DatabaseHelper {
     String jdbcUrl = null;
     String userName = null;
     String passWord = null;


    public Connection getAnyConnection(String url, String username, String password) throws SQLException {
        Properties prop = new Properties();
        Connection dbConnection = null;
        try (
                InputStream input = new FileInputStream("./src/test/resources/settings.properties")) {
            prop.load(input);
            // get the property value and print it out
            jdbcUrl = prop.getProperty(url);
            userName = prop.getProperty(username);
            passWord = prop.getProperty(password);

            dbConnection = DriverManager.getConnection(jdbcUrl, userName, passWord);

            if (dbConnection != null) { System.out.println("Successfully connected to MySQL database test"); }

        } catch (IOException ex) {
            System.out.println("An error occurred while connecting MySQL databse");
            ex.printStackTrace();
        }
        return dbConnection;
    }
}
