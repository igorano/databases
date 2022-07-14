package tests.drivers;

import tests.interfaces.DatabaseHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseDriver implements DatabaseHelper {
    public Connection getAnyConnection(String url, String username, String password) throws SQLException {
        return  DriverManager.getConnection(url, username, password);
    }
}
