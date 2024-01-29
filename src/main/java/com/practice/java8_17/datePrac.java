package com.practice.java8_17;
import java.util.*;

/**
 * 
 */

/**
 * @author asaha
 *
 */
public class datePrac {
	static String str ;
	datePrac(){
		System.out.println("qqqqqqqqqqqq");
		str = "aaaaaaaaaaaaaaaa";
	}

	public static void main(String[] args) {
		List<Integer> arr = Arrays.asList(1,2,3,4,1,2,8);
		Comparator c1 = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2)
			{
				if(o1 == o2){
					return 0;
				}
				return 1;
			}
		};

		Collections.sort(arr,c1);
		System.out.println(arr);


	}

	public void inite(){

	}
}
