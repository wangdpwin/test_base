package cn.wangdpwin.test.base.excel;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: wangdongpeng
 * @Date: 2019/5/16 下午7:05
 * @Description
 * @Version 1.0
 */
public class EasyExcel {

    private static List<String> list = Arrays.asList("第一列","第二列","第三列","四","五","六","");

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        Thread.sleep(30 * 1000L);
        generateExcel("1.xlsx");
        Thread.sleep(3000L);
        generateExcel("2.xlsx");
        Thread.sleep(3000L);
        generateExcel("3.xlsx");
        Thread.sleep(3000L);
    }

    private static void generateExcel(String filename) throws FileNotFoundException {
        OutputStream out = new FileOutputStream("/Users/wangdongpeng/usr/testGitRespository/test/src/main/resources/excel/"+ filename );
        try {
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX,true);
            //写第一个sheet, sheet1  数据全是List<String> 无模型映射关系
            Sheet sheet1 = new Sheet(1, 0);
            sheet1.setSheetName("第一个sheet");
            sheet1.setClazz(ExcelPropertyIndexModel.class);
            List<? extends BaseRowModel> models = getListModel();
            writer.write(models, sheet1);
            writer.finish();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static List<List<String>> getListString() {

        List<List<String>> lists = new ArrayList<>(100000);
        for (int i=0;i<100000;i++){
            lists.add(list);
        }
        return lists;
    }

    private static List<? extends BaseRowModel> getListModel() {
        List<ExcelPropertyIndexModel> list = new ArrayList<>(100000);
        for(int i=0;i<100000;i++){
            ExcelPropertyIndexModel model = new ExcelPropertyIndexModel();
            model.setName("李涛桑");
            model.setAge("22");
            model.setEmail("litao@gmail.com");
            model.setAddress("六道口");
            model.setHeigh("11");
            model.setLast("aifan");
            model.setSax("测试数据");
            list.add(model);
        }
        return list;
    }

}
