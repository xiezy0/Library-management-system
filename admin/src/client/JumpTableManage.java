package client;

import java.awt.event.*;
import java.sql.Connection;

import javax.swing.*;

public class JumpTableManage {
	public JumpTableManage(Connection conn) {
		JFrame jf = new JFrame("�ճ�����");
		jf.setSize(300, 250);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	    JPanel panel = new JPanel();
	    panel.setLayout(null);
	    
	    // Υ���¼��д����
	    JButton btn_1 = new JButton("Υ���¼��д");
	    btn_1.setBounds(75,10,150,25);
	    btn_1.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {
	            	new ManageViolate(conn);
	            	jf.dispose();
	         }
	    });
	    panel.add(btn_1);
	    
	    // ������ͼ�鰴��
	    JButton btn_2 = new JButton("��ͼ������");
	    btn_2.setBounds(75,50,150,25);
	    btn_2.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {
	            	new NewBook(conn);
	            	jf.dispose();
	         }
	    });
	    panel.add(btn_2);
	    
	    // ɾ��ͼ�鰴��
	    JButton btn_3 = new JButton("��ͼ��ɾ��");
	    btn_3.setBounds(75,90,150,25);
	    btn_3.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {
	            	new DeleteBook(conn);
	            	jf.dispose();
	         }
	    });
	    panel.add(btn_3);
	    
	    // ͼ����Ϣ�޸İ���
	    JButton btn_4 = new JButton("ͼ����Ϣ�޸�");
	    btn_4.setBounds(75,130,150,25);
	    btn_4.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {
	            	new BookRevise(conn);
	            	jf.dispose();
	         }
	    });
	    panel.add(btn_4);
	    
	    // ���ذ���
	    JButton btn_5 = new JButton("����");
	    btn_5.setBounds(100,180,100,25);
	    btn_5.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {
	            	new JumpTable(conn);
	            	jf.dispose();
	         }
	    });
	    panel.add(btn_5);
	    
	    jf.setContentPane(panel);
	    jf.setVisible(true);
		
	}
	
	public static void main(String[] args){
	}

}
