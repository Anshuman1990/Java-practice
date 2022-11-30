package com.language.threads;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamsThreadRunnable implements Runnable{
private String filePath = "";
	public StreamsThreadRunnable(String filepath) {
		this.filePath = filepath;
	}
	@Override
	public void run() {
		System.out.println("%%%%%%%%%%%%%%%RUNNABLE%%%%%%%%%%%%%%%%%");
	fileRead(this.filePath);
		System.out.println("%%%%%%%%%%%%%%%RUNNABLE%%%%%%%%%%%%%%%%%");
	}

	public void fileRead(String file_name) {
		try (Stream<String> stream = Files.lines(Paths.get(file_name))) {
			stream.forEach(s -> {
				System.out.println(s);
			});
			 

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
