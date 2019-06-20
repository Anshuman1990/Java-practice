package com.threading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DataScanThread {
public static void main(String[] args) throws InterruptedException, ExecutionException {
	ExecutorService executorservice = Executors.newFixedThreadPool(10);

	StreamsThreadRunnable threadRunnable = new StreamsThreadRunnable("D://Dataset//sentiment labelled sentences//readme.txt");
	StreamsThreadCallable threadCallable = new StreamsThreadCallable("D://Dataset//sentiment labelled sentences//readme.txt");

	List<StreamsThreadRunnable> runnableTasks = new ArrayList();
	runnableTasks.add(threadRunnable);
	runnableTasks.add(threadRunnable);
	runnableTasks.add(threadRunnable);

	List<StreamsThreadCallable> callableTasks = new ArrayList();
	callableTasks.add(threadCallable);
	callableTasks.add(threadCallable);
	callableTasks.add(threadCallable);

	executorservice.execute(threadRunnable);

//	Future<String> future = executorservice.submit(threadCallable);

//	StreamsThreadRunnable result = future.get();
	
//	executorservice.execute(threadRunnable);
//	System.out.println("&&&&&&&"+future.isDone());
}
}
