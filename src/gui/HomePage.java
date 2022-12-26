package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HomePage extends JFrame {

	private JPanel backgroundPane;
	
	private provapanel1 panel1;
	private provapanel2 panel2;
	
	private JButton btn1;
	private JButton btn2;
	 
	public HomePage() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("LaboratorioScientificoUCM");
		setBounds(100, 100, 1024, 768);
		setLocationRelativeTo(null);
		backgroundPane = new JPanel();
		backgroundPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(backgroundPane);
		backgroundPane.setLayout(new CardLayout(0, 0));
		
		panel1 = new provapanel1();
		panel2 = new provapanel2();
		backgroundPane.add(panel1);
		backgroundPane.add(panel2);
		
		btn1 = new JButton("GoTo2");
		btn1.setBounds(10, 11, 89, 23);
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				panel1.setVisible(false);
				panel2.setVisible(true);
			}
		});
		panel1.add(btn1);
		
		btn2 = new JButton("GoTo1");
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				panel1.setVisible(true);
				panel2.setVisible(false);
			}
		});
		btn2.setBounds(10, 11, 89, 23);
		panel2.add(btn2);
	}
}
