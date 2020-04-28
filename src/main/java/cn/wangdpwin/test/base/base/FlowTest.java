package cn.wangdpwin.test.base.base;

/**
 * @Author: wangdongpeng
 * @Date: 2019/8/12 下午5:53
 * @Description
 * @Version 1.0
 */
public class FlowTest {

    public static void main(String[] args) {
        System.out.println("start");
        flow("pgs");
        System.out.println("end");
    }

    private static void flow(String type) {
        if(type.equals("pgs")){
            return;
        }
        System.out.println("flow");
    }

}
