package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BookingPage extends JPanel {

	private JButton prenotaBtn, 
					modificaPrenotazioneBtn, calendarioPrenotazioneBtn;
	private JPanel emptyPanel;

	private EffettuaPrenotazionePage prenotaStrumentoPanel;
	private ModificaPrenotazionePage modificaPrenotazionePanel;
	private CalendarioPrenotazionePage calendarioPrenotazionePanel;

	public BookingPage() {
		setBackground(new Color(171, 191, 244));
		setLayout(null);
		
		emptyPanel = new JPanel();
		emptyPanel.setBounds(25, 100, 950, 600);
		emptyPanel.setBackground(new Color(171, 191, 244));
		add(emptyPanel);
		
		prenotaStrumentoPanel = new EffettuaPrenotazionePage();
		modificaPrenotazionePanel = new ModificaPrenotazionePage();
		calendarioPrenotazionePanel = new CalendarioPrenotazionePage();
		
		prenotaStrumentoPanel.setBounds(25, 100, 950, 600);
		modificaPrenotazionePanel.setBounds(25, 100, 950, 600);
		calendarioPrenotazionePanel.setBounds(25, 100, 950, 600);

		add(prenotaStrumentoPanel);
		add(modificaPrenotazionePanel);
		add(calendarioPrenotazionePanel);

		prenotaStrumentoPanel.setVisible(false);
		modificaPrenotazionePanel.setVisible(false);
		calendarioPrenotazionePanel.setVisible(false);

		prenotaBtn = new JButton("Prenota");
		prenotaBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		prenotaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				emptyPanel.setVisible(false);
				prenotaStrumentoPanel.setVisible(true);
				modificaPrenotazionePanel.setVisible(false);
				calendarioPrenotazionePanel.setVisible(false);
			}
		});
		prenotaBtn.setBounds(220, 59, 150, 30);
		add(prenotaBtn);

		modificaPrenotazioneBtn = new JButton("Modifica");
		modificaPrenotazioneBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		modificaPrenotazioneBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				emptyPanel.setVisible(false);
				prenotaStrumentoPanel.setVisible(false);
				modificaPrenotazionePanel.setVisible(true);
				calendarioPrenotazionePanel.setVisible(false);
			}
		});
		modificaPrenotazioneBtn.setBounds(426, 59, 150, 30);
		add(modificaPrenotazioneBtn);

		calendarioPrenotazioneBtn = new JButton("Calendario");
		calendarioPrenotazioneBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		calendarioPrenotazioneBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
			}
		});
		calendarioPrenotazioneBtn.setBounds(630, 59, 150, 30);
		add(calendarioPrenotazioneBtn);
	}

}
