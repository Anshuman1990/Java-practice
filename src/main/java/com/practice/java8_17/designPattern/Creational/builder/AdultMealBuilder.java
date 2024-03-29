package com.practice.java8_17.designPattern.Creational.builder;

public class AdultMealBuilder extends MealBuilder {

	@Override
	public void buildDrink() {
		meal.setDrink("Adult Drink");
	}

	@Override
	public void buildMain() {
		meal.setMainCourse("Adults Main meal!!!");
	}

	@Override
	public void buildDessert() {
		meal.setDessert("Adults desserts");
	}

	@Override
	public Meal getMeal() {
		return meal;
	}

}
