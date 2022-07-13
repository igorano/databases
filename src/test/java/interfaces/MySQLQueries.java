package interfaces;

public interface MySQLQueries {
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
        return  String.format("INSERT INTO students.students VALUES (%2d, '%s', '%s' );", id , firstName, lastName);
    };

    default String countIds(){
        return String.format("SELECT COUNT(StudentID) FROM students.students");
    };

    default String selectByFirstname(String firstName){
        return  String.format("SELECT * FROM students.students Where students.Firstname = '%s'", firstName);
    };

    default String selectDistinctLastname(){
        return  String.format("SELECT DISTINCT(LastName) FROM students.students");
    };
    default String selectDistinctFirstname(){
        return  String.format("SELECT DISTINCT(FirstName) FROM students.students");
    };
    default String dropDB(){
        return "DROP DATABASE STUDENTS;";
    };
}
