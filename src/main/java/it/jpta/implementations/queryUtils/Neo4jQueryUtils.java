package it.jpta.implementations.queryUtils;

import it.jpta.functions.Relation;
import it.jpta.functions.LeftToRightRelation;

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

    protected LeftToRightRelation<N,N,R,Relation> functionRelation =
            (startNode, endNode, relation) -> new Relation<N, N, R>(startNode, endNode, relation);

    protected LeftToRightRelation<N,N,R,Relation> functionNode =
            (startNode, endNode, relation) -> new Relation<N, N, R>(startNode, endNode, relation);
}
