package com.language.streams;

import com.language.LambdaExp;
import com.language.lambda.lambdaTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        lambdaTest test  = () -> {

        };

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,85,78);

        List listCombination =  (list
                .stream()
                .flatMap(integer -> list.stream().filter(integer1 -> !integer.equals(integer1)).map(integer1 -> integer+"-"+integer1))
                .collect(Collectors.toList()))
                .stream()
                .filter(data -> Integer.parseInt(data.split("-")[0]) + Integer.parseInt(data.split("-")[1]) == 10)
                .collect(Collectors.toList());

        System.out.println(listCombination);

        Main.peek(list);

        // Create ArrayList containing names
        ArrayList<String> lists = new ArrayList<String>();
        lists.add("Aman");
        lists.add("Zufaq");
        lists.add("Suraj");

        // create a stream with ArrayList
        Stream<ArrayList<String> > value
                = Stream.of(lists);

        // print values
        System.out.println("Values of Stream:");
        value.forEach(System.out::println);
    //reduce
        Optional<Integer> val = list.stream()
                .filter(x->x%2==0)
                .reduce((x,y)->{
                    System.out.println("x= "+x);
                    System.out.println("y="+y);
                    return x+y;
                });
        System.out.println("%%%%%%%%%"+val.get());
    }


    public static void peek(List<Integer> list){
        System.out.println("--------------------------------------PEEK---------------------------------------------");
        Consumer<Integer> consumer = integer -> System.out.println(integer*10);

        list.stream().peek(consumer).count();
    }
}
