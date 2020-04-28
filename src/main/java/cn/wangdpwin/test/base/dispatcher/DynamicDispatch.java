package cn.wangdpwin.test.base.dispatcher;

/**
 * @Author: wangdongpeng
 * @Date: 2019/3/5 下午3:58
 * @Description 动态分派
 * @Version 1.0
 */
public class DynamicDispatch {

    static abstract class Human{
        public abstract void sayHello();
    }

    static class Man extends Human{
        @Override
        public void sayHello(){
            System.out.println("man");
        }
    }

    static class Woman extends Human{
        @Override
        public void sayHello(){
            System.out.println("woman");
        }
    }

    /*
    分析过程：
    public static void main(java.lang.String[]);    //找到方法指令码运行信息
     1-16 行为找到类，生成对象 <init>方法，将实例对象放入局部变量表第一个第二个Slot中， astore_1  astore_2
     17行以后，执行 invokevirtual 指令，查找常量池发现都是调用#6  com/example/test/dispatcher/DynamicDispatch$Human.sayHello:()V
     将局部变量表元素压入操作数栈中，aload_1  aload_2，开始执行方法调用
     invokevirtual指令关于多态性执行过程：
        栈顶第一个元素所指向的对象记为C,C中有没有对应的方法，如果没有寻找父类的，最终没有找到抛异常，
        因为子类有同名方法，所以调用子类的，完成方法重写功能
        invokevirtual指令执行的第一步就是运行期确定接受者的实际类型，
        所以两个对象在常连池中找到对应的类方法的符号引用解析到不同的直接引用上，
        调用不同方法
    */
    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        man.sayHello();
        woman.sayHello();
        man = new Woman();
        man.sayHello();
    }
}

/*
 javap -verbose DynamicDispatch
// class文件所在目录下执行
Classfile /Users/wangdongpeng/usr/testGitRespository/test/target/classes/com/example/test/dispatcher/DynamicDispatch.class
  Last modified 2019-3-5; size 855 bytes
  MD5 checksum 1d8b81fb0438f0ba31660ce3758e5bab
  Compiled from "DynamicDispatch.java"
public class com.example.test.dispatcher.DynamicDispatch
  minor version: 0
  major version: 49
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #8.#30         // java/lang/Object."<init>":()V
   #2 = Class              #31            // com/example/test/dispatcher/DynamicDispatch$Man
   #3 = Methodref          #2.#30         // com/example/test/dispatcher/DynamicDispatch$Man."<init>":()V
   #4 = Class              #32            // com/example/test/dispatcher/DynamicDispatch$Woman
   #5 = Methodref          #4.#30         // com/example/test/dispatcher/DynamicDispatch$Woman."<init>":()V
   #6 = Methodref          #12.#33        // com/example/test/dispatcher/DynamicDispatch$Human.sayHello:()V
   #7 = Class              #34            // com/example/test/dispatcher/DynamicDispatch
   #8 = Class              #35            // java/lang/Object
   #9 = Utf8               Woman
  #10 = Utf8               InnerClasses
  #11 = Utf8               Man
  #12 = Class              #36            // com/example/test/dispatcher/DynamicDispatch$Human
  #13 = Utf8               Human
  #14 = Utf8               <init>
  #15 = Utf8               ()V
  #16 = Utf8               Code
  #17 = Utf8               LineNumberTable
  #18 = Utf8               LocalVariableTable
  #19 = Utf8               this
  #20 = Utf8               Lcom/example/test/dispatcher/DynamicDispatch;
  #21 = Utf8               main
  #22 = Utf8               ([Ljava/lang/String;)V
  #23 = Utf8               args
  #24 = Utf8               [Ljava/lang/String;
  #25 = Utf8               man
  #26 = Utf8               Lcom/example/test/dispatcher/DynamicDispatch$Human;
  #27 = Utf8               woman
  #28 = Utf8               SourceFile
  #29 = Utf8               DynamicDispatch.java
  #30 = NameAndType        #14:#15        // "<init>":()V
  #31 = Utf8               com/example/test/dispatcher/DynamicDispatch$Man
  #32 = Utf8               com/example/test/dispatcher/DynamicDispatch$Woman
  #33 = NameAndType        #37:#15        // sayHello:()V
  #34 = Utf8               com/example/test/dispatcher/DynamicDispatch
  #35 = Utf8               java/lang/Object
  #36 = Utf8               com/example/test/dispatcher/DynamicDispatch$Human
  #37 = Utf8               sayHello
{
  public com.example.test.dispatcher.DynamicDispatch();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 9: 0
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       5     0  this   Lcom/example/test/dispatcher/DynamicDispatch;

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=2, locals=3, args_size=1
         0: new           #2                  // class com/example/test/dispatcher/DynamicDispatch$Man
         3: dup
         4: invokespecial #3                  // Method com/example/test/dispatcher/DynamicDispatch$Man."<init>":()V
         7: astore_1
         8: new           #4                  // class com/example/test/dispatcher/DynamicDispatch$Woman
        11: dup
        12: invokespecial #5                  // Method com/example/test/dispatcher/DynamicDispatch$Woman."<init>":()V
        15: astore_2
        16: aload_1
        17: invokevirtual #6                  // Method com/example/test/dispatcher/DynamicDispatch$Human.sayHello:()V
        20: aload_2
        21: invokevirtual #6                  // Method com/example/test/dispatcher/DynamicDispatch$Human.sayHello:()V
        24: new           #4                  // class com/example/test/dispatcher/DynamicDispatch$Woman
        27: dup
        28: invokespecial #5                  // Method com/example/test/dispatcher/DynamicDispatch$Woman."<init>":()V
        31: astore_1
        32: aload_1
        33: invokevirtual #6                  // Method com/example/test/dispatcher/DynamicDispatch$Human.sayHello:()V
        36: return
      LineNumberTable:
        line 30: 0
        line 31: 8
        line 32: 16
        line 33: 20
        line 34: 24
        line 35: 32
        line 36: 36
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0      37     0  args   [Ljava/lang/String;
            8      29     1   man   Lcom/example/test/dispatcher/DynamicDispatch$Human;
           16      21     2 woman   Lcom/example/test/dispatcher/DynamicDispatch$Human;
}
SourceFile: "DynamicDispatch.java"
InnerClasses:
     static #9= #4 of #7; //Woman=class com/example/test/dispatcher/DynamicDispatch$Woman of class com/example/test/dispatcher/DynamicDispatch
     static #11= #2 of #7; //Man=class com/example/test/dispatcher/DynamicDispatch$Man of class com/example/test/dispatcher/DynamicDispatch
     static abstract #13= #12 of #7; //Human=class com/example/test/dispatcher/DynamicDispatch$Human of class com/example/test/dispatcher/DynamicDispatch

 */