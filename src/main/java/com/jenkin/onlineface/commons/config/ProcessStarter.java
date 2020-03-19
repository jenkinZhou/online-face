//package com.jenkin.onlineface.commons.config;
//
//import com.jenkin.onlineface.commons.utils.AppClassLoader;
//import org.apache.commons.lang3.ArrayUtils;
//import org.apache.ibatis.javassist.*;
//import org.apache.ibatis.javassist.bytecode.AnnotationsAttribute;
//import org.apache.ibatis.javassist.bytecode.ClassFile;
//import org.apache.ibatis.javassist.bytecode.ConstPool;
//import org.apache.ibatis.javassist.bytecode.annotation.Annotation;
//import org.apache.ibatis.javassist.bytecode.annotation.IntegerMemberValue;
//import org.apache.ibatis.javassist.bytecode.annotation.StringMemberValue;
//import org.apache.ibatis.reflection.ArrayUtil;
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.config.BeanPostProcessor;
//import org.springframework.beans.factory.support.BeanDefinitionBuilder;
//import org.springframework.beans.factory.support.DefaultListableBeanFactory;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Controller;
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.IOException;
//
//@Component
//public class ProcessStarter implements  ApplicationContextAware, BeanPostProcessor {
//    private static ApplicationContext applicationContext;
//    @Autowired
//    private DefaultListableBeanFactory defaultListableBeanFactory;
//    @Override
//    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        String className = bean.getClass().getName();
////        System.out.println(" =================="+className);
//
//        boolean annotationPresent = bean.getClass().isAnnotationPresent(RestController.class);
//        if (annotationPresent &&className.contains("com.jenkin")) {
//            System.out.println(" =================="+className);
//             if(className.contains("$$")){
//                 className=className.split("\\$$")[0];
//                 System.out.println("转义后:"+className);
//             }
//            ClassPool pool = ClassPool.getDefault();
//
//            try {
//                CtClass cc = pool.get(className);
//                ClassFile ccFile = cc.getClassFile();
//                ConstPool constpool = ccFile.getConstPool();
//
//                // create the annotation
//                AnnotationsAttribute attr = new AnnotationsAttribute(constpool, AnnotationsAttribute.visibleTag);
//                Annotation annot = new Annotation("GetMapping", constpool);
//                annot.addMemberValue("value", new StringMemberValue("/test",ccFile.getConstPool()));
//                attr.addAnnotation(annot);
//                CtMethod ctMethod = (CtMethod) CtNewMethod.make(
//                        "public com.jenkin.onlineface.commons.http.Response test(){" +
//                        "return com.jenkin.onlineface.commons.http.Response.ok(\"测试成功！\");}",cc);
//                ctMethod.getMethodInfo().addAttribute(attr);
//                cc.addMethod(ctMethod);
//
//                AppClassLoader appClassLoader = AppClassLoader.getInstance();
//                Class<?> clazz = appClassLoader.findClassByBytes(className, cc.toBytecode());
////            clazz.getDeclaredConstructor().newInstance();
//                Object obj = appClassLoader.getObj(clazz,bean);
//                //注册新的bean定义和实例
////                defaultListableBeanFactory.registerBeanDefinition(beanName,
////                        BeanDefinitionBuilder.genericBeanDefinition(bean.getClass()).getBeanDefinition());
//                defaultListableBeanFactory.removeBeanDefinition(beanName);
//                bean = obj;
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//
//        }
//        return bean;
//    }
//
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        ProcessStarter.applicationContext = applicationContext;
//
//    }
//}