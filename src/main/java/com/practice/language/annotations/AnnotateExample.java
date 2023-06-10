package com.practice.language.annotations;

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
            int parameterCount = method.getParameterCount();
            String DBName = annotation.DatabaseName();
            switch (DBName.toUpperCase()) {
                case "MYSQL":
                case "SQL SERVER":
                    try {
                        invoke(method, demoObject);
                    } catch (InvocationTargetException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        });

    }

    private static Object invoke(Method method, Object methodObject) throws InvocationTargetException, IllegalAccessException {
        Object response = null;
        int parameterCount = method.getParameterCount();
        if (parameterCount == 0) {
            response = method.invoke(methodObject);
        } else {
            Class[] parameterType = method.getParameterTypes();
            
        }
        return response;
    }
}
