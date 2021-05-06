package com.crab.function;

import org.junit.Test;

import java.util.function.Supplier;

/**
 *
 *
 *@author zfd
 *@date 2021/5/6 11:49
 *@version v1.0
 */
public class SupplierTest {

    @Test
    public void  testSupplier() {
        Supplier<String> supplier = () -> "hello";
        System.out.println(supplier.get());

        System.out.println(create(supplier));
    }

    public <T> T create(Supplier<T> s){
        return s.get();
    }

}
