package client;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ManageViolateResult {
	// 违规记录填写成功
	public ManageViolateResult(Connection conn, String UsrName){
		JFrame jf = new JFrame("违规记录填写成功");
        jf.setSize(300, 200);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        // ***被警告违规
        JLabel AdminLable = new JLabel(UsrName + "被警告违规");
        AdminLable.setBounds(10, 20, 160, 25);
        panel.add(AdminLable);

        // 返回
        JButton btn = new JButton("返回");
        btn.setBounds(100, 110, 100, 25);
        btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new ManageViolate(conn);
                    jf.dispose();
                }
        });
        panel.add(btn);

        jf.setContentPane(panel);
        jf.setVisible(true);
	}
	// 违规记录填写失败
	public ManageViolateResult(Connection conn) {
		JFrame jf = new JFrame("违规记录填写失败");
        jf.setSize(300, 200);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        // 归还失败
        JLabel AdminLable = new JLabel("违规记录填写失败，请检验是否存在该用户");
        AdminLable.setBounds(10, 20, 250, 25);
        panel.add(AdminLable);

        // 返回
        JButton btn = new JButton("返回");
        btn.setBounds(100, 110, 100, 25);
        btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new ManageViolate(conn);
                    jf.dispose();
                }
            });
        panel.add(btn);

        jf.setContentPane(panel);
        jf.setVisible(true);
	}

}
