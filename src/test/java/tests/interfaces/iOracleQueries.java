package tests.interfaces;

public interface iOracleQueries {
    String SELECT_ALL =  "SELECT * FROM STUDENTS ;";
    String CREATE_TABLE ="CREATE TABLE students.%s (StudentID int,FirstName varchar(255),LastName varchar(255));";
    String CREATE_DATABASE = "CREATE DATABASE STUDENTS";
    String INSERT = "INSERT INTO students.%s VALUES (%2d, %s, %s );";
    String SELECT_FIRSTNAMES = "SELECT * FROM students.%s Where students.Firstname = '%s'";
    String DROP_DATABASE = "DROP DATABASE STUDENTS;";

    String TABLE_COUNT_QUERY = "SELECT COUNT(*) FROM students.tables";
    String BY_FULL_NAME_QUERY = "SELECT * FROM FROM students.tables WHERE NAME1 = '%s' AND NAME2 = '%s'";
}
