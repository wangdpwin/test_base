package cn.wangdpwin.test.base.io;

import com.google.common.base.Charsets;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.Test;

/**
 * @Author: wangdongpeng
 * @Date: 2019/9/9 下午12:23
 * @Description
 * @Version 1.0
 */
public class ZipModifyTest {

    @Test
    public void modify(){
        File path2File = new File("test.zip");
        FileSystem fileSystem;
        try {
            fileSystem = FileSystems.newFileSystem(path2File.toPath(), null);//path2File是压缩包的File
            Path zipXmlPath =fileSystem.getPath("dir1/Report_Data_sta.txt");//获取压缩包内xml的path
            String description1= "Report_Data_sta1.txt";
            File description1File = new File(description1);
            if(!description1File.exists()){
                description1File.createNewFile();//此文件用来存放从的description.xml复制的内容
            }
            Path dPath1 =description1File.toPath();
            Files.copy(zipXmlPath,dPath1, StandardCopyOption.REPLACE_EXISTING);//将压缩文件的description.xml复制内容到description1.xml文件中


            String modifyXml= "Report_Data_sta.txt";
            File modifyFile = new File(modifyXml);
            if(!modifyFile.exists()){
                modifyFile.createNewFile();//此文件用来存放description1.xml修改后的内容
            }
            Path modifyPath =modifyFile.toPath();
            BufferedReader reader = Files.newBufferedReader(dPath1, StandardCharsets.UTF_8);
            BufferedWriter writer = Files.newBufferedWriter(modifyPath, StandardCharsets.UTF_8);
            String str = null;
            boolean flag=true;
            while ((str = reader.readLine()) != null) {
                writer.write(str);
                writer.write("\r\n +1");
            }
            writer.flush();
            writer.close();
            Files.copy(modifyPath,zipXmlPath, StandardCopyOption.REPLACE_EXISTING);//将修改后的文件再复制到压缩文件内
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void create() throws IOException {
        Map<String, String> env = new HashMap<>();
        env.put("create", "true");
        Path path = Paths.get("test.zip");
        URI uri = URI.create("jar:" + path.toUri());
        try (FileSystem fs = FileSystems.newFileSystem(uri, env)){
            Path nf = fs.getPath("Report_Data_sta2.txt");
            Path nf2 = new File("Report_Data_sta1.txt").toPath();
            try (Writer writer = Files.newBufferedWriter(nf, StandardCharsets.UTF_8, StandardOpenOption.CREATE)){
                try {
                    writer.write(Files.readAllLines(nf2, Charsets.UTF_8).stream().collect(Collectors.joining("\n")));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
