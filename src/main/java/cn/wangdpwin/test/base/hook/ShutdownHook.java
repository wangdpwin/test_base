package cn.wangdpwin.test.base.hook;

/**
 * @Author: wangdongpeng
 * @Date: 2019/6/19 下午6:13
 * @Description
 * @Version 1.0
 */
public class ShutdownHook {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("start");
        Runtime.getRuntime().addShutdownHook(new Thread(){
            public void run(){
                System.out.println("clean");
            }
        });
        runParam();
        System.out.println("end");
    }

    private static void runParam() {
        for (int i=0;i<100;i++){
            try {
                System.out.println("run");
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
