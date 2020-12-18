package com.bean;

import java.lang.reflect.Field;

/**
 * ClassName: com.bean
 * Function: 反射可以获取类中被private修饰的变量、方法和构造器，这违反了面向对象的封装特性
 * Reason: TODO
 * Date: 2020/8/21
 *
 * @author zfd
 * @version v0.0.1
 * @since JDK 1.8
 */
public class Demo07 {
    public static void main(String[] args) throws  Exception{
        SmallPieapple sp = new SmallPieapple("xx", 21, 99.99);
        //weight 是私有的 但是反射可以窥探到 破坏了封装性
        Class clazz = Class.forName("com.bean.SmallPieapple");
        Field weight = clazz.getDeclaredField("weight");
        weight.setAccessible(true);
        System.out.println("xx体重私有的，但是我就是能看到： "+ weight.get(sp));

    }
}
