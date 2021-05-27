package com.bean;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;

/**
 * ClassName: com.bean
 * Function: 获取类的Field Method Constructor
 *     getXXX 可获取该类中的public的变量 方法 构造器
 *     getDeclaredxxx 可获取该类中内部包含的变量 方法 构造器，但是无法获取继承下来的信息
 * Reason: TODO
 * Date: 2020/8/21
 *
 * @author zfd
 * @version v0.0.1
 * @since JDK 1.8
 */
public class Demo04 {
    public static void main(String[] args)  throws  Exception{
        Class clazz = Class.forName("com.bean.SmallPieapple");

        System.out.print("获取所有public的Field: ");
        Field[] fields = clazz.getFields();
        Arrays.stream(fields).forEach(f -> System.out.print(f.getName() + " "));
        System.out.println();
        System.out.print("获取所有本类内部声明的不包括继承的Field: ");
        Field[] fields2 = clazz.getDeclaredFields();
        Arrays.stream(fields2).forEach(f -> System.out.print(f.getName() + " "));
        System.out.println();
        System.out.print("获取所有本类内部声明的和包括继承的Field: ");
        HashSet<Field> allFields = new HashSet<>();
        allFields.addAll(Arrays.asList(fields));
        allFields.addAll(Arrays.asList(fields2));
        allFields.stream().forEach(f -> System.out.print(f.getName() +" "));

    }
}
