package client;

import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import action.*;

public class DeleteBook {
	public DeleteBook(Connection conn) {
		JFrame jf = new JFrame("ɾ��ͼ�� ");
		jf.setSize(300, 200);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    JPanel panel = new JPanel();
	    panel.setLayout(null);
	    
	    // ������Ҫɾ����ͼ��id
	    JLabel deleteBookLable = new JLabel("����Ҫɾ����ͼ��ID:");
	    deleteBookLable.setBounds(80,10,200,25);
	    panel.add(deleteBookLable);
	    
		// ͼ��id�����
	    JTextField deleteBookInput = new JTextField(8);
	    deleteBookInput.setBounds(70,50,150,25);
	    panel.add(deleteBookInput);
	    
	    // ȷ����Ϣ��ɾ������
	    JButton btn_1 = new JButton("ȷ����Ϣ����ѯ");
	    btn_1.setBounds(70,90,150,25);
	    btn_1.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {
	        	  SqlDeleteBook delete = new SqlDeleteBook();
	        	  String Delect = null;
	        	  try {
	        		  Delect = delete.delete(conn, deleteBookInput.getText());
	        	  }catch(SQLException n) {
	        		  System.out.println("ɾ��ʧ��");
	        	  }
	        	  if(Delect != null) {
	        		  new DeleteBookResult(conn, Delect);
	        		  jf.dispose();
	        	  }else {
	        		  new DeleteBookResult(conn);
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
	            	new JumpTableManage(conn);
	            	jf.dispose();
	         }
	    });
	    panel.add(btn_2);
	    
	    jf.setContentPane(panel);
	    jf.setVisible(true);
	}

}
