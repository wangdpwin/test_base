package cn.wangdpwin.test.base.lru;

/**
 * @Author: wangdongpeng
 * @Date: 2019/8/26 下午4:20
 * @Description
 * @Version 1.0
 */
public class LRUClient {

    public static void main(String[] args) {
        LRUCache<String, Integer> lruCache = new LRUCache<String, Integer>(100);
        String key = "str";
        for(int i=0;i<100;i++){
            lruCache.put(key+i,i);
        }
        lruCache.forEach((k,v) -> System.out.println(k + " : " + v));
        System.out.println("start to remove cacha");
        for(int i=100;i<250;i++){
            lruCache.put(key+i,i);
        }
        Integer str50 = lruCache.get("str50");
        Integer str52 = lruCache.get("str50");
        Integer str53 = lruCache.get("str50");
        Integer str100 = lruCache.get("str100");
        lruCache.forEach((k,v) -> System.out.println(k + " : " + v));
    }
}
