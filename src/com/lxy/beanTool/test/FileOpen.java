package com.lxy.beanTool.test;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileOpen extends JFrame
  implements ActionListener
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
JFileChooser chooser;
  FileFilter filter;

  public static void main(String[] arg)
  {
    new FileOpen();
  }

  public FileOpen() {
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    setLocation(250, 150);
    Container pane = getContentPane();
    pane.setLayout(new FlowLayout());
    JButton button = new JButton("Open");
    button.addActionListener(this);
    pane.add(button);
    button = new JButton("Save");
    button.addActionListener(this);
    pane.add(button);
    pack();
    this.chooser = new JFileChooser();
    this.chooser.setFileSelectionMode(2);
    String[] extt = { "xls" };
    this.filter = new FileNameExtensionFilter("excel", extt);
    this.chooser.setFileFilter(this.filter);

    setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    String selection = e.getActionCommand();
    if (selection.equals("Open")) {
      int retval = this.chooser.showOpenDialog(this);
      if (retval == 0) {
        File file = this.chooser.getSelectedFile();
        System.out.println("File to open " + file);
      }
    } else if (selection.equals("Save")) {
      File file = new File("mongrove.tiff");
      this.chooser.setSelectedFile(file);
      int retval = this.chooser.showSaveDialog(this);
      if (retval == 0) {
        file = this.chooser.getSelectedFile();
        System.out.println("File to save " + file);
      }
    }
  }
}
