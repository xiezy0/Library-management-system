package client;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class BookReviseResult {
	public BookReviseResult(Connection conn, String BookName)  {
		JFrame jf = new JFrame("信息修改成功");
        jf.setSize(300, 200);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        // 归还成功
        JLabel AdminLable = new JLabel(BookName + "修改成功");
        AdminLable.setBounds(10, 20, 180, 25);
        panel.add(AdminLable);

        // 返回
        JButton btn = new JButton("返回");
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
	
	
	public BookReviseResult(Connection conn)  {
		JFrame jf = new JFrame("信息修改失败");
        jf.setSize(300, 200);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        // 归还失败
        JLabel AdminLable = new JLabel("修改失败，请重新输入");
        AdminLable.setBounds(10, 20, 180, 25);
        panel.add(AdminLable);

        // 返回
        JButton btn = new JButton("返回");
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

}
