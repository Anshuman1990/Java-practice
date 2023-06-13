package com.easyrentals.ui;

import com.easyrentals.model.Bike;
import com.easyrentals.service.EasyRentalsService;
import com.easyrentals.service.impl.EasyRentalsServiceImpl;

import java.util.ServiceLoader;
import java.util.Set;

import static java.lang.System.out;

public class UserInterface {
    public static void main(String[] args) {
        EasyRentalsServiceImpl service = new EasyRentalsServiceImpl();

//        ServiceLoader<EasyRentalsService> easyRentalsService = ServiceLoader.load(EasyRentalsService.class);
//        out.println("Services Found:- " + easyRentalsService.stream().count());
//        easyRentalsService.stream().forEach(easyRentalsServiceProvider -> {
//            Set<Bike> bikeSet = easyRentalsServiceProvider.get().getBikeDetails();
//            out.println("The following 4 bikes are available for rent:");
//            bikeSet.forEach(bike -> out.println(bike.toString()));
//        });
    }
}
