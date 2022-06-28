package cn.wangdpwin.test.base.synchronizeObjOrThis;

/**
 * @Author wangdongpeng
 * @Date 2022/6/28 11:32 上午
 * @Version 1.0
 */
public class SyncObjTest {

    private final Object object = new Object();

    public void print(){
        synchronized (object){
            System.out.println("xxxx");
        }
    }
}