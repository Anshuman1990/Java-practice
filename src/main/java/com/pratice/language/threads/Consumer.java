package com.language.threads;

public class Consumer extends Thread {
    private Producer producer;

    private Consumer(Producer producer1) {
        this.producer = producer1;
    }

    public static void main(String[] args) {
        Producer producer = new Producer();
        producer.start();

        new Consumer(producer).start();
    }

    @Override
    public void run() {
        try {
            while (true) {

                String message = producer.getMessage();
                // sends a reply to producer got a message
                System.out.println("Got message: " + message);
                sleep(2000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
