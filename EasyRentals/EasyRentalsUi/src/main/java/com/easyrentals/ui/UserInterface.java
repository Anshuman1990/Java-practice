package com.easyrentals.ui;

import com.easyrentals.dao.EasyRentalsDAO;
import com.easyrentals.model.Bike;
import com.easyrentals.service.EasyRentalsService;

import java.util.Set;

import static java.lang.System.*;

public class UserInterface {
    public static void main(String[] args) {
        EasyRentalsDAO easyRentalsDAO = new EasyRentalsDAO();
        EasyRentalsService easyRentalsService = new EasyRentalsService(easyRentalsDAO);
        Set<Bike> bikeSet = easyRentalsService.getBikeDetails();
        out.println("The following 4 bikes are available for rent:");
        bikeSet.forEach(bike -> out.println(bike.toString()));
    }
}
