package client;

import java.sql.*;
import action.*;
import java.awt.event.*;
import javax.swing.*;

public class usrSign {

	public usrSign(Connection conn) {
		JFrame jf = new JFrame("登录");
		  jf.setSize(300, 200);
		  jf.setLocationRelativeTo(null);
		  jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	      JPanel panel = new JPanel();
	      panel.setLayout(null);
	      
	      // 管理员用户名
	      JLabel usrLable = new JLabel("用户名:");
	      usrLable.setBounds(10,20,80,25);
	      panel.add(usrLable);
	      
	      // 管理员用户名输入框
	      JTextField usrLableInput = new JTextField(8);
	      usrLableInput.setBounds(80,20,150,25);
	      panel.add(usrLableInput);
	      
	      // 管理员密码
	      JLabel usrKey = new JLabel("密码:");
	      usrKey.setBounds(10,50,80,25);
	      panel.add(usrKey);
	      
	      // 管理员密码输入框
	      JPasswordField usrKeyInput = new JPasswordField(8);
	      usrKeyInput.setBounds(80,50,150,25);
	      panel.add(usrKeyInput);
	      
	      // 登录按键
	      JButton btn = new JButton("登录");
	      btn.setBounds(110,110,80,25);
	      btn.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	String inputUsr = usrLableInput.getText();
	            	String inputKeywords = new String(usrKeyInput.getPassword()); 
	            	String Sign = null;
	            	
	            	sqlUsrSign sign = new sqlUsrSign();
	            	try {
	            		Sign = sign.select(conn,inputUsr, inputKeywords);
	            	}catch(SQLException n){
	            		System.out.println("登录失败");
	            	}
	            	
	            	if(Sign != null) {
	            		System.out.println("用户登陆成功！");
	            		new jumpTable(conn,Sign);
	            		jf.dispose();
	            	}else {
	            		System.out.println("失败失败");
	            		new signErr(conn);
	            		jf.dispose();
	            	}
	            }
	      });
	      panel.add(btn);
	      
	      jf.setContentPane(panel);
	      jf.setVisible(true);
	}

}
