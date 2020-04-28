package cn.wangdpwin.test.base.dispatcher;

/**
 * @Author: wangdongpeng
 * @Date: 2019/3/5 下午3:58
 * @Description 静态分派，
 * @Version 1.0
 */
public class StaticDispatch {

    static abstract class Human{

    }

    static class Man extends Human{

    }

    static class Woman extends Human{

    }

    public void sayHello(Human human){
        System.out.println("human");
    }

    public void sayHello(Man man){
        System.out.println("man");
    }

    public void sayHello(Woman woman){
        System.out.println("woman");
    }

    //测试显式的指定静态类型
    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch dispatch = new StaticDispatch();
        dispatch.sayHello(man);
        dispatch.sayHello(woman);
    }
}

/*

Classfile /Users/wangdongpeng/usr/testGitRespository/test/target/classes/com/example/test/dispatcher/StaticDispatch.class
  Last modified 2019-3-5; size 1523 bytes
  MD5 checksum 4066287f4d32daebdc17aed2476b18a4
  Compiled from "StaticDispatch.java"
public class com.example.test.dispatcher.StaticDispatch
  minor version: 0
  major version: 49
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #14.#44        // java/lang/Object."<init>":()V
   #2 = Fieldref           #45.#46        // java/lang/System.out:Ljava/io/PrintStream;
   #3 = String             #29            // human
   #4 = Methodref          #47.#48        // java/io/PrintStream.println:(Ljava/lang/String;)V
   #5 = String             #32            // man
   #6 = String             #35            // woman
   #7 = Class              #49            // com/example/test/dispatcher/StaticDispatch$Man
   #8 = Methodref          #7.#44         // com/example/test/dispatcher/StaticDispatch$Man."<init>":()V
   #9 = Class              #50            // com/example/test/dispatcher/StaticDispatch$Woman
  #10 = Methodref          #9.#44         // com/example/test/dispatcher/StaticDispatch$Woman."<init>":()V
  #11 = Class              #51            // com/example/test/dispatcher/StaticDispatch
  #12 = Methodref          #11.#44        // com/example/test/dispatcher/StaticDispatch."<init>":()V
  #13 = Methodref          #11.#52        // com/example/test/dispatcher/StaticDispatch.sayHello:(Lcom/example/test/dispatcher/StaticDispatch$Human;)V
  #14 = Class              #53            // java/lang/Object
  #15 = Utf8               Woman
  #16 = Utf8               InnerClasses
  #17 = Utf8               Man
  #18 = Class              #54            // com/example/test/dispatcher/StaticDispatch$Human
  #19 = Utf8               Human
  #20 = Utf8               <init>
  #21 = Utf8               ()V
  #22 = Utf8               Code
  #23 = Utf8               LineNumberTable
  #24 = Utf8               LocalVariableTable
  #25 = Utf8               this
  #26 = Utf8               Lcom/example/test/dispatcher/StaticDispatch;
  #27 = Utf8               sayHello
  #28 = Utf8               (Lcom/example/test/dispatcher/StaticDispatch$Human;)V
  #29 = Utf8               human
  #30 = Utf8               Lcom/example/test/dispatcher/StaticDispatch$Human;
  #31 = Utf8               (Lcom/example/test/dispatcher/StaticDispatch$Man;)V
  #32 = Utf8               man
  #33 = Utf8               Lcom/example/test/dispatcher/StaticDispatch$Man;
  #34 = Utf8               (Lcom/example/test/dispatcher/StaticDispatch$Woman;)V
  #35 = Utf8               woman
  #36 = Utf8               Lcom/example/test/dispatcher/StaticDispatch$Woman;
  #37 = Utf8               main
  #38 = Utf8               ([Ljava/lang/String;)V
  #39 = Utf8               args
  #40 = Utf8               [Ljava/lang/String;
  #41 = Utf8               dispatch
  #42 = Utf8               SourceFile
  #43 = Utf8               StaticDispatch.java
  #44 = NameAndType        #20:#21        // "<init>":()V
  #45 = Class              #55            // java/lang/System
  #46 = NameAndType        #56:#57        // out:Ljava/io/PrintStream;
  #47 = Class              #58            // java/io/PrintStream
  #48 = NameAndType        #59:#60        // println:(Ljava/lang/String;)V
  #49 = Utf8               com/example/test/dispatcher/StaticDispatch$Man
  #50 = Utf8               com/example/test/dispatcher/StaticDispatch$Woman
  #51 = Utf8               com/example/test/dispatcher/StaticDispatch
  #52 = NameAndType        #27:#28        // sayHello:(Lcom/example/test/dispatcher/StaticDispatch$Human;)V
  #53 = Utf8               java/lang/Object
  #54 = Utf8               com/example/test/dispatcher/StaticDispatch$Human
  #55 = Utf8               java/lang/System
  #56 = Utf8               out
  #57 = Utf8               Ljava/io/PrintStream;
  #58 = Utf8               java/io/PrintStream
  #59 = Utf8               println
  #60 = Utf8               (Ljava/lang/String;)V
{
  public com.example.test.dispatcher.StaticDispatch();
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
            0       5     0  this   Lcom/example/test/dispatcher/StaticDispatch;

  public void sayHello(com.example.test.dispatcher.StaticDispatch$Human);
    descriptor: (Lcom/example/test/dispatcher/StaticDispatch$Human;)V
    flags: ACC_PUBLIC
    Code:
      stack=2, locals=2, args_size=2
         0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
         3: ldc           #3                  // String human
         5: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
         8: return
      LineNumberTable:
        line 24: 0
        line 25: 8
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       9     0  this   Lcom/example/test/dispatcher/StaticDispatch;
            0       9     1 human   Lcom/example/test/dispatcher/StaticDispatch$Human;

  public void sayHello(com.example.test.dispatcher.StaticDispatch$Man);
    descriptor: (Lcom/example/test/dispatcher/StaticDispatch$Man;)V
    flags: ACC_PUBLIC
    Code:
      stack=2, locals=2, args_size=2
         0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
         3: ldc           #5                  // String man
         5: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
         8: return
      LineNumberTable:
        line 28: 0
        line 29: 8
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       9     0  this   Lcom/example/test/dispatcher/StaticDispatch;
            0       9     1   man   Lcom/example/test/dispatcher/StaticDispatch$Man;

  public void sayHello(com.example.test.dispatcher.StaticDispatch$Woman);
    descriptor: (Lcom/example/test/dispatcher/StaticDispatch$Woman;)V
    flags: ACC_PUBLIC
    Code:
      stack=2, locals=2, args_size=2
         0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
         3: ldc           #6                  // String woman
         5: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
         8: return
      LineNumberTable:
        line 32: 0
        line 33: 8
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       9     0  this   Lcom/example/test/dispatcher/StaticDispatch;
            0       9     1 woman   Lcom/example/test/dispatcher/StaticDispatch$Woman;

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=2, locals=4, args_size=1
         0: new           #7                  // class com/example/test/dispatcher/StaticDispatch$Man
         3: dup
         4: invokespecial #8                  // Method com/example/test/dispatcher/StaticDispatch$Man."<init>":()V
         7: astore_1
         8: new           #9                  // class com/example/test/dispatcher/StaticDispatch$Woman
        11: dup
        12: invokespecial #10                 // Method com/example/test/dispatcher/StaticDispatch$Woman."<init>":()V
        15: astore_2
        16: new           #11                 // class com/example/test/dispatcher/StaticDispatch
        19: dup
        20: invokespecial #12                 // Method "<init>":()V
        23: astore_3
        24: aload_3
        25: aload_1
        26: invokevirtual #13                 // Method sayHello:(Lcom/example/test/dispatcher/StaticDispatch$Human;)V
        29: aload_3
        30: aload_2
        31: invokevirtual #13                 // Method sayHello:(Lcom/example/test/dispatcher/StaticDispatch$Human;)V
        34: return
      LineNumberTable:
        line 36: 0
        line 37: 8
        line 38: 16
        line 39: 24
        line 40: 29
        line 41: 34
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0      35     0  args   [Ljava/lang/String;
            8      27     1   man   Lcom/example/test/dispatcher/StaticDispatch$Human;
           16      19     2 woman   Lcom/example/test/dispatcher/StaticDispatch$Human;
           24      11     3 dispatch   Lcom/example/test/dispatcher/StaticDispatch;
}
SourceFile: "StaticDispatch.java"
InnerClasses:
     static #15= #9 of #11; //Woman=class com/example/test/dispatcher/StaticDispatch$Woman of class com/example/test/dispatcher/StaticDispatch
     static #17= #7 of #11; //Man=class com/example/test/dispatcher/StaticDispatch$Man of class com/example/test/dispatcher/StaticDispatch
     static abstract #19= #18 of #11; //Human=class com/example/test/dispatcher/StaticDispatch$Human of class com/example/test/dispatcher/StaticDispatch


 */