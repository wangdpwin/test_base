package cn.wangdpwin.test.jdk11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @Author wangdongpeng
 * @Date 2022/3/28 7:29 下午
 * @Version 1.0
 */
public class FileApi {

    public static void main(String[] args) throws IOException {
        // 创建临时文件
        Path path = Files.writeString(Files.createTempFile("test", ".txt"), "https://www.wdbyte.com");
        System.out.println(path);
        // 读取文件
        // String ss = Files.readString(Path.of("file.json"));
        String s = Files.readString(path);
        System.out.println(s);

        // 结果
        // https://www.wdbyte.com
    }
}
