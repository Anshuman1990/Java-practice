package com.threading;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamsThreadCallable implements Callable{
	private String filePath = "";
public StreamsThreadCallable(String filepath) {
	this.filePath = filepath;
}
	@Override
	public Object call() {
		System.out.println("%%%%%%%%%%%%%%%CALLABLE%%%%%%%%%%%%%%%%%");
		fileRead(this.filePath);
		return "Done";
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
