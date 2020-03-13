package com.jenkin.onlineface.commons.aspects;

import com.jenkin.onlineface.commons.anno.EnableErrorCatch;
import com.jenkin.onlineface.commons.anno.IgnoreErrorCatch;
import com.jenkin.onlineface.commons.exception.FaceException;
import com.jenkin.onlineface.commons.http.Response;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

@Aspect
public class ErrorCatchAspect {


    @Pointcut(value = "execution(public * com.jenkin.onlineface.*.controller..*.*(..))")
    public void controllerPoint(){ }

    @Around("controllerPoint()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        //获取签名
        Signature signature= joinPoint.getSignature();
        //将签名转为方法签名
        MethodSignature methodSignature = (MethodSignature) signature;
        //获取方法
        Method method = methodSignature.getMethod();
        Class<?> declaringClass = method.getDeclaringClass();
        EnableErrorCatch anno = null;
        if (declaringClass.isAnnotationPresent(EnableErrorCatch.class)) {
            anno = declaringClass.getDeclaredAnnotation(EnableErrorCatch.class);
        }else{
            anno=method.isAnnotationPresent(EnableErrorCatch.class)?method.getDeclaredAnnotation(EnableErrorCatch.class):null;
        }
        if (method.isAnnotationPresent(IgnoreErrorCatch.class)) {
            anno=null;
        }

        Object res = null;
        try {
            res = joinPoint.proceed();
        }catch (Throwable e){
            e.printStackTrace();
            if (anno==null) {
                throw e;
            }
            FaceException exception=null;
            if ("com.jenkin.onlineface.commons.exception.FaceException".equals(e.getClass().getName())) {
                exception = (FaceException) e;
            }else{
                exception = FaceException.systemException(e.getMessage());
            }
            String code = exception.getType().getCode();
            String msg = exception.getMsg();
            res = Response.error(code,msg);
        }
        return res;
    }

}
