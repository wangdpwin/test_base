package cn.wangdpwin.test.base.ivoke;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @Author: wangdongpeng
 * @Date: 2019/3/5 下午6:47
 * @Description
 * @Version 1.0
 */
public class InvokeTest {

    /**
     * 实现son调用其父类的父类的方法，因为son无法获得其字符类的方法调用执行指令，
     * 非静态方法不能执行invokeStatic，invokeVirtual指令的分配逻辑是按照接收者的实际类型进行分派，
     * son必须拿到grandfather对象才能调用invokeVirtual执行grandfather的thinking方法
     * 只能采取son调father，father的同名方法调用grandFather的方法，完成多层方法重写
     * 改为使用invokeDynamic指令执行，获取grandFather的thining()方法的执行句柄，
     * 直接使用son对象执行grandfather的thinking方法
     * @param args
     */
    public static void main(String[] args) {
        new Son().thinking();
    }
}


class GFather{

    void thinking(){
        System.out.println("GFather");
    }
}

class Father extends GFather{

    @Override
    void thinking(){
        System.out.println("Father");
    }
}

class Son extends Father{

    @Override
    void thinking(){
        MethodType methodType = MethodType.methodType(void.class);
        try {
            MethodHandle methodHandle = MethodHandles.lookup().findSpecial(GFather.class, "thinking", methodType, getClass());
            methodHandle.invoke(this);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }

}