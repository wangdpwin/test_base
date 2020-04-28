package cn.wangdpwin.test.base.clazz;

import org.junit.Test;

/**
 * @Author: wangdongpeng
 * @Date: 2019/7/22 下午6:34
 * @Description
 * @Version 1.0
 */
public class BaseClazz {

    @Test
    public void read(){
        Class<Boolean> aClass = boolean.class;
        Class<Boolean> aClass1 = Boolean.TYPE;
        System.out.println(aClass.toString() + "\n" + aClass1.toGenericString());
    }
}
