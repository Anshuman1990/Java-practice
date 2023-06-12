package com.practice.language.reactive.streams;

import java.util.concurrent.SubmissionPublisher;

public class StockTester {
    public static void main(String[] args) throws InterruptedException {
        try (SubmissionPublisher<Stock> publisher = new SubmissionPublisher<>()) {
            StockSubscriber broker1 = new StockSubscriber("Broker-1", 1, 0, 0);
            StockSubscriber broker2 = new StockSubscriber("Broker-2", 3, 0, 0);
            publisher.subscribe(broker1);
            publisher.subscribe(broker2);

            DataProvider.getStockData()
                    .forEach(e -> {
                        System.out.println("Publishing: " + e);
                        publisher.submit(e);
                    });

            Thread.sleep(2000);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        Thread.sleep(100);
    }
}
