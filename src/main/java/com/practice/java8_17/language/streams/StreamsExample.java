package com.practice.java8_17.language.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamsExample {
public static void main(String[] args) {
	System.out.println(sum(Arrays.asList(11,2,13,4,15,6)));
	StreamsExample stream = new StreamsExample();
	stream.fileRead("C://dataset//test.txt");
	
	List<String> list = Arrays.asList("A","B","C");
	list.forEach(name -> test(name));
}

public static int sum(List<Integer> list) {
	return list.stream().filter(i -> i>10).mapToInt(i -> i).sum();
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

public static void test(String data) {
	
}


}
