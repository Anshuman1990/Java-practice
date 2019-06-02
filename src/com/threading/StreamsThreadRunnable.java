package com.threading;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamsThreadRunnable implements Runnable{
private String filePath = "";
	public StreamsThreadRunnable(String filepath) {
		this.filePath = filepath;
	}
	@Override
	public void run() {
		System.out.println("%%%%%%"+this.filePath);
	fileRead(this.filePath);
	}

	public void fileRead(String file_name) {
		try (Stream<String> stream = Files.lines(Paths.get(file_name))) {
			stream.forEach(new Consumer<String>() {
				@Override
				public void accept(String t) {
					System.out.println("$$$$"+t);
					
				}
			});
			 

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
