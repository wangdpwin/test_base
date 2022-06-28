package cn.wangdpwin.test.base.stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.summarizingInt;

import cn.wangdpwin.test.base.model.User;
import com.alibaba.fastjson.JSON;

import java.util.*;

import org.junit.Test;

/**
 * @Author: wangdongpeng
 * @Date: 2019/4/23 下午7:07
 * @Description
 * @Version 1.0
 */
public class StreamOperationTest {

    Date now = new Date();
    List<User> users = Arrays.asList(
            new User("tom",21,now),
            new User("peter",12,now),
            new User("david",34,now),
            new User("kaben",55,now)
    );


    @Test
    public void max(){
        Comparator<User> comparator = Comparator.comparingInt(User::getAge);
        Optional<User> max = users.stream().collect(maxBy(comparator));
        User user = max.orElse(null);
        System.out.println(JSON.toJSONString(user));
    }

    @Test
    public void statistics(){
        IntSummaryStatistics summaryStatistics = users.stream().collect(summarizingInt(User::getAge));
        System.out.println(JSON.toJSONString(summaryStatistics));
    }

    @Test
    public void join(){
        String collect = users.stream().map(User::getName).collect(joining());
        System.out.println(collect);
    }

}
