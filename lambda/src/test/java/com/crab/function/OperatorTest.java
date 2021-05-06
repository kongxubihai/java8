package com.crab.function;

import org.junit.Test;

import java.math.BigInteger;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

/**
 *
 *
 *@author zfd
 *@date 2021/5/6 11:55
 *@version v1.0
 */
public class OperatorTest {
    @Test
    public void testOperator() {
        UnaryOperator<String> unaryOperator = String::toUpperCase;
        System.out.println(unaryOperator.apply("xxoo"));
    }
    @Test
    public void testBinaryOperator() {
        BinaryOperator<BigInteger> binaryOperator = BigInteger::add;
        System.out.println(binaryOperator.apply(BigInteger.ONE, BigInteger.TEN));
    }
}
