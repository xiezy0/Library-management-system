package client;

import java.awt.event.*;
import java.sql.Connection;

import javax.swing.*;

public class JumpTable {
	public JumpTable(Connection conn) {
		JFrame jf = new JFrame("登陆成功");
		jf.setSize(300, 200);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	    JPanel panel = new JPanel();
	    panel.setLayout(null);
	      
	    // 查询按键
	    JButton btn_1 = new JButton("查询");
	    btn_1.setBounds(100,10,100,25);
	    btn_1.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {
	            	new JumpTableSearch(conn);
	            	jf.dispose();
	         }
	    });
	    panel.add(btn_1);
	    
	    // 借阅按键
	    JButton btn_2 = new JButton("借阅与归还");
	    btn_2.setBounds(100,40,100,25);
	    btn_2.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {
	            	new JumpTableBorrow(conn);
	            	jf.dispose();
	         }
	    });
	    panel.add(btn_2);
	    
	    // 日常管理按键
	    JButton btn_3 = new JButton("日常管理");
	    btn_3.setBounds(100,70,100,25);
	    btn_3.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {
	            	new JumpTableManage(conn);
	            	jf.dispose();
	         }
	    });
	    panel.add(btn_3);
	    
	    // 退出登录按键
	    JButton btn_4 = new JButton("退出登录");
	    btn_4.setBounds(100,120,100,25);
	    btn_4.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {
	            	new AdminSign(conn);
	            	jf.dispose();
	         }
	    });
	    panel.add(btn_4);
	    
	    jf.setContentPane(panel);
	    jf.setVisible(true);  
	}
}
