package com.solidpattern.good;

public class MySQLConnection implements DBConnectionInterface{
    @Override
    public String connect() {
        return "return database";
    }
}
