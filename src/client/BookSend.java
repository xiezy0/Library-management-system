package client;

import action.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class BookSend {
	public BookSend(Connection conn) {
		JFrame jf = new JFrame("归还图书");
		jf.setSize(300, 200);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	    JPanel panel = new JPanel();
	    panel.setLayout(null);
	      
	    // 请输入图书ID:
	    JLabel BookLable = new JLabel("请输入图书ID:");
	    BookLable.setBounds(10,20,80,25);
	    panel.add(BookLable);
	      
	    // 图书ID输入框
	    JTextField BookLableInput = new JTextField(8);
	    BookLableInput.setBounds(100,20,150,25);
	    panel.add(BookLableInput);
	    
	    // 请输入用户ID:
	    JLabel UsrLable = new JLabel("请输入用户ID:");
	    UsrLable.setBounds(10,50,80,25);
	    panel.add(UsrLable);
	      
	    // 用户ID输入框
	    JTextField UsrLableInput = new JTextField(8);
	    UsrLableInput.setBounds(100,50,150,25);
	    panel.add(UsrLableInput);
	      
	    // 确认信息并借阅按键
	    JButton btn_1 = new JButton("确认信息并归还");
	    btn_1.setBounds(75,90,150,25);
	    btn_1.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {       
	        	  String sendResult = null;
	        	  String UsrId = UsrLableInput.getText();
	        	  String BookId = BookLableInput.getText();
	        	  SqlSend send = new SqlSend();
	        	  try {
	        		  sendResult = send.send(conn, UsrId, BookId);
	        	  }catch(SQLException n) {
	        		  System.out.println("归还失败");
	        	  }
	        	  if(sendResult != null) {
	        		  new BookSendResult(conn, sendResult);
	        		  jf.dispose();
	        	  }else {
	        		  new BookSendResult(conn);
	        		  jf.dispose();
	        	  }
	        	  
	          }
	    });
	    panel.add(btn_1);
	    
	    // 返回按键
	    JButton btn_2 = new JButton("返回");
	    btn_2.setBounds(110,120,80,25);
	    btn_2.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {
	        	  new JumpTableBorrow(conn);
	        	  jf.dispose();
	            		            	
	          }
	    });
	    panel.add(btn_2);
	      
	    jf.setContentPane(panel);
	    jf.setVisible(true);
	}

}
