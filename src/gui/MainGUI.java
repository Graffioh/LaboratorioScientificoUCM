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
	private JButton profiloPersonaleBtn, backBtn1, backBtn2, prenotazioneBtn, 
					riepilogoStrumentiBtn, riepilogoDotazioniBtn,
					effettuaPrenotStrumentoBtn, effettuaPrenotDotazioneBtn,
					modificaPrenotazioneBtn, cancellaPrenotazioneBtn,
					calendarioPrenotazioneBtn;
	
	private HomePage homepagePanel;
	
	private ProfilePage profilePanel;

	private BookingPage bookingPanel;
	 
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
				homepagePanel.setVisible(false);
				profilePanel.setVisible(true);
			}
		});
		homepagePanel.add(profiloPersonaleBtn);
		
		
		
		prenotazioneBtn = new JButton("Prenotazione");
		prenotazioneBtn.setFont(new Font("Tahoma", Font.BOLD, 25));
		prenotazioneBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homepagePanel.setVisible(false);
				bookingPanel.setVisible(true);
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

		backBtn1 = new JButton("Back");
		backBtn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				homepagePanel.setVisible(true);
				profilePanel.setVisible(false);
			}
		});
		backBtn1.setBounds(25, 11, 89, 23);
		profilePanel.add(backBtn1);

		backBtn2 = new JButton("Back");
		backBtn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				homepagePanel.setVisible(true);
				bookingPanel.setVisible(false);
			}
		});
		backBtn2.setBounds(25, 11, 89, 23);
		bookingPanel.add(backBtn2);
		/*effettuaPrenotStrumentoBtn = new JButton("Prenota strumento");
		effettuaPrenotStrumentoBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		effettuaPrenotStrumentoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
			}
		});
		effettuaPrenotStrumentoBtn.setBounds(25, 20, 150, 30);
		bookingPanel.add(effettuaPrenotStrumentoBtn);

		effettuaPrenotDotazioneBtn = new JButton("Prenota dotazione");
		effettuaPrenotDotazioneBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		effettuaPrenotDotazioneBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
			}
		});
		effettuaPrenotDotazioneBtn.setBounds(225, 20, 150, 30);
		bookingPanel.add(effettuaPrenotDotazioneBtn);

		modificaPrenotazioneBtn = new JButton("Modifica");
		modificaPrenotazioneBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		modificaPrenotazioneBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
			}
		});
		modificaPrenotazioneBtn.setBounds(425, 20, 150, 30);
		bookingPanel.add(modificaPrenotazioneBtn);

		cancellaPrenotazioneBtn = new JButton("Cancella");
		cancellaPrenotazioneBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cancellaPrenotazioneBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
			}
		});
		cancellaPrenotazioneBtn.setBounds(625, 20, 150, 30);
		bookingPanel.add(cancellaPrenotazioneBtn);

		calendarioPrenotazioneBtn = new JButton("Calendario");
		calendarioPrenotazioneBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		calendarioPrenotazioneBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
			}
		});
		calendarioPrenotazioneBtn.setBounds(825, 20, 150, 30);
		bookingPanel.add(calendarioPrenotazioneBtn);*/

	}
}
