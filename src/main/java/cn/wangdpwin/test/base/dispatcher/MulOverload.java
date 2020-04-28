package cn.wangdpwin.test.base.dispatcher;

import java.io.Serializable;

/**
 * @Author: wangdongpeng
 * @Date: 2019/3/5 下午4:18
 * @Description
 * @Version 1.0
 */
public class MulOverload {

    //顺序为  char int  long  Character ...
    public static void main(String[] args) {
        sayHello('a');
    }

    private static void sayHello(char a) {
        System.out.println("char");
    }

    private static void sayHello(int a) {
        System.out.println("int");
    }


    private static void sayHello(long a) {
        System.out.println("long");
    }

    private static void sayHello(float a) {
        System.out.println("float");
    }

    /**
     * 编译报错，与 'a' 字符类型无关系
     * @param a
     */
    private static void sayHello(String a) {
        System.out.println("String");
    }

    private static void sayHello(Character a) {
        System.out.println("Character");
    }

    private static void sayHello(char... a) {
        System.out.println("char...");
    }

    private static void sayHello(Serializable a) {
        System.out.println("Serializable");
    }

    private static void sayHello(Object a) {
        System.out.println("Object");
    }
}
