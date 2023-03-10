package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.Controller;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Font;

public class MainGUI extends JFrame {

	public static final int HEIGHT_HOMEPAGE_WINDOW = 768;
    public static final int WIDTH_HOMEPAGE_WINDOW = 1024;

	private JPanel backgroundPanel;
	private JButton profiloPersonaleBtn, profileBackBtn, bookingBackBtn, prenotazioneBtn, 
					riepilogoStrumentiBtn, riepilogoDotazioniBtn, riepilogoStrumentiBackBtn,
					riepilogoDotazioniBackBtn, segnalaMConsumabiliBtn, segnalaMaterialiConsumabiliBackBtn;
	
	private HomePage homepagePanel;
	
	private ProfilePage profilePanel;

	private BookingPage bookingPanel;
	
	private RiepilogoStrumentiPage riepilogoStrumentiPanel;
	
	private RiepilogoDotazioniPage riepilogoDotazioniPanel;
	
	private SegnalaMaterialiConsumabiliPage segnalaMaterialiConsumabiliPanel;
	
	private CalendarioPrenotazionePage calendarioPrenotazioniPanel;
	
	private Controller controller;
	
	private BufferedImage picture;
	 
	// The MainGUI is used for buttons that changes the whole page
	public MainGUI() { 
		try {
			picture = ImageIO.read(new File("./img/lab-flask-500.png"));
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		
		setIconImage(
				picture
		);
		
		setBackground(new Color(171, 191, 244));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("LaboratorioScientificoUCM");
		setBounds(100, 100, WIDTH_HOMEPAGE_WINDOW, HEIGHT_HOMEPAGE_WINDOW);
		setLocationRelativeTo(null);
		
		backgroundPanel = new JPanel();
		backgroundPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		backgroundPanel.setBackground(new Color(171, 191, 244));
		backgroundPanel.setLayout(new CardLayout(0, 0));
		setContentPane(backgroundPanel);
		
		homepagePanel = new HomePage();
		profilePanel = new ProfilePage();
		bookingPanel = new BookingPage();
		riepilogoStrumentiPanel = new RiepilogoStrumentiPage();
		riepilogoDotazioniPanel = new RiepilogoDotazioniPage();
		calendarioPrenotazioniPanel = new CalendarioPrenotazionePage();
		segnalaMaterialiConsumabiliPanel = new SegnalaMaterialiConsumabiliPage();
		backgroundPanel.add(homepagePanel);
		backgroundPanel.add(profilePanel);
		backgroundPanel.add(bookingPanel);
		backgroundPanel.add(riepilogoStrumentiPanel);
		backgroundPanel.add(riepilogoDotazioniPanel);
		backgroundPanel.add(calendarioPrenotazioniPanel);
		backgroundPanel.add(segnalaMaterialiConsumabiliPanel);
		
		controller = new Controller();
		
		profiloPersonaleBtn = new JButton("PROFILO");
		profiloPersonaleBtn.setBounds(880, 20, 89, 23);
		profiloPersonaleBtn.setBackground(new Color(171, 165, 255));
		profiloPersonaleBtn.setOpaque(true);
		profiloPersonaleBtn.setBorderPainted(true);
		profiloPersonaleBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		profiloPersonaleBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				profiloPersonaleBtn.setBackground(new Color(157,149,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				profiloPersonaleBtn.setBackground(new Color(171, 165, 255));
			}
		});
		homepagePanel.add(profiloPersonaleBtn);
		
		prenotazioneBtn = new JButton("PRENOTAZIONE");
		prenotazioneBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				prenotazioneBtn.setBackground(new Color(157,149,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				prenotazioneBtn.setBackground(new Color(171, 165, 255));
			}
		});
		prenotazioneBtn.setFont(new Font("Tahoma", Font.BOLD, 25));
		prenotazioneBtn.setBackground(new Color(171, 165, 255));
		prenotazioneBtn.setOpaque(true);
		prenotazioneBtn.setBorderPainted(true);
		prenotazioneBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		prenotazioneBtn.setBounds(300, 650, 400, 50);
		homepagePanel.add(prenotazioneBtn);

		riepilogoStrumentiBtn = new JButton("RIEPILOGO STRUMENTI");
		riepilogoStrumentiBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				riepilogoStrumentiBtn.setBackground(new Color(157,149,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				riepilogoStrumentiBtn.setBackground(new Color(171, 165, 255));
			}
		});
		riepilogoStrumentiBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		riepilogoStrumentiBtn.setBackground(new Color(171, 165, 255));
		riepilogoStrumentiBtn.setOpaque(true);
		riepilogoStrumentiBtn.setBorderPainted(true);
		riepilogoStrumentiBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		riepilogoStrumentiBtn.setBounds(160, 600, 180, 25);
		homepagePanel.add(riepilogoStrumentiBtn);

		riepilogoDotazioniBtn = new JButton("RIEPILOGO DOTAZIONI");
		riepilogoDotazioniBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				riepilogoDotazioniBtn.setBackground(new Color(157,149,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				riepilogoDotazioniBtn.setBackground(new Color(171, 165, 255));
			}
		});
		riepilogoDotazioniBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		riepilogoDotazioniBtn.setBackground(new Color(171, 165, 255));
		riepilogoDotazioniBtn.setOpaque(true);
		riepilogoDotazioniBtn.setBorderPainted(true);
		riepilogoDotazioniBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		riepilogoDotazioniBtn.setBounds(650, 600, 180, 25);
		homepagePanel.add(riepilogoDotazioniBtn);
		
		segnalaMConsumabiliBtn = new JButton("SEGNALA CONSUMABILI");
		segnalaMConsumabiliBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		segnalaMConsumabiliBtn.setBackground(new Color(171, 165, 255));
		segnalaMConsumabiliBtn.setBorderPainted(true);
		segnalaMConsumabiliBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		segnalaMConsumabiliBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				segnalaMConsumabiliBtn.setBackground(new Color(157,149,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				segnalaMConsumabiliBtn.setBackground(new Color(171, 165, 255));
			}
		});
		segnalaMConsumabiliBtn.setBounds(760, 660, 200, 30);
		homepagePanel.add(segnalaMConsumabiliBtn);

		profileBackBtn = new JButton("BACK");
		profileBackBtn.setBackground(new Color(171, 165, 255));
		profileBackBtn.setOpaque(true);
		profileBackBtn.setBorderPainted(true);
		profileBackBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		profileBackBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				profileBackBtn.setBackground(new Color(157,149,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				profileBackBtn.setBackground(new Color(171, 165, 255));
			}
		});
		profileBackBtn.setBounds(25, 11, 89, 23);
		profilePanel.add(profileBackBtn);

		bookingBackBtn = new JButton("BACK");
		bookingBackBtn.setBackground(new Color(171, 165, 255));
		bookingBackBtn.setOpaque(true);
		bookingBackBtn.setBorderPainted(true);
		bookingBackBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		bookingBackBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bookingBackBtn.setBackground(new Color(157,149,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bookingBackBtn.setBackground(new Color(171, 165, 255));
			}
		});
		bookingBackBtn.setBounds(25, 11, 89, 23);
		bookingPanel.add(bookingBackBtn);
		
		riepilogoStrumentiBackBtn = new JButton("BACK");
		riepilogoStrumentiBackBtn.setBackground(new Color(171, 165, 255));
		riepilogoStrumentiBackBtn.setOpaque(true);
		riepilogoStrumentiBackBtn.setBorderPainted(true);
		riepilogoStrumentiBackBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		riepilogoStrumentiBackBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				riepilogoStrumentiBackBtn.setBackground(new Color(157,149,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				riepilogoStrumentiBackBtn.setBackground(new Color(171, 165, 255));
			}
		});
		riepilogoStrumentiBackBtn.setBounds(25, 11, 89, 23);
		riepilogoStrumentiPanel.add(riepilogoStrumentiBackBtn);
		
		riepilogoDotazioniBackBtn = new JButton("BACK");
		riepilogoDotazioniBackBtn.setBackground(new Color(171, 165, 255));
		riepilogoDotazioniBackBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.switchPage(homepagePanel, riepilogoDotazioniPanel);
			}
		});
		riepilogoDotazioniBackBtn.setOpaque(true);
		riepilogoDotazioniBackBtn.setBorderPainted(true);
		riepilogoDotazioniBackBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		riepilogoDotazioniBackBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				riepilogoDotazioniBackBtn.setBackground(new Color(157,149,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				riepilogoDotazioniBackBtn.setBackground(new Color(171, 165, 255));
			}
		});
		riepilogoDotazioniBackBtn.setBounds(25, 11, 89, 23);
		riepilogoDotazioniPanel.add(riepilogoDotazioniBackBtn);
		
		segnalaMaterialiConsumabiliBackBtn = new JButton("BACK");
		segnalaMaterialiConsumabiliBackBtn.setBackground(new Color(171, 165, 255));
		segnalaMaterialiConsumabiliBackBtn.setOpaque(true);
		segnalaMaterialiConsumabiliBackBtn.setBorderPainted(true);
		segnalaMaterialiConsumabiliBackBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		segnalaMaterialiConsumabiliBackBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				segnalaMaterialiConsumabiliBackBtn.setBackground(new Color(157,149,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				segnalaMaterialiConsumabiliBackBtn.setBackground(new Color(171, 165, 255));
			}
		});
		segnalaMaterialiConsumabiliBackBtn.setBounds(25, 11, 89, 23);
		segnalaMaterialiConsumabiliPanel.add(segnalaMaterialiConsumabiliBackBtn);
		
		profiloPersonaleBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.switchPage(profilePanel, homepagePanel);
			}
		});
		
		prenotazioneBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.switchPage(bookingPanel, homepagePanel);
			}
		});
		
		riepilogoStrumentiBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.switchPage(riepilogoStrumentiPanel, homepagePanel);
			}
		});
		
		riepilogoDotazioniBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.switchPage(riepilogoDotazioniPanel, homepagePanel);
			}
		});
		
		segnalaMConsumabiliBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.switchPage(segnalaMaterialiConsumabiliPanel, homepagePanel);
			}
		});
		
		bookingBackBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.switchPage(homepagePanel, bookingPanel);
			}
		});
		
		profileBackBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.switchPage(homepagePanel, profilePanel);
			}
		});
		
		riepilogoStrumentiBackBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.switchPage(homepagePanel, riepilogoStrumentiPanel);
			}
		});
		
		segnalaMaterialiConsumabiliBackBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.switchPage(homepagePanel, segnalaMaterialiConsumabiliPanel);
			}
		});
	}
}