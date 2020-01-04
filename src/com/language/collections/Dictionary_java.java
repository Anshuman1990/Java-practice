package com.language.collections;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Random;

public class Dictionary_java {
public static void main(String[] args) {
	Dictionary<Integer, String> dictionary = new Hashtable<>();
	
	for(int i=1;i<=10;i++){
		String data = get_random_string();
		System.out.println(data);
		dictionary.put(i, data);
	}
	
	Enumeration<String> datas = dictionary.elements();
	while(datas.hasMoreElements()){
		System.out.println(">>>>>>>"+datas.nextElement());
	}
	System.out.println("check elements "+dictionary.get(3));
	System.out.println(dictionary.hashCode());
}

private static String get_random_string(){
	StringBuffer s_buf = new StringBuffer();
	Random rnd = new Random();
	for(int i=0;i<8;i++){
		char c = (char) (rnd.nextInt(122-65)+65);
		s_buf.append(c);
	}
	return s_buf.toString();
}

}
