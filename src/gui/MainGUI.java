package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.Controller;

import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class MainGUI extends JFrame {

	public static final int HEIGHT_HOMEPAGE_WINDOW = 768;
    public static final int WIDTH_HOMEPAGE_WINDOW = 1024;

	private JPanel backgroundPanel;
	private JButton profiloPersonaleBtn, profileBackBtn, bookingBackBtn, prenotazioneBtn, 
					riepilogoStrumentiBtn, riepilogoDotazioniBtn, riepilogoStrumentiBackBtn;
	
	private HomePage homepagePanel;
	
	private ProfilePage profilePanel;

	private BookingPage bookingPanel;
	
	private RiepilogoStrumentiPage riepilogoStrumentiPanel;
	
	private Controller controller;
	 
	public MainGUI() {
		controller = new Controller();
		
		setBackground(new Color(171, 191, 244));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("LaboratorioScientificoUCM");
		setBounds(100, 100, WIDTH_HOMEPAGE_WINDOW, HEIGHT_HOMEPAGE_WINDOW);
		setLocationRelativeTo(null);
		backgroundPanel = new JPanel();
		backgroundPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		backgroundPanel.setBackground(new Color(171, 191, 244));
		setContentPane(backgroundPanel);
		backgroundPanel.setLayout(new CardLayout(0, 0));
		
		homepagePanel = new HomePage();
		profilePanel = new ProfilePage();
		bookingPanel = new BookingPage();
		riepilogoStrumentiPanel = new RiepilogoStrumentiPage();
		backgroundPanel.add(homepagePanel);
		backgroundPanel.add(profilePanel);
		backgroundPanel.add(bookingPanel);
		backgroundPanel.add(riepilogoStrumentiPanel);
		
		profiloPersonaleBtn = new JButton("Profilo");
		profiloPersonaleBtn.setBounds(880, 20, 89, 23);
		profiloPersonaleBtn.setBackground(new Color(171, 165, 255));
		profiloPersonaleBtn.setOpaque(true);
		profiloPersonaleBtn.setBorderPainted(true);
		profiloPersonaleBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		profiloPersonaleBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controller.switchPage(profilePanel, homepagePanel);
			}
		});
		homepagePanel.add(profiloPersonaleBtn);
		
		
		prenotazioneBtn = new JButton("Prenotazione");
		prenotazioneBtn.setFont(new Font("Tahoma", Font.BOLD, 25));
		prenotazioneBtn.setBackground(new Color(171, 165, 255));
		prenotazioneBtn.setOpaque(true);
		prenotazioneBtn.setBorderPainted(true);
		prenotazioneBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		prenotazioneBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.switchPage(bookingPanel, homepagePanel);
			}
		});
		prenotazioneBtn.setBounds(300, 650, 400, 50);
		homepagePanel.add(prenotazioneBtn);

		riepilogoStrumentiBtn = new JButton("Riepilogo strumenti");
		riepilogoStrumentiBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		riepilogoStrumentiBtn.setBackground(new Color(171, 165, 255));
		riepilogoStrumentiBtn.setOpaque(true);
		riepilogoStrumentiBtn.setBorderPainted(true);
		riepilogoStrumentiBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		riepilogoStrumentiBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.switchPage(riepilogoStrumentiPanel, homepagePanel);
			}
		});
		riepilogoStrumentiBtn.setBounds(160, 600, 180, 25);
		homepagePanel.add(riepilogoStrumentiBtn);

		riepilogoDotazioniBtn = new JButton("Riepilogo dotazioni");
		riepilogoDotazioniBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		riepilogoDotazioniBtn.setBackground(new Color(171, 165, 255));
		riepilogoDotazioniBtn.setOpaque(true);
		riepilogoDotazioniBtn.setBorderPainted(true);
		riepilogoDotazioniBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		riepilogoDotazioniBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
			}
		});
		riepilogoDotazioniBtn.setBounds(650, 600, 180, 25);
		homepagePanel.add(riepilogoDotazioniBtn);

		profileBackBtn = new JButton("Back");
		profileBackBtn.setBackground(new Color(171, 165, 255));
		profileBackBtn.setOpaque(true);
		profileBackBtn.setBorderPainted(true);
		profileBackBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		profileBackBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controller.switchPage(homepagePanel, profilePanel);
			}
		});
		profileBackBtn.setBounds(25, 11, 89, 23);
		profilePanel.add(profileBackBtn);

		bookingBackBtn = new JButton("Back");
		bookingBackBtn.setBackground(new Color(171, 165, 255));
		bookingBackBtn.setOpaque(true);
		bookingBackBtn.setBorderPainted(true);
		bookingBackBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		bookingBackBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				homepagePanel.setVisible(true);
				bookingPanel.setVisible(false);
				controller.switchPage(homepagePanel, bookingPanel);
			}
		});
		bookingBackBtn.setBounds(25, 11, 89, 23);
		bookingPanel.add(bookingBackBtn);
		
		riepilogoStrumentiBackBtn = new JButton("Back");
		riepilogoStrumentiBackBtn.setBackground(new Color(171, 165, 255));
		riepilogoStrumentiBackBtn.setOpaque(true);
		riepilogoStrumentiBackBtn.setBorderPainted(true);
		riepilogoStrumentiBackBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		riepilogoStrumentiBackBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				homepagePanel.setVisible(true);
				bookingPanel.setVisible(false);
				controller.switchPage(homepagePanel, riepilogoStrumentiPanel);
			}
		});
		riepilogoStrumentiBackBtn.setBounds(25, 11, 89, 23);
		riepilogoStrumentiPanel.add(riepilogoStrumentiBackBtn);
	}
}
