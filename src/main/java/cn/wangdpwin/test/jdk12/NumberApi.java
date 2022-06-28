package cn.wangdpwin.test.jdk12;

import javax.swing.text.Style;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * @Author wangdongpeng
 * @Date 2022/3/28 7:36 下午
 * @Version 1.0
 */
public class NumberApi {

    //简化的数字格式可以直接转换数字显示格式，比如 1000 -> 1K，1000000 -> 1M 。
    public static void main(String[] args) {
        System.out.println("Compact Formatting is:");
//        NumberFormat upvotes = NumberFormat.getCompactNumberInstance(new Locale("en", "US"), Style.SHORT);

//        System.out.println(upvotes.format(100));
//        System.out.println(upvotes.format(1000));
//        System.out.println(upvotes.format(10000));
//        System.out.println(upvotes.format(100000));
//        System.out.println(upvotes.format(1000000));

        // 设置小数位数
//        upvotes.setMaximumFractionDigits(1);
//        System.out.println(upvotes.format(1234));
//        System.out.println(upvotes.format(123456));
//        System.out.println(upvotes.format(12345678));
    }
}
