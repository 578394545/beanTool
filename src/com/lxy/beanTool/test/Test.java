package com.lxy.beanTool.test;

import com.lxy.beanTool.bean.BeanData;
import com.lxy.beanTool.execute.CreateBean;
import com.lxy.beanTool.execute.OutputBean;
import com.lxy.beanTool.util.ReadExcel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.read.biff.BiffException;

public class Test
{
  public static int createFile(String beanStr, String fileName, String fileType)
  {
    int i = 0;
    try {
      i = OutputBean.createFile(beanStr, fileName, fileType);
    } catch (IOException e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
    return i;
  }

  public static String createBean(List<BeanData> beanList, int createType, Map<String, String> fileMap)
  {
    return CreateBean.createBean(beanList, createType, fileMap);
  }

  public static Map<String, String> getFileName()
  {
    File file = new File("entity.xls");
    Map<String, String> fileMap = new HashMap<String, String>();
    try {
      fileMap = ReadExcel.getFileName(file);
    }
    catch (BiffException|IOException e) {
      e.printStackTrace();
    }
    return fileMap;
  }

  public static List<BeanData> getBeanData()
  {
    File file = new File("entity.xls");
    List<BeanData> list = new ArrayList<BeanData>();
    try {
      list = ReadExcel.getBeanData(file);
    }
    catch (BiffException|IOException e) {
      e.printStackTrace();
    }
    return list;
  }

  public static void main(String[] args)
  {
    List<BeanData> list = getBeanData();
    Map<String, String> fileMap = getFileName();
    for (String key : fileMap.keySet()) {
      System.out.println((String)fileMap.get(key));
    }

    String str = "";
    str = createBean(list, 1, fileMap);
    System.out.println(str);

    createFile(str, (String)fileMap.get("fileName"), "java");
  }

  public static String forTextArea()
  {
    List<BeanData> list = getBeanData();
    Map<String, String> fileMap = getFileName();
    for (String key : fileMap.keySet()) {
      System.out.println((String)fileMap.get(key));
    }

    String str = "";
    str = createBean(list, 1, fileMap);
    return str;
  }
}
