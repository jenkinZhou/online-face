//package com.jenkin.onlineface.commons.utils;
//
//import javax.annotation.processing.*;
//import javax.lang.model.util.Elements;
//import javax.lang.model.util.Types;
//import java.util.LinkedHashMap;
//import java.util.LinkedHashSet;
//import java.util.Set;
//
///**
// * @author ：jenkin
// * @date ：Created at 2020/3/15 17:33
// * @description：apt
// * @modified By：
// * @version: 1.0
// */
//@AutoService(Processor.class)
//public class FactoryProcessor extends AbstractProcessor {
//    private Types mTypeUtils;
//    private Messager mMessager;
//    private Filer mFiler;
//    private Elements mElementUtils;
//    private Map<String, FactoryGroupedClasses> factoryClasses = new LinkedHashMap<>();
//
//    @Override
//    public synchronized void init(ProcessingEnvironment processingEnvironment) {
//        super.init(processingEnvironment);
//
//        mTypeUtils = processingEnvironment.getTypeUtils();
//        mMessager = processingEnvironment.getMessager();
//        mFiler = processingEnvironment.getFiler();
//        mElementUtils = processingEnvironment.getElementUtils();
//    }
//
//    @Override
//    public Set<String> getSupportedAnnotationTypes() {
//        Set<String> annotations = new LinkedHashSet<>();
//        annotations.add(T.class.getCanonicalName());
//        return annotations;
//    }
//
//    @Override
//    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
//
//        //	扫描所有被@Factory注解的元素
//        for (Element annotatedElement : roundEnv.getElementsAnnotatedWith(Factory.class)) {
//
//        }
//
//        return false;
//    }
//
//    @Override
//    public SourceVersion getSupportedSourceVersion() {
//        return SourceVersion.latestSupported();
//    }
//}