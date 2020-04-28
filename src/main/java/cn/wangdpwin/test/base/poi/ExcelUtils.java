package cn.wangdpwin.test.base.poi;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import lombok.Data;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * @Author: wangdongpeng
 * @Date: 2019/2/28 下午1:37
 * @Description
 * @Version 1.0
 */
public class ExcelUtils {

    private static String str = "";

    public static void main(String[] args) throws IllegalAccessException {
        System.out.println("begin");
        //第一步创建workbook
        HSSFWorkbook wb = new HSSFWorkbook();
        //第二步创建sheet
        HSSFSheet sheet = wb.createSheet("pgs");
        //第三步创建行row:添加表头0行
        HSSFRow row = sheet.createRow(0);
        HSSFCellStyle style = wb.createCellStyle();
        //style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  //居中
        String[] colum = {"aaa", "bbb", "ccc", "ddd", "eee", "fff"};
        //列名
        for(int i=0;i<colum.length;i++){
            HSSFCell cell = row.createCell(i); //第一个单元格
            cell.setCellValue(colum[i]);
            cell.setCellStyle(style);
        }
        List<Example> examples = JSONObject.parseArray(str, Example.class);
        for(int i=0;i<examples.size();i++){
            Example example = examples.get(i);
            HSSFRow rowStr = sheet.createRow(i+1);
            Field[] fields = example.getClass().getDeclaredFields();
            int col = 0;
            for (Field field : fields) {
                if (AnnotationUtils.has(field, Ignored.class)) {
                    continue;
                }
                Object o = field.get(example);
                if(o==null){
                    o = "";
                }
                rowStr.createCell(col).setCellValue(o.toString());
                col++;
            }

        }
        //第六步将生成excel文件保存到指定路径下
        try {
            FileOutputStream fout = new FileOutputStream("a.xlsx");
            wb.write(fout);
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Excel文件生成成功...");
    }
}

@Data
class Example implements Serializable{
    private String platform;
    private String type;
    private String group;
    private String username;
    private String address;
    @JSONField(format = "yyyy-MM-ddd")
    private Date creatTime;
}