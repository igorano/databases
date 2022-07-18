package tests.drivers;

import java.sql.Connection;
import java.sql.SQLException;

public class MySQLDriver extends DatabaseDriver {
        public Connection connectToMysql() throws SQLException {
            return getAnyConnection("jdbcUrl", "username", "password");
        }
}