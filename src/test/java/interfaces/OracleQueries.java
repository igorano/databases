package interfaces;

public interface OracleQueries {
    public default void selectAll(){
        String selectAll = "SELECT * FROM STUDENTS ;";
    };
    public default void createTable() {
        String createTable = "CREATE TABLE students.students (StudentID int,FirstName varchar(255),LastName varchar(255));";
    };

    public default void createDatabase() {
        String createTable = "CREATE DATABASE STUDENTS";
    };

    public default void insert(int id, String firstName, String lastName){
        String insert = String.format("INSERT INTO students.students VALUES (%2d, %s, %s );", id , firstName, lastName);
    };


    public default void selectByFirstname(String firstName){
        String selectByFirstname = String.format("SELECT * FROM students.students Where students.Firstname = '%s'", firstName);
    };
    public default void dropDB(){
        String drop = "DROP DATABASE STUDENTS;";
    };
}
