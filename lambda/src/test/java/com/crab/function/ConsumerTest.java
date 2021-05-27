package com.crab.function;

import org.junit.Test;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 *
 *
 *@author zfd
 *@date 2021/5/6 9:44
 *@version v1.0
 */

public class ConsumerTest {

    @Test
    public void testConsumer() {
        // accept
        Consumer<String> consumer = System.out::println;

        // andThen()
        StringBuilder sb = new StringBuilder("Hello ");
        Consumer<StringBuilder> c1 = (str) -> str.append("Jack ");
        Consumer<StringBuilder> c2 = (str) -> str.append("Bob ");
        c2.andThen(c1).accept(sb);
        System.out.println(sb.toString());
    }

    @Test
    public void testBiConsumer() {
        BiConsumer<String, String> bc = (str, str2) -> System.out.printf("%s %s", str, str2);
        bc.accept("hello ", "world");
    }
}

