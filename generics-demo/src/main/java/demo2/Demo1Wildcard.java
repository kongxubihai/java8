package demo2;

import java.util.ArrayList;
import java.util.List;

/**
 * ？表示不确定的 java 类型,不确定或者不关心实际要操作的类型，可以使用无限制通配符（尖括号里一个问号，即 <?> ），表示可以持有任何类型
 * T (type) 表示具体的一个java类型
 * K V (key value) 分别代表java键值中的Key Value
 * E (element) 代表Element
 */
public class Demo1Wildcard {
    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog(4));
        // 不会报错
        int count1 = countLegs(dogs);
        System.out.println(count1);
        // 报错
//        int count2 = countLegs1(dogs);
//        System.out.println(count2);
    }

    /**
     * @param animals  ? extends Animal表示Animal的子类
     * @return
     */
    static int countLegs (List<? extends Animal > animals ) {
        int retVal = 0;
        for ( Animal animal : animals )
        {
            retVal += animal.getLegs();
        }
        return retVal;
    }

    /**
     * @param animals 直接指定了父类Animal
     * @return
     */
    static int countLegs1 (List< Animal > animals ){
        int retVal = 0;
        for ( Animal animal : animals )
        {
            retVal += animal.getLegs();
        }
        return retVal;
    }


}
