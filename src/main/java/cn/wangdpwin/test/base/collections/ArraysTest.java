package cn.wangdpwin.test.base.collections;

import java.util.Arrays;
import org.junit.Test;

/**
 * @Author: wangdongpeng
 * @Date: 2019/4/14 下午11:00
 * @Description
 * @Version 1.0
 */
public class ArraysTest {

    @Test
    public void fill(){
        // *************填充fill(批量初始化)****************
        int[] g = { 1, 2, 3, 3, 3, 3, 6, 6, 6 };
        // 数组中所有元素重新分配值
        Arrays.fill(g, 3);
        System.out.println("Arrays.fill(g, 3)：");
        // 输出结果：333333333
        for (int i : g) {
            System.out.print(i);
        }
        // 换行
        System.out.println();

        int[] h = { 1, 2, 3, 3, 3, 3, 6, 6, 6, };
        // 数组中指定范围元素重新分配值
        Arrays.fill(h, 0, 2, 9);
        System.out.println("Arrays.fill(h, 0, 2, 9);：");
        // 输出结果：993333666
        for (int i : h) {
            System.out.print(i);
        }
    }

    @Test
    public void copyOf(){
        // *************复制 copy****************
        // copyOf 方法实现数组复制,h为数组，6为复制的长度
        int[] h = { 1, 2, 3, 3, 3, 3, 6, 6, 6, };
        int i[] = Arrays.copyOf(h, 6);
        System.out.println("Arrays.copyOf(h, 6);：");
        // 输出结果：123333
        for (int j : i) {
            System.out.print(j);
        }
        // 换行
        System.out.println();
        // copyOfRange将指定数组的指定范围复制到新数组中
        int j[] = Arrays.copyOfRange(h, 6, 11);
        System.out.println("Arrays.copyOfRange(h, 6, 11)：");
        // 输出结果66600(h数组只有9个元素这里是从索引6到索引11复制所以不足的就为0)
        for (int j2 : j) {
            System.out.print(j2);
        }
        // 换行
        System.out.println();
    }
}
