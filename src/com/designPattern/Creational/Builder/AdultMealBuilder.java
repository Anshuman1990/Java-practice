package com.designPattern.Creational.Builder;

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
