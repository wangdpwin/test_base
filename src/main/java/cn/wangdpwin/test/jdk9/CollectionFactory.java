package cn.wangdpwin.test.jdk9;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author wangdongpeng
 * @Date 2022/3/28 6:56 下午
 * @Version 1.0
 */
public class CollectionFactory {

    public static void main(String[] args) {
        // 工厂方法创建集合
        List<String> stringList = List.of("a", "b", "c", "d");
        Set<String> stringSet = Set.of("a", "b", "c", "d");
        Map<String, Integer> stringIntegerMap = Map.of("key1", 1, "key2", 2, "key3", 3);
        Map<String, Integer> stringIntegerMap2 = Map.ofEntries(Map.entry("key1", 1), Map.entry("key2", 2));

        // 集合输出
        System.out.println(stringList);
        System.out.println(stringSet);
        System.out.println(stringIntegerMap);
        System.out.println(stringIntegerMap2);

        // 工厂可以自由创建新的实例或者复用现有实例，所以 使用 of 创建的集合，避免 == 或者 hashCode 判断操作
        List<String> stringListA = List.of("a", "b", "c", "d");
        List<String> stringListB = List.of("a", "b", "c", "d");
        System.out.println(stringListA.hashCode());
        System.out.println(stringListB.hashCode());
        // 输出结果
        // 3910595
        // 3910596
    }
}
