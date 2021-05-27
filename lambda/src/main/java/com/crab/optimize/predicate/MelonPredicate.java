package com.crab.optimize.predicate;

import com.crab.optimize.Melon;

/**
 * 瓜类的函数式接口
 *
 *@author zfd
 *@date 2021/5/6 14:44
 *@version v1.0
 */
@FunctionalInterface
public interface MelonPredicate {
    boolean test(Melon melon);
}
