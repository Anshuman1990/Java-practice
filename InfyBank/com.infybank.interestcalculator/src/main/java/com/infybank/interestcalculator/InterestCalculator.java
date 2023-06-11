package com.infybank.interestcalculator;

public interface InterestCalculator {
    String getInterestType();
    Double calculateInterest(Double principal, Double rate, Double time);
}
