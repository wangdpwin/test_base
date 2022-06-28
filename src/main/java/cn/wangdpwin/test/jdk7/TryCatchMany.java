package cn.wangdpwin.test.jdk7;

import java.io.IOException;

/**
 * @Author wangdongpeng
 * @Date 2022/3/28 6:41 下午
 * @Version 1.0
 */
public class TryCatchMany {

    public static void main(String[] args) {
        try (TxtRead txtRead = new TxtRead()) {
            txtRead.reader();
        } catch (IOException | NoSuchFieldException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class TxtRead implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("资源释放");
    }

    public void reader() throws IOException, NoSuchFieldException {
        System.out.println("数据读取");
    }
}
