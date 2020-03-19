package com.jenkin.onlineface.commons.aspects;

import com.jenkin.onlineface.commons.anno.AutoDoc;
import com.jenkin.onlineface.commons.http.Response;
import io.swagger.annotations.ApiModelProperty;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ：jenkin
 * @date ：Created at 2020/3/15 17:42
 * @description：自动生成前端得到一些属性
 * @modified By：
 * @version: 1.0
 */
@Aspect
@Component
public class AutoDocAspect {

    @Pointcut(value = "execution(public * com.jenkin.onlineface.*.controller..*.getDoc(..))")
    public void controllerPoint(){ }
    @Around( "controllerPoint()")
    public Object around(ProceedingJoinPoint joinPoint){
        Set<String > temp = new HashSet<>();
        //获取签名
        Signature signature= joinPoint.getSignature();
        //将签名转为方法签名
        MethodSignature methodSignature = (MethodSignature) signature;
        //获取方法
        Method method = methodSignature.getMethod();
        Class<?> declaringClass = method.getDeclaringClass();
        Method[] methods = declaringClass.getMethods();
        StringBuilder res = new StringBuilder();
        for (Method m : methods) {
            if((m.isAnnotationPresent(AutoDoc.class))
                    &&!m.getName().equals("getDoc")){
                AutoDoc autoDoc = m.getDeclaredAnnotation(AutoDoc.class);
                Class returnClass =autoDoc.returnClass();
                Class paramClass = autoDoc.paramClass();
                String path=null;

                if (m.isAnnotationPresent(GetMapping.class)) {
                    GetMapping annotation = m.getDeclaredAnnotation(GetMapping.class);
                    path=annotation.value()[0];
                }else{
                    PostMapping postMapping = m.getDeclaredAnnotation(PostMapping.class);
                    path=postMapping.value()[0];
                }
                if(temp.contains(paramClass.getName())&&temp.contains(returnClass.getName())){
                    continue;
                }else {
                    res.append("//---------------------------").append(m.getName()).append("开始----------------------------------\n\n");
                    parseClassField(temp, res, paramClass, path);
                    parseClassField(temp, res, returnClass, path);
                }
                res.append("//---------------------------").append(m.getName()).append("结束----------------------------------\n\n\n\n");

            }

        }
        return Response.ok(res.toString());
    }

    private void parseClassField(Set<String> temp, StringBuilder res, Class returnClass, String path) {
        if (returnClass != Object.class&&!temp.contains(returnClass.getName())) {
            String note = getResultsByClass(returnClass, "当前类为接口 " + path + "  的返回参数");
            res.append(note).append("\n\n\n\n").append("//---------------------------");
            temp.add(returnClass.getName());
        }
    }

    private String getResultsByClass(Class<?> returnType,String note) {

        Field[] fields = returnType.getDeclaredFields();
        StringBuilder responseStr = new StringBuilder("");
        responseStr.append("//").append(note);
        responseStr.append("\n");
        responseStr.append("export class ").append(returnType.getSimpleName()).append(" {\n");
        responseStr.append("\n").append("\n").append("constructor(){};\n");
        for (Field field : fields) {
            if (field.isAnnotationPresent(ApiModelProperty.class)) {
                ApiModelProperty property = field.getDeclaredAnnotation(ApiModelProperty.class);
                String value = property.value();
                if(field.getType().isAssignableFrom(String.class)){
                    responseStr.append("//").append(value).append("\n")
                            .append(field.getName()).append(":").append("string\n");

                }else if(Number.class.isAssignableFrom(field.getType())){
                    responseStr.append("//").append(value).append("\n")
                            .append(field.getName()).append(":").append("number\n");
                }else{
                    responseStr.append("//").append(value).append("\n")
                            .append(field.getName()).append(":").append("any\n");
                }
            }
        }
        responseStr.append("\n").append("}\n\n");
        return responseStr.toString();
    }
}
