package tests.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface iDatabaseHelper {
    Integer getTableCount();
    String getByFullName(String firstName, String lastName);
    void createDB(String dbName) throws SQLException;
    void createTable(String tableName);
    void insertRecord(String tableName, Integer id, String firstName, String lastName);
    Integer countId(String tableName) throws SQLException;
    String getLastname(String tableName) throws SQLException;
    String getFirstname(String tableName) throws SQLException;
    void dropDb(String dbName);
    Connection getConnection(String dbType) throws SQLException;
}
