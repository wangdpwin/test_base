package cn.wangdpwin.test.base.remote;

/**
 * @Author: wangdongpeng
 * @Date: 2019/3/7 下午3:50
 * @Description
 * @Version 1.0
 */
public class HotSwapClassLoader extends ClassLoader{

    public HotSwapClassLoader() {
        super(HotSwapClassLoader.class.getClassLoader());
    }

    public Class<?> loadByte(byte[] classByte){
        return defineClass(null,classByte,0,classByte.length);
    }

}
