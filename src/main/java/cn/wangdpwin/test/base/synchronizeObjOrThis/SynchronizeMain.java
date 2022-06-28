package cn.wangdpwin.test.base.synchronizeObjOrThis;

import java.lang.reflect.Field;

/**
 * @Author wangdongpeng
 * @Date 2022/6/28 11:26 上午
 * @Version 1.0
 */
public class SynchronizeMain {

    public static void main(String[] args) {
        //syncThis();
       // syncObj();
        syncObjWithReflect();
    }

    private static void syncThis() {
        SyncThisTest test = new SyncThisTest();
        Thread t1 = new Thread(() -> test.print());


        Thread t2 = new Thread(() -> {
            synchronized (test) {
                while (true) {
                    System.out.println("running");
                }
            }
        });
        t1.start();
        t2.start();
    }

    /**
     * 选择锁对象时，要考虑到锁对象的安全性，尽量避免锁对象暴露出去。
     * 很多开源库采用的同步方法块的方法是通过设置object来实现。
     * 虽然，它仍然可以通过反射来破解。但却增强了一层保障，以及一些可能存在人为的误操作，导致的死锁。
     */
    private static void syncObj() {
        SyncObjTest test = new SyncObjTest();
        Thread t1 = new Thread(() -> test.print());

        Thread t2 = new Thread(() -> {
            synchronized (test) {
                while (true) {
//                    System.out.println("running");
                }
            }
        });
        t1.start();
        t2.start();
    }

    private static void syncObjWithReflect() {
        SyncObjTest test = new SyncObjTest();
        Thread t1 = new Thread(() -> test.print());

        Thread t2 = new Thread(() -> {
            try {
                synchronized (getPrivateField(test,"object")) {
                    while (true) {
//                    System.out.println("running");
                    }
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
    }

    private static Object getPrivateField(Object instance, String filedName) throws NoSuchFieldException, IllegalAccessException {
        Field field = instance.getClass().getDeclaredField(filedName);
        field.setAccessible(true);
        return field.get(instance);
    }
}

