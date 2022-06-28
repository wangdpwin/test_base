package cn.wangdpwin.test.jdk10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author wangdongpeng
 * @Date 2022/3/28 7:18 下午
 * @Version 1.0
 */
public class Var {
    /**
     * var 看似好用，其实也有很多限制，官方介绍了 var 只能用于下面的几种情况。
     *
     * 仅限带有初始化的程序的局部变量。
     * for 循环或者增强for 循环中。
     * for循环中的声明。
     */
    public static void main(String[] args) {
        // 情况1，没有初始化会报错
        // var list;
        var list = List.of(1, 2, 3, 4);
        // 情况2
        for (var integer : list) {
            System.out.println(integer);
        }
        // 情况3
        for (var i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
