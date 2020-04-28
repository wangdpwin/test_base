package cn.wangdpwin.test.base.hashmap;

/**
 * @Author: wangdongpeng
 * @Date: 2020-04-27 18:23
 * @Description
 * @Version 1.0
 */
public class Client {

    public static void main(String[] args)
    {
        HashMapThread hmt0 = new HashMapThread();
        HashMapThread hmt1 = new HashMapThread();
        HashMapThread hmt2 = new HashMapThread();
        HashMapThread hmt3 = new HashMapThread();
        HashMapThread hmt4 = new HashMapThread();
        hmt0.start();
        hmt1.start();
        hmt2.start();
        hmt3.start();
        hmt4.start();
    }

}
