package com.solidpattern.good   ;

public class PasswordReminder {

    private DBConnectionInterface mySQLConnection;

    public PasswordReminder(MySQLConnection mySQLConn) {
        this.mySQLConnection = mySQLConn;
    }
}
