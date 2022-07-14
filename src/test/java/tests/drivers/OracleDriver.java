package tests.drivers;

import tests.interfaces.MySQLQueries;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class OracleDriver extends DatabaseDriver implements MySQLQueries {
    public Connection connectToOracle() throws SQLException {
        String jdbcUrl = null;
        String username = null;
        String password = null;

        Properties prop = new Properties();
        try (
                InputStream input = new FileInputStream("./src/test/resources/settings.properties")) {
            prop.load(input);
            // get the property value and print it out
            jdbcUrl = prop.getProperty("oracleJdbcURL");
            username = prop.getProperty("oracleUsername");
            password = prop.getProperty("oraclePassword");

        } catch (
                IOException ex) {
            ex.printStackTrace();
        }

        return getAnyConnection(jdbcUrl, username, password);
    }
}
