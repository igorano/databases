package tests.interfaces;

import java.sql.SQLException;

public interface iMySQLQueries {
    String CREATE_DATABASE =  "CREATE DATABASE STUDENTS";
    String INSERT_QUERY =  "INSERT INTO students.students VALUES (%2d, '%s', '%s' );";
    String COUNT_IDS = "SELECT COUNT(StudentID) FROM students.students;";
    String SELECT_DISTINCT_LASTNAME = "SELECT DISTINCT(LastName) FROM students.students;";
    String SELECT_DISTINCT_FIRSTNAME = "SELECT DISTINCT(FirstName) FROM students.students;";
    String DROP_DATABASE = "DROP DATABASE STUDENTS;";
    String CREATE_TABLE ="CREATE TABLE students.%s (StudentID int,FirstName varchar(255),LastName varchar(255));";

    String TABLE_COUNT_QUERY = "SELECT COUNT(*) FROM students.%s";
    String BY_FULL_NAME_QUERY = "SELECT * FROM FROM students.tables WHERE NAME1 = '%s' AND NAME2 = '%s'";
}
