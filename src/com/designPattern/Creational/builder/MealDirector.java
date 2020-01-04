package com.designPattern.Creational.builder;

public class MealDirector {
public Meal createMeal(MealBuilder builder){
	builder.buildDrink();
	builder.buildDessert();
	builder.buildMain();
	return builder.getMeal();
}
}
