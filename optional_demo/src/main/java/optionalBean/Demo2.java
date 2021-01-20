package optionalBean;

import demo.User;


/**
 * 用Optional开发时要注意正确使用Optional的“姿势”，特别注意不要使用2示例提到的错误示范，
 * 谨慎使用isPresent()和get()方法，
 * 尽量多使用map()、filter()、orElse()
 * 等方法来发挥Optional的作用。
 *
 */
public class Demo2 {
    public static void main(String[] args) {
        demo.User user = demo.User.builder().name("zhangsan").gender("男").build();

        // 构建Optional对象
        // 包装对象为空
        EnhanceOptional<Object> empty = EnhanceOptional.empty();
        // 包装对象不为空
        EnhanceOptional<String> not_null = EnhanceOptional.of("not null");
        // 包装对象可为空
        EnhanceOptional<String> nullable = EnhanceOptional.ofNullable("nullable");


        // 1.get方法
        System.out.println("------get方法---------");
        System.out.println(nullable.get());

        // 2.isPresent 应该避免糟糕的使用，如下
        // 这种用法不但没有减少null的防御性检查，而且增加了Optional包装的过程，违背了Optional设计的初衷，因此开发中要避免这种糟糕的使用
        System.out.println("------isPresent---------");
        EnhanceOptional<demo.User> optionalUser = EnhanceOptional.ofNullable(user);
        if (optionalUser.isPresent()) {
            System.out.println(optionalUser.get().getGender());
        }

        // 3.ifPresent() 包装对象非null就应用
        System.out.println("------ifPresent---------");
        EnhanceOptional<demo.User> optionalUser1 = EnhanceOptional.ofNullable(user);
        optionalUser1.ifPresent(u-> System.out.println(u.getGender()));
        optionalUser1.ifPresent(System.out::println);

        // 4.filter方法，接受参数为Predicate对象，用于对Optional对象进行过滤，如果符合Predicate的条件，
        // 返回Optional对象本身，否则返回一个空的Optional对象
        System.out.println("------filter方法---------");
        EnhanceOptional<demo.User> optionalUser2 = EnhanceOptional.ofNullable(user);
        optionalUser2.filter(u -> u.getName().equals("zhangsan"))
                .ifPresent(System.out::println);

        // 5.map()方法的参数为Function（函数式接口）对象，map()方法将Optional中的包装对象用Function函数进行运算，
        // 并包装成新的Optional对象（包装对象的类型可能改变）
        System.out.println("------map()---------");
        optionalUser.map(demo.User::getGender).ifPresent(System.out::println);

        // 6.flatMap入参Function函数的返回值类型为Optional<U>类型，而不是U类型，
        // 这样flatMap()能将一个二维的Optional对象映射成一个一维的对象。
        System.out.println("------flatMap()---------");
        optionalUser.flatMap(u-> EnhanceOptional.ofNullable(u.getGender()))
                .ifPresent(System.out::println);

        // 7.orElse
        System.out.println("------orElse()---------");
        String unknown = optionalUser.map(demo.User::getGender).orElse("unknown");
        System.out.println(unknown);

        // 8.orElseGet()方法与orElse()方法类似，区别在于orElseGet()方法的入参为一个Supplier对象，用Supplier对象的get()方法的返回值作为默认值。
        System.out.println("------orElseGet()---------");
        demo.User.School school = optionalUser.map(demo.User::getSchool).orElseGet(() -> new demo.User.School());
        System.out.println(school);

        // 9.orElseThrow()方法其实与orElseGet()方法非常相似了，入参都是Supplier对象，只不过orElseThrow()
        // 的Supplier对象必须返回一个Throwable异常，并在orElseThrow()中将异常抛出：
        // orElseThrow()方法适用于包装对象值为空时需要抛出特定异常的场景。
        System.out.println("------orElseThrow()---------");
        // optionalUser.map(User::getSchool).orElseThrow(() -> new RuntimeException("exception"));
        String exception = optionalUser.map(User::getName).orElseThrow(() -> new RuntimeException("exception"));
        System.out.println(exception);

        //10.扩展的getBean()
        String address2 =
                EnhanceOptional.ofNullable(user).getBean(User::getSchool).getBean(User.School::getAddress).get();
        System.out.println(address2);


    }
}
