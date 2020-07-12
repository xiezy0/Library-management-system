package client;

import java.sql.*;
import java.util.List;
import action.*;
import javax.swing.*;
import java.awt.event.*;

public class SearchBookResult {
	// ��ѯ�ɹ�
	public SearchBookResult(Connection conn, List<Book> books){
		JFrame jf = new JFrame("�û���Ϣ��ѯ���");
		jf.setSize(600, 400);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    JPanel panel = new JPanel();
	    panel.setLayout(null);
  	  
	    // ��ʾ��
	    Object[] columnNames = {"ͼ��ID", "����", "����", "������", "�������", "�ݲ���", "��������"};
	    int bookslong = 0;
        // �������������
	    Object[][] rowData = new Object[books.size()][];
        while(bookslong < books.size()) {
        	rowData[bookslong] = new Object[7];
        	rowData[bookslong][0] = new String(books.get(bookslong).getBookId());
        	rowData[bookslong][1] = books.get(bookslong).getBookName();
        	rowData[bookslong][2] = books.get(bookslong).getBookWriter();
        	rowData[bookslong][3] = books.get(bookslong).getBookPublisher();
        	rowData[bookslong][4] = books.get(bookslong).getBookPublishYear();
        	rowData[bookslong][5] = books.get(bookslong).getBookTotal();
        	rowData[bookslong][6] = books.get(bookslong).getBookBorrowed();
        	bookslong++;
        }
        JTable table = new JTable(rowData, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 0, 600, 250);
        panel.add(scrollPane);
        
        
//        panel.add(table.getTableHeader(), BorderLayout.NORTH);
//        panel.add(table, BorderLayout.CENTER);
	    
        
//         ���ذ���
	    JButton btn_1 = new JButton("����");
	    btn_1.setBounds(230,300,100,25);
	    btn_1.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {
	            	new SearchBook(conn);
	            	jf.dispose();
	         }
	    });
	    panel.add(btn_1);
	    
	    jf.setContentPane(panel);
	    jf.setVisible(true);
	}
	// ��ѯʧ��
	public SearchBookResult(Connection conn){
		JFrame jf = new JFrame("��ѯʧ��");
		jf.setSize(300, 200);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	    JPanel panel = new JPanel();
	    panel.setLayout(null);
	      
	    // ��¼ʧ��
	    JLabel AdminLable = new JLabel("ͼ���ѯʧ�ܣ�����������");
	    AdminLable.setBounds(10,20,160,25);
	    panel.add(AdminLable);
	    
	    // ���µ�½����
	    JButton btn = new JButton("����");
	    btn.setBounds(100,110,100,25);
	    btn.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {
	            	new SearchBook(conn);
	            	jf.dispose();
	         }
	    });
	    panel.add(btn);
	    
	    jf.setContentPane(panel);
	    jf.setVisible(true);
	}
	
}
