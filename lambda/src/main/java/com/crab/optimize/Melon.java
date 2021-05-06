package com.crab.optimize;

/**
 *
 *瓜
 *@author zfd
 *@date 2021/5/6 14:19
 *@version v1.0
 */
public class Melon {
    /**品种*/
    private  String type;
    /**重量*/
    private  int weight;
    /**产地*/
    private  String origin;

    public Melon(String type, int weight, String origin) {
        this.type = type;
        this.weight = weight;
        this.origin = origin;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        return "Melon{" +
                "type='" + type + '\'' +
                ", weight=" + weight +
                ", origin='" + origin + '\'' +
                '}';
    }
}
