package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class MainGUI extends JFrame {

	public static final int HEIGHT_HOMEPAGE_WINDOW = 768;
    public static final int WIDTH_HOMEPAGE_WINDOW = 1024;

	private JPanel backgroundPane;
	
	private HomePage homepagePanel;
	private provapanel2 panel2;
	
	private JButton profiloPersonaleBtn;
	private JButton btn2;
	private JButton prenotazioneBtn;
	private JButton riepilogoStrumentiBtn;
	private JButton riepilogoDotazioniBtn;
	 
	public MainGUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("LaboratorioScientificoUCM");
		setBounds(100, 100, WIDTH_HOMEPAGE_WINDOW, HEIGHT_HOMEPAGE_WINDOW);
		setLocationRelativeTo(null);
		backgroundPane = new JPanel();
		backgroundPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(backgroundPane);
		backgroundPane.setLayout(new CardLayout(0, 0));
		
		homepagePanel = new HomePage();
		panel2 = new provapanel2();
		backgroundPane.add(homepagePanel);
		backgroundPane.add(panel2);
		
		profiloPersonaleBtn = new JButton("Profilo");
		profiloPersonaleBtn.setBounds(880, 20, 89, 23);
		profiloPersonaleBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				homepagePanel.setVisible(false);
				panel2.setVisible(true);
			}
		});
		homepagePanel.add(profiloPersonaleBtn);
		
		btn2 = new JButton("GoTo1");
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				homepagePanel.setVisible(true);
				panel2.setVisible(false);
			}
		});
		btn2.setBounds(10, 11, 89, 23);
		panel2.add(btn2);
		
		prenotazioneBtn = new JButton("Prenotazione");
		prenotazioneBtn.setFont(new Font("Tahoma", Font.BOLD, 25));
		prenotazioneBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		prenotazioneBtn.setBounds(300, 650, 400, 50);
		homepagePanel.add(prenotazioneBtn);

		riepilogoStrumentiBtn = new JButton("RiepilogoS");
		riepilogoStrumentiBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		riepilogoStrumentiBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		riepilogoStrumentiBtn.setBounds(40, 600, 100, 50);
		homepagePanel.add(riepilogoStrumentiBtn);



		riepilogoDotazioniBtn = new JButton("RiepilogoD");
		riepilogoDotazioniBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		riepilogoDotazioniBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		riepilogoDotazioniBtn.setBounds(680, 600, 100, 50);
		homepagePanel.add(riepilogoDotazioniBtn);

		
	}
}
