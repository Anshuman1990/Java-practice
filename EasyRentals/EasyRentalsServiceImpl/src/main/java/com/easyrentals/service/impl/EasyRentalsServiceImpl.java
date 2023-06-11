package com.easyrentals.service.impl;

import com.easyrentals.dao.EasyRentalsDAO;
import com.easyrentals.model.Bike;
import com.easyrentals.service.EasyRentalsService;

import java.util.Set;

public class EasyRentalsServiceImpl implements EasyRentalsService {
    private final EasyRentalsDAO easyRentalsDAO;

    public EasyRentalsServiceImpl(){
        easyRentalsDAO = new EasyRentalsDAO();
    }

    public Set<Bike> getBikeDetails() {
        return this.easyRentalsDAO.getBikeDetails();
    }
}
