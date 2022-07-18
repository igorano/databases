package tests.drivers;

import tests.interfaces.MySQLQueries;
import java.sql.SQLException;

public class OracleDriver extends DatabaseDriver implements MySQLQueries {
    public void connectToOracle() throws SQLException {
        getAnyConnection("oracleJdbcURL", "oracleUsername", "oraclePassword");
    }
}
