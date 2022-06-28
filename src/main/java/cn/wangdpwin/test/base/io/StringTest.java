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

    @Test
    public void split() {
        String filename = "205785380152_R01C01_Grn.idat";
        String filename2 = "205297630115_R05C02.vcf";
        int index = filename.indexOf("_", filename.indexOf("_") + 1);
        int index2 = filename2.indexOf("_", filename2.indexOf("_") + 1);
        if(index2>-1) {
            String fileNumber = filename.substring(0, index);
            System.out.println(fileNumber);
        }else {
            String fileNumber = filename2.substring(0, filename2.lastIndexOf("."));
            System.out.println(fileNumber);
        }

    }

}
