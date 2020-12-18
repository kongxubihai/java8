import java.util.Random;
import java.util.function.Supplier;

/**
 * ClassName: PACKAGE_NAME
 * Function: 自定义一个流进行计算输出:
 * Reason: TODO
 * Date: 2020/8/18
 *
 * @author zfd
 * @version v0.0.1
 * @since JDK 1.8
 */
public class UserSupplier implements Supplier<User> {
    private int index = 16;
    private Random rnd = new Random();

    @Override
    public User get() {
        index++;
        return new User(index % 2 == 0 ? index : index + 1,
                "name" + rnd.nextInt(100));
    }
}
