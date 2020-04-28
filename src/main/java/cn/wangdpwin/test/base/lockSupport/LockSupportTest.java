package cn.wangdpwin.test.base.lockSupport;

import java.util.concurrent.locks.LockSupport;

/**
 * @Author: wangdongpeng
 * @Date: 2019-12-05 14:59
 * @Description
 * @Version 1.0
 */
public class LockSupportTest {

    static Thread t1 = null, t2 = null;

    public static void main(String[] args) {
        int[] iArr = {1,2,3,4,5,6};
        String[] Arr = {"a","b","c","d","e","f"};
        new Thread(() -> {
            System.out.println("1");
            LockSupport.park();

            LockSupport.unpark(t2);

        },"t1").start();
    }
}
