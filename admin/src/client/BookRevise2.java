package client;

import action.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class BookRevise2 {
	public BookRevise2(Connection conn) {
    	JFrame jf = new JFrame("û�д�ͼ��������Ϣ");
        jf.setSize(300, 200);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        // �黹ʧ��
        JLabel AdminLable = new JLabel("û�д�ͼ����Ϣ������������");
        AdminLable.setBounds(10, 20, 180, 25);
        panel.add(AdminLable);

        // ����
        JButton btn = new JButton("����");
        btn.setBounds(100, 110, 100, 25);
        btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new BookRevise(conn);
                    jf.dispose();
                }
            });
        panel.add(btn);

        jf.setContentPane(panel);
        jf.setVisible(true);
	}
	
	public BookRevise2(Connection conn, Book book, int number) {
		JFrame jf = new JFrame("��ʼ�޸�");
        jf.setSize(300, 200);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        switch(number) {
        	case 0: BookRevise2_BookId(conn, book, panel, jf);break;
        	case 1: BookRevise2_BookName(conn, book, panel, jf);break;
        	case 2: BookRevise2_BookWriter(conn, book, panel, jf);break;
        	case 3: BookRevise2_BookPublisher(conn, book, panel, jf);break;
        	case 4: BookRevise2_BookPublishYear(conn, book, panel, jf);break;
        	case 5: BookRevise2_BookTotal(conn, book, panel, jf);break;
        }
        
        // ���ذ���
	    JButton btn_2 = new JButton("����");
	    btn_2.setBounds(110,120,80,25);
	    btn_2.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {
	        	  new BookRevise(conn);
	        	  jf.dispose();
	          }
	    });
	    panel.add(btn_2);

        jf.setContentPane(panel);
        jf.setVisible(true);
	}
	
	public void BookRevise2_BookId(Connection conn, Book book, JPanel panel, JFrame jf){
		// ͼ��ԭʼ���
	    JLabel BookLable = new JLabel("ͼ��ԭʼ���:");
	    BookLable.setBounds(10,20,120,25);
	    panel.add(BookLable);
	      
	    // ͼ��ԭʼ���ֵ
	    JLabel BookIdLable = new JLabel(book.getBookId());
	    BookIdLable.setBounds(110,20,180,25);
	    panel.add(BookIdLable);
	    
	    // Ҫ�޸ĵ����:
	    JLabel UsrLable = new JLabel("�����޸ĺ�����:");
	    UsrLable.setBounds(10,50,120,25);
	    panel.add(UsrLable);
	      
	    // BookID�����
	    JTextField UsrLableInput = new JTextField(8);
	    UsrLableInput.setBounds(130,50,120,25);
	    panel.add(UsrLableInput);
	      
	    // ȷ����Ϣ���޸İ���
	    JButton btn_1 = new JButton("ȷ����Ϣ���޸�");
	    btn_1.setBounds(75,90,150,25);
	    btn_1.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) { 
	        	  SqlBookRevise revise = new SqlBookRevise();
	        	  String result = null;
	        	  try {
	        		  result = revise.revise(conn, UsrLableInput.getText(), book, 0);
	        	  }catch(SQLException n) {
	        		  System.out.println("�޸�ʧ��");
	        	  }
	        	  if(result != null) {
	        		  new BookReviseResult(conn,result);
	        		  jf.dispose();
	        	  }else {
	        		  new BookReviseResult(conn);
	        		  jf.dispose();
	        	  }
	          }
	    });
	    panel.add(btn_1);
	}
	
    public void BookRevise2_BookName(Connection conn, Book book, JPanel panel, JFrame jf){
    	// ͼ��ԭʼ����
	    JLabel BookLable = new JLabel("ͼ��ԭʼ����:");
	    BookLable.setBounds(10,20,120,25);
	    panel.add(BookLable);
	      
	    // ͼ��ԭʼ��������
	    JLabel BookIdLable = new JLabel(book.getBookName());
	    BookIdLable.setBounds(110,20,180,25);
	    panel.add(BookIdLable);
	    
	    // Ҫ�޸ĵ�����:
	    JLabel UsrLable = new JLabel("�����޸ĺ������:");
	    UsrLable.setBounds(10,50,120,25);
	    panel.add(UsrLable);
	      
	    // BookName�����
	    JTextField UsrLableInput = new JTextField(8);
	    UsrLableInput.setBounds(130,50,120,25);
	    panel.add(UsrLableInput);
	      
	    // ȷ����Ϣ���޸İ���
	    JButton btn_1 = new JButton("ȷ����Ϣ���޸�");
	    btn_1.setBounds(75,90,150,25);
	    btn_1.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {       
	        	  SqlBookRevise revise = new SqlBookRevise();
	        	  String result = null;
	        	  try {
	        		  result = revise.revise(conn, UsrLableInput.getText(), book, 1);
	        	  }catch(SQLException n) {
	        		  System.out.println("�޸�ʧ��");
	        	  }
	        	  if(result != null) {
	        		  new BookReviseResult(conn,result);
	        		  jf.dispose();
	        	  }else {
	        		  new BookReviseResult(conn);
	        		  jf.dispose();
	        	  }
	          }
	    });
	    panel.add(btn_1);
	}
    
    public void BookRevise2_BookWriter(Connection conn, Book book, JPanel panel, JFrame jf){
    	// ͼ��ԭʼ����
	    JLabel BookLable = new JLabel("ͼ��ԭʼ����:");
	    BookLable.setBounds(10,20,120,25);
	    panel.add(BookLable);
	      
	    // ͼ��ԭʼ�������ݣ�
	    JLabel BookIdLable = new JLabel(book.getBookWriter());
	    BookIdLable.setBounds(110,20,180,25);
	    panel.add(BookIdLable);
	    
	    // Ҫ�޸ĵ�����:
	    JLabel UsrLable = new JLabel("�����޸ĺ������:");
	    UsrLable.setBounds(10,50,120,25);
	    panel.add(UsrLable);
	      
	    // BookWriter�����
	    JTextField UsrLableInput = new JTextField(8);
	    UsrLableInput.setBounds(130,50,120,25);
	    panel.add(UsrLableInput);
	      
	    // ȷ����Ϣ���޸İ���
	    JButton btn_1 = new JButton("ȷ����Ϣ���޸�");
	    btn_1.setBounds(75,90,150,25);
	    btn_1.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {       
	        	  SqlBookRevise revise = new SqlBookRevise();
	        	  String result = null;
	        	  try {
	        		  result = revise.revise(conn, UsrLableInput.getText(), book, 2);
	        	  }catch(SQLException n) {
	        		  System.out.println("�޸�ʧ��");
	        	  }
	        	  if(result != null) {
	        		  new BookReviseResult(conn,result);
	        		  jf.dispose();
	        	  }else {
	        		  new BookReviseResult(conn);
	        		  jf.dispose();
	        	  }
	          }
	    });
	    panel.add(btn_1);
	}
    
    public void BookRevise2_BookPublisher(Connection conn, Book book, JPanel panel, JFrame jf){
    	// ͼ��ԭʼ������
	    JLabel BookLable = new JLabel("ͼ��ԭʼ������:");
	    BookLable.setBounds(10,20,120,25);
	    panel.add(BookLable);
	      
	    // ͼ��ԭʼ���������ݣ�
	    JLabel BookIdLable = new JLabel(book.getBookPublisher());
	    BookIdLable.setBounds(120,20,180,25);
	    panel.add(BookIdLable);
	    
	    // Ҫ�޸ĵĳ�����:
	    JLabel UsrLable = new JLabel("�����޸ĺ�ĳ�����:");
	    UsrLable.setBounds(10,50,120,25);
	    panel.add(UsrLable);
	      
	    // BookPublisher�����
	    JTextField UsrLableInput = new JTextField(8);
	    UsrLableInput.setBounds(140,50,120,25);
	    panel.add(UsrLableInput);
	      
	    // ȷ����Ϣ���޸İ���
	    JButton btn_1 = new JButton("ȷ����Ϣ���޸�");
	    btn_1.setBounds(75,90,150,25);
	    btn_1.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {       
	        	  SqlBookRevise revise = new SqlBookRevise();
	        	  String result = null;
	        	  try {
	        		  result = revise.revise(conn, UsrLableInput.getText(), book, 3);
	        	  }catch(SQLException n) {
	        		  System.out.println("�޸�ʧ��");
	        	  }
	        	  if(result != null) {
	        		  new BookReviseResult(conn,result);
	        		  jf.dispose();
	        	  }else {
	        		  new BookReviseResult(conn);
	        		  jf.dispose();
	        	  }
	          }
	    });
	    panel.add(btn_1);
	}
    
    public void BookRevise2_BookPublishYear(Connection conn, Book book, JPanel panel, JFrame jf){
    	// ͼ��ԭʼ�������
	    JLabel BookLable = new JLabel("ͼ��ԭʼ�������:");
	    BookLable.setBounds(10,20,150,25);
	    panel.add(BookLable);
	      
	    // ͼ��ԭʼ����������ݣ�
	    JLabel BookIdLable = new JLabel(book.getBookPublishYear());
	    BookIdLable.setBounds(130,20,120,25);
	    panel.add(BookIdLable);
	    
	    // Ҫ�޸ĵĳ������:
	    JLabel UsrLable = new JLabel("�����޸ĺ�ĳ������:");
	    UsrLable.setBounds(10,50,150,25);
	    panel.add(UsrLable);
	      
	    // BookPublishYear�����
	    JTextField UsrLableInput = new JTextField(8);
	    UsrLableInput.setBounds(150,50,120,25);
	    panel.add(UsrLableInput);
	      
	    // ȷ����Ϣ���޸İ���
	    JButton btn_1 = new JButton("ȷ����Ϣ���޸�");
	    btn_1.setBounds(75,90,150,25);
	    btn_1.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {       
	        	  SqlBookRevise revise = new SqlBookRevise();
	        	  String result = null;
	        	  try {
	        		  result = revise.revise(conn, UsrLableInput.getText(), book, 4);
	        	  }catch(SQLException n) {
	        		  System.out.println("�޸�ʧ��");
	        	  }
	        	  if(result != null) {
	        		  new BookReviseResult(conn,result);
	        		  jf.dispose();
	        	  }else {
	        		  new BookReviseResult(conn);
	        		  jf.dispose();
	        	  }
	          }
	    });
	    panel.add(btn_1);
	}
    
    public void BookRevise2_BookTotal(Connection conn, Book book, JPanel panel, JFrame jf){
    	// ͼ��ԭʼ�ݲ�����
	    JLabel BookLable = new JLabel("ͼ��ԭʼ�ݲ�����:");
	    BookLable.setBounds(10,20,120,25);
	    panel.add(BookLable);
	      
	    // ͼ��ԭʼ�ݲ��������ݣ�
	    String s4 =Integer.toString(book.getBookTotal());
	    JLabel BookIdLable = new JLabel(s4);
	    BookIdLable.setBounds(130,20,120,25);
	    panel.add(BookIdLable);
	    
	    // Ҫ�޸ĵĹݲ�:
	    JLabel UsrLable = new JLabel("�����޸ĺ�Ĺݲ�����:");
	    UsrLable.setBounds(10,50,150,25);
	    panel.add(UsrLable);
	      
	    // BookPublishYear�����
	    JTextField UsrLableInput = new JTextField(8);
	    UsrLableInput.setBounds(150,50,120,25);
	    panel.add(UsrLableInput);
	      
	    // ȷ����Ϣ���޸İ���
	    JButton btn_1 = new JButton("ȷ����Ϣ���޸�");
	    btn_1.setBounds(75,90,150,25);
	    btn_1.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {  
	        	  SqlBookRevise revise = new SqlBookRevise();
	        	  String result = null;
	        	  try {
	        		  result = revise.revise(conn, UsrLableInput.getText(), book, 5);
	        	  }catch(SQLException n) {
	        		  System.out.println("�޸�ʧ��");
	        	  }
	        	  if(result != null) {
	        		  new BookReviseResult(conn,result);
	        		  jf.dispose();
	        	  }else {
	        		  new BookReviseResult(conn);
	        		  jf.dispose();
	        	  }
	          }
	    });
	    panel.add(btn_1);
	}
    
//    public static void main(String[] args){
//		  // ��ʼ�����Ӷ��󣬵���context
//		  Connection conn = null;
//		  SqlConnect sqlconnect = new SqlConnect();
//		  conn = sqlconnect.connect();
//		  
//		  SqlSearchBook2 Book = new SqlSearchBook2();
//    	  Book book = new Book();
//    	  try {
//    		  book = Book.select(conn, "101-3-2-4");
//    	  }catch(SQLException n) {
//    		  System.out.println("û�и�ͼ�����Ϣ");
//    	  }
//    	  
//    	  new BookRevise2(conn, book, 5);
//	}

}
