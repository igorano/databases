package tests.interfaces;

public interface DatabaseHelper {
    String GET_DATA_BY_ID =  "SELECT * FROM students.students WHERE id=%2d";
    String GET_TABLE_COUNT = "SELECT COUNT(*) FROM students.tables";
    String GET_FULL_NAME = "SELECT * FROM students.students WHERE FirstName=%s AND LastName = %s";
}
