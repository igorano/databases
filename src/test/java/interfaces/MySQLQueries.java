package interfaces;

public interface MySQLQueries {
    public default String selectAll(){
        return "SELECT * FROM STUDENTS ;";
    };
    public default String createTable() {
        return "CREATE TABLE students.students (StudentID int,FirstName varchar(255),LastName varchar(255));";
    };

    public default String createDatabase() {
        return "CREATE DATABASE STUDENTS";
    };

    public default String insert(int id, String firstName, String lastName){
        return  String.format("INSERT INTO students.students VALUES (%2d, '%s', '%s' );", id , firstName, lastName);
    };

    public default String countIds(){
        return String.format("SELECT COUNT(StudentID) FROM students.students");
    };

    public default String selectByFirstname(String firstName){
        return  String.format("SELECT * FROM students.students Where students.Firstname = '%s'", firstName);
    };

    public default String selectDistinctLastname(){
        return  String.format("SELECT DISTINCT(LastName) FROM students.students");
    };
    public default String selectDistinctFirstname(){
        return  String.format("SELECT DISTINCT(FirstName) FROM students.students");
    };
    public default String dropDB(){
        return "DROP DATABASE STUDENTS;";
    };
}
