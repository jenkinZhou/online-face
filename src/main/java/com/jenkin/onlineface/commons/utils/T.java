package com.jenkin.onlineface.commons.utils;

import com.jenkin.onlineface.commons.http.Response;
import com.jenkin.onlineface.users.controller.TrainQuestionsSuitController;
import com.jenkin.onlineface.users.controller.UserTrainController;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author ：jenkin
 * @date ：Created at 2020/3/15 18:12
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class T {
    public static void main(String[] args) throws NoSuchMethodException {
//        Response<List<String>> foo = new Response<>();
        // 在类的外部这样获取
//        UserTrainController userTrainController = new UserTrainController();
//        userTrainController.getClass().getMethod("")
        TrainQuestionsSuitController trainQuestionsSuitController = new TrainQuestionsSuitController();
        Method getUndoQuestion = trainQuestionsSuitController.getClass().getMethod("getUndoQuestion",String.class);
        Type genericReturnType = getUndoQuestion.getGenericReturnType();
        Class superClassGenricType = getSuperClassGenricType(genericReturnType,0);
        System.out.println(superClassGenricType.getName());
        // 在类的内部这样获取
     }
    /**
     * 通过反射,获得定义Class时声明的父类的范型参数的类型. 如public BookManager extends
     * GenricManager<Book>
     *
     * @param clazz The class to introspect
     * @return the first generic declaration, or <code>Object.class</code> if cannot be determined
     */
    public static Class getSuperClassGenricType(Class clazz) {
        return getSuperClassGenricType(clazz, 0);
    }

    /**
     * 通过反射,获得定义Class时声明的父类的范型参数的类型. 如public BookManager extends GenricManager<Book>
     *
     * @param index the Index of the generic ddeclaration,start from 0.
     */
    public static Class getSuperClassGenricType(Type genType, int index)
            throws IndexOutOfBoundsException {
        System.out.println(genType);
//         genType = genType.getClass();


        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        System.out.println(params.length);
        if (index >= params.length || index < 0) {
            return Object.class;
        }
        String aClass = params[index].getTypeName();
        System.out.println(aClass);
        if (!(params[index] instanceof Class)) {
            return Object.class;
        }
        return (Class) params[index];
    }

    public static Class getSuperClassGenricType( Class clazz, int index)
            throws IndexOutOfBoundsException {
        Type genType = clazz.getGenericSuperclass();
        if (!(genType instanceof ParameterizedType)) {
            return Object.class;
        }

        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        if (index >= params.length || index < 0) {
            return Object.class;
        }
        if (!(params[index] instanceof Class)) {
            return Object.class;
        }
        return (Class) params[index];
    }
}
