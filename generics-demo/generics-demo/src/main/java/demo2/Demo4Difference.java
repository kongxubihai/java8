package demo2;

import java.util.List;

/**
 * T和?的区别：
 * T 是一个 确定的 类型，通常用于泛型类和泛型方法的定义，
 * ？是一个 不确定 的类型，通常用于泛型方法的调用代码和形参，不能用于定义类和泛型方法。
 */
public class Demo4Difference {
    /**
     * 区别1.1、通过T来确保泛型参数的一致性  可以确保
     *
     * @param dst
     * @param src
     * @param <T>
     */
    public <T extends Number> void test(List<T> dst, List<T> src) {
    }

    /**
     * 区别1.2、通配符是 不确定的，所以这个方法不能保证两个 List 具有相同的元素类型
     * @param dst
     * @param src
     */
    public void test2(List<? extends Number> dst, List<? extends Number> src){}


    /**
     * 区别2、类型参数可以多重限定而通配符不行
     */
    class MultiLimit implements MultiLimitInterfaceA, MultiLimitInterfaceB{
        /**
         *使用 & 符号设定多重边界（Multi Bounds)，
         * 指定泛型类型 T 必须是 MultiLimitInterfaceA 和 MultiLimitInterfaceB 的共有子类型，
         * 此时变量 t 就具有了所有限定的方法和属性
         * @param t
         * @param <T>
         */
        public <T extends MultiLimitInterfaceB & MultiLimitInterfaceA> void test(T t){}
    }

    interface MultiLimitInterfaceA{};
    interface MultiLimitInterfaceB{};

    /**
     * 区别3：通配符可以使用超类限定而类型参数不行
     * @param list
     */
    private void test3(List<? extends Animal> list){}
    private void test4(List<? super Animal> list){}
    private < T extends Animal> void test5(List<T> list){}
}

