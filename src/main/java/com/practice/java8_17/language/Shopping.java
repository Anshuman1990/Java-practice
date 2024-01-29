package com.practice.java8_17.language;

public interface Shopping {
    default void addItem(String userName) {
        login(userName);
        System.out.println("add new item to cart");
    }

    default void viewCart(String userName) {
        login(userName);
        System.out.println("view cart");
    }

    default void makePayment(String userName) {
        login(userName);
        System.out.println("make payment to purchase items");
    }

    private void login(String userName) {
        System.out.println(userName + " please login to continue");
    }
}

