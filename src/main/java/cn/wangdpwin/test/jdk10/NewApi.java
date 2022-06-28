package cn.wangdpwin.test.jdk10;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author wangdongpeng
 * @Date 2022/3/28 7:21 下午
 * @Version 1.0
 */
public class NewApi {

    public static void main(String[] args) {
        //通过 Collection.copyOf 复制得到一个不可改变集合，即使原来的集合元素发生了变化也不会有影响。
        var list = new ArrayList<String>();
        list.add("wechat");
        list.add("wn8398");
        List<String> copyList = List.copyOf(list);
        list.add("test");
        System.out.println(copyList);
        // result
        // [wechat, wn8398]

        //也为 Optional 增加了一个新的方法 orElseThrow。调用这个方法也可以获取到 optional 中的 value , 但是如果 value 为 null ，就会抛出异常。

        //另外在 Stream 最后收集数据的时候，Collectors 可以直接指定收集的集合为不可变集合，像下面这样。
        list.stream().collect(Collectors.toUnmodifiableList());
        list.stream().collect(Collectors.toUnmodifiableSet());
    }

}
