import java.time.LocalDateTime;
import java.util.*;

/**
 * ClassName: PACKAGE_NAME
 * Function: Lambda 表达式(lambda expression)是一个匿名函数，Lambda表达式基于数学中的λ演算得名，
 * 直接对应于其中的lambda抽象(lambda abstraction)，是一个匿名函数，即没有函数名的函数。
 *
 * Lambda表达式的结构:
 * 一个 Lambda 表达式可以有零个或多个参数
 * 参数的类型既可以明确声明，也可以根据上下文来推断。例如：(int a)与(a)效果相同
 * 所有参数需包含在圆括号内，参数之间用逗号相隔。例如：(a, b) 或 (int a, int b) 或 (String a, int b, float c)
 * 空圆括号代表参数集为空。例如：() -> 42
 * 当只有一个参数，且其类型可推导时，圆括号（）可省略。例如：a -> return a*a
 * Lambda 表达式的主体可包含零条或多条语句
 * 如果 Lambda 表达式的主体只有一条语句，花括号{}可省略。匿名函数的返回类型与该主体表达式一致
 * 如果 Lambda 表达式的主体包含一条以上语句，则表达式必须包含在花括号{}中（形成代码块）。
 * 匿名函数的返回类型与代码块的返回类型一致，若没有返回则为空
 * Date: 2020/8/14
 *
 * @author zfd
 * @version v0.0.1
 * @since JDK 1.8
 */
public class LambdaDemo {
    public static void main(String[] args) {
        System.out.println(new Date(1602400786131L));
//        forEachMap();
//        forEachList();
//        replaceInnerClass();
    }

    /**
     * 代替匿名内部类
     */
    private static void replaceInnerClass() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("普通方式创建");
            }
        };
        Runnable r2 = () -> System.out.println("lambda方式创建");
        new Thread(r1).start();
        new Thread(r2).start();
    }

    private static void forEachList() {
        System.out.println("======List遍历======");
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("bb");
        list.add("ccc");
        list.add("dddd");
        list.forEach(System.out::println);
    }

    private static void forEachMap() {
        System.out.println("=======Map遍历========");
        Map<String, String> map = new HashMap<>();
        map.put("a", "a");
        map.put("b", "b");
        map.put("c", "c");
        map.put("d", "d");
        map.forEach((k,v) -> System.out.println("k=" + k + ", v=" + v));
    }

}
