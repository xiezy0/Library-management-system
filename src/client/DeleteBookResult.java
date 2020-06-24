package client;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class DeleteBookResult {
	public DeleteBookResult(Connection conn, String BookId) {
		JFrame jf = new JFrame("删除成功");
        jf.setSize(300, 200);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        // 归还成功
        JLabel AdminLable = new JLabel("成功删除图书" + BookId);
        AdminLable.setBounds(10, 20, 160, 25);
        panel.add(AdminLable);

        // 返回
        JButton btn = new JButton("返回");
        btn.setBounds(100, 110, 100, 25);
        btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new DeleteBook(conn);
                    jf.dispose();
                }
        });
        panel.add(btn);

        jf.setContentPane(panel);
        jf.setVisible(true);
	}
	
    public DeleteBookResult(Connection conn) {
    	JFrame jf = new JFrame("删除失败");
        jf.setSize(300, 200);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        // 删除失败
        JLabel AdminLable = new JLabel("删除失败");
        AdminLable.setBounds(10, 20, 190, 25);
        panel.add(AdminLable);
        
        // 删除失败
        JLabel AdminLable0 = new JLabel("1：检验BookId正确性");
        AdminLable0.setBounds(10, 50, 190, 25);
        panel.add(AdminLable0);
        
        // 删除失败
        JLabel AdminLable1 = new JLabel("2：检验图书被借阅情况");
        AdminLable1.setBounds(10, 80, 190, 25);
        panel.add(AdminLable1);

        // 返回
        JButton btn = new JButton("返回");
        btn.setBounds(100, 110, 100, 25);
        btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new DeleteBook(conn);
                    jf.dispose();
                }
            });
        panel.add(btn);

        jf.setContentPane(panel);
        jf.setVisible(true);
	} 

}
