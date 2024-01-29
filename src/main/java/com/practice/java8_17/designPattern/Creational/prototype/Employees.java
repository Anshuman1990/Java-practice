package com.practice.java8_17.designPattern.Creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class Employees implements Cloneable{
private List<String> empList;

public Employees() {
	empList = new ArrayList<String>();
}

private Employees(List<String> list){
	this.empList = list;
}
public void loadData(){
	empList.add("Pankaj");
	empList.add("Raj");
	empList.add("David");
	empList.add("Lisa");
}

public List<String> getEmpList(){
	return this.empList;
}

@Override
	protected Object clone() throws CloneNotSupportedException {
		List<String> temp = new ArrayList<String>();
		for(String str:this.empList){
			temp.add(str);
		}
		return new Employees(temp);
	}
}
