package com.crab.function;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 *
 *@author zfd
 *@date 2021/5/6 10:07
 *@version v1.0
 */
public class PredicateTest {
    @Test
    public void testPredicate() {
        // test
        Predicate<List<String>> p = Collection::isEmpty;
        System.out.println(p.test(Arrays.asList("xxx", "ooo")));

        // test
        Predicate<Integer> pi = integer -> integer != 0;
        System.out.println(pi.test(10));

        // and
        pi = pi.and(integer -> integer > 10);
        System.out.println(pi.test(10));

        // or
        pi = pi.and(integer -> integer != 10);
        pi.test(10);

        // negate
        pi = pi.negate();
        System.out.println(pi.test(10));

    }
}
