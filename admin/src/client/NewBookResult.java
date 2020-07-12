package client;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class NewBookResult {
	public NewBookResult(Connection conn, String BookId, String BookName) {
		JFrame jf = new JFrame("用户信息查询结果");
		jf.setSize(300, 200);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    JPanel panel = new JPanel();
	    panel.setLayout(null);
	    
	    JLabel UsrIdLable = new JLabel("Bookid:  " + BookId);
	    UsrIdLable.setBounds(10,10,200,25);
	    panel.add(UsrIdLable);
	    
	    JLabel UsrNameLable = new JLabel("BookName:  " + BookName);
	    UsrNameLable.setBounds(10,40,200,25);
	    panel.add(UsrNameLable);
	    
	    JLabel UsrBorrowLable = new JLabel("新图书增加成功");
	    UsrBorrowLable.setBounds(10,70,200,25);
	    panel.add(UsrBorrowLable);
	    
	    // 返回按键
	    JButton btn_1 = new JButton("返回");
	    btn_1.setBounds(100,120,100,25);
	    btn_1.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {
	            	new NewBook(conn);
	            	jf.dispose();
	         }
	    });
	    panel.add(btn_1);
	    
	    jf.setContentPane(panel);
	    jf.setVisible(true);
	}
	
	
	// 添加新书失败
	public NewBookResult(Connection conn) {
		JFrame jf = new JFrame("增加失败");
        jf.setSize(300, 200);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        // 归还失败
        JLabel AdminLable = new JLabel("增加失败，请检验BookId是否重复");
        AdminLable.setBounds(10, 20, 220, 25);
        panel.add(AdminLable);

        // 返回
        JButton btn = new JButton("返回");
        btn.setBounds(100, 110, 100, 25);
        btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new NewBook(conn);
                    jf.dispose();
                }
            });
        panel.add(btn);

        jf.setContentPane(panel);
        jf.setVisible(true);
	}
}
