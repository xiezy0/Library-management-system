package client;

import action.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class BookRevise2 {
	public BookRevise2(Connection conn) {
    	JFrame jf = new JFrame("没有此图书的相关信息");
        jf.setSize(300, 200);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        // 归还失败
        JLabel AdminLable = new JLabel("没有此图书信息，请重新输入");
        AdminLable.setBounds(10, 20, 180, 25);
        panel.add(AdminLable);

        // 返回
        JButton btn = new JButton("返回");
        btn.setBounds(100, 110, 100, 25);
        btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new BookRevise(conn);
                    jf.dispose();
                }
            });
        panel.add(btn);

        jf.setContentPane(panel);
        jf.setVisible(true);
	}
	
	public BookRevise2(Connection conn, Book book, int number) {
		JFrame jf = new JFrame("开始修改");
        jf.setSize(300, 200);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        switch(number) {
        	case 0: BookRevise2_BookId(conn, book, panel, jf);break;
        	case 1: BookRevise2_BookName(conn, book, panel, jf);break;
        	case 2: BookRevise2_BookWriter(conn, book, panel, jf);break;
        	case 3: BookRevise2_BookPublisher(conn, book, panel, jf);break;
        	case 4: BookRevise2_BookPublishYear(conn, book, panel, jf);break;
        	case 5: BookRevise2_BookTotal(conn, book, panel, jf);break;
        }
        
        // 返回按键
	    JButton btn_2 = new JButton("返回");
	    btn_2.setBounds(110,120,80,25);
	    btn_2.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {
	        	  new BookRevise(conn);
	        	  jf.dispose();
	          }
	    });
	    panel.add(btn_2);

        jf.setContentPane(panel);
        jf.setVisible(true);
	}
	
	public void BookRevise2_BookId(Connection conn, Book book, JPanel panel, JFrame jf){
		// 图书原始书号
	    JLabel BookLable = new JLabel("图书原始书号:");
	    BookLable.setBounds(10,20,120,25);
	    panel.add(BookLable);
	      
	    // 图书原始书号值
	    JLabel BookIdLable = new JLabel(book.getBookId());
	    BookIdLable.setBounds(110,20,180,25);
	    panel.add(BookIdLable);
	    
	    // 要修改的书号:
	    JLabel UsrLable = new JLabel("输入修改后的书号:");
	    UsrLable.setBounds(10,50,120,25);
	    panel.add(UsrLable);
	      
	    // BookID输入框
	    JTextField UsrLableInput = new JTextField(8);
	    UsrLableInput.setBounds(130,50,120,25);
	    panel.add(UsrLableInput);
	      
	    // 确认信息并修改按键
	    JButton btn_1 = new JButton("确认信息并修改");
	    btn_1.setBounds(75,90,150,25);
	    btn_1.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) { 
	        	  SqlBookRevise revise = new SqlBookRevise();
	        	  String result = null;
	        	  try {
	        		  result = revise.revise(conn, UsrLableInput.getText(), book, 0);
	        	  }catch(SQLException n) {
	        		  System.out.println("修改失败");
	        	  }
	        	  if(result != null) {
	        		  new BookReviseResult(conn,result);
	        		  jf.dispose();
	        	  }else {
	        		  new BookReviseResult(conn);
	        		  jf.dispose();
	        	  }
	          }
	    });
	    panel.add(btn_1);
	}
	
    public void BookRevise2_BookName(Connection conn, Book book, JPanel panel, JFrame jf){
    	// 图书原始书名
	    JLabel BookLable = new JLabel("图书原始书名:");
	    BookLable.setBounds(10,20,120,25);
	    panel.add(BookLable);
	      
	    // 图书原始书名内容
	    JLabel BookIdLable = new JLabel(book.getBookName());
	    BookIdLable.setBounds(110,20,180,25);
	    panel.add(BookIdLable);
	    
	    // 要修改的书名:
	    JLabel UsrLable = new JLabel("输入修改后的书名:");
	    UsrLable.setBounds(10,50,120,25);
	    panel.add(UsrLable);
	      
	    // BookName输入框
	    JTextField UsrLableInput = new JTextField(8);
	    UsrLableInput.setBounds(130,50,120,25);
	    panel.add(UsrLableInput);
	      
	    // 确认信息并修改按键
	    JButton btn_1 = new JButton("确认信息并修改");
	    btn_1.setBounds(75,90,150,25);
	    btn_1.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {       
	        	  SqlBookRevise revise = new SqlBookRevise();
	        	  String result = null;
	        	  try {
	        		  result = revise.revise(conn, UsrLableInput.getText(), book, 1);
	        	  }catch(SQLException n) {
	        		  System.out.println("修改失败");
	        	  }
	        	  if(result != null) {
	        		  new BookReviseResult(conn,result);
	        		  jf.dispose();
	        	  }else {
	        		  new BookReviseResult(conn);
	        		  jf.dispose();
	        	  }
	          }
	    });
	    panel.add(btn_1);
	}
    
    public void BookRevise2_BookWriter(Connection conn, Book book, JPanel panel, JFrame jf){
    	// 图书原始作者
	    JLabel BookLable = new JLabel("图书原始作者:");
	    BookLable.setBounds(10,20,120,25);
	    panel.add(BookLable);
	      
	    // 图书原始作者内容：
	    JLabel BookIdLable = new JLabel(book.getBookWriter());
	    BookIdLable.setBounds(110,20,180,25);
	    panel.add(BookIdLable);
	    
	    // 要修改的作者:
	    JLabel UsrLable = new JLabel("输入修改后的作者:");
	    UsrLable.setBounds(10,50,120,25);
	    panel.add(UsrLable);
	      
	    // BookWriter输入框
	    JTextField UsrLableInput = new JTextField(8);
	    UsrLableInput.setBounds(130,50,120,25);
	    panel.add(UsrLableInput);
	      
	    // 确认信息并修改按键
	    JButton btn_1 = new JButton("确认信息并修改");
	    btn_1.setBounds(75,90,150,25);
	    btn_1.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {       
	        	  SqlBookRevise revise = new SqlBookRevise();
	        	  String result = null;
	        	  try {
	        		  result = revise.revise(conn, UsrLableInput.getText(), book, 2);
	        	  }catch(SQLException n) {
	        		  System.out.println("修改失败");
	        	  }
	        	  if(result != null) {
	        		  new BookReviseResult(conn,result);
	        		  jf.dispose();
	        	  }else {
	        		  new BookReviseResult(conn);
	        		  jf.dispose();
	        	  }
	          }
	    });
	    panel.add(btn_1);
	}
    
    public void BookRevise2_BookPublisher(Connection conn, Book book, JPanel panel, JFrame jf){
    	// 图书原始出版社
	    JLabel BookLable = new JLabel("图书原始出版社:");
	    BookLable.setBounds(10,20,120,25);
	    panel.add(BookLable);
	      
	    // 图书原始出版社内容：
	    JLabel BookIdLable = new JLabel(book.getBookPublisher());
	    BookIdLable.setBounds(120,20,180,25);
	    panel.add(BookIdLable);
	    
	    // 要修改的出版社:
	    JLabel UsrLable = new JLabel("输入修改后的出版社:");
	    UsrLable.setBounds(10,50,120,25);
	    panel.add(UsrLable);
	      
	    // BookPublisher输入框
	    JTextField UsrLableInput = new JTextField(8);
	    UsrLableInput.setBounds(140,50,120,25);
	    panel.add(UsrLableInput);
	      
	    // 确认信息并修改按键
	    JButton btn_1 = new JButton("确认信息并修改");
	    btn_1.setBounds(75,90,150,25);
	    btn_1.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {       
	        	  SqlBookRevise revise = new SqlBookRevise();
	        	  String result = null;
	        	  try {
	        		  result = revise.revise(conn, UsrLableInput.getText(), book, 3);
	        	  }catch(SQLException n) {
	        		  System.out.println("修改失败");
	        	  }
	        	  if(result != null) {
	        		  new BookReviseResult(conn,result);
	        		  jf.dispose();
	        	  }else {
	        		  new BookReviseResult(conn);
	        		  jf.dispose();
	        	  }
	          }
	    });
	    panel.add(btn_1);
	}
    
    public void BookRevise2_BookPublishYear(Connection conn, Book book, JPanel panel, JFrame jf){
    	// 图书原始出版年份
	    JLabel BookLable = new JLabel("图书原始出版年份:");
	    BookLable.setBounds(10,20,150,25);
	    panel.add(BookLable);
	      
	    // 图书原始出版年份内容：
	    JLabel BookIdLable = new JLabel(book.getBookPublishYear());
	    BookIdLable.setBounds(130,20,120,25);
	    panel.add(BookIdLable);
	    
	    // 要修改的出版年份:
	    JLabel UsrLable = new JLabel("输入修改后的出版年份:");
	    UsrLable.setBounds(10,50,150,25);
	    panel.add(UsrLable);
	      
	    // BookPublishYear输入框
	    JTextField UsrLableInput = new JTextField(8);
	    UsrLableInput.setBounds(150,50,120,25);
	    panel.add(UsrLableInput);
	      
	    // 确认信息并修改按键
	    JButton btn_1 = new JButton("确认信息并修改");
	    btn_1.setBounds(75,90,150,25);
	    btn_1.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {       
	        	  SqlBookRevise revise = new SqlBookRevise();
	        	  String result = null;
	        	  try {
	        		  result = revise.revise(conn, UsrLableInput.getText(), book, 4);
	        	  }catch(SQLException n) {
	        		  System.out.println("修改失败");
	        	  }
	        	  if(result != null) {
	        		  new BookReviseResult(conn,result);
	        		  jf.dispose();
	        	  }else {
	        		  new BookReviseResult(conn);
	        		  jf.dispose();
	        	  }
	          }
	    });
	    panel.add(btn_1);
	}
    
    public void BookRevise2_BookTotal(Connection conn, Book book, JPanel panel, JFrame jf){
    	// 图书原始馆藏总量
	    JLabel BookLable = new JLabel("图书原始馆藏总量:");
	    BookLable.setBounds(10,20,120,25);
	    panel.add(BookLable);
	      
	    // 图书原始馆藏总量内容：
	    String s4 =Integer.toString(book.getBookTotal());
	    JLabel BookIdLable = new JLabel(s4);
	    BookIdLable.setBounds(130,20,120,25);
	    panel.add(BookIdLable);
	    
	    // 要修改的馆藏:
	    JLabel UsrLable = new JLabel("输入修改后的馆藏总量:");
	    UsrLable.setBounds(10,50,150,25);
	    panel.add(UsrLable);
	      
	    // BookPublishYear输入框
	    JTextField UsrLableInput = new JTextField(8);
	    UsrLableInput.setBounds(150,50,120,25);
	    panel.add(UsrLableInput);
	      
	    // 确认信息并修改按键
	    JButton btn_1 = new JButton("确认信息并修改");
	    btn_1.setBounds(75,90,150,25);
	    btn_1.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {  
	        	  SqlBookRevise revise = new SqlBookRevise();
	        	  String result = null;
	        	  try {
	        		  result = revise.revise(conn, UsrLableInput.getText(), book, 5);
	        	  }catch(SQLException n) {
	        		  System.out.println("修改失败");
	        	  }
	        	  if(result != null) {
	        		  new BookReviseResult(conn,result);
	        		  jf.dispose();
	        	  }else {
	        		  new BookReviseResult(conn);
	        		  jf.dispose();
	        	  }
	          }
	    });
	    panel.add(btn_1);
	}
    
//    public static void main(String[] args){
//		  // 初始化连接对象，当做context
//		  Connection conn = null;
//		  SqlConnect sqlconnect = new SqlConnect();
//		  conn = sqlconnect.connect();
//		  
//		  SqlSearchBook2 Book = new SqlSearchBook2();
//    	  Book book = new Book();
//    	  try {
//    		  book = Book.select(conn, "101-3-2-4");
//    	  }catch(SQLException n) {
//    		  System.out.println("没有该图书的信息");
//    	  }
//    	  
//    	  new BookRevise2(conn, book, 5);
//	}

}
