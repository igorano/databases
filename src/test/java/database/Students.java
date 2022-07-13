package database;

public class Students {
    private int id;
    private String Fname;
    private String Lname;

    public Students(int id, String Fname, String Lname){
        this.id = id;
        this.Fname = Fname;
        this.Lname = Lname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getlname() {

        return Lname;
    }

    public void setLname(String Lname) {

        this.Lname = Lname;
    }

    public String getFname() {

        return Fname;
    }

    public void setFname(String Fname) {

        this.Fname = Fname;
    }
}
