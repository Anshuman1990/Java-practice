package com.practice.java8_17;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class dummyThread {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("run");
            }
        });
        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "";
            }
        });

        if(future.isDone()) {
            System.out.println("Is Done");
        }
    }


}



