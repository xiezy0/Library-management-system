package client;

import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

import action.*;

public class NewBook {
	public NewBook(Connection conn) {
		JFrame jf = new JFrame("Υ���¼��д");
		jf.setSize(350, 315);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	    JPanel panel = new JPanel();
	    panel.setLayout(null);
	    
	    // ������ͼ��ID:
	    JLabel BookIdLable = new JLabel("����ͼ��ID:");
	    BookIdLable.setBounds(10,20,150,25);
	    panel.add(BookIdLable);
	    JTextField BookIdInput = new JTextField(8);
	    BookIdInput.setBounds(130,20,200,25);
	    panel.add(BookIdInput);
	    
	    // ������ͼ����:
	    JLabel BookNameLable = new JLabel("����ͼ����:");
	    BookNameLable.setBounds(10,50,150,25);
	    panel.add(BookNameLable);
	    JTextField BookNameInput = new JTextField(8);
	    BookNameInput.setBounds(130,50,200,25);
	    panel.add(BookNameInput);
	    
	    // ��������������:
	    JLabel BookWriterLable = new JLabel("������������:");
	    BookWriterLable.setBounds(10,80,150,25);
	    panel.add(BookWriterLable);
	    JTextField BookWriterInput = new JTextField(8);
	    BookWriterInput.setBounds(130,80,200,25);
	    panel.add(BookWriterInput);
	    
	    // ������ͼ�������:
	    JLabel BookPublisherLable = new JLabel("����ͼ�������:");
	    BookPublisherLable.setBounds(10,110,150,25);
	    panel.add(BookPublisherLable);
	    JTextField BookPublisherInput = new JTextField(8);
	    BookPublisherInput.setBounds(130,110,200,25);
	    panel.add(BookPublisherInput);
	    
	    // ������ͼ��������:
	    JLabel BookPublishYearLable = new JLabel("����������:");
	    BookPublishYearLable.setBounds(10,140,150,25);
	    panel.add(BookPublishYearLable);
	    JTextField BookPublishYearInput = new JTextField(8);
	    BookPublishYearInput.setBounds(130,140,200,25);
	    panel.add(BookPublishYearInput);
	    
	    // ������ݲ�����:
	    JLabel BookTotalLable = new JLabel("����ͼ������:");
	    BookTotalLable.setBounds(10,170,150,25);
	    panel.add(BookTotalLable);
	    JTextField BookTotalInput = new JTextField(8);
	    BookTotalInput.setBounds(130,170,200,25);
	    panel.add(BookTotalInput);
	    
	    // ȷ����Ϣ�ύ
	    JButton btn_1 = new JButton("ȷ����Ϣ���ύ");
	    btn_1.setBounds(90,210,150,25);
	    btn_1.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {       
	        	  SqlNewBook newBook = new SqlNewBook();
	        	  boolean newBookResult = false;
	        	  try {
	        		  newBookResult = newBook.newBook(conn, BookIdInput.getText(), BookNameInput.getText(),BookWriterInput.getText(),BookPublisherInput.getText(),BookPublishYearInput.getText(),Integer.parseInt(BookTotalInput.getText()));
	        	  }catch(SQLException n) {
	        		  System.out.println("�����ͼ��ʧ��");
	        	  }
	        	  if(newBookResult == true) {
	        		  new NewBookResult(conn, BookIdInput.getText(), BookNameInput.getText());
	        		  jf.dispose();
	        	  }else {
	        		  new NewBookResult(conn);
	        		  jf.dispose();
	        	  }
	          }
	    });
	    panel.add(btn_1);
	   
	    // ���ذ���
	    JButton btn_2 = new JButton("����");
	    btn_2.setBounds(125,240,80,25);
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
