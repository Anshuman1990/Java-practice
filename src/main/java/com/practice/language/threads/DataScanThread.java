package com.practice.language.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DataScanThread {
public static void main(String[] args) throws InterruptedException, ExecutionException {
	int numberOfThreads = Runtime.getRuntime().availableProcessors();
	ExecutorService executorservice = Executors.newFixedThreadPool(10);

	StreamsThreadRunnable threadRunnable = new StreamsThreadRunnable("C://dataset//test.txt");
	StreamsThreadCallable threadCallable = new StreamsThreadCallable("C://dataset//test.txt");

	List<StreamsThreadRunnable> runnableTasks = new ArrayList();
	runnableTasks.add(threadRunnable);
	runnableTasks.add(threadRunnable);
	runnableTasks.add(threadRunnable);

	List<StreamsThreadCallable> callableTasks = new ArrayList();
	callableTasks.add(threadCallable);
	callableTasks.add(threadCallable);
	callableTasks.add(threadCallable);

	Future<String> future = executorservice.submit(threadCallable);
	executorservice.execute(threadRunnable);

	String result = future.get();
	if(future.isDone()){
		System.out.println(result);
	}
}
}
