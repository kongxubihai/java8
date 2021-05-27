package com.crab.lambda;

import java.util.function.*;

public class Test {
    public static void main(String[] args) {
        Student student = new Student("xx", 12, 185);
        // Predicate断言
        Predicate<Integer> predicate = x -> x > 185;
        System.out.println(predicate.test(student.getHeight()));

        // Consumer消费者
        Consumer<String> consumer = System.out::println;
        consumer.accept(student.getName());

        // Function函数
        Function<Student, String> function = Student::getName;
        System.out.println(function.apply(student));

        // Supplier生产者
        Supplier<Integer> supplier = () -> Integer.valueOf("10");
        Integer integer = supplier.get();
        System.out.println(integer);

        // 一元操作
        UnaryOperator<Boolean> unaryOperator = flag -> !flag;
        Boolean apply = unaryOperator.apply(false);
        System.out.println(apply);

        // 二元操作
        BinaryOperator<Integer> binaryOperator = (x, y) -> x * y;
        Integer res = binaryOperator.apply(3, 4);
        System.out.println(res);

        // 自定义
        Worker worker = () -> "我是worker的返回值";
        String work = worker.work();
        System.out.println(work);

    }


}
