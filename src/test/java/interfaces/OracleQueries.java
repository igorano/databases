package interfaces;

public interface OracleQueries {
    default String selectAll(){
        return "SELECT * FROM STUDENTS ;";
    };
    default String createTable() {
        return "CREATE TABLE students.students (StudentID int,FirstName varchar(255),LastName varchar(255));";
    };

    default String createDatabase() {
        return "CREATE DATABASE STUDENTS";
    };

    default String insert(int id, String firstName, String lastName){
        return String.format("INSERT INTO students.students VALUES (%2d, %s, %s );", id , firstName, lastName);
    };


    public default void selectByFirstname(String firstName){
        String selectByFirstname = String.format("SELECT * FROM students.students Where students.Firstname = '%s'", firstName);
    };
    public default void dropDB(){
        String drop = "DROP DATABASE STUDENTS;";
    };
}
