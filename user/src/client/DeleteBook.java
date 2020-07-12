package client;

import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import action.*;

public class DeleteBook {
	public DeleteBook(Connection conn) {
		JFrame jf = new JFrame("删除图书 ");
		jf.setSize(300, 200);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    JPanel panel = new JPanel();
	    panel.setLayout(null);
	    
	    // 请输入要删除的图书id
	    JLabel deleteBookLable = new JLabel("输入要删除的图书ID:");
	    deleteBookLable.setBounds(80,10,200,25);
	    panel.add(deleteBookLable);
	    
		// 图书id输入框
	    JTextField deleteBookInput = new JTextField(8);
	    deleteBookInput.setBounds(70,50,150,25);
	    panel.add(deleteBookInput);
	    
	    // 确认信息并删除按键
	    JButton btn_1 = new JButton("确认信息并查询");
	    btn_1.setBounds(70,90,150,25);
	    btn_1.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {
	        	  SqlDeleteBook delete = new SqlDeleteBook();
	        	  String Delect = null;
	        	  try {
	        		  Delect = delete.delete(conn, deleteBookInput.getText());
	        	  }catch(SQLException n) {
	        		  System.out.println("删除失败");
	        	  }
	        	  if(Delect != null) {
	        		  new DeleteBookResult(conn, Delect);
	        		  jf.dispose();
	        	  }else {
	        		  new DeleteBookResult(conn);
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
	            	new JumpTableManage(conn);
	            	jf.dispose();
	         }
	    });
	    panel.add(btn_2);
	    
	    jf.setContentPane(panel);
	    jf.setVisible(true);
	}

}
