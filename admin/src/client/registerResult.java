package client;

import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

public class registerResult {
	// ×¢²á³É¹¦
	public registerResult(Connection conn, String usrId) {
		JFrame jf = new JFrame("×¢²á³É¹¦");
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
        JLabel AdminLable = new JLabel("×¢²á³É¹¦");
        AdminLable.setBounds(10, 50, 160, 25);
        panel.add(AdminLable);

        // ·µ»Ø
        JButton btn = new JButton("·µ»Ø");
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
	
    // ×¢²áÊ§°Ü
	public registerResult(Connection conn) {
		JFrame jf = new JFrame("×¢²áÊ§°Ü");
        jf.setSize(300, 200);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        // ¹é»¹Ê§°Ü
        JLabel AdminLable = new JLabel("×¢²áÊ§°Ü£¬ÇëÖØÐÂÊäÈë");
        AdminLable.setBounds(10, 20, 160, 25);
        panel.add(AdminLable);

        // ·µ»Ø
        JButton btn = new JButton("·µ»Ø");
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
