package cn.wangdpwin.test.base.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

/**
 * @Author: wangdongpeng
 * @Date: 2019/8/22 下午4:14
 * @Description
 * @Version 1.0
 */
public class Demo {

    @Test
    public void test(){
        System.out.println("start");
        List<String> list = Arrays.asList("a", "b", "c", "d", "e");
        list.forEach(s -> {
            System.out.println(s);
            if(s.equals("c")){
                return;
            }
        });
        System.out.println("end");

    }


    @Test
    public void test2(){
        System.out.println("start");
        List<String> list = Arrays.asList("a", "b", "c", "d", "e");
        for(String s:list) {
            System.out.println(s);
            if (s.equals("c")) {
                return;
            }
        }
        System.out.println("end");
    }

    @Test
    public void test3() {
        System.out.println("start");
        List list = filterStr();
        System.out.println(list.size());

    }

    private List filterStr() {
        List<String> list = Arrays.asList("a", "b", "c", "d", "e");
        List<String> results = new ArrayList<>();
        for(String s:list) {
            System.out.println(s);
            if (s.equals("c")) {
                return results;
            }
            results.add(s);
        }
        System.out.println(list.size());
        return results;
    }
}
