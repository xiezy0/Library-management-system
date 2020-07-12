package client;

import java.sql.*;
import action.*;
import java.awt.event.*;
import javax.swing.*;

public class usrRegister {

	public usrRegister(Connection conn) {
		JFrame jf = new JFrame("用户注册");
		jf.setSize(300, 250);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	    JPanel panel = new JPanel();
	    panel.setLayout(null);
	      
	    // 请输入用户名:
	    JLabel usrName = new JLabel("请输入用户名:");
	    usrName.setBounds(10,20,100,25);
	    panel.add(usrName);
	      
	    // 用户名输入框
	    JTextField usrNameInput = new JTextField(8);
	    usrNameInput.setBounds(120,20,150,25);
	    panel.add(usrNameInput);
	    
	    // 请输入用户密码:
	    JLabel usrKeyWords = new JLabel("请输入用户密码:");
	    usrKeyWords.setBounds(10,50,100,25);
	    panel.add(usrKeyWords);
	      
	    // 用户密码输入框：
	    JPasswordField usrKeyWordsInput = new JPasswordField(8);
	    usrKeyWordsInput.setBounds(120,50,150,25);
	    panel.add(usrKeyWordsInput);
	    
	    // 再次输入用户密码:
	    JLabel usrKeyWords2 = new JLabel("请再次输入密码:");
	    usrKeyWords2.setBounds(10,80,100,25);
	    panel.add(usrKeyWords2);
	      
	    // 再次输入用户密码输入框：
	    JPasswordField usrKeyWords2Input = new JPasswordField(8);
	    usrKeyWords2Input.setBounds(120,80,150,25);
	    panel.add(usrKeyWords2Input);
	      
	    // 确认信息并借阅按键
	    JButton btn_1 = new JButton("确认信息并注册");
	    btn_1.setBounds(75,130,150,25);
	    btn_1.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {  
	        	  String usrName = usrNameInput.getText();
	        	  String usrKeywords = new String(usrKeyWordsInput.getPassword());
	        	  String usrKeywords2 = new String(usrKeyWords2Input.getPassword());
	        	  sqlRegister register = new sqlRegister();
	        	  String result = null;
	        	  
	        	  if(usrKeywords.compareTo(usrKeywords2) != 0) {
	        		  new registerResult(conn);
	        		  jf.dispose();
	        	  }else {
	        		  try {
		        		  result = register.register(conn, usrName, usrKeywords);
		        	  }catch(SQLException n) {
		        		  System.out.println("注册失败");
		        	  }
		        	  if(result != null) {
		        		  new registerResult(conn, result);
		        		  jf.dispose();
		        	  }else {
		        		  new registerResult(conn);
		        		  jf.dispose();
		        	  }
	        	  }
	          }
	    });
	    panel.add(btn_1);
	    
	    // 返回按键
	    JButton btn_2 = new JButton("返回");
	    btn_2.setBounds(110,160,80,25);
	    btn_2.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {
	        	  new run(conn);
	        	  jf.dispose();
	          }
	    });
	    panel.add(btn_2);
	      
	    jf.setContentPane(panel);
	    jf.setVisible(true);
		
	}

}
