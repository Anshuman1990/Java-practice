package com.hackerrank.algorithms;

import java.util.Scanner;

public class DayOfTheProgrammer {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int year = scanner.nextInt();
        System.out.println(dayOfProgrammer(year));
    }

    // Complete the dayOfProgrammer function below.
    static String dayOfProgrammer(int year) {
        StringBuilder stringBuilder = new StringBuilder();
        String dateWithLeapYear = "12.09." + year;
        String dateWithoutLeapYear = "13.09." + year;
        boolean isLeapYear = false;
        if (year <= 1917) {
            isLeapYear = year % 4 == 0 ? true : false;
        } else if (year >= 1919) {
            isLeapYear = year %400 == 0?true : ((year % 4 ==0) && (year % 100 !=0)) ? true: false;
        } else {
            
        }
        if (isLeapYear) {
            return dateWithLeapYear;
        }
        return dateWithoutLeapYear;
    }
}
