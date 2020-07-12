package client;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class BookReviseResult {
	public BookReviseResult(Connection conn, String BookName)  {
		JFrame jf = new JFrame("��Ϣ�޸ĳɹ�");
        jf.setSize(300, 200);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        // �黹�ɹ�
        JLabel AdminLable = new JLabel(BookName + "�޸ĳɹ�");
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
	
	
	public BookReviseResult(Connection conn)  {
		JFrame jf = new JFrame("��Ϣ�޸�ʧ��");
        jf.setSize(300, 200);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        // �黹ʧ��
        JLabel AdminLable = new JLabel("�޸�ʧ�ܣ�����������");
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

}
