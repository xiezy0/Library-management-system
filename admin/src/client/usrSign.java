package client;

import java.sql.*;
import action.*;
import java.awt.event.*;
import javax.swing.*;

public class usrSign {

	public usrSign(Connection conn) {
		JFrame jf = new JFrame("��¼");
		  jf.setSize(300, 200);
		  jf.setLocationRelativeTo(null);
		  jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	      JPanel panel = new JPanel();
	      panel.setLayout(null);
	      
	      // ����Ա�û���
	      JLabel usrLable = new JLabel("�û���:");
	      usrLable.setBounds(10,20,80,25);
	      panel.add(usrLable);
	      
	      // ����Ա�û��������
	      JTextField usrLableInput = new JTextField(8);
	      usrLableInput.setBounds(80,20,150,25);
	      panel.add(usrLableInput);
	      
	      // ����Ա����
	      JLabel usrKey = new JLabel("����:");
	      usrKey.setBounds(10,50,80,25);
	      panel.add(usrKey);
	      
	      // ����Ա���������
	      JPasswordField usrKeyInput = new JPasswordField(8);
	      usrKeyInput.setBounds(80,50,150,25);
	      panel.add(usrKeyInput);
	      
	      // ��¼����
	      JButton btn = new JButton("��¼");
	      btn.setBounds(110,110,80,25);
	      btn.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	String inputUsr = usrLableInput.getText();
	            	String inputKeywords = new String(usrKeyInput.getPassword()); 
	            	String Sign = null;
	            	
	            	sqlUsrSign sign = new sqlUsrSign();
	            	try {
	            		Sign = sign.select(conn,inputUsr, inputKeywords);
	            	}catch(SQLException n){
	            		System.out.println("��¼ʧ��");
	            	}
	            	
	            	if(Sign != null) {
	            		System.out.println("�û���½�ɹ���");
	            		new jumpTable(conn,Sign);
	            		jf.dispose();
	            	}else {
	            		System.out.println("ʧ��ʧ��");
	            		new signErr(conn);
	            		jf.dispose();
	            	}
	            }
	      });
	      panel.add(btn);
	      
	      jf.setContentPane(panel);
	      jf.setVisible(true);
	}

}
