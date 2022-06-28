package cn.wangdpwin.test.jdk9;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @Author wangdongpeng
 * @Date 2022/3/28 7:00 下午
 * @Version 1.0
 */
public class StreamProd {

    /**
     * 对 Stream 进行了增强，主要增加了 4 个新的操作方法：dropWhile，takeWhile，ofNullable，iterate。
     * takeWhile: 从头开始筛选，遇到不满足的就结束了。
     * dropWhile: 从头开始删除，遇到不满足的就结束了。
     * ofNullable: 创建支持全 null 的 Stream.
     * iterate: 可以重载迭代器。
     */
    public static void main(String[] args) {

        //Optional 增加了可以转换成 Stream 的方法
        Stream<Integer> s = Optional.of(1).stream();
        s.forEach(System.out::print);
    }
}
