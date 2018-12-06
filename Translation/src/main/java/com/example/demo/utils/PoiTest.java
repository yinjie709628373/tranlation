package com.example.demo.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

public class PoiTest {
    private static final String TRANS_API_HOST = "http://api.fanyi.baidu.com/api/trans/vip/translate";
    protected static final int SOCKET_TIMEOUT = 10000; // 10S
    protected static final String GET = "GET";

    public static void TT() throws Exception {

        ArrayList<String> columnList = new ArrayList<String>();
        File file = new File("d:\\title.xlsx");

        try {
            FileInputStream in = new FileInputStream(file);

            XSSFWorkbook wb = new XSSFWorkbook(in);

            Sheet sheet = wb.getSheetAt(0);
            int firstRowNum = sheet.getFirstRowNum();
            int lastRowNum = sheet.getLastRowNum();

            Row row = null;
            Cell cell_a = null;
            Cell cell_b = null;
            for (int i = 1; i <= lastRowNum; i++) {
                row = sheet.getRow(i);//取得第i行
                cell_a = row.getCell(1);//取得i行的第一列
                String cellValue = cell_a.getStringCellValue().trim();
                //转化为驼峰式
                String source =  TranslateUtil.getTransResult(cellValue, "auto", "en");
                //分割
                String result[] =source.split(" ");
                String resultt="";
                if (result.length <= 1 && result.length > 0) {
                    resultt=result[0];
                }else if(result.length>1){

                    for(int t=0;t<result.length;t++){
                        if(t==0){
                            //判断 第一个单词首字母需要小写正则
                            resultt=resultt+result[0];
                        }else{
                            resultt=resultt+  (new StringBuilder()).append(Character.toUpperCase(result[t].charAt(0))).append(result[t].substring(1)).toString();
                        }
                    }
                }

                //匹配正则表达式
                System.out.println(cellValue+"："+resultt);
                columnList.add(cellValue);
            }

        }catch(Exception e)

        {
            e.printStackTrace();
        }
    }
}



