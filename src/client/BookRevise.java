package client;

import action.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class BookRevise {
	public BookRevise(Connection conn) {
		JFrame jf = new JFrame("修改图书 ");
		jf.setSize(300, 270);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    JPanel panel = new JPanel();
	    panel.setLayout(null);
	    
	    // 请输入要修改的图书id
	    JLabel BookIdLable = new JLabel("请输入要修改的图书ID:");
	    BookIdLable.setBounds(80,10,200,25);
	    panel.add(BookIdLable);
	    
		// 图书Id输入框
	    JTextField BookIdInput = new JTextField(8);
	    BookIdInput.setBounds(70,40,150,25);
	    panel.add(BookIdInput);
	    
	    // 修改书号按键
	    JButton btn_0 = new JButton("修改书号");
	    btn_0.setBounds(10,80,120,25);
	    btn_0.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {
	        	  SqlSearchBook2 Book = new SqlSearchBook2();
	        	  Book book = new Book();
	        	  try {
	        		  book = Book.select(conn, BookIdInput.getText());
	        	  }catch(SQLException n) {
	        		  System.out.println("没有该图书的信息");
	        	  }
	        	  
	        	  if(book.getBookId() != null) {
	        		  new BookRevise2(conn, book, 0);
		        	  jf.dispose();
	        	  }else {
	        		  new BookRevise2(conn);
		        	  jf.dispose();
	        	  }
	         }
	    });
	    panel.add(btn_0);
	    
	    // 修改书名
	    JButton btn_1 = new JButton("修改书名");
	    btn_1.setBounds(150,80,120,25);
	    btn_1.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {
	        	  SqlSearchBook2 Book = new SqlSearchBook2();
	        	  Book book = new Book();
	        	  try {
	        		  book = Book.select(conn, BookIdInput.getText());
	        	  }catch(SQLException n) {
	        		  System.out.println("没有该图书的信息");
	        	  }
	        	  
	        	  if(book.getBookId() != null) {
	        		  new BookRevise2(conn, book, 1);
		        	  jf.dispose();
	        	  }else {
	        		  new BookRevise2(conn);
		        	  jf.dispose();
	        	  }
	         }
	    });
	    panel.add(btn_1);
	    
	    // 修改作者
	    JButton btn_2 = new JButton("修改作者");
	    btn_2.setBounds(10,110,120,25);
	    btn_2.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {
	        	  SqlSearchBook2 Book = new SqlSearchBook2();
	        	  Book book = new Book();
	        	  try {
	        		  book = Book.select(conn, BookIdInput.getText());
	        	  }catch(SQLException n) {
	        		  System.out.println("没有该图书的信息");
	        	  }
	        	  
	        	  if(book.getBookId() != null) {
	        		  new BookRevise2(conn, book, 2);
		        	  jf.dispose();
	        	  }else {
	        		  new BookRevise2(conn);
		        	  jf.dispose();
	        	  }
	         }
	    });
	    panel.add(btn_2);
	    
	    // 修改出版社
	    JButton btn_3 = new JButton("修改出版社");
	    btn_3.setBounds(150,110,120,25);
	    btn_3.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {
	        	  SqlSearchBook2 Book = new SqlSearchBook2();
	        	  Book book = new Book();
	        	  try {
	        		  book = Book.select(conn, BookIdInput.getText());
	        	  }catch(SQLException n) {
	        		  System.out.println("没有该图书的信息");
	        	  }
	        	  
	        	  if(book.getBookId() != null) {
	        		  new BookRevise2(conn, book, 3);
		        	  jf.dispose();
	        	  }else {
	        		  new BookRevise2(conn);
		        	  jf.dispose();
	        	  }
	         }
	    });
	    panel.add(btn_3);
	    
	    // 修改出版年份
	    JButton btn_4 = new JButton("修改作者");
	    btn_4.setBounds(10,140,120,25);
	    btn_4.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {
	        	  SqlSearchBook2 Book = new SqlSearchBook2();
	        	  Book book = new Book();
	        	  try {
	        		  book = Book.select(conn, BookIdInput.getText());
	        	  }catch(SQLException n) {
	        		  System.out.println("没有该图书的信息");
	        	  }
	        	  
	        	  if(book.getBookId() != null) {
	        		  new BookRevise2(conn, book, 4);
		        	  jf.dispose();
	        	  }else {
	        		  new BookRevise2(conn);
		        	  jf.dispose();
	        	  }
	         }
	    });
	    panel.add(btn_4);
	    
	    // 修改馆藏总量
	    JButton btn_5 = new JButton("修改馆藏总量");
	    btn_5.setBounds(150,140,120,25);
	    btn_5.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {
	        	  SqlSearchBook2 Book = new SqlSearchBook2();
	        	  Book book = new Book();
	        	  try {
	        		  book = Book.select(conn, BookIdInput.getText());
	        	  }catch(SQLException n) {
	        		  System.out.println("没有该图书的信息");
	        	  }
	        	  
	        	  if(book.getBookId() != null) {
	        		  new BookRevise2(conn, book, 5);
		        	  jf.dispose();
	        	  }else {
	        		  new BookRevise2(conn);
		        	  jf.dispose();
	        	  }
	         }
	    });
	    panel.add(btn_5);
	    
	    // 返回按键
	    JButton btn_6 = new JButton("返回");
	    btn_6.setBounds(90,190,100,25);
	    btn_6.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent e) {
	        	 new JumpTableManage(conn);
	             jf.dispose();
	         }
	    });
	    panel.add(btn_6);
	    
	    jf.setContentPane(panel);
	    jf.setVisible(true);
	}
	

}
