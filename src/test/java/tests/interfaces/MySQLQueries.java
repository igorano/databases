package tests.interfaces;

public interface MySQLQueries {
    String CREATE_DATABASE =  "CREATE DATABASE STUDENTS";
    String INSERT_QUERY =  "INSERT INTO students.%s VALUES (%2d, '%s', '%s' );";
    String COUNT_IDS = "SELECT COUNT(StudentID) FROM students.%s ;";
    String SELECT_DISTINCT_LASTNAME = "SELECT DISTINCT(LastName) FROM students.%s;";
    String SELECT_DISTINCT_FIRSTNAME = "SELECT DISTINCT(FirstName) FROM students.%s;";
    String DROP_DATABASE = "DROP DATABASE STUDENTS;";
    String CREATE_TABLE ="CREATE TABLE students.%s (StudentID int,FirstName varchar(255),LastName varchar(255));";
}
