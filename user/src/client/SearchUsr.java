package client;

import java.sql.*;
import action.*;
import javax.swing.*;
import java.awt.event.*;

public class SearchUsr {
	public SearchUsr(Connection conn) {
		JFrame jf = new JFrame("查询用户信息");
		jf.setSize(300, 200);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    JPanel panel = new JPanel();
	    panel.setLayout(null);
	    
	    // 请输入用户id
	    JLabel SearchUsrLable = new JLabel("请输入用户id:");
	    SearchUsrLable.setBounds(105,10,200,25);
	    panel.add(SearchUsrLable);
	    
		// 用户信息输入框
	    JTextField SearchUsrInput = new JTextField(8);
	    SearchUsrInput.setBounds(70,50,150,25);
	    panel.add(SearchUsrInput);
	    
	    // 查询按键
	    JButton btn_1 = new JButton("查询");
	    btn_1.setBounds(100,90,100,25);
	    btn_1.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {
	        	  String UsrID = SearchUsrInput.getText();
	        	  User Usr = new User();
	        	  SqlSearchUsr usr = new SqlSearchUsr(); 
	        	  try {
	        		  Usr = usr.select(conn, UsrID);
	              }catch(SQLException n){
	            	  System.out.println("查询失败");
	              }
	        	  if(Usr.getUsrId() == null) {
	        		  new SearchUsrResult(conn);
	        		  jf.dispose();
        		  }else {
        			  new SearchUsrResult(conn, Usr);
        			  jf.dispose();
        		  }
	         }
	    });
	    panel.add(btn_1);
	    
	    // 返回按键
	    JButton btn_2 = new JButton("返回");
	    btn_2.setBounds(100,120,100,25);
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
