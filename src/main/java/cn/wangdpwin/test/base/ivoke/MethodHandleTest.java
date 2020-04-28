package cn.wangdpwin.test.base.ivoke;

import static java.lang.invoke.MethodHandles.lookup;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

/**
 * @Author: wangdongpeng
 * @Date: 2019/3/5 下午6:22
 * @Description
 * @Version 1.0
 */
public class MethodHandleTest {

    static class ClassA{
        public void println(String s){
            System.out.println("classA " + s);
        }
    }

    public static void main(String[] args) throws Throwable {
        Object obj = System.currentTimeMillis() %2 ==0 ? System.out : new ClassA();
        getPrintMH(obj).invokeExact("aaaa");
    }

    private static MethodHandle getPrintMH(Object obj) throws NoSuchMethodException, IllegalAccessException {
        MethodType methodType = MethodType.methodType(void.class, String.class);
        return lookup().findVirtual(obj.getClass(),"println",methodType).bindTo(obj);

    }
}
