package demo1;

/**
 *泛型的本质是参数化类型，也就是说所操作的数据类型被指定为一个参数
 */
public class GenericClass<T> {
    private T param;

    public T getParam() {
        return param;
    }

    public void setParam(T param) {
        this.param = param;
    }

    public static void main(String[] args) {
        // 可以不指定类型
        GenericClass<Object> genericClass = new GenericClass<>();
        genericClass.setParam("xxxx");
        // 获取时候需要强转
        String param = (String) genericClass.getParam();
        System.out.println(param);

        //  定义时候 指定类型
        GenericClass<String> stringGenericClass = new GenericClass<>();
        stringGenericClass.setParam("ooo");
        System.out.println(stringGenericClass.getParam());

    }
}
