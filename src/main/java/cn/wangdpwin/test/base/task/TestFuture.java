package cn.wangdpwin.test.base.task;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @Author: wangdongpeng
 * @Date: 2019/4/30 下午4:40
 * @Description
 * @Version 1.0
 */
public class TestFuture {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Task task = new Task();
        Future<Integer> result = executor.submit(task);
        executor.shutdown();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        System.out.println("主线程在执行任务");
        while (true) {
            try {
                Integer sum = result.get(3,TimeUnit.SECONDS);
                if(sum!=null){
                    System.out.println("task运行结果 - "+sum);
                }
                break;
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            } catch (ExecutionException e) {
                e.printStackTrace();
                break;
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        }
        System.out.println("所有任务执行完毕");
    }
}

class Task implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("子线程在进行计算");
        Thread.sleep(10000);
        int sum = 0;
        for(int i=0;i<100;i++)
            sum += i;
        return sum;
    }
}