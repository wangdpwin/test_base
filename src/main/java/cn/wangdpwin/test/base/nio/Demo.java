package cn.wangdpwin.test.base.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Author: wangdongpeng
 * @Date: 2019/8/14 下午4:17
 * @Description
 * @Version 1.0
 */
public class Demo {

    public static void main(String[] args) {
        DemoServer server = new DemoServer();
        server.start();
        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), server.getPort());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedReader.lines().forEach(s -> System.out.println(s));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
