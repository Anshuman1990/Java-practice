package com.practice.java8_17.language.reactive.streams;

import java.util.List;
import java.util.Random;

public class DataProvider {
    public static List<Stock> getStockData() {
        Random random = new Random();

        Stock stock1 = new Stock();
        stock1.setName("stock1");
        stock1.setPrice(random.nextFloat() * 100);

        Stock stock2 = new Stock();
        stock2.setName("stock2");
        stock2.setPrice(random.nextFloat() * 100);

        Stock stock3 = new Stock();
        stock3.setName("stock3");
        stock3.setPrice(random.nextFloat() * 100);

        Stock stock4 = new Stock();
        stock4.setName("stock4");
        stock4.setPrice(random.nextFloat() * 100);

        Stock stock5 = new Stock();
        stock5.setName("stock5");
        stock5.setPrice(random.nextFloat() * 100);
        return List.of(stock1, stock2, stock3, stock4, stock5);
    }
}
