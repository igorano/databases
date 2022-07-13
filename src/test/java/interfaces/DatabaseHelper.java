package interfaces;

public interface DatabaseHelper {
    static String getDataByID(int id){
        return String.format("SELECT * FROM students.students WHERE id=%2d", id);
    }
    static String getTableCount(){
        return "SELECT COUNT(*) FROM students.tables";
    }
    static String getByFullName(String firstName, String lastName ){
        return String.format("SELECT * FROM students.students WHERE FirstName=%s AND LastName = %s", firstName, lastName);
    }
}
