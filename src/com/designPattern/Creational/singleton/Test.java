package com.designPattern.Creational.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
    DBConnection connection = DBConnection.getInstance();
    DBConnection connection1 = null;
    Constructor[] constructors =  DBConnection.class.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            constructor.setAccessible(true);
            connection1 = (DBConnection) constructor.newInstance();
            break;
        }
        System.out.println("\nhashcode= "+connection.hashCode());
        assert connection1 != null;
        System.out.println("\nhashcode="+connection1.hashCode());
    }
}
