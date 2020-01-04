package com.language.collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class listMain {

    public static void main(String[] args) {
        ArrayList<String> arraylist = new ArrayList<>( Arrays.asList("qwerty","asdfgh","zxcvb"));


        arraylist.add(1,"qazwsx");

        System.out.println(arraylist);
    }
}
