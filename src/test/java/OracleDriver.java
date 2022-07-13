import interfaces.MySQLQueries;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class OracleDriver extends DatabaseDriver implements MySQLQueries {
    private static Properties prop;

    public void setupDefaultConnection() {
            prop = new Properties();
            try (
                    InputStream input = new FileInputStream("./src/test/resources/settings.properties")) {

                prop = new Properties();

                // load a properties file
                prop.load(input);

                // get the property value and print it out
                System.out.println(prop.getProperty("oracleJdbcURL"));
                System.out.println(prop.getProperty("oracleUsername"));
                System.out.println(prop.getProperty("oraclePassword"));

            } catch (
                    IOException ex) {
                ex.printStackTrace();
            }
    }
}
