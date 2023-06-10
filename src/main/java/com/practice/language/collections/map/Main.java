package com.practice.language.collections.map;
import com.practice.language.collections.*;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<Employee,Integer> myMap = new HashMap<>();

        Employee emp_1 = new Employee();
        Employee emp_2 = new Employee();
        emp_1.setId(1);
        emp_1.setName("qwerty");
        emp_1.setAddress("q1w2e3r4t5y6");

        emp_2.setId(2);
        emp_2.setName("asdfgh");
        emp_2.setAddress("a1s2d3f4g5h6");

        myMap.put(emp_1,emp_1.getId());
        myMap.put(emp_2,emp_2.getId());

        System.out.println(myMap.get(emp_1).toString());
    }
}
