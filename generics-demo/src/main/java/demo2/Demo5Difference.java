package demo2;

/**
 * Class<T> 和 Class<?> 区别
 * Class<T> 在实例化的时候，T 要替换成具体类。
 * Class<?> 它是个通配泛型，? 可以代表任何类型，所以主要用于声明时的限制情况。
 */
public class Demo5Difference {

    public static  <T> T createInstance(Class<T> tClass) throws IllegalAccessException, InstantiationException {
        return tClass.newInstance();
    }


    private Class<?> clazz;
}
