package com.language.concurrency;

import java.util.concurrent.*;

public class ScheduledExecutorExample {
    public static void main(String[] args) {
        Callable<String> callableTask = () -> {
            TimeUnit.MILLISECONDS.sleep(300);
            return "Task's execution";
        };

        ScheduledExecutorService executorService = Executors
                .newSingleThreadScheduledExecutor();

        Future<String> resultFuture =
                executorService.schedule(callableTask, 1, TimeUnit.SECONDS);
    }
}
