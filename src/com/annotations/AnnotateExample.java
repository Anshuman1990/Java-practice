package com.annotations;

/**
 * 
 */

/**
 * @author asaha
 *
 */
@JDBCConnection(DbName = "",DbPass="",DbUname="")
public class AnnotateExample {

	public void mymethod(){
		
	}
	
	public static void main(String[] args) {
		AnnotationsManager annotationManager = AnnotationsManager.newInstance();
		annotationManager.initiate(AnnotateExample.class);
	}
}