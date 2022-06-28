package cn.wangdpwin.test.jdk7;

/**
 * @Author wangdongpeng
 * @Date 2022/3/28 6:42 下午
 * @Version 1.0
 */
public class Binary {

    /**
     * 直接指定不同的进制数字。
     *
     * 二进制指定数字值，只需要使用 0b 或者 OB 开头。
     * 八进制指定数字值，使用 0 开头。
     * 十六进制指定数字值，使用 0x 开头。
     */
    public static void main(String[] args) {
        // 二进制
        System.out.println("------2进制-----");
        int a = 0b001;
        int b = 0b010;
        System.out.println(a);
        System.out.println(b);
        // 八进制
        System.out.println("------8进制-----");
        int a1 = 010;
        int b1 = 020;
        System.out.println(a1);
        System.out.println(b1);
        // 十六进制
        System.out.println("------16进制-----");
        int a2 = 0x10;
        int b2 = 0x20;
        System.out.println(a2);
        System.out.println(b2);
    }

    /**
     * Java 7 开始支持在数字定义时候使用下划线分割
     */
    public static void main2(String[] args) {
        int a = 1_000;
        int b = 1_0__0_0_0_____00;
        System.out.println(a);
        System.out.println(b);
    }
}
