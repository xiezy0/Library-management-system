package client;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class DeleteBookResult {
	public DeleteBookResult(Connection conn, String BookId) {
		JFrame jf = new JFrame("ɾ���ɹ�");
        jf.setSize(300, 200);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        // �黹�ɹ�
        JLabel AdminLable = new JLabel("�ɹ�ɾ��ͼ��" + BookId);
        AdminLable.setBounds(10, 20, 160, 25);
        panel.add(AdminLable);

        // ����
        JButton btn = new JButton("����");
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
    	JFrame jf = new JFrame("ɾ��ʧ��");
        jf.setSize(300, 200);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        // ɾ��ʧ��
        JLabel AdminLable = new JLabel("ɾ��ʧ��");
        AdminLable.setBounds(10, 20, 190, 25);
        panel.add(AdminLable);
        
        // ɾ��ʧ��
        JLabel AdminLable0 = new JLabel("1������BookId��ȷ��");
        AdminLable0.setBounds(10, 50, 190, 25);
        panel.add(AdminLable0);
        
        // ɾ��ʧ��
        JLabel AdminLable1 = new JLabel("2������ͼ�鱻�������");
        AdminLable1.setBounds(10, 80, 190, 25);
        panel.add(AdminLable1);

        // ����
        JButton btn = new JButton("����");
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
