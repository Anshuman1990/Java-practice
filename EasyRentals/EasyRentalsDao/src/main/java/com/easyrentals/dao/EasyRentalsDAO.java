package com.easyrentals.dao;

import java.util.LinkedHashSet;
import java.util.Set;

import com.easyrentals.model.Bike;

public class EasyRentalsDAO {
    public Set<Bike> getBikeDetails()  {
        Set<Bike> set = new LinkedHashSet<Bike>();

        Bike bike1= new Bike();
        bike1.setBikeId(1001);
        bike1.setBikeName("CBR");
        bike1.setCompanyName("Honda");
        bike1.setRentPrice(500.0);
        bike1.setSerialNumber("Hon:1001");

        Bike bike2= new Bike();
        bike2.setBikeId(1003);
        bike2.setBikeName("Bullet");
        bike2.setCompanyName("Enfield");
        bike2.setRentPrice(900.0);
        bike2.setSerialNumber("Enf:1003");

        Bike bike3= new Bike();
        bike3.setBikeId(1004);
        bike3.setBikeName("Karizma");
        bike3.setCompanyName("Hero");
        bike3.setRentPrice(700.0);
        bike3.setSerialNumber("Her:1004");

        Bike bike4= new Bike();
        bike4.setBikeId(1002);
        bike4.setBikeName("CBZ");
        bike4.setCompanyName("Hero");
        bike4.setRentPrice(800.0);
        bike1.setSerialNumber("Her:1002");

        set.add(bike1);
        set.add(bike2);
        set.add(bike3);
        set.add(bike4);
        return set;
    }
}
