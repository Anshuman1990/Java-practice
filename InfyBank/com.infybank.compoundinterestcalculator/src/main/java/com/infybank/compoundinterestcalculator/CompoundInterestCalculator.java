package com.infybank.compoundinterestcalculator;

import com.infybank.interestcalculator.InterestCalculator;

public class CompoundInterestCalculator implements InterestCalculator {
private String interestType = "Compound Interest";

    @Override
    public String getInterestType() {
        return interestType;
    }

    @Override
    public Double calculateInterest(Double principal, Double rate, Double time) {
        return principal * Math.pow(1 + (rate/1200), 12*time) - principal;
    }
}
