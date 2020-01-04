package com.language;

public class Generics_Class<T> {
private T T_data = null;

public T getT_data() {
	return T_data;
}

public void setT_data(T t_data) {
	T_data = t_data;
}

public void process(){
	if(T_data instanceof Integer){
		System.out.println("Integer");
	}	
	else if(T_data instanceof String){
		System.out.println("String");
	}
}
	
public static void main(String[] args) {
	Generics_Class<String> gen= new Generics_Class<String>();
	gen.setT_data("qqqq");
	gen.process();
	System.out.println(gen.getT_data());
}
}
