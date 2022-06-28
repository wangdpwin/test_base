package cn.wangdpwin.test.jdk11;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * @Author wangdongpeng
 * @Date 2022/3/28 7:30 下午
 * @Version 1.0
 * 更多的如同步异步请求，并发访问，设置代理等方式，可以参考 OpenJDK 官方文档。
 *
 * http://openjdk.java.net/groups/net/httpclient/recipes-incubating.html
 */
public class HttpClient {

    /**
     * 在 Java 11 中 Http Client API 得到了标准化的支持。且支持 HTTP/1.1 和 HTTP/2 ，也支持 websockets。
     * @param args
     */
    public static void main(String[] args) {
        //你可以像这样发起一个请求。
        /*HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.hao123.com"))
                .build();*/
        // 异步
//        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
//                .thenApply(HttpResponse::body)
//                .thenAccept(System.out::println)
//                .join();

        // 同步
//        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        System.out.println(response.body());
    }
}
