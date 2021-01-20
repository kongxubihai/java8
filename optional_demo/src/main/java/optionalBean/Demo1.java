package optionalBean;

import java.sql.SQLOutput;
import java.util.Objects;
import java.util.Optional;

/**
 * @author zfd
 * @version v1.0
 * @description TODO
 * @date 2021/1/20 19:30
 */
public class Demo1 {
    public static void main(String[] args) {
        // 判空逻辑：现在有一个User类，School 是它的成员变量,要获得School的成员变量 address
        User user = User.builder().
                name("xxx")
                .gender("ooo")
                .school(User.School.builder().address("address").scName("scname").build())
                .build();

        // 1、常规写法
        if (Objects.nonNull(user) && Objects.nonNull(user.getSchool())){
            User.School school = user.getSchool();
            System.out.println(school.getAddress());
        }

        // 2、Java8的Optional写法
        Optional<User> optionalUser = Optional.ofNullable(user);
        String address = optionalUser.map(User::getSchool).map(User.School::getAddress).orElse("unknown");
        System.out.println(address);

        // 3、自封装的OptionalBean写法，直接链式调用
        String address2 = OptionalBean.ofNullable(user)
                .getBean(User::getSchool)
                .getBean(User.School::getAddress)
                .orElse("xxxx");
        System.out.println(address2);

        // 4、扩展封装的EnhanceOptionalBean写法，直接链式调用
        String address3 = EnhanceOptional.ofNullable(user)
                .getBean(User::getSchool)
                .getBean(User.School::getAddress)
                .orElse("xxxx");
        System.out.println(address2);


    }
}
