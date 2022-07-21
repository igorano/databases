package tests.database;

import tests.interfaces.iDatabaseHelper;

import java.sql.SQLException;

public class StudentsDAO {

    iDatabaseHelper driver;

    public StudentsDAO(iDatabaseHelper driver) {
        this.driver = driver;
    }

    public Integer getTableCount(){
        return driver.getTableCount();
    }

    public void createDB(String dbName) throws SQLException {
        driver.createDB(dbName);
    }
    public void createTable(String TableName){
        driver.createTable(TableName);
    }

    public void insertRecord(String tableName, Integer id , String firstName, String lastName){
        driver.insertRecord(tableName, id , firstName, lastName);
    }

    public Integer countId(String tableName) throws SQLException {
        return driver.countId(tableName);
    }
    public String getFirstname(String tableName) throws SQLException {
        return driver.getFirstname(tableName);
    }

    public String getLastname(String tableName) throws SQLException {
        return driver.getLastname(tableName);
    }

    public String getByFullName(String firstName, String lastName){
        return driver.getByFullName(firstName, lastName);
    }
    public void dropDb(String dbName) {
        driver.dropDb(dbName);
    }
}
