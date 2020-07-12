package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class BookBorrowResult {
    // ���ĳɹ�
    public BookBorrowResult(Connection conn, String Usr) {
        JFrame jf = new JFrame("���ĳɹ�");
        jf.setSize(300, 200);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        // ���ĳɹ�
        JLabel AdminLable = new JLabel(Usr + "���ĳɹ�");
        AdminLable.setBounds(10, 20, 160, 25);
        panel.add(AdminLable);

        // ���µ�½����
        JButton btn = new JButton("����");
        btn.setBounds(100, 110, 100, 25);
        btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new BookBorrow(conn);
                    jf.dispose();
                }
        });
        panel.add(btn);

        jf.setContentPane(panel);
        jf.setVisible(true);
    }

    // ����ʧ��
    public BookBorrowResult(Connection conn) {
        JFrame jf = new JFrame("����ʧ��");
        jf.setSize(300, 200);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        // ����ʧ��
        JLabel AdminLable = new JLabel("����ʧ�ܣ�����������");
        AdminLable.setBounds(10, 20, 160, 25);
        panel.add(AdminLable);

        // ���µ�½����
        JButton btn = new JButton("����");
        btn.setBounds(100, 110, 100, 25);
        btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new BookBorrow(conn);
                    jf.dispose();
                }
            });
        panel.add(btn);

        jf.setContentPane(panel);
        jf.setVisible(true);
    }
}