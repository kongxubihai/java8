package com.bean;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * ClassName: com.bean
 * Function: 获取注解
 * Reason: Annotation[] getAnnotations()：获取该对象上的所有注解
 * Annotation getAnnotation(Class annotaionClass)：传入注解类型，获取该对象上的特定一个注解
 * Annotation[] getDeclaredAnnotations()：获取该对象上的显式标注的所有注解，无法获取继承下来的注解
 * Annotation getDeclaredAnnotation(Class annotationClass)：根据注解类型，获取该对象上的特定一个注解，
 *                                                          无法获取继承下来的注解
 * Date: 2020/8/21
 *
 * @author zfd
 * @version v0.0.1
 * @since JDK 1.8
 */
public class Demo05 {
    public static void main(String[] args)  throws Exception {
        Class clazz = Class.forName("com.bean.SmallPieapple");

        //获取方法上的注解
        Method method = clazz.getMethod("getInfo");
        Annotation[] annotations = method.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation.toString());
        }


    }
}
