package client;

import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

import action.*;

public class ManageViolate {
	public ManageViolate(Connection conn) {
		JFrame jf = new JFrame("违规记录填写");
		jf.setSize(300, 200);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	    JPanel panel = new JPanel();
	    panel.setLayout(null);
	      
	    // 输入违规读者ID:
	    JLabel usrLable = new JLabel("输入违规读者ID:");
	    usrLable.setBounds(10,20,120,25);
	    panel.add(usrLable);
	      
	    // 违规读者ID输入框
	    JTextField usrLableInput = new JTextField(8);
	    usrLableInput.setBounds(120,20,150,25);
	    panel.add(usrLableInput);
	    
	    // 输入新增违规次数:
	    JLabel numberLable = new JLabel("输入新增违规次数:");
	    numberLable.setBounds(10,50,120,25);
	    panel.add(numberLable);
	      
	    // 新增违规次数输入框
	    JTextField numberLableInput = new JTextField(8);
	    numberLableInput.setBounds(120,50,50,25);
	    panel.add(numberLableInput);
	      
	    // 确认信息并借阅按键
	    JButton btn_1 = new JButton("确认信息并填写");
	    btn_1.setBounds(75,90,150,25);
	    btn_1.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {       
	        	  String usrId = usrLableInput.getText();
	        	  int number = Integer.parseInt(numberLableInput.getText());
	        	  SqlViolate violate = new SqlViolate();
	        	  String violateresult = null;
	        	  
	        	  try {
	        		  violateresult = violate.violate(conn, usrId, number);
	        	  }catch(SQLException n) {
	        		  System.out.println("借阅失败");
	        	  }
	        	  if(violateresult != null) {
	        		  new ManageViolateResult(conn,violateresult);
	        		  jf.dispose();
	        	  }else {
	        		  new ManageViolateResult(conn);
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
	        	  new JumpTableManage(conn);
	        	  jf.dispose();
	          }
	    });
	    panel.add(btn_2);
	      
	    jf.setContentPane(panel);
	    jf.setVisible(true);
	}

}
