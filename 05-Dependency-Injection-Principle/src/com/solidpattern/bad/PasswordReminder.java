package com.solidpattern.bad;

public class PasswordReminder {

    private MySQLConnection mySQLConnection;

    public PasswordReminder(MySQLConnection mySQLConn) {
        this.mySQLConnection = mySQLConn;
    }
}
