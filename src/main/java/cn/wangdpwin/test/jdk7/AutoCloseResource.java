package cn.wangdpwin.test.jdk7;

/**
 * @Author wangdongpeng
 * @Date 2022/3/28 6:40 下午
 * @Version 1.0
 */
public class AutoCloseResource {

    public static void main(String[] args) throws Exception {
        try (Mysql mysql = new Mysql();
             OracleDatabase oracleDatabase = new OracleDatabase()) {
            mysql.conn();
            oracleDatabase.conn();
        }
    }
}

class Mysql implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("mysql 已关闭");
    }

    public void conn() {
        System.out.println("mysql 已连接");
    }
}

class OracleDatabase implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("OracleDatabase 已关闭");
    }

    public void conn() {
        System.out.println("OracleDatabase 已连接");
    }
}
