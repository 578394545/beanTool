package com.lxy.beanTool.execute;

import com.lxy.beanTool.util.Format;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 * @Title: OutputBean.java <br />
 * @Description:bean相关方法 <br />
 * <br />
 * @author: lxy <br />
 */
public class OutputBean
{
  public static int createFile(String beanStr, String fileName, String fileType)
    throws IOException
  {
    File file = new File(Format.toUpperCase(fileName) + "." + fileType);
    if (file.exists())
    {
      System.out.println("创建单个文件" + fileName + "失败，目标文件已存在！");
      return 1;
    }
    if (fileName.endsWith(File.separator))
    {
      System.out.println("创建单个文件" + fileName + "失败，目标文件不能为目录！");
      return 1;
    }
    try
    {
      file.createNewFile();

      FileWriter fw = new FileWriter(file);
      fw.write(beanStr);

      fw.flush();
      fw.close();
    } catch (IOException e) {
      new IOException("1");
    }
    return 0;
  }
}
