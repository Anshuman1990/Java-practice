package com.practice.java8_17.Reactive;


import io.reactivex.rxjava3.core.Observable;
import reactor.core.publisher.Flux;


public class ReactiveTest {

	public static void main(String[] args) {
		String[] letters = {"a", "b", "c", "d", "e", "f", "g"};
		Observable<String> observable = Observable.fromArray(letters);
		StringBuilder result = new StringBuilder();
		var res = observable.subscribe(
                result::append,  //OnNext
				Throwable::printStackTrace, //OnError
				() -> result.append("_Completed") //OnCompleted
		);
		res.dispose();
		System.out.println(result.toString());
	}

	private static void monoAndFlux(){
		Flux<Integer> just = Flux.just(1, 2, 3, 4);
	}
}
