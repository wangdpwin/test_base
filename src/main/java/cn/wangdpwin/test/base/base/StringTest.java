package cn.wangdpwin.test.base.base;

import org.junit.Test;

/**
 * @Author wangdongpeng
 * @Date 2022/4/2 4:40 下午
 * @Version 1.0
 */
public class StringTest {

    @Test
    public void length() {
        String name = "成吉思汗";
        int length = name.toString().length();
        System.out.println(length);
    }
}
