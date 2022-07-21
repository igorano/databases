package tests.drivers;

import tests.interfaces.iOracleQueries;

import java.sql.SQLException;

public class OracleDriver extends DatabaseDriver implements iOracleQueries {

    public OracleDriver() {
        super.driver = getConnection("Oracle");
    }

    @Override
    public Integer getTableCount(){
        return getTableCount(TABLE_COUNT_QUERY);
    }

    @Override
    public String getByFullName(String firstName, String lastName) {
        return getByFullName(BY_FULL_NAME_QUERY, firstName, lastName);
    }

    @Override
    public void createDB(String dbName) {

    }

    @Override
    public void createTable(String tableName) {

    }

    @Override
    public void insertRecord(String tableName, Integer id, String firstName, String lastName) {

    }

    @Override
    public Integer countId(String tableName) throws SQLException {
        return null;
    }

    @Override
    public String getLastname(String tableName) throws SQLException {
        return null;
    }

    @Override
    public String getFirstname(String tableName) throws SQLException {
        return null;
    }

    @Override
    public void dropDb(String dbName) {

    }

}
