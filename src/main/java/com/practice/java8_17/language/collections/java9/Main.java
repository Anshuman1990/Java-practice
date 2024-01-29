package com.practice.java8_17.language.collections.java9;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> courseList=new ArrayList<>();
        courseList.add("English");
        courseList.add("Mathematics");
        courseList.add("Java");
        courseList.add("Operating Systems");
        courseList.add("Data Structures");
        List<String> immutableCourseList= Collections.unmodifiableList(courseList);
        System.out.println("immutableCourseList = " + immutableCourseList);
        courseList.add("Algorithms");
        System.out.println("immutableCourseList = " + immutableCourseList);

        List<String> immutableCourseListOf = List.of("English", "Mathematics", "Java", "Operating Systems", "Data Structures");
        System.out.println(immutableCourseListOf);

        Set<String> immutableSet = Set.of("English", "Mathematics", "Operating Systems");
        System.out.println(immutableSet);

        Map<Integer,String> immutableCoursesMap = Map.ofEntries(Map.entry(1001,"English"), Map.entry(1002,"Mathematics"));
        System.out.println(immutableCoursesMap);
    }
}
