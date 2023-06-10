package com.language.threads;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Callable;
import java.util.stream.Stream;

public class StreamsThreadCallable implements Callable<String>{
	private String filePath = "";
public StreamsThreadCallable(String filepath) {
	this.filePath = filepath;
}
	@Override
	public String call() {
		System.out.println("%%%%%%%%%%%%%%%CALLABLE%%%%%%%%%%%%%%%%%");
		return fileRead(this.filePath);
	}

	public String fileRead(String file_name) {
	StringBuilder stringBuilder = new StringBuilder();
		try (Stream<String> stream = Files.lines(Paths.get(file_name))) {
			stream.forEach(stringBuilder::append);
			 return stringBuilder.toString();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
