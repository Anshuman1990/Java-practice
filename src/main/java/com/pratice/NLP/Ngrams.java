package com.NLP;

import java.util.Arrays;
import java.util.List;

import edu.stanford.nlp.util.CollectionUtils;

public class Ngrams {
public static void main(String[] args) {
	List<String> items = Arrays.asList("qwert", "asdfg", "zxcv", "rtyh");
	Ngrams.getNgrams(items);
}

private static void getNgrams(List<String> words) {
	List<List<String>> ngrams = CollectionUtils.getNGrams(words, 1, 3);
	for(List<String> grams:ngrams) {
		System.out.println(grams);
	}
}
}
