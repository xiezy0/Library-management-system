package client;

import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

public class signErr {

	public signErr(Connection conn) {
		JFrame jf = new JFrame("µÇÂ½Ê§°Ü");
		jf.setSize(300, 200);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	    JPanel panel = new JPanel();
	    panel.setLayout(null);
	      
	    // µÇÂ¼Ê§°Ü
	    JLabel AdminLable = new JLabel("µÇÂ¼Ê§°Ü");
	    AdminLable.setBounds(10,20,80,25);
	    panel.add(AdminLable);
	    
	    // ÖØÐÂµÇÂ½°´¼ü
	    JButton btn = new JButton("ÖØÐÂµÇÂ½");
	    btn.setBounds(100,110,100,25);
	    btn.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {
	            	new usrSign(conn);
	            	jf.dispose();
	         }
	    });
	    panel.add(btn);
	    
	    jf.setContentPane(panel);
	    jf.setVisible(true);
	}

}
