package cn.wangdpwin.test.base.strategy;

import org.junit.Test;

/**
 * @Author: wangdongpeng
 * @Date: 2019/5/13 下午5:56
 * @Description
 * @Version 1.0
 */
public class Client {

    /**
     * 策略模式测试
     */
    @Test
    public void test(){
        String str = "sadsadAA";
        ValidationStrategy strategy = new LowerCaseValidation();
        ValidationStrategy strategy2 = new NumberValidation();
        Validator validator = new Validator(strategy2);
        boolean b = validator.execute(str);
        System.out.println(b);
    }

    /**
     * 使用lambda实现策略模式
     */
    @Test
    public void lambdaTest(){
        Validator validator = new Validator((String str) -> str.matches("\\d+") );
        boolean execute = validator.execute("121321321");
        System.out.println(execute);
    }

}
