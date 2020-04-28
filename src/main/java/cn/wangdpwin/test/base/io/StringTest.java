package cn.wangdpwin.test.base.io;

import org.junit.Test;

/**
 * @Author: wangdongpeng
 * @Date: 2019/8/28 下午4:24
 * @Description
 * @Version 1.0
 */
public class StringTest {

    @Test
    public void concat(){
        String str = "\t姓名\t年龄\t性别\t手机";
        String[] arr = str.split("\t");
        StringBuilder builder = new StringBuilder("");
        for (String s:arr) {
            builder.append(s).append("\", \"");
        }
        System.out.println(builder.toString());
    }
}
