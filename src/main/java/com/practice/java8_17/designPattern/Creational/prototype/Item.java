package com.practice.java8_17.designPattern.Creational.prototype;

public abstract class Item implements Cloneable{
	private String title;
	private double price;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public Item clone() {
		Item clonedItem = null;
		try {
			clonedItem = (Item) super.clone();
			clonedItem.setPrice(price);
			clonedItem.setTitle(title);
		} catch (CloneNotSupportedException ex) {
			ex.printStackTrace();
		}
		return clonedItem;
	}
	
	@Override
	public String toString(){
		return "Title= "+this.getTitle()+"\n Price= "+this.getPrice();
	}
}
