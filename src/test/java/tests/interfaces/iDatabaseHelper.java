package tests.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface iDatabaseHelper {
    Integer getTableCount();
    String getByFullName(String firstName, String lastName);
    Connection getConnection(String dbType) throws SQLException;
}
