package it.jpta.annotations;

import java.lang.annotation.*;

/**
 * Created by simon on 10/01/17.
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Relation {
    String name() default "";
}
