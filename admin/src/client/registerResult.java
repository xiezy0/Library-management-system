package client;

import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

public class registerResult {
	// ע��ɹ�
	public registerResult(Connection conn, String usrId) {
		JFrame jf = new JFrame("ע��ɹ�");
        jf.setSize(300, 200);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        // usrId
        JLabel usrIdLable = new JLabel("usrId = " + usrId);
        usrIdLable.setBounds(10, 20, 160, 25);
        panel.add(usrIdLable);
        
        // usrId
        JLabel AdminLable = new JLabel("ע��ɹ�");
        AdminLable.setBounds(10, 50, 160, 25);
        panel.add(AdminLable);

        // ����
        JButton btn = new JButton("����");
        btn.setBounds(100, 110, 100, 25);
        btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new run(conn);
                    jf.dispose();
                }
        });
        panel.add(btn);

        jf.setContentPane(panel);
        jf.setVisible(true);
	}
	
    // ע��ʧ��
	public registerResult(Connection conn) {
		JFrame jf = new JFrame("ע��ʧ��");
        jf.setSize(300, 200);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        // �黹ʧ��
        JLabel AdminLable = new JLabel("ע��ʧ�ܣ�����������");
        AdminLable.setBounds(10, 20, 160, 25);
        panel.add(AdminLable);

        // ����
        JButton btn = new JButton("����");
        btn.setBounds(100, 110, 100, 25);
        btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new usrRegister(conn);
                    jf.dispose();
                }
            });
        panel.add(btn);

        jf.setContentPane(panel);
        jf.setVisible(true);
	}

}
