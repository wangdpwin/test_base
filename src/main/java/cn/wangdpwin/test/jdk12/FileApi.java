package cn.wangdpwin.test.jdk12;

import java.io.IOException;


/**
 * @Author wangdongpeng
 * @Date 2022/3/28 7:35 下午
 * @Version 1.0
 */
public class FileApi {

    /**
     * 文件对比 Files.mismatch
     * 在 Java 中对于文件的操作已经在 Java 7 中进行了一次增强，这次 Java 12 又带来了文件对比功能。对比两个文件，如果内容一致，会返回 -1 ，如果内容不同，会返回不同的字节开始位置。
     * @param args
     */
    public static void main(String[] args) throws IOException {
        // 创建两个文件
//        Path pathA = Files.createFile(Paths.get("a.txt"));
//        Path pathB = Files.createFile(Paths.get("b.txt"));

        // 写入相同内容
//        Files.write(pathA,"abc".getBytes(), StandardOpenOption.WRITE);
//        Files.write(pathB,"abc".getBytes(), StandardOpenOption.WRITE);
//        long mismatch = Files.mismatch(pathA, pathB);
//        System.out.println(mismatch);

        // 追加不同内容
//        Files.write(pathA,"123".getBytes(), StandardOpenOption.APPEND);
//        Files.write(pathB,"321".getBytes(), StandardOpenOption.APPEND);
//        mismatch = Files.mismatch(pathA, pathB);
//        System.out.println(mismatch);

        // 删除创建的文件
//        pathA.toFile().deleteOnExit();
//        pathB.toFile().deleteOnExit();

        // RESULT
        // -1
        // 3
    }
}
