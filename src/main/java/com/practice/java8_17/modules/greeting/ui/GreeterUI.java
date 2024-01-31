package com.practice.java8_17.modules.greeting.ui;


import com.practice.java8_17.modules.greeting.service.birthday.BirthdayGreeterService;

public class GreeterUI {
    public static void main(String[] args) {
        System.out.println(new BirthdayGreeterService().greet("Sarah"));
    }
}

