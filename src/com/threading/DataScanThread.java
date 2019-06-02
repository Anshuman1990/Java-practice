package com.threading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DataScanThread {
public static void main(String[] args) throws InterruptedException, ExecutionException {
	ExecutorService executorservice = Executors.newFixedThreadPool(10);
	StreamsThreadRunnable threadRunnable = new StreamsThreadRunnable("D://Dataset//sentiment labelled sentences//imdb_labelled.txt");
//	StreamsThreadCallable threadCallable = new StreamsThreadCallable("D://Dataset//sentiment labelled sentences//imdb_labelled.txt");
	Future<StreamsThreadRunnable> future = executorservice.submit(() -> threadRunnable);
	StreamsThreadRunnable result = future.get();
	
//	executorservice.execute(threadRunnable);
	System.out.println("&&&&&&&"+future.isDone());
}
}
