package client;

import java.sql.*;
import action.*;
import javax.swing.*;
import java.awt.event.*;

public class usrInfo {
	// 查询成功
	public usrInfo(Connection conn,User Usr) {
		JFrame jf = new JFrame("用户信息查询结果");
		jf.setSize(300, 200);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    JPanel panel = new JPanel();
	    panel.setLayout(null);
	    
	    JLabel UsrIdLable = new JLabel("用户id:  "+Usr.getUsrId());
	    UsrIdLable.setBounds(10,10,200,25);
	    panel.add(UsrIdLable);
	    
	    JLabel UsrNameLable = new JLabel("用户姓名:  "+Usr.getUsrName());
	    UsrNameLable.setBounds(10,40,200,25);
	    panel.add(UsrNameLable);
	    
	    JLabel UsrBorrowLable = new JLabel("借书数量:  "+Usr.getUsrBorrow());
	    UsrBorrowLable.setBounds(10,70,200,25);
	    panel.add(UsrBorrowLable);
	    
	    JLabel UsrBadRecordLable = new JLabel("违规记录:  "+Usr.getUsrBadRecord());
	    UsrBadRecordLable.setBounds(10,100,200,25);
	    panel.add(UsrBadRecordLable);
	    
	    // 返回按键
	    JButton btn_1 = new JButton("返回");
	    btn_1.setBounds(100,120,100,25);
	    btn_1.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {
	            	new jumpTable(conn, Usr.getUsrId());
	            	jf.dispose();
	         }
	    });
	    panel.add(btn_1);
	    
	    jf.setContentPane(panel);
	    jf.setVisible(true);
	}
	
	// 查询失败
	public usrInfo(Connection conn,String usrId){
		JFrame jf = new JFrame("查询失败");
		jf.setSize(300, 200);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	    JPanel panel = new JPanel();
	    panel.setLayout(null);
	      
	    // 登录失败
	    JLabel AdminLable = new JLabel("查询用户失败，请重新输入");
	    AdminLable.setBounds(10,20,160,25);
	    panel.add(AdminLable);
	    
	    // 重新登陆按键
	    JButton btn = new JButton("返回");
	    btn.setBounds(100,110,100,25);
	    btn.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {
	            	new jumpTable(conn, usrId);
	            	jf.dispose();
	         }
	    });
	    panel.add(btn);
	    
	    jf.setContentPane(panel);
	    jf.setVisible(true);
	}

}
