package cn.wangdpwin.test.base.base;

/**
 * @Author: wangdongpeng
 * @Date: 2019/8/12 下午5:56
 * @Description
 * @Version 1.0
 */
public class LoopTest {
    public static void main(String[] args) {
        loop(1000);
    }

    private static void loop(int i) {
        System.out.println(i);
        while (i>0){
            System.out.println("start");
            i--;
            break;
//            System.out.println("end");
        }

    }

}
