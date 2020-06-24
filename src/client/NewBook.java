package client;

import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

import action.*;

public class NewBook {
	public NewBook(Connection conn) {
		JFrame jf = new JFrame("违规记录填写");
		jf.setSize(350, 315);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	    JPanel panel = new JPanel();
	    panel.setLayout(null);
	    
	    // 请输入图书ID:
	    JLabel BookIdLable = new JLabel("输入图书ID:");
	    BookIdLable.setBounds(10,20,150,25);
	    panel.add(BookIdLable);
	    JTextField BookIdInput = new JTextField(8);
	    BookIdInput.setBounds(130,20,200,25);
	    panel.add(BookIdInput);
	    
	    // 请输入图书名:
	    JLabel BookNameLable = new JLabel("输入图书名:");
	    BookNameLable.setBounds(10,50,150,25);
	    panel.add(BookNameLable);
	    JTextField BookNameInput = new JTextField(8);
	    BookNameInput.setBounds(130,50,200,25);
	    panel.add(BookNameInput);
	    
	    // 请输入作者姓名:
	    JLabel BookWriterLable = new JLabel("输入作者姓名:");
	    BookWriterLable.setBounds(10,80,150,25);
	    panel.add(BookWriterLable);
	    JTextField BookWriterInput = new JTextField(8);
	    BookWriterInput.setBounds(130,80,200,25);
	    panel.add(BookWriterInput);
	    
	    // 请输入图书出版社:
	    JLabel BookPublisherLable = new JLabel("输入图书出版社:");
	    BookPublisherLable.setBounds(10,110,150,25);
	    panel.add(BookPublisherLable);
	    JTextField BookPublisherInput = new JTextField(8);
	    BookPublisherInput.setBounds(130,110,200,25);
	    panel.add(BookPublisherInput);
	    
	    // 请输入图书出版年份:
	    JLabel BookPublishYearLable = new JLabel("输入出版年份:");
	    BookPublishYearLable.setBounds(10,140,150,25);
	    panel.add(BookPublishYearLable);
	    JTextField BookPublishYearInput = new JTextField(8);
	    BookPublishYearInput.setBounds(130,140,200,25);
	    panel.add(BookPublishYearInput);
	    
	    // 请输入馆藏总量:
	    JLabel BookTotalLable = new JLabel("输入图书数量:");
	    BookTotalLable.setBounds(10,170,150,25);
	    panel.add(BookTotalLable);
	    JTextField BookTotalInput = new JTextField(8);
	    BookTotalInput.setBounds(130,170,200,25);
	    panel.add(BookTotalInput);
	    
	    // 确认信息提交
	    JButton btn_1 = new JButton("确认信息并提交");
	    btn_1.setBounds(90,210,150,25);
	    btn_1.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {       
	        	  SqlNewBook newBook = new SqlNewBook();
	        	  boolean newBookResult = false;
	        	  try {
	        		  newBookResult = newBook.newBook(conn, BookIdInput.getText(), BookNameInput.getText(),BookWriterInput.getText(),BookPublisherInput.getText(),BookPublishYearInput.getText(),Integer.parseInt(BookTotalInput.getText()));
	        	  }catch(SQLException n) {
	        		  System.out.println("添加新图书失败");
	        	  }
	        	  if(newBookResult == true) {
	        		  new NewBookResult(conn, BookIdInput.getText(), BookNameInput.getText());
	        		  jf.dispose();
	        	  }else {
	        		  new NewBookResult(conn);
	        		  jf.dispose();
	        	  }
	          }
	    });
	    panel.add(btn_1);
	   
	    // 返回按键
	    JButton btn_2 = new JButton("返回");
	    btn_2.setBounds(125,240,80,25);
	    btn_2.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {
	        	  new JumpTableManage(conn);
	        	  jf.dispose();
	            		            	
	          }
	    });
	    panel.add(btn_2);
	    
	    
	    
	    jf.setContentPane(panel);
	    jf.setVisible(true);
	}

}
