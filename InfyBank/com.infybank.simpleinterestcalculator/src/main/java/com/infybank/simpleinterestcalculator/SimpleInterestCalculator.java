package com.infybank.simpleinterestcalculator;

import com.infybank.interestcalculator.InterestCalculator;

public class SimpleInterestCalculator implements InterestCalculator {

    private String interestType = "Simple Interest";
    @Override
    public String getInterestType() {
        return interestType;
    }

    @Override
    public Double calculateInterest(Double principal, Double rate, Double time) {
        return (principal * rate * time)/100;
    }
}
