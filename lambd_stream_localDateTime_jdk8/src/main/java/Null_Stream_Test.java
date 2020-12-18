import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName: PACKAGE_NAME
 * Function: TODO
 * Reason: TODO
 * Date: 2020/11/26
 *
 * @author zfd
 * @version v0.0.1
 * @since JDK 1.8
 */
public class Null_Stream_Test {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        User user = new User(1, "1");
        User user1 = new User(2, "2");

        users = null;

        List<Integer> integers = users.stream().distinct().map(User::getId).collect(Collectors.toList());
        System.out.println(integers);


    }
}
