package client;

import java.sql.*;
import action.*;
import javax.swing.*;
import java.awt.event.*;

public class SearchUsr {
	public SearchUsr(Connection conn) {
		JFrame jf = new JFrame("��ѯ�û���Ϣ");
		jf.setSize(300, 200);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    JPanel panel = new JPanel();
	    panel.setLayout(null);
	    
	    // �������û�id
	    JLabel SearchUsrLable = new JLabel("�������û�id:");
	    SearchUsrLable.setBounds(105,10,200,25);
	    panel.add(SearchUsrLable);
	    
		// �û���Ϣ�����
	    JTextField SearchUsrInput = new JTextField(8);
	    SearchUsrInput.setBounds(70,50,150,25);
	    panel.add(SearchUsrInput);
	    
	    // ��ѯ����
	    JButton btn_1 = new JButton("��ѯ");
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
	            	  System.out.println("��ѯʧ��");
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
	    
	    // ���ذ���
	    JButton btn_2 = new JButton("����");
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
