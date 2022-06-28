package cn.wangdpwin.test.jni;

import java.io.IOException;
import java.nio.channels.Selector;

/**
 * @Author wangdongpeng
 * @Date 2021/7/27 4:29 下午
 * @Version 1.0
 */
public class SelectorTest {

    public static void main(String[] args) throws IOException {
        Selector.open().select();
    }
}
