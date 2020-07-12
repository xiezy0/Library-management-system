package client;

import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

import action.*;

public class BookBorrow {
	public BookBorrow(Connection conn) {
		JFrame jf = new JFrame("����ͼ��");
		jf.setSize(300, 200);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	    JPanel panel = new JPanel();
	    panel.setLayout(null);
	      
	    // ������ͼ��ID:
	    JLabel BookLable = new JLabel("������ͼ��ID:");
	    BookLable.setBounds(10,20,80,25);
	    panel.add(BookLable);
	      
	    // ͼ��ID�����
	    JTextField BookLableInput = new JTextField(8);
	    BookLableInput.setBounds(100,20,150,25);
	    panel.add(BookLableInput);
	    
	    // �������û�ID:
	    JLabel UsrLable = new JLabel("�������û�ID:");
	    UsrLable.setBounds(10,50,80,25);
	    panel.add(UsrLable);
	      
	    // �û�ID�����
	    JTextField UsrLableInput = new JTextField(8);
	    UsrLableInput.setBounds(100,50,150,25);
	    panel.add(UsrLableInput);
	      
	    // ȷ����Ϣ�����İ���
	    JButton btn_1 = new JButton("ȷ����Ϣ������");
	    btn_1.setBounds(75,90,150,25);
	    btn_1.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {       
	        	  String borrowresult = null;
	        	  String BookId = BookLableInput.getText();
	        	  String UsrId = UsrLableInput.getText();
	        	  SqlBorrow borrow = new SqlBorrow();
	        	  try {
	        		  borrowresult = borrow.borrow(conn, BookId, UsrId);
	        	  }catch(SQLException n) {
	        		  System.out.println("����ʧ��");
	        	  }
	        	  if(borrowresult != null) {
	        		  new BookBorrowResult(conn, borrowresult);
	        		  jf.dispose();
	        	  }else {
	        		  new BookBorrowResult(conn);
	        		  jf.dispose();
	        	  }
	        	  
	          }
	    });
	    panel.add(btn_1);
	    
	    // ���ذ���
	    JButton btn_2 = new JButton("����");
	    btn_2.setBounds(110,120,80,25);
	    btn_2.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {
	        	  new JumpTableBorrow(conn);
	        	  jf.dispose();
	          }
	    });
	    panel.add(btn_2);
	      
	    jf.setContentPane(panel);
	    jf.setVisible(true);
	}
}
