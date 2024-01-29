/**
 *
 */
package com.practice.java8_17.language.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author asaha
 *
 */
public class AnnotationsManager {


    public List<Map<String, Object>> getMethodAnnotationDetails(Class annotatedClass) {
        List<Map<String, Object>> annotationDetails = new ArrayList<>();
        Method[] methods = annotatedClass.getMethods();
        for (Method method : methods) {
            Annotation[] annotationsDeclared = method.getDeclaredAnnotations();
            for (Annotation annotation : annotationsDeclared) {
                Map<String, Object> annotationDetail = new HashMap<String, Object>();
                annotationDetail.put("annotation", annotation);
                annotationDetail.put("method", method);
                annotationDetails.add(annotationDetail);
            }
        }
        return annotationDetails;
    }

}
