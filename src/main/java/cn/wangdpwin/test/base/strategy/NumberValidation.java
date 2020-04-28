package cn.wangdpwin.test.base.strategy;

/**
 * @Author: wangdongpeng
 * @Date: 2019/5/13 下午5:52
 * @Description
 * @Version 1.0
 */
public class NumberValidation implements ValidationStrategy{
    @Override
    public boolean validate(String str) {
        return str.matches("\\d+");
    }
}
