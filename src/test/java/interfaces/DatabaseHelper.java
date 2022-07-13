package interfaces;

public interface DatabaseHelper {
    public static void getDataByID(int id){
        String getId = String.format("SELECT * FROM students.students WHERE id=%2d", id);
    }
    public static void getTableCount(){
        String tableCount = "SELECT COUNT(*) FROM students.tables";
    }
    public static void getByFullName(String firstName, String lastName ){
        String getId = String.format("SELECT * FROM students.students WHERE FirstName=%s AND LastName = %s", firstName, lastName);
    }
}
