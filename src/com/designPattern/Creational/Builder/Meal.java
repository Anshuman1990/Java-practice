package com.designPattern.Creational.Builder;

public class Meal {
	private String drink;
	private String mainCourse;
	private String dessert;

	public String getDrink() {
		return drink;
	}

	public void setDrink(String drink) {
		this.drink = drink;
	}

	public String getMainCourse() {
		return mainCourse;
	}

	public void setMainCourse(String mainCourse) {
		this.mainCourse = mainCourse;
	}

	public String getDessert() {
		return dessert;
	}

	public void setDessert(String dessert) {
		this.dessert = dessert;
	}

	@Override
	public String toString() {
		return "Drink= " + this.getDrink() + "\nMain Course= " + this.getMainCourse() + "\nDessert= "
				+ this.getDessert();
	}
}
