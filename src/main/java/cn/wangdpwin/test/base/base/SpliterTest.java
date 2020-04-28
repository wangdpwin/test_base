package cn.wangdpwin.test.base.base;

import com.google.common.base.Splitter;
import java.util.List;
import org.junit.Test;

/**
 * @Author: wangdongpeng
 * @Date: 2019/4/18 下午3:32
 * @Description
 * @Version 1.0
 */
public class SpliterTest {

    @Test
    public void test(){
        String result = "first row\n" +
                "second row\n" +
                "thrid row\n";
        List<String> strings = Splitter.on("\n")
                .trimResults()
                .omitEmptyStrings()
                .splitToList(result);
        System.out.println(strings);
    }
}
