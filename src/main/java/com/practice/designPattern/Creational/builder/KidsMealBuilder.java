package com.practice.designPattern.Creational.builder;

public class KidsMealBuilder extends MealBuilder {

	@Override
	public void buildDrink() {
		meal.setDrink("Kids Drink");
	}

	@Override
	public void buildMain() {
		meal.setMainCourse("kids Main Course");
	}

	@Override
	public void buildDessert() {
		meal.setDessert("Kids Dessert");
	}

	@Override
	public Meal getMeal() {
		return meal;
	}

}
