package tests.drivers;

import tests.interfaces.MySQLQueries;
import tests.interfaces.OracleQueries;

import java.sql.SQLException;

public class OracleDriver extends DatabaseDriver implements OracleQueries {
    public void connectToOracle() throws SQLException {
        getAnyConnection("oracleJdbcURL", "oracleUsername", "oraclePassword");
    }
}
