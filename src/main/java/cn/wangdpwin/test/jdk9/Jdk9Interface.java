package cn.wangdpwin.test.jdk9;

/**
 * @Author wangdongpeng
 * @Date 2022/3/28 7:03 下午
 * @Version 1.0
 */
public class Jdk9Interface {

    /**
     * 接口私有方法
     */
    public static void main(String[] args) {
        ChinaPeople chinaPeople = new ChinaPeople();
        chinaPeople.sleep();
        chinaPeople.eat();
        chinaPeople.doXxx();
    }

}

class ChinaPeople implements People {
    @Override
    public void sleep() {
        System.out.println("躺着睡");
    }
}

interface People {
    void sleep();

    default void eat() {
        drink();
    }

    default void doXxx() {
        drink();
    }

    private void drink() {
        System.out.println("喝水");
    }
}