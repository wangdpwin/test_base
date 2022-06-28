package cn.wangdpwin.test.base.string;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @Author wangdongpeng
 * @Date 2022/2/14 5:53 下午
 * @Version 1.0
 */
public class EnumUtil {

    public static void main(String[] args) {
        String str = "@Remark(\"服务器内部错误\")\n" +
                "public static final int INTERNAL_SERVER_ERROR = 5000;\n" +
                "\n" +
                "@Remark(\"不支持的请求,无法完成\")\n" +
                "public static final int NOT_IMPLEMENTED = 5001;\n" +
                "\n" +
                "@Remark(\"网关错误\")\n" +
                "public static final int BAD_GATEWAY = 5002;\n" +
                "\n" +
                "@Remark(\"服务暂不可用\")\n" +
                "public static final int SERVICE_UNAVAILABLE = 5003;\n" +
                "\n" +
                "@Remark(\"网关超时\")\n" +
                "public static final int GATEWAY_TIME_OUT = 5004;\n" +
                "\n" +
                "@Remark(\"无效的请求协议\")\n" +
                "public static final int HTTP_VERSION_NOT_SUPPORTED = 5004;\n" +
                "\n" +
                "@Remark(\"超出带宽限制\")\n" +
                "public static final int BANDWIDTH_LIMIT_EXCEEDED = 5009;\n" +
                "\n" +
                "@Remark(\"服务器繁忙\")\n" +
                "public static final int SERVER_BUSY = 5100;\n" +
                "\n" +
                "@Remark(\"资源不足\")\n" +
                "public static final int SERVER_RESOURCE_LIMIT = 5200;\n" +
                "\n" +
                "@Remark(\"服务更新中\")\n" +
                "public static final int SERVER_UPDATE = 5300;";
        List<String> list = Arrays.asList(str.split("\n"));

        List<String> result = Lists.newArrayListWithCapacity(100);
        list.forEach(s -> {
            String msg = "";
            String code = "";
            if(s.startsWith("@")) {
                int start = s.indexOf("(");
                int end = s.indexOf(")");
                msg = s.substring(start + 1, end);
//                System.out.println(msg);
                result.add(msg);
            }
            if(s.startsWith("public")) {
                int start = s.indexOf("= ");
                int end = s.indexOf(";");
                code = s.substring(start + 2, end);
//                System.out.println(code);
                result.add(code);
            }
//            System.out.println("("+code+","+msg+")");
        });

        StringBuilder stringBuilder = new StringBuilder(str);
        for (int i = 0; i < result.size(); i=i+2) {
            stringBuilder.append("(");
            stringBuilder.append(result.get(i+1));
            stringBuilder.append(",");
            stringBuilder.append(result.get(i));
            stringBuilder.append("),");
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder.toString());
    }
}
