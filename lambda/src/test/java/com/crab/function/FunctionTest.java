package com.crab.function;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 *
 * 实现一个”一元函数“，即传入一个值经过函数的计算返回另一个值
 *
 *@author zfd
 *@date 2021/5/6 10:37
 *@version v1.0
 */
public class FunctionTest {

    @Test
    public void testFunction() {
        // Function<T, R>:R apply(T t)
        Function<String[], List<String>> f1 = Arrays::asList;
        System.out.println(f1.apply(new String[]{"hello", "world"}));

        // compose andThen
        Function<String, String> f = s -> String.format("%s, Jack", s);
        Function<String, String> compose = s -> s.length() > 0 ? s : "hello";
        Function<String, String> andThen = String::toUpperCase;

        String apply = f.compose(compose).andThen(andThen).apply("");
        System.out.println(apply);
    }
}
