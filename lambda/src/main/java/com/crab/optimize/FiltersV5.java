package com.crab.optimize;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 *v3: 增加需求按照类型和重量筛选: 合并一下
 * 加入产品和客户继续提其它的筛选条件？会不会产生很多的样板代码？如何应对这种变化？lambda表达式和函数式接口考虑下
 * v4: 采用lambda表达式  Predicate接口
 *
 * v5: 除了瓜之外，还有其它很多产品，如何应对？ 泛型
 *
 *@author zfd
 *@date 2021/5/6 14:31
 *@version v1.0
 */
public class FiltersV5 {
    /**
     * 根据类型筛选瓜类
     * @param melons
     * @param type
     * @return
     */
    public static List<Melon> filterMelonByType(List<Melon> melons, String type) {
        ArrayList<Melon> res = new ArrayList<>();
        melons.forEach(item -> {
            if (type.equalsIgnoreCase(item.getType())) {
                res.add(item);
            }
        });
        return res;
    }

    /**
     * 根据重量筛选瓜类
     * @param melons
     * @param weight
     * @return
     */
    public static List<Melon> filterMelonByWeight(List<Melon> melons, int weight) {
        ArrayList<Melon> res = new ArrayList<>();
        melons.forEach(item -> {
            if (weight == item.getWeight()) {
                res.add(item);
            }
        });
        return res;
    }

    /**
     * 根据重量筛选瓜类
     * @param melons
     * @param weight
     * @return
     */
    public static List<Melon> filterMelonByTypeAndWeight(List<Melon> melons, String type, int weight) {
        ArrayList<Melon> res = new ArrayList<>();
        melons.forEach(item -> {
            if (type.equalsIgnoreCase(item.getType()) && weight == item.getWeight()) {
                res.add(item);
            }
        });
        return res;
    }

    /**
     * v4
     * 行为参数化
     * @param melons
     * @param predicate
     * @return
     */
    public static List<Melon> filterByPredicate(List<Melon> melons, Predicate<Melon> predicate) {
        ArrayList<Melon> res = new ArrayList<>();
        melons.forEach(m -> {
            if (predicate.test(m)) {
                res.add(m);
            }
        });
        return res;
    }

    /**
     * v5
     * 泛型化
     * @param list
     * @param predicate
     * @return
     */
    public static <T> List<T> filterGenericByPredicate(List<T> list, Predicate<T> predicate) {
        ArrayList<T> res = new ArrayList<>();
        list.forEach(m -> {
            if (predicate.test(m)) {
                res.add(m);
            }
        });
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Melon> melons = new ArrayList<>();
        melons.add(new Melon("羊角蜜", 1, "泰国"));
        melons.add(new Melon("西瓜", 2, "三亚"));
        melons.add(new Melon("黄河蜜", 3, "兰州"));
        List<Melon> melonType = FiltersV5.filterMelonByType(melons, "黄河蜜");
        melonType.forEach(melon -> {
            System.out.println("瓜类型:" + melon.getType());
        });

        List<Melon> melonByWeight = FiltersV5.filterMelonByWeight(melons, 3);
        melonByWeight.forEach(m -> {
            System.out.println("瓜重量：" + m.getWeight());
        });
        List<Melon> melonByTypeAndWeight = FiltersV5.filterMelonByTypeAndWeight(melons, "黄河蜜", 3);
        melonByTypeAndWeight.forEach(m -> {
            System.out.println(String.format("瓜类型：%s，重量：%s", m.getType(), m.getWeight()));
        });

        // v4
        String origin = "兰州";
        String type = "黄河蜜";
        int weight = 3;
        Predicate<Melon> p =
                melon -> origin.equalsIgnoreCase(melon.getOrigin()) && melon.getWeight() == weight && type.equalsIgnoreCase(melon.getType());
        List<Melon> filterByPredicate = filterByPredicate(melons, p);
        filterByPredicate.forEach(m -> {
            System.out.println(String.format("产地:%s,瓜类型：%s，重量：%s", m.getOrigin(), m.getType(), m.getWeight()));
        });

        // v5
        List<Melon> generic = filterGenericByPredicate(melons, p);
        generic.forEach(m -> {
            System.out.println(String.format("产地:%s,瓜类型：%s，重量：%s", m.getOrigin(), m.getType(), m.getWeight()));
        });
    }
}
