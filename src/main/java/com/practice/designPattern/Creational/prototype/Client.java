package com.practice.designPattern.Creational.prototype;

public class Client {
	public static void main(String[] args) {
		ItemRegistry registry = new ItemRegistry();
		Book myBook = (Book) registry.createBasicItem("Book");
		CD myCD = (CD) registry.createBasicItem("CD");
		
//		myBook.setTitle("qwerty");
		System.out.println(myBook.toString());
		System.out.println(myCD.toString());
	}
}
