package demo2;

/**
 * @author zfd
 * @version v1.0
 * @description 父类
 * @date 2021/1/15 11:31
 */
public abstract class Animal {
    public int legs;

    public Animal(int legs) {
        this.legs = legs;
    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }
}
