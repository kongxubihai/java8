/**
 * ClassName: PACKAGE_NAME
 * Function: 用法六 使用枚举组织枚举
 * 好处：组织后防止大量的枚举类文件； 伪多态
 * Reason: TODO
 * Date: 2020/8/18
 *
 * @author zfd
 * @version v0.0.1
 * @since JDK 1.8
 */
public class Usage6 {
    public static void main(String[] args) {
        for (Food.Dessert dessert : Food.Dessert.values()) {
            System.out.println(dessert + "   ");
        }
        System.out.println();


        //搞个实现接口，来组织枚举，简单讲，就是分类吧。如果大量使用枚举的话，
        // 这么干，在写代码的时候，就很方便调用啦。
        //还有就是个“多态”的功能吧，
        Food food = Food.Dessert.CAKE;
        System.out.println(food);

        food=Food.Coffe.BLACK_COFFE;
        System.out.println(food);
    }


}

interface Food{
    enum Coffe implements Food{
        BLACK_COFFE, WHITE_COFFE, LATTE
    }
    enum Dessert implements  Food{
        FRUIT, CAKE, GELATO
    }
}
