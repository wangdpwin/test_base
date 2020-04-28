package cn.wangdpwin.test.base.poi;

import com.alibaba.fastjson.JSON;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Author: wangdongpeng
 * @Date: 2019/4/3 上午10:12
 * @Description
 * @Version 1.0
 */

public class Client {

    public static void main(String[] args) {
        try {
            File[] files= getFiles("objectLogs/result/logs","test-",".txt");
            System.out.println(JSON.toJSONString(files));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

  public static File[] getFiles(String filepath, String prefix, String suffix) throws FileNotFoundException, IOException {
    filepath = checkFilePathEnd(filepath);
    File file = new File(filepath);
    if (!file.isDirectory()) {
      return null;
    }
    FileFilter fileFilter = filea -> filea.getName().startsWith(prefix) && filea.getName().endsWith(suffix);
    File[] files = file.listFiles(fileFilter);
    if (files.length > 0) {
        return files;
    } else {
      System.out.println("error blank file");
      return null;
    }
  }

    public static String  checkFilePathEnd(String filepath){
        if(!filepath.endsWith("/"))
            filepath =filepath + "/";
        return filepath;

    }

    public static Integer getNum(File readfile, String prefix, String suffix ){
        Integer number = null;
        if (!readfile.isDirectory() && readfile.getName().endsWith(suffix)
                && readfile.getName().startsWith(prefix)) {
            String num = readfile.getName().substring(prefix.length(),
                    readfile.getName().length()-suffix.length());
            try {
                number = Integer.parseInt(num);
            } catch (Exception e) {
                return number;
            }


        }
        return number;
    }

}