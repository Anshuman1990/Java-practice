package com.language.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        LambdaTest test = new LambdaTest();
        test.test(t -> "HOLLA");

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,85,78);

        List listCombination =  (list
                .stream()
                .flatMap(integer -> list.stream().filter(integer1 -> integer == integer1 ? false:true).map(integer1 -> integer+"-"+integer1))
                .collect(Collectors.toList()))
                .stream()
                .filter(data -> Integer.valueOf(data.split("-")[0])+Integer.valueOf(data.split("-")[1]) == 10 ? true:false )
                .collect(Collectors.toList());

        System.out.println(listCombination);

        Main.peek(list);
    }


    public static void peek(List<Integer> list){
        System.out.println("--------------------------------------PEEK---------------------------------------------");
        Consumer<Integer> consumer = integer -> System.out.println(integer*10);

        list.stream().peek(consumer).count();
    }
}
