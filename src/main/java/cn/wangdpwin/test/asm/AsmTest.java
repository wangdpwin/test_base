package cn.wangdpwin.test.asm;

//import jdk.internal.org.objectweb.asm.ClassReader;
//import jdk.internal.org.objectweb.asm.ClassVisitor;
//import jdk.internal.org.objectweb.asm.ClassWriter;

/**
 * @Author wangdongpeng
 * @Date 2022/1/19 9:44 下午
 * @Version 1.0
 */
public class AsmTest {

    public static void main(String[] args) {
        // 使用全限定名，创建一个ClassReader对象
//        ClassReader classReader = new ClassReader("com.yn.test.Test");

        // 构建一个ClassWriter对象，并设置让系统自动计算栈和本地变量大小
//        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);

        //创建一个自定义ClassVisitor，方便后续ClassReader的遍历通知
//        ClassVisitor classVisitor = new TestClassVisitor(classWriter);

        //开始扫描class文件
//        classReader.accept(classVisitor, ClassReader.SKIP_DEBUG);
    }
}
