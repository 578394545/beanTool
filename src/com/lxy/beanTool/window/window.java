package com.lxy.beanTool.window;

import com.lxy.beanTool.bean.BeanData;
import com.lxy.beanTool.execute.CreateBean;
import com.lxy.beanTool.execute.OutputBean;
import com.lxy.beanTool.util.ReadExcel;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class window extends JFrame
{
  private static final long serialVersionUID = -2702319797130172508L;
  private JMenuBar menuBar;
  private JButton btnexcel;
  private JTextField textField;
  private JLabel label_1;
  private JTextField textField_1;
  private JTextField pro1;
  private JTextField note1;
  private JComboBox type1;
  private JButton button;
  private JButton btnexcel_1;
  private JButton btnjavabean;
  private JTextField pro2;
  private JTextField note2;
  private JComboBox type2;
  private int proTime = 1;
  private int clickTime = 0;

  private List<BeanData> list = new ArrayList<BeanData>();

  public static void main(String[] args)
  {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          window frame = new window();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  public window()
  {
    setTitle("beanTool");
    setResizable(false);
    setDefaultCloseOperation(3);
    setBounds(100, 100, 800, 600);

    final JTextArea textArea = new JTextArea();
    textArea.setBackground(Color.WHITE);
    textArea.setEditable(false);
    textArea.setBounds(10, 295, 774, 241);
    getContentPane().add(textArea);

    this.menuBar = new JMenuBar();
    setJMenuBar(this.menuBar);

    this.btnexcel = new JButton("导入Excel");
    this.btnexcel.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent e) {
        JFileChooser jfc = new JFileChooser();

        jfc.setFileSelectionMode(0);
        String[] extt = { "xls" };
        FileFilter filter = new FileNameExtensionFilter("请选择配套的bean.xls文件", extt);
        jfc.setFileFilter(filter);
        jfc.showDialog(new JLabel(), "选择");
        File file = jfc.getSelectedFile();
        try {
          if (file != null) {
            List<BeanData> beanList = ReadExcel.getBeanData(file);
            textArea.setText(null);
            String str = CreateBean.createBean(beanList, 1, null);
            textArea.setText(str);
            window.this.button.setEnabled(true);
            window.this.btnjavabean.setEnabled(true);
          }
        } catch (Exception e1) {
          JOptionPane.showMessageDialog(null, "读取excel文件失败,请确认所选文档格式正确：" + e1.getMessage(), "异常", 0);
        }
      }
    });
    this.menuBar.add(this.btnexcel);
    getContentPane().setLayout(null);

    JLabel label = new JLabel("类名");
    label.setFont(new Font("微软雅黑", 0, 13));
    label.setBounds(47, 11, 32, 24);
    getContentPane().add(label);

    this.textField = new JTextField();
    this.textField.addFocusListener(new FocusAdapter()
    {
      public void focusLost(FocusEvent e) {
        String text1 = window.this.textField.getText().trim();
        for (int i = 0; i < text1.length(); i++) {
          char ch = text1.charAt(i);
          if (((ch > 'z') || (ch < 'a')) && ((ch > 'Z') || (ch < 'A')) && ((ch < '0') || (ch > '9')))
          {
            JOptionPane.showMessageDialog(null, "类名仅能输入数字、字母及下划线,内容已重置", "警告", 2);
            window.this.textField.setText(null);
            return;
          }
        }
      }
    });
    this.textField.setToolTipText("java类名");
    this.textField.setBounds(83, 14, 126, 21);
    getContentPane().add(this.textField);
    this.textField.setColumns(10);

    this.label_1 = new JLabel("包名");
    this.label_1.setFont(new Font("微软雅黑", 0, 13));
    this.label_1.setBounds(303, 11, 32, 24);
    getContentPane().add(this.label_1);

    this.textField_1 = new JTextField();
    this.textField_1.addFocusListener(new FocusAdapter()
    {
      public void focusLost(FocusEvent e) {
        String textField1 = window.this.textField_1.getText().trim();
        for (int i = 0; i < textField1.length(); i++) {
          char ch = textField1.charAt(i);
          if (((ch > 'z') || (ch < 'a')) && ((ch > 'Z') || (ch < 'A')) && ((ch < '0') || (ch > '9')) && (ch != '.'))
          {
            JOptionPane.showMessageDialog(null, "包名仅能输入数字、字母及下划线,内容已重置", "警告", 2);
            window.this.textField_1.setText(null);
            return;
          }
        }
      }
    });
    this.textField_1.setToolTipText("java包名");
    this.textField_1.setColumns(10);
    this.textField_1.setBounds(339, 14, 295, 21);
    getContentPane().add(this.textField_1);

    this.pro1 = new JTextField();
    this.pro1.addFocusListener(new FocusAdapter()
    {
      public void focusLost(FocusEvent e) {
        String p1 = window.this.pro1.getText().trim();
        for (int i = 0; i < p1.length(); i++) {
          char ch = p1.charAt(i);
          if (((ch > 'z') || (ch < 'a')) && ((ch > 'Z') || (ch < 'A')) && ((ch < '0') || (ch > '9')))
          {
            JOptionPane.showMessageDialog(null, "属性名仅能输入数字、字母及下划线,内容已重置", "警告", 2);
            window.this.pro1.setText(null);
            return;
          }
        }
      }
    });
    this.pro1.setToolTipText("输入一个属性名称");
    this.pro1.setBounds(47, 67, 210, 21);
    getContentPane().add(this.pro1);
    this.pro1.setColumns(10);

    this.note1 = new JTextField();
    this.note1.setToolTipText("输入属性名称对应的注释");
    this.note1.setColumns(10);
    this.note1.setBounds(422, 67, 212, 21);
    getContentPane().add(this.note1);

    this.type1 = new JComboBox();
    this.type1.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == 1) {
          String t1 = window.this.type1.getSelectedItem().toString().trim();
          for (int i = 0; i < t1.length(); i++) {
            char ch = t1.charAt(i);
            if (((ch > 'z') || (ch < 'a')) && ((ch > 'Z') || (ch < 'A')) && ((ch < '0') || (ch > '9')))
            {
              JOptionPane.showMessageDialog(null, "数据类型仅能输入数字、字母及下划线,内容已重置", "警告", 2);
              window.this.type1.setSelectedIndex(0);
              return;
            }
          }
        }
      }
    });
    this.type1.setToolTipText("选择数据类型，可使用常规类型或自定义类型");
    this.type1.setEditable(true);
    this.type1.setModel(new DefaultComboBoxModel(
      new String[] { "String", "int" }));
    this.type1.setBounds(267, 67, 145, 21);
    getContentPane().add(this.type1);

    final JButton add1 = new JButton("添加属性");
    add1.setToolTipText("添加一行新的输入栏");
    add1.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent e) {
        BeanData bean = new BeanData();
        if (window.this.proTime >= 9) {
          JOptionPane.showMessageDialog(null, "目前仅支持添加9个属性，添加更多属性请使用Excel导入功能", "警告", 2);
          add1.setVisible(false);
          return;
        }
        if (window.this.proTime == 1) {
          if ((window.this.pro1.getText() == null) || 
            ("".equals(window.this.pro1.getText().trim())) || 
            (window.this.note1.getText() == null) || 
            ("".equals(window.this.note1.getText().trim())))
            JOptionPane.showMessageDialog(null, "请先填写当前行属性及注释后再添加新属性", "警告", 2);
        }
        else
        {
          if ((window.this.pro2.getText() == null) || 
            ("".equals(window.this.pro2.getText().trim())) || 
            (window.this.note2.getText() == null) || 
            ("".equals(window.this.note2.getText().trim()))) {
            JOptionPane.showMessageDialog(null, "请先填写当前行属性及注释后再添加新属性", "警告", 2);
            return;
          }
          boolean flag = true;
          for (BeanData beanData : window.this.list) {
            if (beanData.getPName().equals(window.this.pro2.getText().trim())) {
              flag = false;
              break;
            }
          }
          if (flag) {
            bean.setPName(window.this.pro2.getText().trim());
            bean.setPType(window.this.type2.getSelectedItem().toString().trim());
            bean.setRemark(window.this.note2.getText().trim());
            window.this.list.add(bean);
          }
        }
        window.this.createElement();
        window.this.proTime += 1;
        add1.setBounds(add1.getBounds().x, add1.getBounds().y + 22, add1.getBounds().width, add1.getBounds().height);
      }
    });
    add1.setBounds(644, 66, 103, 23);
    getContentPane().add(add1);

    JButton btnNewButton = new JButton("生成代码");
    btnNewButton.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent e) {
        if ((window.this.proTime == 1) && (
          (window.this.pro1.getText() == null) || 
          ("".equals(window.this.pro1.getText().trim())) || 
          (window.this.note1.getText() == null) || 
          ("".equals(window.this.note1.getText().trim())))) {
          JOptionPane.showMessageDialog(null, "请至少添加一行完整的属性", "警告", 2);
          return;
        }

        window.this.clickTime += 1;
        BeanData bean = new BeanData();
        if (window.this.clickTime == 1) {
          bean.setPName(window.this.pro1.getText().trim());
          bean.setPType(window.this.type1.getSelectedItem().toString().trim());
          bean.setRemark(window.this.note1.getText().trim());
          window.this.list.add(bean);
        }
        if ((window.this.proTime > window.this.list.size()) && 
          (window.this.pro2.getText() != null) && (!"".equals(window.this.pro2.getText().trim()))) {
          bean = new BeanData();
          bean.setPName(window.this.pro2.getText().trim());
          bean.setPType(window.this.type2.getSelectedItem().toString().trim());
          bean.setRemark(window.this.note2.getText().trim());
          window.this.list.add(bean);
        }

        textArea.setText(null);

        String result = CreateBean.createBean(window.this.list, 1, null);
        textArea.setText(result);

        window.this.button.setEnabled(true);
        window.this.btnexcel_1.setEnabled(true);
        window.this.btnjavabean.setEnabled(true);
      }
    });
    btnNewButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
      }
    });
    btnNewButton.setBounds(10, 268, 93, 23);
    getContentPane().add(btnNewButton);

    this.button = new JButton("复制代码");
    this.button.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent e) {
        StringSelection editText = new StringSelection(textArea.getText());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(editText, null);
        JOptionPane.showMessageDialog(null, "代码已添加到剪切板", "提示", 1);
      }
    });
    this.button.setEnabled(false);
    this.button.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
      }
    });
    this.button.setBounds(113, 268, 93, 23);
    getContentPane().add(this.button);

    this.btnexcel_1 = new JButton("导出Excel");
    this.btnexcel_1.setEnabled(false);
    this.btnexcel_1.setBounds(691, 268, 93, 23);
    getContentPane().add(this.btnexcel_1);

    this.btnjavabean = new JButton("生成JavaBean");
    this.btnjavabean.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent e) {
        Map<String, String> fileMap = new HashMap<String, String>();

        if ((window.this.textField.getText() != null) && 
          (!"".equals(window.this.textField.getText().trim())) && 
          (window.this.textField_1.getText() != null) && 
          (!"".equals(window.this.textField_1.getText().trim()))) {
          fileMap.put("packName", window.this.textField_1.getText().trim());
          fileMap.put("fileName", window.this.textField.getText().trim());
        } else {
          JOptionPane.showMessageDialog(null, "请先填写类名和包名", "提示", 0);
          return;
        }
        String result = CreateBean.createBean(window.this.list, 2, fileMap);
        try {
          OutputBean.createFile(result, (String)fileMap.get("fileName"), "java");
        } catch (IOException e1) {
          JOptionPane.showMessageDialog(null, "创建.java文件失败：" + e1.getMessage(), "异常", 0);
        }
      }
    });
    this.btnjavabean.setEnabled(false);
    this.btnjavabean.setBounds(555, 268, 126, 23);
    getContentPane().add(this.btnjavabean);

    JLabel label_2 = new JLabel("属性名");
    label_2.setFont(new Font("微软雅黑", 0, 13));
    label_2.setBounds(47, 45, 53, 24);
    getContentPane().add(label_2);

    JLabel label_3 = new JLabel("数据类型");
    label_3.setFont(new Font("微软雅黑", 0, 13));
    label_3.setBounds(267, 45, 68, 24);
    getContentPane().add(label_3);

    JLabel label_4 = new JLabel("注释");
    label_4.setFont(new Font("微软雅黑", 0, 13));
    label_4.setBounds(422, 45, 32, 24);
    getContentPane().add(label_4);

    JButton button_1 = new JButton("清空");
    button_1.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent e)
      {
      }
    });
    button_1.setToolTipText("重置面板");
    button_1.setEnabled(false);
    button_1.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
      }
    });
    button_1.setBounds(681, 12, 103, 23);
    getContentPane().add(button_1);
  }

  private void createElement()
  {
    this.pro2 = new JTextField(" ");
    this.pro2.addFocusListener(new FocusAdapter()
    {
      public void focusLost(FocusEvent e) {
        window.this.pro2.setText(window.this.pro2.getText().trim());
        String p2 = window.this.pro2.getText().trim();
        for (int i = 0; i < p2.length(); i++) {
          char ch = p2.charAt(i);
          if (((ch > 'z') || (ch < 'a')) && ((ch > 'Z') || (ch < 'A')) && ((ch < '0') || (ch > '9')))
          {
            JOptionPane.showMessageDialog(null, "属性名仅能输入数字、字母及下划线,内容已重置", "警告", 2);
            window.this.pro2.setText(null);
            return;
          }
        }
      }
    });
    this.pro2.setBounds(this.pro1.getBounds().x, this.pro1.getBounds().y + 22 * this.proTime, 
      this.pro1.getBounds().width, this.pro1.getBounds().height);
    this.pro2.setColumns(10);
    getContentPane().add(this.pro2);

    this.type2 = new JComboBox();
    this.type2.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == 1) {
          String t2 = window.this.type2.getSelectedItem().toString().trim();
          for (int i = 0; i < t2.length(); i++) {
            char ch = t2.charAt(i);
            if (((ch > 'z') || (ch < 'a')) && ((ch > 'Z') || (ch < 'A')) && ((ch < '0') || (ch > '9')))
            {
              JOptionPane.showMessageDialog(null, "数据类型仅能输入数字、字母及下划线,内容已重置", "警告", 2);
              window.this.type2.setSelectedIndex(0);
              return;
            }
          }
        }
      }
    });
    this.type2.setEditable(true);
    this.type2.setEnabled(true);
    this.type2.setModel(new DefaultComboBoxModel(
      new String[] { "String", "int" }));
    this.type2.setBounds(this.type1.getBounds().x, this.type1.getBounds().y + 22 * this.proTime, 
      this.type1.getBounds().width, this.type1.getBounds().height);
    getContentPane().add(this.type2);
    getContentPane().validate();

    this.note2 = new JTextField(" ");
    this.note2.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent e) {
        window.this.note2.setText(window.this.note2.getText().trim());
      }
    });
    this.note2.setBounds(this.note1.getBounds().x, this.note1.getBounds().y + 22 * this.proTime, 
      this.note1.getBounds().width, this.note1.getBounds().height);
    this.note2.setColumns(10);
    getContentPane().add(this.note2);
  }
}