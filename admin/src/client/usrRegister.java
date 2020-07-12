package client;

import java.sql.*;
import action.*;
import java.awt.event.*;
import javax.swing.*;

public class usrRegister {

	public usrRegister(Connection conn) {
		JFrame jf = new JFrame("�û�ע��");
		jf.setSize(300, 250);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	    JPanel panel = new JPanel();
	    panel.setLayout(null);
	      
	    // �������û���:
	    JLabel usrName = new JLabel("�������û���:");
	    usrName.setBounds(10,20,100,25);
	    panel.add(usrName);
	      
	    // �û��������
	    JTextField usrNameInput = new JTextField(8);
	    usrNameInput.setBounds(120,20,150,25);
	    panel.add(usrNameInput);
	    
	    // �������û�����:
	    JLabel usrKeyWords = new JLabel("�������û�����:");
	    usrKeyWords.setBounds(10,50,100,25);
	    panel.add(usrKeyWords);
	      
	    // �û����������
	    JPasswordField usrKeyWordsInput = new JPasswordField(8);
	    usrKeyWordsInput.setBounds(120,50,150,25);
	    panel.add(usrKeyWordsInput);
	    
	    // �ٴ������û�����:
	    JLabel usrKeyWords2 = new JLabel("���ٴ���������:");
	    usrKeyWords2.setBounds(10,80,100,25);
	    panel.add(usrKeyWords2);
	      
	    // �ٴ������û����������
	    JPasswordField usrKeyWords2Input = new JPasswordField(8);
	    usrKeyWords2Input.setBounds(120,80,150,25);
	    panel.add(usrKeyWords2Input);
	      
	    // ȷ����Ϣ�����İ���
	    JButton btn_1 = new JButton("ȷ����Ϣ��ע��");
	    btn_1.setBounds(75,130,150,25);
	    btn_1.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {  
	        	  String usrName = usrNameInput.getText();
	        	  String usrKeywords = new String(usrKeyWordsInput.getPassword());
	        	  String usrKeywords2 = new String(usrKeyWords2Input.getPassword());
	        	  sqlRegister register = new sqlRegister();
	        	  String result = null;
	        	  
	        	  if(usrKeywords.compareTo(usrKeywords2) != 0) {
	        		  new registerResult(conn);
	        		  jf.dispose();
	        	  }else {
	        		  try {
		        		  result = register.register(conn, usrName, usrKeywords);
		        	  }catch(SQLException n) {
		        		  System.out.println("ע��ʧ��");
		        	  }
		        	  if(result != null) {
		        		  new registerResult(conn, result);
		        		  jf.dispose();
		        	  }else {
		        		  new registerResult(conn);
		        		  jf.dispose();
		        	  }
	        	  }
	          }
	    });
	    panel.add(btn_1);
	    
	    // ���ذ���
	    JButton btn_2 = new JButton("����");
	    btn_2.setBounds(110,160,80,25);
	    btn_2.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {
	        	  new run(conn);
	        	  jf.dispose();
	          }
	    });
	    panel.add(btn_2);
	      
	    jf.setContentPane(panel);
	    jf.setVisible(true);
		
	}

}
