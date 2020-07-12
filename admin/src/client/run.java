package client;

import java.sql.*;
import action.*;
import java.awt.event.*;
import javax.swing.*;


public class run {
	
	public run(Connection conn) {
		JFrame jf = new JFrame("�û���¼/ע��");
		jf.setSize(300, 200);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	    JPanel panel = new JPanel();
	    panel.setLayout(null);
	    
	    // �˻���¼
	    JButton btn_1 = new JButton("�˻���¼");
	    btn_1.setBounds(75,40,150,25);
	    btn_1.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {
	            	new usrSign(conn);
	            	jf.dispose();
	         }
	    });
	    panel.add(btn_1);
	    
	    // ���˻�ע��
	    JButton btn_2 = new JButton("���˻�ע��");
	    btn_2.setBounds(75,80,150,25);
	    btn_2.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {
	            	new usrRegister(conn);
	            	jf.dispose();
	         }
	    });
	    panel.add(btn_2);
	    
	    jf.setContentPane(panel);
	    jf.setVisible(true);
	}
	
	public static void main(String[] args){
		  Connection conn = null;
		  sqlConnect sqlconnect = new sqlConnect();
		  conn = sqlconnect.connect();
		  new run(conn);
	  }

}
