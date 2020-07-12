package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class BookBorrowResult {
    // 借阅成功
    public BookBorrowResult(Connection conn, String Usr) {
        JFrame jf = new JFrame("借阅成功");
        jf.setSize(300, 200);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        // 借阅成功
        JLabel AdminLable = new JLabel(Usr + "借阅成功");
        AdminLable.setBounds(10, 20, 160, 25);
        panel.add(AdminLable);

        // 重新登陆按键
        JButton btn = new JButton("返回");
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

    // 借阅失败
    public BookBorrowResult(Connection conn) {
        JFrame jf = new JFrame("借阅失败");
        jf.setSize(300, 200);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        // 借阅失败
        JLabel AdminLable = new JLabel("借阅失败，请重新输入");
        AdminLable.setBounds(10, 20, 160, 25);
        panel.add(AdminLable);

        // 重新登陆按键
        JButton btn = new JButton("返回");
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