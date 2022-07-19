package tests.drivers;

import tests.interfaces.iOracleQueries;

public class OracleDriver extends DatabaseDriver implements iOracleQueries {

    public OracleDriver() {
        super.driver = getConnection("Oracle");
    }

    @Override
    public Integer getTableCount(){
        return getTableCount(TABLE_COUNT_QUERY);
    }

    @Override
    public String getByFullName(String firstName, String lastName) {
        return getByFullName(BY_FULL_NAME_QUERY, firstName, lastName);
    }

}
