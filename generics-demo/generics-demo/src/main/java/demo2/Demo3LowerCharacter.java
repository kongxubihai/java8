package demo2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 下界通配符 < ? super E>
 *     下界: 用 super 进行声明，表示参数化的类型可能是所指定的类型，
 *     或者是此类型的父类型，直至 Object
 */
public class Demo3LowerCharacter {


    /**
     *
     * @param dst 目标数据类型是T或是T的父类，可以转
     * @param src 源数据类型是T
     * @param <T>
     */
    private <T> void test(List<? super T> dst, List<T> src){
        for (T t : src) {
            dst.add(t);
        }
    }

    public static void main(String[] args) {
        List<Animal> dogs = Arrays.asList(new Dog(4), new Cat(5));

        List<Animal> animals = new ArrayList<>();
        new Demo3LowerCharacter().test(animals, dogs);
        System.out.println(animals);
    }

}
