package com.jenkin.onlineface.commons.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AutoDoc {
    Class paramClass() default Object.class;
    Class returnClass() default Object.class;
}
