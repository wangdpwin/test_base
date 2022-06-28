package cn.wangdpwin.test.base.synchronizeObjOrThis;

/**
 * @Author wangdongpeng
 * @Date 2022/6/28 11:32 上午
 * @Version 1.0
 */
public class SyncThisTest {

    public void print(){
        synchronized (this){
            System.out.println("xxxx");
        }
    }
}