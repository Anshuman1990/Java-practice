package com.designPattern.Creational.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
    DBConnection connection = DBConnection.createInstance("connection");
    DBConnection connection1 = null;
    Constructor[] constructors =  DBConnection.class.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            constructor.setAccessible(true);
            connection1 = (DBConnection) constructor.newInstance("qwerty");
            break;
        }
        System.out.println(connection.getName()+"\nhashcode= "+connection.hashCode());
        assert connection1 != null;
        System.out.println(connection1.getName()+"\nhashcode="+connection1.hashCode());
    }
}
