/**
 * 
 */
package com.language.annotations;

import java.lang.annotation.Annotation;

/**
 * @author asaha
 *
 */
public class AnnotationsManager {
private String AnnotationsName = "";

	private AnnotationsManager(){
		
	}
	
	public static AnnotationsManager newInstance(){
		return new AnnotationsManager();
	}
	
	public void initiate(Class cls){
		Annotation[] annotations_arr = cls.getAnnotations();
		for(int i=0;i<annotations_arr.length;i++){
			System.out.println(annotations_arr[i]);
		}
		switch (getAnnotationsName()) {
		case AnnotationsConstants.JDBCConnection:
			
			break;

		default:
			break;
		}
	}
	private String getAnnotationsName() {
		return AnnotationsName;
	}

	private void setAnnotationsName(String annotationsName) {
		AnnotationsName = annotationsName;
	}

}
