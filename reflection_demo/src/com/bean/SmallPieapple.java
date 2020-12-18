package com.bean;

import java.beans.Transient;

/**
 * ClassName: com.bean
 * Function: TODO
 * Reason: TODO
 * Date: 2020/8/21
 *
 * @author zfd
 * @version v0.0.1
 * @since JDK 1.8
 */
public class SmallPieapple extends Pieapple {
    public String name;

    public SmallPieapple(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public int age;

    /**
     * 体重只有自己知道
     */
    private double weight;

    public SmallPieapple(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public SmallPieapple(){

    }

    @Transient
    @Override
    public void getInfo() {
        String str = "SmallPieapple{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
        System.out.println(str);
    }
}
