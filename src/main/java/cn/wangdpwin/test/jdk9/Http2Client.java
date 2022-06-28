package cn.wangdpwin.test.jdk9;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * @Author wangdongpeng
 * @Date 2022/3/28 7:05 下午
 * @Version 1.0
 */
public class Http2Client {

    public static void main(String[] args) {
        /*HttpClient client = HttpClient.newHttpClient();
        URI uri = URI.create("http://www.tianqiapi.com/api/xxx");
        HttpRequest req = HttpRequest.newBuilder(uri).header("User-Agent", "Java").GET().build();
        HttpResponse<String> resp = client.send(req, HttpResponse.BodyHandler.asString());
        String body = resp.body();
        System.out.println(body);*/
    }
}
