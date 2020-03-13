package com.jenkin.onlineface.commons.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自动捕获异常，加在类或者方法上面
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EnableErrorCatch {
    /**
     * 模块名称
     * @return
     */
    String value() default "";


}
