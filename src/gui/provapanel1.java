package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class provapanel1 extends JPanel {
	
	JLabel mammtLabel;

	public provapanel1() {
		setLayout(null);
		
		mammtLabel = new JLabel("mammt");
		mammtLabel.setBounds(30, 50, 46, 14);
		add(mammtLabel);	
	}
	
}
