package client;

import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import action.*;

public class SearchBook {
	public SearchBook(Connection conn) {
		JFrame jf = new JFrame("查询图书 ");
		jf.setSize(300, 200);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    JPanel panel = new JPanel();
	    panel.setLayout(null);
	    
	    // 请输入图书id或者书名
	    JLabel SearchBookLable = new JLabel("请输入图书ID或者书名:");
	    SearchBookLable.setBounds(80,10,200,25);
	    panel.add(SearchBookLable);
	    
	    // 请输入图书id或者书名
	    JLabel SearchBookLable2 = new JLabel("（输入星号*以检索全部）");
	    SearchBookLable2.setBounds(80,30,200,25);
	    panel.add(SearchBookLable2);
	    
		// 图书信息输入框
	    JTextField SearchBookInput = new JTextField(8);
	    SearchBookInput.setBounds(70,60,150,25);
	    panel.add(SearchBookInput);
	    
	    // 确认信息并删除按键
	    JButton btn_1 = new JButton("确认信息并查询");
	    btn_1.setBounds(70,100,150,25);
	    btn_1.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {
	        	  String BookId = SearchBookInput.getText();
	        	  List<Book> books = new ArrayList<Book>();
	        	  SqlSearchBook book = new SqlSearchBook(); 
	        	  try {
	        		  books = book.select(conn, BookId);
	              }catch(SQLException n){
	            	  System.out.println("查询失败");
	              }
	        	  if(books.size() == 0) {
	        		  new SearchBookResult(conn);
	        		  jf.dispose();
        		  }else {
        			  new SearchBookResult(conn, books);
        			  jf.dispose();
        		  }
	         }
	    });
	    panel.add(btn_1);
	    
	    // 返回按键
	    JButton btn_2 = new JButton("返回");
	    btn_2.setBounds(100,130,100,25);
	    btn_2.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {
	            	new JumpTableSearch(conn);
	            	jf.dispose();
	         }
	    });
	    panel.add(btn_2);
	    
	    jf.setContentPane(panel);
	    jf.setVisible(true);
	}

}
