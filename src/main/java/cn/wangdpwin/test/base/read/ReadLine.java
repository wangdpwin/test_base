package cn.wangdpwin.test.base.read;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * @Author: wangdongpeng
 * @Date: 2019/5/7 下午4:03
 * @Description
 * @Version 1.0
 */
public class ReadLine {

    /**
     * 一行一行读取文件，解决读取中文字符时出现乱码
     *
     * 流的关闭顺序：先打开的后关，后打开的先关，
     *       否则有可能出现java.io.IOException: Stream closed异常
     *
     * @throws IOException
     */
    @Test
    public void readFile() throws IOException {
        FileInputStream fis=new FileInputStream("/Users/wangdongpeng/usr/testGitRespository/test/src/main/resources/param.txt");
        InputStreamReader isr=new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String line="";
        StringBuilder builder = new StringBuilder("(");
        List<String> list = new ArrayList<String>();
        int i = 0;
        while ((line=br.readLine())!=null) {
            i++;
            list.add(line);
            builder.append("'").append(line).append("',");
        }
        builder.append(")");
        System.out.println(builder.toString());
        System.out.println(i);

        fis=new FileInputStream("/Users/wangdongpeng/usr/testGitRespository/test/src/main/resources/exsist.txt");
        isr=new InputStreamReader(fis, "UTF-8");
        br = new BufferedReader(isr);
        String line2 ="";
        StringBuilder builder2 = new StringBuilder("(");
        List<String> list2 = new ArrayList<String>();
        int j = 0;
        while ((line2=br.readLine())!=null) {
            j++;
            list2.add(line2);
        }
        list.removeAll(list2);
        System.out.println(j);
        System.out.println(list.toString());
        System.out.println(list.size());
        br.close();
        isr.close();
        fis.close();
    }
}
