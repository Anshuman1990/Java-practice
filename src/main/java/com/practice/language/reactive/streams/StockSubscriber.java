package com.practice.language.reactive.streams;

import java.util.Objects;
import java.util.concurrent.Flow;

public class StockSubscriber implements Flow.Subscriber<Stock>{
    private Flow.Subscription subscription;
    private String name;
    private Integer processingRate;
    private Integer processingLimit;
    private Integer rateCounter = 0;
    private Integer limitCounter = 0;
    private Integer sleepDuration;

    public StockSubscriber(String name, Integer processingRate, Integer processingLimit, Integer sleepDuration) {
        this.name = name;
        this.processingRate = processingRate;
        this.processingLimit = processingLimit;
        this.sleepDuration = sleepDuration;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        System.out.println(name + " has been subscribed");
        subscription.request(processingRate);
        System.out.println(name + " requested for " + processingRate + " items");
    }

    @Override
    public void onNext(Stock item) {
        if(rateCounter < processingRate) {
            System.out.println("Item received by " + name + ": " + item);
            rateCounter++;
            limitCounter++;
            try {
                Thread.sleep(sleepDuration);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        if(Objects.equals(rateCounter, processingRate)) {
            subscription.request(processingRate);
            System.out.println("Request for " + processingRate + " items sent by " + name);
            rateCounter = 0;
        }
        if(processingLimit != 0 && Objects.equals(limitCounter, processingLimit))
            subscription.cancel();
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("Publishing Finished for " + name);
    }
}
