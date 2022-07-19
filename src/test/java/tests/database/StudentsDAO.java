package tests.database;

import tests.interfaces.iDatabaseHelper;

public class StudentsDAO {

    iDatabaseHelper driver;

    public StudentsDAO(iDatabaseHelper driver) {
        this.driver = driver;
    }

    public Integer getTableCount(){
        return driver.getTableCount();
    }

    public String getByFullName(String firstName, String lastName){
        return driver.getByFullName(firstName, lastName);
    }

}
