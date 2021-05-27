package com.crab.optimize;

import java.util.ArrayList;
import java.util.List;

/**
 *v2: 增加按照重量筛选  CV大法
 *
 *@author zfd
 *@date 2021/5/6 14:31
 *@version v1.0
 */
public class FiltersV2 {
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

    public static void main(String[] args) {
        ArrayList<Melon> melons = new ArrayList<>();
        melons.add(new Melon("羊角蜜", 1, "泰国"));
        melons.add(new Melon("西瓜", 2, "三亚"));
        melons.add(new Melon("黄河蜜", 3, "兰州"));
        List<Melon> melonType = FiltersV2.filterMelonByType(melons, "黄河蜜");
        melonType.forEach(melon -> {
            System.out.println("瓜类型:" + melon.getType());
        });

        List<Melon> melonByWeight = FiltersV2.filterMelonByWeight(melons, 3);
        melonByWeight.forEach(m -> {
            System.out.println("瓜重量：" + m.getWeight());
        });
    }
}
