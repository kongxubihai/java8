package com.bean;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * ClassName: com.bean
 * Function: 反射调用方法
 * invoke(Oject obj, Object... args)：参数``1指定调用该方法的**对象**，参数2`是方法的参数列表值。
 * Reason: TODO
 * Date: 2020/8/21
 *
 * @author zfd
 * @version v0.0.1
 * @since JDK 1.8
 */
public class Demo06 {
    public static void main(String[] args)  throws  Exception{
        Class clazz = Class.forName("com.bean.SmallPieapple");

        Constructor constructor = clazz.getConstructor(String.class, int.class);
        SmallPieapple sp = (SmallPieapple) constructor.newInstance("xxx", 21);
        Method method = clazz.getMethod("getInfo");
        if (method != null){
            method.invoke(sp, null);
        }

    }
}
