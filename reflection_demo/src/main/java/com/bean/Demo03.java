package com.bean;

import java.lang.reflect.Constructor;

/**
 * ClassName: com.bean
 * Function: 反射构造类的实例化对象
 * Reason: TODO
 * Date: 2020/8/21
 *
 * @author zfd
 * @version v0.0.1
 * @since JDK 1.8
 */
public class Demo03 {
    public static void main(String[] args) throws Exception {
        // Class 对象调用newInstance()方法 默认构造方法
        Class clazz = Class.forName("com.bean.SmallPieapple");
        SmallPieapple sp = (SmallPieapple) clazz.newInstance();
        sp.getInfo();

        // Constructor 构造器调用newInstance()方法
        Class clazz2 = Class.forName("com.bean.SmallPieapple");
        Constructor con = clazz2.getConstructor(String.class, int.class);
        con.setAccessible(true);
        SmallPieapple sp2 = (SmallPieapple) con.newInstance("xxxx", 21);
        sp2.getInfo();


    }
}
