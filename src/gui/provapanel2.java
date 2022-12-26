package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class provapanel2 extends JPanel {

	JLabel pattLabel;
	
	public provapanel2() {
		setLayout(null);
		
		pattLabel = new JLabel("pat't");
		pattLabel.setBounds(30, 50, 46, 14);
		add(pattLabel);
	}

}
