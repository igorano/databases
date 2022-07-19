package tests.drivers;

import tests.interfaces.iMySQLQueries;

public class MySQLDriver extends DatabaseDriver implements iMySQLQueries {

    public MySQLDriver() {
        super.driver = getConnection("mySQL");
    }

    @Override
    public Integer getTableCount() {
        return getTableCount(TABLE_COUNT_QUERY);
    }

    @Override
    public String getByFullName(String firstName, String lastName) {
        return getByFullName(BY_FULL_NAME_QUERY, firstName, lastName);
    }

}