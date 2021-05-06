package com.crab.optimize;

import java.util.ArrayList;
import java.util.List;

/**
 *v3: 增加需求按照类型和重量筛选: 合并一下
 * 加入产品和客户继续提其它的筛选条件？会不会产生很多的样板代码？如何应对这种变化？lambda表达式和函数式接口考虑下
 *
 *@author zfd
 *@date 2021/5/6 14:31
 *@version v1.0
 */
public class FiltersV3 {
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

    public static void main(String[] args) {
        ArrayList<Melon> melons = new ArrayList<>();
        melons.add(new Melon("羊角蜜", 1, "泰国"));
        melons.add(new Melon("西瓜", 2, "三亚"));
        melons.add(new Melon("黄河蜜", 3, "兰州"));
        List<Melon> melonType = FiltersV3.filterMelonByType(melons, "黄河蜜");
        melonType.forEach(melon -> {
            System.out.println("瓜类型:" + melon.getType());
        });

        List<Melon> melonByWeight = FiltersV3.filterMelonByWeight(melons, 3);
        melonByWeight.forEach(m -> {
            System.out.println("瓜重量：" + m.getWeight());
        });
        List<Melon> melonByTypeAndWeight = FiltersV3.filterMelonByTypeAndWeight(melons, "黄河蜜", 3);
        melonByTypeAndWeight.forEach(m -> {
            System.out.println(String.format("瓜类型：%s，重量：%s", m.getType(), m.getWeight()));
        });
    }
}
