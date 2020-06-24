package client;

import java.sql.*;
import java.util.List;
import action.*;
import javax.swing.*;
import java.awt.event.*;

public class SearchBookResult {
	// 查询成功
	public SearchBookResult(Connection conn, List<Book> books){
		JFrame jf = new JFrame("用户信息查询结果");
		jf.setSize(600, 400);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    JPanel panel = new JPanel();
	    panel.setLayout(null);
  	  
	    // 显示表单
	    Object[] columnNames = {"图书ID", "书名", "作者", "出版社", "出版年份", "馆藏量", "被借数量"};
	    int bookslong = 0;
        // 表格所有行数据
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
	    
        
//         返回按键
	    JButton btn_1 = new JButton("返回");
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
	// 查询失败
	public SearchBookResult(Connection conn){
		JFrame jf = new JFrame("查询失败");
		jf.setSize(300, 200);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	    JPanel panel = new JPanel();
	    panel.setLayout(null);
	      
	    // 登录失败
	    JLabel AdminLable = new JLabel("图书查询失败，请重新输入");
	    AdminLable.setBounds(10,20,160,25);
	    panel.add(AdminLable);
	    
	    // 重新登陆按键
	    JButton btn = new JButton("返回");
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
