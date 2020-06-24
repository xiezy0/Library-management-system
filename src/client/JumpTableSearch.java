package client;

import java.awt.event.*;
import java.sql.Connection;

import javax.swing.*;

public class JumpTableSearch {
	public JumpTableSearch(Connection conn) {
		JFrame jf = new JFrame("查询信息");
		jf.setSize(300, 200);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	    JPanel panel = new JPanel();
	    panel.setLayout(null);
	    
	    // 查询图书信息按键
	    JButton btn_1 = new JButton("查询图书信息");
	    btn_1.setBounds(75,10,150,25);
	    btn_1.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {
	            	new SearchBook(conn);
	            	jf.dispose();
	         }
	    });
	    panel.add(btn_1);
	    
	    // 查询读者信息按键
	    JButton btn_2 = new JButton("查询读者信息");
	    btn_2.setBounds(75,50,150,25);
	    btn_2.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {
	            	new SearchUsr(conn);
	            	jf.dispose();
	         }
	    });
	    panel.add(btn_2);
	    
	    // 返回按键
	    JButton btn_3 = new JButton("返回");
	    btn_3.setBounds(100,120,100,25);
	    btn_3.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {
	            	new JumpTable(conn);
	            	jf.dispose();
	         }
	    });
	    panel.add(btn_3);
	    
	    jf.setContentPane(panel);
	    jf.setVisible(true);
		
	}
	
	public static void main(String[] args){
	}

}
