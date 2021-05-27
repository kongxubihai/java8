package com.bean;

/**
 * ClassName: com.bean
 * Function: 获取类的Class对象
 * Reason: TODO
 * Date: 2020/8/21
 *
 * @author zfd
 * @version v0.0.1
 * @since JDK 1.8
 */
public class Demo02 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 类名.class：这种获取方式只有在编译前已经声明了该类的类型才能获取到
        Class clazz1 = SmallPieapple.class;

        // 实例.getClass()：通过实例化对象获取该实例的 Class 对象
        SmallPieapple sp = new SmallPieapple();
        Class clazz2 = sp.getClass();
        //Class.forName(className)：通过类的全限定名获取该类的 Class 对象
        Class clazz3=Class.forName("com.bean.SmallPieapple");

        // Class文件只有一个 上面3种反射出来的都是同一个对象
        System.out.println("clazz1 == clazz2: " + (clazz1 == clazz2));
        System.out.println("clazz1 == clazz3: " + (clazz1 == clazz3));
        System.out.println("clazz2 == clazz3: " + (clazz2 == clazz3));
    }


}
