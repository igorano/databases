package tests.drivers;

import tests.interfaces.iMySQLQueries;

import java.sql.SQLException;

public class MySQLDriver extends DatabaseDriver implements iMySQLQueries {

    public MySQLDriver() {
        super.driver = getConnection("mySQL");
    }

    @Override
    public Integer getTableCount() {
        return getTableCount(TABLE_COUNT_QUERY);
    }

    @Override
    public void createDB(String dbName) {
        createDB(CREATE_DATABASE, dbName);
    }

    @Override
    public void createTable(String tableName) {
        createTable(CREATE_TABLE, tableName);
    }

    @Override
    public void insertRecord(String tableName, Integer id, String firstName, String lastName) {

    }

    @Override
    public String getByFullName(String firstName, String lastName) {
        return getByFullName(BY_FULL_NAME_QUERY, firstName, lastName);
    }

    @Override
    public Integer countId(String tableName) throws SQLException {
        return countId(COUNT_IDS, tableName);
    }

    @Override
    public String getLastname(String tableName) throws SQLException {
        return getLastName(SELECT_DISTINCT_LASTNAME, tableName);
    }

    @Override
    public String getFirstname(String tableName) throws SQLException {
        return getFirstName(SELECT_DISTINCT_FIRSTNAME, tableName);
    }

    @Override
    public void dropDb(String dbName) {
        dropDb(DROP_DATABASE, dbName);
    }
}