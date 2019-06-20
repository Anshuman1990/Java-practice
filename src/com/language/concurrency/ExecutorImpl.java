package com.language.concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorImpl {

    public static void main(String[] args) {
ExecutorImpl executor = new ExecutorImpl();
executor.testExecutors();
    }

    private void testExecutors(){
        test t1 = new test();
        test t2 = new test();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> {
            t1.increment();
            t1.display();
        });
        executorService.submit(() -> {
            t2.increment();
            t2.display();
        });
    }
}


    class test {
        private int number = 0;

        public void increment() {
            this.number++;
        }

        public void decrement() {
            this.number--;
        }

        public void display() {
            System.out.println(this.number);
        }
    }
