package com.practice.java8_17.designPattern.Creational.builder;

public class Main {
	public static boolean isKid = false;
public static void main(String[] args) {
	MealDirector director = new MealDirector();
	MealBuilder builder = null;
	if(isKid){
		builder = new KidsMealBuilder();
	}
	else{
		builder = new AdultMealBuilder();
	}
	Meal meal = director.createMeal(builder);
	System.out.println(meal.toString());
}
}
