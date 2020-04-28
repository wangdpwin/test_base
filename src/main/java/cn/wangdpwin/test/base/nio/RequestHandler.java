package cn.wangdpwin.test.base.nio;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @Author: wangdongpeng
 * @Date: 2019/8/14 下午4:13
 * @Description
 * @Version 1.0
 */
public class RequestHandler extends Thread {
    private Socket socket;
    public RequestHandler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){
        PrintWriter out = null;
        try {
            out = new PrintWriter(socket.getOutputStream());
            out.println("hello world");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
