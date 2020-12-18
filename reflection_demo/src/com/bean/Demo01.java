package com.bean;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * ClassName: com.bean
 * Function: TODO
 * Reason: 反射的引入
 * Date: 2020/8/21
 *
 * @author zfd
 * @version v0.0.1
 * @since JDK 1.8
 */
public class Demo01 {
    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        // 版本1 HashMap不合适 需求要改成LinkedHashMap 只能改代码
        // Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map = new LinkedHashMap<>();
        map.put(1, 1);
        // 假如又需要改回HashMap又需要改源码 打包 发布 重启

        // 版本2 简单的工厂传入参数决定使用哪个Map
        map = getMap("HashMap");
        // 如果某一天还想用TreeMap，还是避免不了修改源码，重新编译执行的弊端

        // 版本3 使用反射改进简单工厂
        // 在代码运行之前，我们不确定将来会使用哪一种数据结构，只有在程序运行时才决定使用哪一个数据类，
        // 而反射可以在程序运行过程中动态获取类信息和调用类方法。
        map = getReflectionMap("java.util.HashMap");


    }

    private static Map<Integer, Integer> getReflectionMap(String className) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
            Class<?> clazz = Class.forName(className);
            Constructor<?> constructor = clazz.getConstructor();
            return   (Map<Integer, Integer>)constructor.newInstance();
    }

    private static Map<Integer, Integer> getMap(String param) {
        Map<Integer, Integer> map = null;
        if (param.equals("HashMap")){
            map = new HashMap<>();
        } else if (param.equals("LinkedHashMap")){
            map = new LinkedHashMap<>();
        } else if (param.equals("WeakHashMap")){
            map = new WeakHashMap<>();
        }
        return map;
    }

}
