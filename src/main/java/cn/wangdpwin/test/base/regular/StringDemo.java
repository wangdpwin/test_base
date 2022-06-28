package cn.wangdpwin.test.base.regular;

import com.alibaba.excel.util.FileUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @Author wangdongpeng
 * @Date 2021/9/29 3:27 下午
 * @Version 1.0
 */
public class StringDemo {

    public static void main(String[] args) {
        String str = "[\n" +
                "    {\n" +
                "        \"reportId\": \"ec14395ffd034da28057d3660cf88856\",\n" +
                "        \"marker\": \"PASS\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"reportId\": \"12881066e3a14db586f25f0e310d95e9\",\n" +
                "        \"marker\": \"Manual Review\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"reportId\": \"3c26c3c887a54a23ae9fdd01ecac562b\",\n" +
                "        \"marker\": \"Manual Review\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"reportId\": \"44e2027e94a347649cb28a053f89a325\",\n" +
                "        \"marker\": \"Manual Review\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"reportId\": \"18408fc8012e4b9686b922c9297d0082\",\n" +
                "        \"marker\": \"PASS\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"reportId\": \"9bcc98bd1f0844379c61eb8971b57272\",\n" +
                "        \"marker\": \"PASS\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"reportId\": \"b7f166d8aa1a435a977c288936e8829a\",\n" +
                "        \"marker\": \"PASS\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"reportId\": \"ea3de1eef22f4acbacbdbdc579418765\",\n" +
                "        \"marker\": \"Manual Review\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"reportId\": \"4445a863e6d740dd8a6c10410cbe4509\",\n" +
                "        \"marker\": \"Manual Review\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"reportId\": \"53c54aa7ea1f4a29a2cd1c449cf507dd\",\n" +
                "        \"marker\": \"Manual Review\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"reportId\": \"f8b8d9cc984b4db5a94c45e2edb730a5\",\n" +
                "        \"marker\": \"PASS\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"reportId\": \"7def3b43a2cd49349c9c89afb7bc71f3\",\n" +
                "        \"marker\": \"PASS\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"reportId\": \"90805d97bd8c464dad59f70b3d303159\",\n" +
                "        \"marker\": \"PASS\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"reportId\": \"772049c4fdab4e6e99960ddb6f281a99\",\n" +
                "        \"marker\": \"Manual Review\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"reportId\": \"d9fd102fb89b49a69a4156aa89293508\",\n" +
                "        \"marker\": \"Manual Review\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"reportId\": \"6edecf67693f49e8b36dcefaa9f26ace\",\n" +
                "        \"marker\": \"Manual Review\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"reportId\": \"8b2271065abf449592531eb743474010\",\n" +
                "        \"marker\": \"Manual Review\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"reportId\": \"0d04016c64f64d2fa1b8211a93ddacbf\",\n" +
                "        \"marker\": \"Manual Review\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"reportId\": \"e74e2dba243e4c0c92f5c405856cde58\",\n" +
                "        \"marker\": \"Manual Review\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"reportId\": \"b12420d77a9641b4aff67dedfe3918f2\",\n" +
                "        \"marker\": \"PASS\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"reportId\": \"1d3e08ade112481fa634fcc0534240be\",\n" +
                "        \"marker\": \"Manual Review\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"reportId\": \"4161337dc6e949e1bc845660b94e0e54\",\n" +
                "        \"marker\": \"Manual Review\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"reportId\": \"7425556c59c0402da71bac8006d40989\",\n" +
                "        \"marker\": \"Manual Review\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"reportId\": \"b4d76bc78ab145b18d5f6c6070d571a0\",\n" +
                "        \"marker\": \"PASS\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"reportId\": \"842211a005c1495ca7374eb97a8a818f\",\n" +
                "        \"marker\": \"Manual Review\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"reportId\": \"eb068aaa441b45f7a7bc63ad653f66af\",\n" +
                "        \"marker\": \"Manual Review\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"reportId\": \"8db2f73f35bd4398a1f28e079f4fd5b9\",\n" +
                "        \"marker\": \"Manual Review\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"reportId\": \"1ddec5a4dd884e3d958b7726fb460566\",\n" +
                "        \"marker\": \"Manual Review\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"reportId\": \"cb49c2cf371e496baf4c085fc34ebba6\",\n" +
                "        \"marker\": \"Manual Review\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"reportId\": \"47c3b9ba536d4be698d01d02ab4cd9b2\",\n" +
                "        \"marker\": \"Manual Review\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"reportId\": \"6b8a005e98d1499199e88ee79b5f4e97\",\n" +
                "        \"marker\": \"PASS\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"reportId\": \"eb2463531c664fc2a9aa4e22ffcfced6\",\n" +
                "        \"marker\": \"PASS\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"reportId\": \"6fc7e181993b4bbb84f1af5634ca9f62\",\n" +
                "        \"marker\": \"PASS\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"reportId\": \"44234ec649004741ab766deb8b4f4a2f\",\n" +
                "        \"marker\": \"Manual Review\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"reportId\": \"1fef80b6f1404c0881555a2576658cb1\",\n" +
                "        \"marker\": \"Manual Review\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"reportId\": \"feaf7e00520d4bec8751d77bb68cbe9a\",\n" +
                "        \"marker\": \"Manual Review\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"reportId\": \"09633b0f812b471bbf289acbf84c1861\",\n" +
                "        \"marker\": \"Manual Review\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"reportId\": \"aad5da04752b411dbad8c64a32635a7c\",\n" +
                "        \"marker\": \"Manual Review\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"reportId\": \"2f23dfc025f944b09fa19d3baf507d9f\",\n" +
                "        \"marker\": \"PASS\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"reportId\": \"a6e721835773482ab5df4b9ab894d3a7\",\n" +
                "        \"marker\": \"Manual Review\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"reportId\": \"58669afe3368473bac9424ca710127a0\",\n" +
                "        \"marker\": \"PASS\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"reportId\": \"306d5be6178846f2939c0418ff79819a\",\n" +
                "        \"marker\": \"Manual Review\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"reportId\": \"3003bd873b374ada9af62ece191d833b\",\n" +
                "        \"marker\": \"Manual Review\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"reportId\": \"d075e0b69de840f2ab643ba874519355\",\n" +
                "        \"marker\": \"PASS\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"reportId\": \"c77ab043c71741b8ae78fb01ce92871f\",\n" +
                "        \"marker\": \"Manual Review\"\n" +
                "    }\n" +
                "]";
        String sql = "update t_pgd_report set marker = '%s' where id='%s';";
        List<JSONObject> jsonObjects = JSONArray.parseArray(str, JSONObject.class);
        List<String> sqls = Lists.newArrayListWithCapacity(jsonObjects.size());
        jsonObjects.forEach(jsonObject -> {
            String id = jsonObject.getString("reportId");
            String marker = jsonObject.getString("marker");
            String temp = String.format(sql,marker,id);
            System.out.println(temp);
        });
    }

    @Test
    public void read() throws IOException {
        String datetime = LocalDateTime.now().toString();
        String template = "INSERT INTO [GCYDataBaseOfPe].[dbo].[Article] ([ArticleId], [CateId], [Title], [ArticleDes], [ArticlePhoto], " +
                "[Sex], [UserId], [WordsCount], [ClickCount], [ZhiChiCount], " +
                "[Price], [FreeView], [ChapterCount], [RecentUpdates],[IsBest]," +
                "[SortId],[Status],[AddTime],[UpdateTime],[PublishTime]," +
                "[AuditStatus],[NovelId]) " +
                "VALUES (%s,1,19,1,'%s','%s','%s'," + "1,0);";
        int i = 0;
        List<String> lines = Files.readAllLines(Paths.get("data.txt"));
        List<String> sqlList = Lists.newArrayListWithCapacity(lines.size());
        for (String line : lines) {
            String temp = String.format(template,line, datetime,datetime,datetime);
            sqlList.add(temp);
        }
        File file = new File("data.sql");
        //如果没有文件就创建
        if (!file.isFile()) {
            file.createNewFile();
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter("data.sql"));
        for (String l:sqlList){
            writer.write(l + "\r\n");
        }
    }

    @Test
    public void lost() throws IOException {
        List<String> saved = Files.readAllLines(Paths.get("已入库的articleId.txt"));
        List<String> total = Files.readAllLines(Paths.get("全部articleId.txt"));
        total.removeAll(saved);
        System.out.println(JSON.toJSONString(total));
        StringBuilder stringBuilder = new StringBuilder("'");
        for (String s : total) {
            stringBuilder.append(s).append("',");
        }
        System.out.println(stringBuilder.toString());
    }

}
