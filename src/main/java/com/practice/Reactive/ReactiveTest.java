package com.practice.Reactive;


import io.reactivex.rxjava3.core.Observable;


public class ReactiveTest {

	public static void main(String[] args) {
		String[] letters = {"a", "b", "c", "d", "e", "f", "g"};
		Observable<String> observable = Observable.fromArray(letters);
//		assertTrue(result.equals("abcdefg_Completed"));
	}
}