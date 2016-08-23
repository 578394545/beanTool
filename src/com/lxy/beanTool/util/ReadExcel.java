package com.lxy.beanTool.util;

import com.lxy.beanTool.bean.BeanData;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExcel
{
  public static List<BeanData> getBeanData(File file)
    throws BiffException, IOException
  {
    List<BeanData> list = new ArrayList<BeanData>();

    Workbook wb = Workbook.getWorkbook(file);

    Sheet[] sheetArray = wb.getSheets();

    Sheet sheet = sheetArray[0];
    for (int i = 1; i < sheet.getRows(); i++) {
      Cell[] cells = sheet.getRow(i);
      BeanData bean = new BeanData();
      bean.setPName($(cells, 0));
      bean.setRemark($(cells, 1));
      bean.setPType($(cells, 2));
      bean.setDefaultValue($(cells, 3));
      if (i == 1) {
        bean.setPackName($(cells, 4));
        bean.setClassName($(cells, 5));
      }
      list.add(bean);
    }
    wb.close();

    return list;
  }

  public static Map<String, String> getFileName(File file)
    throws BiffException, IOException
  {
    Map<String, String> fileMap = new HashMap<String, String>();

    Workbook wb = Workbook.getWorkbook(file);

    Sheet[] sheetArray = wb.getSheets();

    Sheet sheet = sheetArray[1];

    for (int i = 1; i < sheet.getRows(); i++) {
      Cell[] cells = sheet.getRow(i);
      fileMap.put("fileName", $(cells, 0));
      fileMap.put("packName", $(cells, 1));
    }
    return fileMap;
  }

  private static String $(Cell[] row, int index)
  {
    if (index >= row.length) {
      return "";
    }
    if (row[index] == null) {
      return "";
    }
    return row[index].getContents();
  }
}