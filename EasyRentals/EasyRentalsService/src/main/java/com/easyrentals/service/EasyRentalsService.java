package com.easyrentals.service;

import com.easyrentals.dao.EasyRentalsDAO;
import com.easyrentals.model.Bike;

import java.util.Set;

public class EasyRentalsService {
    private EasyRentalsDAO easyRentalsDAO;

    public EasyRentalsService(EasyRentalsDAO easyRentalDAO) {
        this.easyRentalsDAO = easyRentalDAO;
    }

    public Set<Bike> getBikeDetails() {
        return this.easyRentalsDAO.getBikeDetails();
    }
}
