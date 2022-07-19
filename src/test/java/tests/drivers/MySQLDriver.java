package tests.drivers;

import tests.interfaces.MySQLQueries;

import java.sql.Connection;
import java.sql.SQLException;

public class MySQLDriver extends DatabaseDriver implements MySQLQueries {
        public Connection connectToMysql() throws SQLException {
            return getAnyConnection("jdbcUrl", "username", "password");
        }
}