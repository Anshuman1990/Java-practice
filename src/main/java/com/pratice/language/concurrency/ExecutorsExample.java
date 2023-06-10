package com.language.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorsExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        ExecutorService executorService =
                new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
                        new LinkedBlockingQueue<Runnable>());

        Runnable runnableTask = () -> {
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Callable<String> callableTask = () -> {
            TimeUnit.MILLISECONDS.sleep(300);
            return "Task's execution";
        };

        List<Callable<String>> callableTasks = new ArrayList<>();
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);
        /*
         * The execute() method is void, and it doesn't give any possibility to get the result of task's execution or to check the task's status (is it running or executed).
         * */
        executorService.execute(runnableTask);
        /*
         * submit() submits a Callable or a Runnable task to an ExecutorService and returns a result of type Future.
         * */
        Future<String> future = executorService.submit(callableTask);
        /*
         * invokeAny() assigns a collection of tasks to an ExecutorService,
         * causing each to be executed, and returns the result of a successful execution of one task (if there was a successful execution).
         * */
        String result = executorService.invokeAny(callableTasks);
        /*
         * invokeAll() assigns a collection of tasks to an ExecutorService,
         * causing each to be executed, and returns the result of all task executions in the form of a list of objects of type Future.
         * */
        List<Future<String>> futures = executorService.invokeAll(callableTasks);
        /*
         * The shutdown() method doesn't cause an immediate destruction of the ExecutorService.
         * It will make the ExecutorService stop accepting new tasks and shut down after all running threads finish their current work.
         * */
        executorService.shutdown();
        /*
        * The shutdownNow() method tries to destroy the ExecutorService immediately, but it doesn't guarantee that all the running threads will be stopped at the same time.
        * This method returns a list of tasks which are waiting to be processed.
        * It is up to the developer to decide what to do with these tasks.
        * */
        List<Runnable> notExecutedTasks = executorService.shutdownNow();
/*
* One good way to shut down the ExecutorService (which is also recommended by Oracle) is to use both of these methods combined with the awaitTermination() method.
* With this approach, the ExecutorService will first stop taking new tasks, the wait up to a specified period of time for all tasks to be completed.
* If that time expires, the execution is stopped immediately
* */
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }




    }
}
