package cn.wangdpwin.test.base.stream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.Test;

/**
 * @Author: wangdongpeng
 * @Date: 2019/4/22 下午5:06
 * @Description
 * @Version 1.0
 */
public class StreamTest {

    @Test
    public void make(){
        Stream<String> stream = Stream.of("a", "b", "c", "d");
        int[] numbers = {1,2,3,4,5};
        IntStream stream2 = Arrays.stream(numbers);
    }

    /**
     * 使用文件产生流
     */
    @Test
    public void makeFileStream(){
        try {
            //Files.lines(path)  产生一个流，文件中每一行都是一个元素
            Stream<String> lines = Files.lines(Paths.get("/Users/wangdongpeng/usr/testGitRespository/test/src/main/resources/test.jsp"),Charset.defaultCharset());
            //flatMap 产生一个扁平的字符流
            lines.flatMap(line -> Arrays.stream(line.split("")))
                 .distinct()
                 .forEach(s -> {
                     System.out.println(s);
                 });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 产生无限流
     */
    @Test
    public void test(){
        //Stream.iterate(init,operation)   init 初始值，operation 操作计算lambda表达式
        //limit 限制个数长度，一定要写
        Stream.iterate(new int[]{0, 1},
                t -> new int[]{t[1], t[0]+t[1]})
                .limit(20)
                .forEach(t -> System.out.println("(" + t[0] + "," + t[1] +")"));

        Stream.iterate(new int[]{0, 1},
                t -> new int[]{t[1], t[0]+t[1]})
                .limit(20)
                .map(t -> t[0])
                .forEach(System.out::println);
    }

    /**
     *
     */
    @Test
    public void generate(){
       //接收Supplier<T>类型的lambda表达式提供的数据源
       Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);
    }

    @Test
    public void continueTest(){
        Stream<String> stream = Stream.of("a", "b", "c", "d");
    }


}
