package com.practice.java8_17.designPattern.Creational.builder;

public abstract class MealBuilder {
	protected Meal meal = new Meal();
	 public abstract void buildDrink();
	  public abstract void buildMain();
	  public abstract void buildDessert();
	  public abstract Meal getMeal();
}
