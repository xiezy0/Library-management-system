package client;

import java.awt.event.*;
import java.sql.Connection;

import javax.swing.*;

public class JumpTable {
	public JumpTable(Connection conn) {
		JFrame jf = new JFrame("��½�ɹ�");
		jf.setSize(300, 200);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	    JPanel panel = new JPanel();
	    panel.setLayout(null);
	      
	    // ��ѯ����
	    JButton btn_1 = new JButton("��ѯ");
	    btn_1.setBounds(100,10,100,25);
	    btn_1.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {
	            	new JumpTableSearch(conn);
	            	jf.dispose();
	         }
	    });
	    panel.add(btn_1);
	    
	    // ���İ���
	    JButton btn_2 = new JButton("������黹");
	    btn_2.setBounds(100,40,100,25);
	    btn_2.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {
	            	new JumpTableBorrow(conn);
	            	jf.dispose();
	         }
	    });
	    panel.add(btn_2);
	    
	    // �ճ�������
	    JButton btn_3 = new JButton("�ճ�����");
	    btn_3.setBounds(100,70,100,25);
	    btn_3.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {
	            	new JumpTableManage(conn);
	            	jf.dispose();
	         }
	    });
	    panel.add(btn_3);
	    
	    // �˳���¼����
	    JButton btn_4 = new JButton("�˳���¼");
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
