package com.annotations;

/**
 * 
 */

/**
 * @author asaha
 *
 */

public class AnnotateExample {

	public void mymethod(){
		
	}
	
	public static void main(String[] args) {
		AnnotationsManager annotationManager = AnnotationsManager.newInstance();
		annotationManager.initiate(AnnotateExample.class);
	}
}
