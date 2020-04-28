package cn.wangdpwin.test.base.stopwatch;

import com.google.common.base.Stopwatch;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

/**
 * @Author: wangdongpeng
 * @Date: 2019/4/4 下午3:59
 * @Description
 * @Version 1.0
 */
public class StopwatchTest {

    @Test
    public void watch() throws InterruptedException {
        // 创建自动start的计时器
        Stopwatch watch = Stopwatch.createStarted();
        Thread.sleep(1000L);
        long time = watch.elapsed(TimeUnit.MILLISECONDS);
        // 结果1003
        System.out.println("代码执行时长：" + time);
        watch.reset();
        watch.start();
        Thread.sleep(2000L);
        time = watch.elapsed(TimeUnit.MILLISECONDS);
        System.out.println("代码执行时长2：" + time);
    }

    @Test
    public void watchMul() throws InterruptedException {
        // 创建自动start的计时器
        Stopwatch watch = Stopwatch.createStarted();
        for(int i=0;i<5;i++){
            Thread.sleep((i+1) * 1000L);
            long time = watch.elapsed(TimeUnit.MILLISECONDS);
            System.out.println("代码执行时长：" + time);
            watch.reset();
            watch.start();
        }
    }
}
