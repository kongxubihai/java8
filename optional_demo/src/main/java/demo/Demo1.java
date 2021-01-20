package demo;

import java.util.Optional;

/**
 * @author zfd
 * @version v1.0
 * @description TODO
 * @date 2021/1/20 17:53
 */
public class Demo1 {
    /**
     * 1、常规判null写法
     * 2、Java8的Optional写法
     * @param args
     */
    public static void main(String[] args) {
        User user1 = User.builder().gender("xxx").build();
        System.out.println(getGenderNormal(user1));
        System.out.println(getGenderOptional(user1));

        //
        user1= null;
        System.out.println(getGenderNormal(user1));
        System.out.println(getGenderOptional(user1));
    }

    /**
     * 常规写法
     * @param user
     * @return
     */
    public static String getGenderNormal(User user){
        if (user != null) {
            return user.getGender();
        }
        return "unknown";
    }

    /**
     * Java8的Optional写法结合Lambda进行api式的写法 简洁
     * @param user
     * @return
     */
    public static String getGenderOptional(User user){
        return Optional.ofNullable(user)
                .map(User::getGender)
                .orElse("unknown");
    }
}
