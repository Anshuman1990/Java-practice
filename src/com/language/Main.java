package com.language;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Stream;

public class Main {
public static void main(String[] args) throws IOException {
	Main main = new Main();

//	String fileName1 = "D://t1.txt";
//	String filename2 = "D://t2.txt";
//	List D1 = new ArrayList();
//	List D2 = new ArrayList();
//	readFile(fileName1,D1);
//	readFile(filename2,D2);
//	System.out.println(">>>>>>>>>>>>>>>"+D1);
//	System.out.println(">>>>>>>>>>>>>>>"+D2);
//	LinkedHashSet set = new LinkedHashSet();
//
//	D1.removeAll(D2);
//
//	System.out.println(D1);
	//read file into stream, try-with-resources

Integer i = new Integer(5);
	Integer j = new Integer(10);
	swap(i,j);
	System.out.println("i= "+i+" j= "+j);

	try{
		main.divide();
	}catch (Exception e){
		e.fillInStackTrace();
		e.printStackTrace();
	}
}

private static void readFile(String fname, List<String> list){
	try (Stream<String> stream = Files.lines(Paths.get(fname))) {
		stream.forEach(s -> {
			list.add(s);
		});

	} catch (IOException e) {
		e.printStackTrace();
	}
}

	public static void swap(Integer i, Integer j)
	{
		Integer temp = new Integer(i);
		i = j;
		j = i;
	}

	public void method() throws Throwable
	{
		divide();
	}

	// divide operation throws ArithmeticException exception
	void divide()
	{

		try {
			System.out.println(10 / 0);
		}
		catch (ArithmeticException e) {
			throw e;
		}
	}
}
