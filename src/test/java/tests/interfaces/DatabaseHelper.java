package tests.interfaces;

import tests.drivers.DatabaseDriver;

public abstract class DatabaseHelper extends DatabaseDriver implements MySQLQueries,OracleQueries{
        abstract  public void getDataByID();
        abstract  public void getTableCount();
        abstract  public void getFullName();
}
