package it.jpta.implementations.queryUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by simon on 10/01/17.
 */
public class Neo4jQueryUtils<N, R> {


    public Boolean isValidInputNode(Class<N> nodeClass) {

        Annotation annotations = nodeClass.getAnnotations()[0];
        Class type = annotations.annotationType();
        return "node".toLowerCase().equals(type.getSimpleName().toLowerCase());
    }

    public Boolean isValidInputRelation(Class<R> nodeClass) {

        Annotation annotations = nodeClass.getAnnotations()[0];
        Class type = annotations.annotationType();
        return "relation".toLowerCase().equals(type.getSimpleName().toLowerCase());
    }


    public String getNameAnnotationNode(Class<N> value) {
        try {
            Annotation annotations = value.getAnnotations()[0];
            Method[] declaredMethods = annotations.annotationType().getDeclaredMethods();
            return declaredMethods[0].invoke(annotations, (Object[]) null).toString();
        } catch (InvocationTargetException | IllegalAccessException inv) {
            inv.getMessage();
        }
        return null;
    }

    public String getNameAnnotationRelation(Class<R> value) {
        try {
            Annotation annotations = value.getAnnotations()[0];
            Method[] declaredMethods = annotations.annotationType().getDeclaredMethods();
            return declaredMethods[0].invoke(annotations, (Object[]) null).toString();
        } catch (InvocationTargetException | IllegalAccessException inv) {
            inv.getMessage();
        }
        return null;
    }

    protected String fillNullOrEmptyString(String stringToFill) {
        return stringToFill!=null && !stringToFill.isEmpty()
                ? stringToFill
                : "";
    }

}
