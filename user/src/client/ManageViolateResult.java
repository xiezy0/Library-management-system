package client;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ManageViolateResult {
	// Υ���¼��д�ɹ�
	public ManageViolateResult(Connection conn, String UsrName){
		JFrame jf = new JFrame("Υ���¼��д�ɹ�");
        jf.setSize(300, 200);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        // ***������Υ��
        JLabel AdminLable = new JLabel(UsrName + "������Υ��");
        AdminLable.setBounds(10, 20, 160, 25);
        panel.add(AdminLable);

        // ����
        JButton btn = new JButton("����");
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
	// Υ���¼��дʧ��
	public ManageViolateResult(Connection conn) {
		JFrame jf = new JFrame("Υ���¼��дʧ��");
        jf.setSize(300, 200);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        // �黹ʧ��
        JLabel AdminLable = new JLabel("Υ���¼��дʧ�ܣ�������Ƿ���ڸ��û�");
        AdminLable.setBounds(10, 20, 250, 25);
        panel.add(AdminLable);

        // ����
        JButton btn = new JButton("����");
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
