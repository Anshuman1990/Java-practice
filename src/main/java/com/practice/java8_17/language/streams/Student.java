package com.practice.java8_17.language.streams;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String departmantName;
    private int joinedYear;
    private String city;
    private int rank;
}
