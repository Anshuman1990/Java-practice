import com.infybank.compoundinterestcalculator.CompoundInterestCalculator;
import com.infybank.interestcalculator.InterestCalculator;

module com.infybank.compoundinterest {
    requires com.infybank.interestcalculator;
    provides InterestCalculator with CompoundInterestCalculator;
}