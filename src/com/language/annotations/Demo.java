package com.language.annotations;

public class Demo {

    @JDBCConnection(DatabaseName = "SQL Server", DatabaseUserName = "root", DatabasePassword = "root")
    public String test1() {
        System.out.println("TEST1");
        return "TEST1";
    }

    @JDBCConnection(DatabaseName = "mySql", DatabaseUserName = "root", DatabasePassword = "root")
    public void test2() {
        System.out.println("TEST2");
    }

}
