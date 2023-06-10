package com.practice.language.threads;

import java.util.LinkedList;

public class Threadexample {

    public static void main(String[] args) throws InterruptedException {
        final PC pc = new PC();

        Thread producerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });



        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();

    }

    public static class PC{
        LinkedList<Integer> list = new LinkedList<>();
        int capacity = 2;

        public void produce() throws InterruptedException {
            int value = 0;
            while(true){
                synchronized (this){
                    while(list.size() == capacity) {
                        System.out.println("produce Waiting ZONE"+list.size());
                        wait();
                    }
                    System.out.println("Producer produced-"+ value);
                    list.add(value++);
                    notify();

                    Thread.sleep(1000);
                }
            }
        }

        public void consume() throws InterruptedException {
            while (true){
                synchronized (this){
                    while(list.size() == 0) {
                        System.out.println("consume Waiting ZONE"+list.size());
                        wait();
                    }
                    int val = list.removeFirst();
                    System.out.println("Consumer consumed-"+ val);
                    notify();
                    Thread.sleep(1000);
                }
            }
        }
    }
}
