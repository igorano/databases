import interfaces.DatabaseHelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public abstract class DatabaseDriver implements DatabaseHelper {
    private static Properties prop;
    private static Connection conn;

    public Connection DatabaseDriver(String url, String username, String password) throws SQLException {
        try (
                InputStream input = new FileInputStream("./src/test/resources/settings.properties")) {

            prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println(prop.getProperty("jdbcUrl"));
            System.out.println(prop.getProperty("username"));
            System.out.println(prop.getProperty("password"));

        } catch (
                IOException ex) {
            ex.printStackTrace();
        }
        conn = DriverManager.getConnection(prop.getProperty("jdbcUrl"), prop.getProperty("username"), prop.getProperty("password"));
        return  conn;
    }
}
