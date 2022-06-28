package cn.wangdpwin.test.jdk11;

import java.util.stream.Stream;

/**
 * @Author wangdongpeng
 * @Date 2022/3/28 7:24 下午
 * @Version 1.0
 * 字符串增强
 */
public class StringEx {

    public static void main(String[] args) {
        // 判空，blank里我放入了全角空格，半角空格，TAB
        String blank = "　　  ";
        System.out.println(blank.isBlank());  // true

        //lines() 分割获取字符串流
        String line = "a\nb\nc";
        Stream<String> lines = line.lines();
        // 使用 lambda 遍历
        lines.forEach(System.out::println);

        // 复制字符串
        String repeat = "我的微信:wn8398,";
        String repeat3 = repeat.repeat(3);
        System.out.println(repeat3); // 我的微信:wn8398,我的微信:wn8398,我的微信:wn8398,

        // trim 只能去除半角空格，而 strip 是去除各种空白符
        //strip() 去除前后空白字符
        // 去除前后空白
        String strip = "   　 https://www.wdbyte.com 　";
        System.out.println("==" + strip.trim() + "==");
        // 去除前后空白字符，如全角空格，TAB
        System.out.println("==" + strip.strip() + "==");
        // 去前面空白字符，如全角空格，TAB
        System.out.println("==" + strip.stripLeading() + "==");
        // 去后面空白字符，如全角空格，TAB
        System.out.println("==" + strip.stripTrailing() + "==");

        // 输出
        // ==　 https://www.wdbyte.com 　==
        // ==https://www.wdbyte.com==
        // ==https://www.wdbyte.com 　==
        // ==   　 https://www.wdbyte.com==





    }

}
