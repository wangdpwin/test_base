package cn.wangdpwin.test.base.delayTask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author wangdongpeng
 * @Date 2021/8/3 6:18 下午
 * @Version 1.0
 *
 */
public class DelayQueueDemo {

    /**
     * 优点:效率高,任务触发时间延迟低。
     * 缺点:(1)服务器重启后，数据全部消失，怕宕机
     * (2)集群扩展相当麻烦
     * (3)因为内存条件限制的原因，比如下单未付款的订单数太多，那么很容易就出现OOM异常
     * (4)代码复杂度较高
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<String> list = new ArrayList<String>();
        list.add("00000001");
        list.add("00000002");
        list.add("00000003");
        list.add("00000004");
        list.add("00000005");
        DelayQueue<OrderDelay> queue = new DelayQueue<OrderDelay>();
        long start = System.currentTimeMillis();
        //同步阻塞
        /*for(int i = 0;i<5;i++){
            //延迟三秒取出
            queue.put(new OrderDelay(list.get(i),
                    TimeUnit.NANOSECONDS.convert(10, TimeUnit.SECONDS)));
            try {
                //task:获取并移除队列的超时元素，如果没有则wait当前线程，直到有元素满足超时条件，返回结果。
                queue.take().print();
                System.out.println("After " +
                        (System.currentTimeMillis()-start) + " MilliSeconds");
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }*/

        for(int i = 0;i<5;i++){
            //延迟三秒取出
            queue.put(new OrderDelay(list.get(i),
                    TimeUnit.NANOSECONDS.convert(10, TimeUnit.SECONDS)));
        }
        //同步非阻塞
        while (queue.size()>0) {
            //Poll():获取并移除队列的超时元素，没有则返回空
            OrderDelay orderDelay = queue.poll();
            if(orderDelay!=null) {
                orderDelay.print();
                System.out.println("After " + (System.currentTimeMillis()-start) + " MilliSeconds");
                continue;
            }
            try {
                System.out.println("sleep 1 second");
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}