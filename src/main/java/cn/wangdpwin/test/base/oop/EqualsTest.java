package cn.wangdpwin.test.base.oop;

import org.junit.Test;

/**
 * @Author: wangdongpeng
 * @Date: 2019/4/7 下午12:02
 * @Description
 * @Version 1.0
 */
public class EqualsTest {

    @Test
    public void test() {
        String a = new String("ab"); // a 为一个引用
        String b = new String("ab"); // b为另一个引用,对象的内容一样
        String aa = "ab"; // 放在常量池中
        String bb = "ab"; // 从常量池中查找
        if (aa == bb) // true
            System.out.println("aa==bb");
        if (a == b) // false，非同一对象
            System.out.println("a==b");
        if (a.equals(b)) // true
            System.out.println("aEQb");
        if (42 == 42.0) { // true
            System.out.println("true");
        }
    }

}
