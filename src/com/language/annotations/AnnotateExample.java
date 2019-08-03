package com.language.annotations;

/**
 *
 */

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * @author asaha
 *
 */

public class AnnotateExample {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class demo = Demo.class;
        Object demoObject = demo.newInstance();
        AnnotationsManager annotationsManager = new AnnotationsManager();
        List<Map<String, Object>> arr = annotationsManager.getMethodAnnotationDetails(demo);
        arr.forEach(annotationMap -> {
            JDBCConnection annotation = (JDBCConnection) annotationMap.get("annotation");
            Method method = (Method) annotationMap.get("method");
            String DBName = annotation.DatabaseName();
            switch (DBName.toUpperCase()) {
                case "MYSQL":
                    try {
                        Object value = method.invoke(demoObject);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        });

    }
}
