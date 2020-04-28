package cn.wangdpwin.test.base.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * @Author: wangdongpeng
 * @Date: 2019/9/9 下午4:12
 * @Description
 * @Version 1.0
 */
public class ZipTest {

    private static final byte[] BUFFER = new byte[4096 * 1024 * 10];

    /**
     * copy input to output stream - available in several StreamUtils or Streams classes
     */
    public static void copy(InputStream input, OutputStream output) throws IOException {
        int bytesRead;
        while ((bytesRead = input.read(BUFFER))!= -1) {
            output.write(BUFFER, 0, bytesRead);
        }
    }

    public static void main(String[] args) throws Exception {
        // read war.zip and write to append.zip
        ZipFile war = new ZipFile("test.zip");
        ZipOutputStream append = new ZipOutputStream(new FileOutputStream("append.zip"));

        // first, copy contents from existing war
        Enumeration<? extends ZipEntry> entries = war.entries();
        while (entries.hasMoreElements()) {
            ZipEntry e = entries.nextElement();
            System.out.println("copy: " + e.getName());
            append.putNextEntry(e);
            if (!e.isDirectory()) {
                copy(war.getInputStream(e), append);
            }
            append.closeEntry();
        }

        // now append some extra content
        ZipEntry e = new ZipEntry("answer.txt");
        System.out.println("append: " + e.getName());
        append.putNextEntry(e);
        append.write("42\n".getBytes());
        append.closeEntry();

        // close
        war.close();
        append.close();
    }
}
