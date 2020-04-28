package cn.wangdpwin.test.base.nio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: wangdongpeng
 * @Date: 2019/8/14 下午4:10
 * @Description
 * @Version 1.0
 */
public class DemoServer extends Thread {

    private ServerSocket serverSocket;

    public int getPort(){
        return 9999;
    }

    @Override
    public void run(){
        try {
            serverSocket = new ServerSocket(9999);
            while (true) {
                Socket socket = serverSocket.accept();
                RequestHandler requestHandler = new RequestHandler(socket);
                requestHandler.start();;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(serverSocket!=null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
