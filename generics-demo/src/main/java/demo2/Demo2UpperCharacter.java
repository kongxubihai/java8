package demo2;

/**
 * 上界通配符： < ? extends E> 用 extends 关键字声明，表示参数化的类型可能是所指定的类型，
 * 或者是此类型的子类。
 * 好处：
 * 如果传入的类型不是 E 或者 E 的子类，编译不成功
 * 泛型中可以使用 E 的方法，要不然还得强转成 E 才能使用
 */
public class Demo2UpperCharacter {

    public static void main(String[] args) {
        Cat cat = new Cat(1);
        String  xx ="xx";
        String test = test(cat, xx);
        System.out.println(test);
    }

    /**
     * 上界的使用
     * @param arg1
     * @param arg2
     * @param <K>
     * @param <E>
     * @return
     */
    static  <K extends Animal, E extends Object> E test(K arg1, E arg2){
        E result = arg2;
        System.out.println(arg2.equals(arg1));;
        return result;
    }
}
