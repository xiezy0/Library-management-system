package client;

import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
import action.*;

public class jumpTable {

	public jumpTable(Connection conn, String usrId) {
		JFrame jf = new JFrame("��ѯ��Ϣ");
		jf.setSize(300, 200);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	    JPanel panel = new JPanel();
	    panel.setLayout(null);
	    
	    // ��ѯͼ����Ϣ����
	    JButton btn_1 = new JButton("��ѯͼ����Ϣ");
	    btn_1.setBounds(75,10,150,25);
	    btn_1.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {
	        	    new search(conn, usrId);
	            	jf.dispose();
	         }
	    });
	    panel.add(btn_1);
	    
	    // ��ѯ������Ϣ����
	    JButton btn_2 = new JButton("��ѯ������Ϣ");
	    btn_2.setBounds(75,50,150,25);
	    btn_2.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {
	        	  User usr = new User();
	        	  sqlSearchUsr user = new sqlSearchUsr();
	        	  try {
	        		  usr = user.search(conn, usrId);
	        	  }catch(SQLException n) {
	        		  System.out.println("��ѯʧ��");
	        	  }
	        	  new usrInfo(conn, usr);
		          jf.dispose();
	         }
	    });
	    panel.add(btn_2);
	    
	    // ���ذ���
	    JButton btn_3 = new JButton("�˳���¼");
	    btn_3.setBounds(100,120,100,25);
	    btn_3.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {
	            	new usrSign(conn);
	            	jf.dispose();
	         }
	    });
	    panel.add(btn_3);
	    
	    jf.setContentPane(panel);
	    jf.setVisible(true);
		
	}

}
