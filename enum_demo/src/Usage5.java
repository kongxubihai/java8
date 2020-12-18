/**
 * ClassName: PACKAGE_NAME
 * Function: 用法五 实现接口
 * 所有的枚举都继承自java.lang.Enum类。
 * 由于Java 不支持多继承，所以枚举对象不能再继承其他类。
 * Reason: TODO
 * Date: 2020/8/18
 *
 * @author zfd
 * @version v0.0.1
 * @since JDK 1.8
 */
public class Usage5 {
    public static void main(String[] args) {
        Color5.RED.print();
    }
}

interface  Behavior{
    void print();
    String getInfo();
}

enum Color5 implements Behavior{
    RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3);
    private String name;
    private int index;

    Color5(String name, int index) {
        this.name = name;
        this.index = index;
    }

    @Override
    public void print() {
        System.out.println(this.index+ "_" + this.name);
    }

    @Override
    public String getInfo() {
        return this.name;
    }
}
