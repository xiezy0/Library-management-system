package client;

import action.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.SQLException;


public class AdminSign {
	public AdminSign(Connection conn) {
		  JFrame jf = new JFrame("��¼");
		  jf.setSize(300, 200);
		  jf.setLocationRelativeTo(null);
		  jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	      JPanel panel = new JPanel();
	      panel.setLayout(null);
	      
	      // ����Ա�û���
	      JLabel AdminLable = new JLabel("�û���:");
	      AdminLable.setBounds(10,20,80,25);
	      panel.add(AdminLable);
	      
	      // ����Ա�û��������
	      JTextField AdminLableInput = new JTextField(8);
	      AdminLableInput.setBounds(80,20,150,25);
	      panel.add(AdminLableInput);
	      
	      // ����Ա����
	      JLabel AdminKey = new JLabel("����:");
	      AdminKey.setBounds(10,50,80,25);
	      panel.add(AdminKey);
	      
	      // ����Ա���������
	      JPasswordField AdminKeyInput = new JPasswordField(8);
	      AdminKeyInput.setBounds(80,50,150,25);
	      panel.add(AdminKeyInput);
	      
	      // ��¼����
	      JButton btn = new JButton("��¼");
	      btn.setBounds(110,110,80,25);
	      btn.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	String InputAdmin = AdminLableInput.getText();
	            	String InputKeywords = new String(AdminKeyInput.getPassword()); 
	            	boolean Sign = false;
	            	
	            	SqlAdminSign sign = new SqlAdminSign();
	            	try {
	            		Sign = sign.select(conn,InputAdmin, InputKeywords);
	            	}catch(SQLException n){
	            		System.out.println("��¼ʧ��");
	            	}
	            	
	            	if(Sign == true) {
	            		System.out.println("����Ա��½�ɹ���");
	            		new JumpTable(conn);
	            		jf.dispose();
	            	}else {
	            		System.out.println("ʧ��ʧ��");
	            		new SignErr(conn);
	            		jf.dispose();
	            	}
	            	
	            }
	      });
	      panel.add(btn);
	      
	      jf.setContentPane(panel);
	      jf.setVisible(true);  
	  }

	  public static void main(String[] args) {
		  // ��ʼ�����Ӷ��󣬵���context
		  Connection conn = null;
		  SqlConnect sqlconnect = new SqlConnect();
		  conn = sqlconnect.connect();
		  
		  new AdminSign(conn);
	  }

}
