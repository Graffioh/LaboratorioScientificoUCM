package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;

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
	private JButton profiloPersonaleBtn, profileBackBtn, bookingBackBtn, prenotazioneBtn, 
					riepilogoStrumentiBtn, riepilogoDotazioniBtn,
					effettuaPrenotStrumentoBtn, effettuaPrenotDotazioneBtn,
					modificaPrenotazioneBtn, cancellaPrenotazioneBtn,
					calendarioPrenotazioneBtn;
	
	private HomePage homepagePanel;
	
	private ProfilePage profilePanel;

	private BookingPage bookingPanel;
	
	private Controller controller;
	 
	public MainGUI() {
		controller = new Controller();
		
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
		profilePanel = new ProfilePage();
		bookingPanel = new BookingPage();
		backgroundPane.add(homepagePanel);
		backgroundPane.add(profilePanel);
		backgroundPane.add(bookingPanel);
		
		profiloPersonaleBtn = new JButton("Profilo");
		profiloPersonaleBtn.setBounds(880, 20, 89, 23);
		profiloPersonaleBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controller.switchPage(profilePanel, homepagePanel);
			}
		});
		homepagePanel.add(profiloPersonaleBtn);
		
		
		
		prenotazioneBtn = new JButton("Prenotazione");
		prenotazioneBtn.setFont(new Font("Tahoma", Font.BOLD, 25));
		prenotazioneBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.switchPage(bookingPanel, homepagePanel);
			}
		});
		prenotazioneBtn.setBounds(300, 650, 400, 50);
		homepagePanel.add(prenotazioneBtn);

		riepilogoStrumentiBtn = new JButton("RiepilogoS");
		riepilogoStrumentiBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		riepilogoStrumentiBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
			}
		});
		riepilogoStrumentiBtn.setBounds(30, 600, 150, 30);
		homepagePanel.add(riepilogoStrumentiBtn);

		riepilogoDotazioniBtn = new JButton("RiepilogoD");
		riepilogoDotazioniBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		riepilogoDotazioniBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
			}
		});
		riepilogoDotazioniBtn.setBounds(820, 600, 150, 30);
		homepagePanel.add(riepilogoDotazioniBtn);

		profileBackBtn = new JButton("Back");
		profileBackBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controller.switchPage(homepagePanel, profilePanel);
			}
		});
		profileBackBtn.setBounds(25, 11, 89, 23);
		profilePanel.add(profileBackBtn);

		bookingBackBtn = new JButton("Back");
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
	}
}
