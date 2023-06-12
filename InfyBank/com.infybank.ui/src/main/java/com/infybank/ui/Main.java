package com.infybank.ui;

import com.infybank.interestcalculator.InterestCalculator;

import java.util.Scanner;
import java.util.ServiceLoader;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        out.println("Enter the principal:- ");
        double principal = scanner.nextDouble();
        out.println("Enter the rate:- ");
        double rate = scanner.nextDouble();
        out.println("Enter time:-");
        double time = scanner.nextDouble();
        ServiceLoader<InterestCalculator> interestCalculators = ServiceLoader.load(InterestCalculator.class);
        out.println("Services Found:- " + interestCalculators.stream().count());
        interestCalculators.stream().forEach(interestCalculatorProvider -> out.println("Compound Interest"+ interestCalculatorProvider.get().calculateInterest(principal, rate, time)));
    }
}