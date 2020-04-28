package cn.wangdpwin.test.base.strategy;

/**
 * @Author: wangdongpeng
 * @Date: 2019/5/13 下午5:53
 * @Description
 * @Version 1.0
 */
public class Validator {

    private ValidationStrategy strategy;

    public Validator(ValidationStrategy strategy){
        this.strategy = strategy;
    }

    public boolean execute(String str){
        return strategy.validate(str);
    }
}
