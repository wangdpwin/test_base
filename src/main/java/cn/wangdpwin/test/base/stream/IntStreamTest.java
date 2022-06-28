package cn.wangdpwin.test.base.stream;

import cn.wangdpwin.test.base.model.User;
import com.google.common.collect.Lists;
import java.util.Date;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.Test;

/**
 * @Author: wangdongpeng
 * @Date: 2019/4/22 下午2:57
 * @Description
 * @Version 1.0
 */
public class IntStreamTest {

    Date now = new Date();
    private List<User> users = Lists.newArrayList();

    {
        users.add(new User("李某",21,now));
        users.add(new User("发某",11,now));
        users.add(new User("庄某",31,now));
        users.add(new User("于某",41,now));
    }


    @Test
    public void streamTest(){
        Integer sum = users.stream().map(User::getAge).reduce(0, Integer::sum);
        System.out.println(sum);
    }

    @Test
    public void mapToInt(){
        //mapToInt get original stream
        IntStream intStream = users.stream().mapToInt(User::getAge);
        // sum()  default value 0
        int sum = users.stream().mapToInt(User::getAge).sum();
        System.out.println(sum);
        //average()  value possiable 0 , with Optional resovle NullPointException
        OptionalDouble average = users.stream().mapToInt(User::getAge).average();
        System.out.println(average.orElse(0));
        //such as max min count , and so on
    }

    @Test
    public void boxedToStream(){
        IntStream intStream = users.stream().mapToInt(User::getAge);
        Stream<Integer> stream = intStream.boxed();
        List<Integer> list = stream.collect(Collectors.toList());
        System.out.println(list);
    }

    @Test
    public void range(){
        //产生指定数据范围内的数据，closed控制是否右闭，默认左闭
        long count = IntStream.range(1, 100).filter(i -> i % 2 == 0).count();
        long count2 = IntStream.rangeClosed(1, 100).filter(i -> i % 2 == 0).count();
        System.out.println("count "+ count + " count2 " + count2);
    }

    @Test
    public void pythagoras(){

    }


}
