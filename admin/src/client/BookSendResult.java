package client;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class BookSendResult {
	// �黹�ɹ�
    public BookSendResult(Connection conn, String Usr) {
        JFrame jf = new JFrame("�黹�ɹ�");
        jf.setSize(300, 200);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        // �黹�ɹ�
        JLabel AdminLable = new JLabel(Usr + "�ɹ��黹ͼ��һ��");
        AdminLable.setBounds(10, 20, 160, 25);
        panel.add(AdminLable);

        // ����
        JButton btn = new JButton("����");
        btn.setBounds(100, 110, 100, 25);
        btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new BookSend(conn);
                    jf.dispose();
                }
        });
        panel.add(btn);

        jf.setContentPane(panel);
        jf.setVisible(true);
    }

    // �黹ʧ��
    public BookSendResult(Connection conn) {
        JFrame jf = new JFrame("�黹ʧ��");
        jf.setSize(300, 200);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        // �黹ʧ��
        JLabel AdminLable = new JLabel("�黹ʧ�ܣ�����������");
        AdminLable.setBounds(10, 20, 160, 25);
        panel.add(AdminLable);

        // ����
        JButton btn = new JButton("����");
        btn.setBounds(100, 110, 100, 25);
        btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new BookSend(conn);
                    jf.dispose();
                }
            });
        panel.add(btn);

        jf.setContentPane(panel);
        jf.setVisible(true);
    }

}
