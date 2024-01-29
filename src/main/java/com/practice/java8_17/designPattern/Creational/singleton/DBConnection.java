package com.practice.java8_17.designPattern.Creational.singleton;

import java.io.Serializable;

public class DBConnection implements Serializable,Cloneable {


    private static volatile DBConnection DB_CONNECTION ;
    private DBConnection()
    {
        // private constructor
    }

    public static DBConnection getInstance()
    {
        if (DB_CONNECTION == null)
        {
            // To make thread safe
            synchronized (DBConnection.class)
            {
                // check again as multiple threads
                // can reach above step
                if (DB_CONNECTION==null)
                    DB_CONNECTION = new DBConnection();
            }
        }
        return DB_CONNECTION;
    }

    protected Object readResolve()
    {
        return getInstance();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
