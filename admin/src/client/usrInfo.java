package client;

import java.sql.*;
import action.*;
import javax.swing.*;
import java.awt.event.*;

public class usrInfo {
	// ��ѯ�ɹ�
	public usrInfo(Connection conn,User Usr) {
		JFrame jf = new JFrame("�û���Ϣ��ѯ���");
		jf.setSize(300, 200);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    JPanel panel = new JPanel();
	    panel.setLayout(null);
	    
	    JLabel UsrIdLable = new JLabel("�û�id:  "+Usr.getUsrId());
	    UsrIdLable.setBounds(10,10,200,25);
	    panel.add(UsrIdLable);
	    
	    JLabel UsrNameLable = new JLabel("�û�����:  "+Usr.getUsrName());
	    UsrNameLable.setBounds(10,40,200,25);
	    panel.add(UsrNameLable);
	    
	    JLabel UsrBorrowLable = new JLabel("��������:  "+Usr.getUsrBorrow());
	    UsrBorrowLable.setBounds(10,70,200,25);
	    panel.add(UsrBorrowLable);
	    
	    JLabel UsrBadRecordLable = new JLabel("Υ���¼:  "+Usr.getUsrBadRecord());
	    UsrBadRecordLable.setBounds(10,100,200,25);
	    panel.add(UsrBadRecordLable);
	    
	    // ���ذ���
	    JButton btn_1 = new JButton("����");
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
	
	// ��ѯʧ��
	public usrInfo(Connection conn,String usrId){
		JFrame jf = new JFrame("��ѯʧ��");
		jf.setSize(300, 200);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	    JPanel panel = new JPanel();
	    panel.setLayout(null);
	      
	    // ��¼ʧ��
	    JLabel AdminLable = new JLabel("��ѯ�û�ʧ�ܣ�����������");
	    AdminLable.setBounds(10,20,160,25);
	    panel.add(AdminLable);
	    
	    // ���µ�½����
	    JButton btn = new JButton("����");
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
