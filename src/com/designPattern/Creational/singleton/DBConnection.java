package com.designPattern.Creational.singleton;

import java.io.Serializable;

public class DBConnection implements Serializable,Cloneable {

    private String name;

    private static DBConnection DB_CONNECTION = null;

    private DBConnection(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public static DBConnection createInstance(String name){
        return (DB_CONNECTION == null ? DB_CONNECTION = new DBConnection(name):DB_CONNECTION);
    }

    protected Object readResolve()
    {
        return DB_CONNECTION;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
