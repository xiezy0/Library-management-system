package client;

import action.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.SQLException;


public class AdminSign {
	public AdminSign(Connection conn) {
		  JFrame jf = new JFrame("登录");
		  jf.setSize(300, 200);
		  jf.setLocationRelativeTo(null);
		  jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	      JPanel panel = new JPanel();
	      panel.setLayout(null);
	      
	      // 管理员用户名
	      JLabel AdminLable = new JLabel("用户名:");
	      AdminLable.setBounds(10,20,80,25);
	      panel.add(AdminLable);
	      
	      // 管理员用户名输入框
	      JTextField AdminLableInput = new JTextField(8);
	      AdminLableInput.setBounds(80,20,150,25);
	      panel.add(AdminLableInput);
	      
	      // 管理员密码
	      JLabel AdminKey = new JLabel("密码:");
	      AdminKey.setBounds(10,50,80,25);
	      panel.add(AdminKey);
	      
	      // 管理员密码输入框
	      JPasswordField AdminKeyInput = new JPasswordField(8);
	      AdminKeyInput.setBounds(80,50,150,25);
	      panel.add(AdminKeyInput);
	      
	      // 登录按键
	      JButton btn = new JButton("登录");
	      btn.setBounds(110,110,80,25);
	      btn.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	String InputAdmin = AdminLableInput.getText();
	            	String InputKeywords = new String(AdminKeyInput.getPassword()); 
	            	boolean Sign = false;
	            	
	            	SqlAdminSign sign = new SqlAdminSign();
	            	try {
	            		Sign = sign.select(conn,InputAdmin, InputKeywords);
	            	}catch(SQLException n){
	            		System.out.println("登录失败");
	            	}
	            	
	            	if(Sign == true) {
	            		System.out.println("管理员登陆成功！");
	            		new JumpTable(conn);
	            		jf.dispose();
	            	}else {
	            		System.out.println("失败失败");
	            		new SignErr(conn);
	            		jf.dispose();
	            	}
	            	
	            }
	      });
	      panel.add(btn);
	      
	      jf.setContentPane(panel);
	      jf.setVisible(true);  
	  }

	  public static void main(String[] args) {
		  // 初始化连接对象，当做context
		  Connection conn = null;
		  SqlConnect sqlconnect = new SqlConnect();
		  conn = sqlconnect.connect();
		  
		  new AdminSign(conn);
	  }

}
