package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BookingPage extends JPanel {

	private JButton prenotaStrumentoBtn, prenotaDotazioneBtn,
					modificaPrenotazioneBtn, cancellaPrenotazioneBtn,
					calendarioPrenotazioneBtn;

	private PrenotaStrumentoPage prenotaStrumentoPanel;
	private PrenotaDotazionePage prenotaDotazionePanel;
	private ModificaPrenotazionePage modificaPrenotazionePanel;
	private CancellaPrenotazionePage cancellaPrenotazionePanel;
	private CalendarioPrenotazionePage calendarioPrenotazionePanel;

	public BookingPage() {
		setLayout(null);

		prenotaStrumentoPanel = new PrenotaStrumentoPage();
		prenotaDotazionePanel = new PrenotaDotazionePage();
		modificaPrenotazionePanel = new ModificaPrenotazionePage();
		cancellaPrenotazionePanel = new CancellaPrenotazionePage();
		calendarioPrenotazionePanel = new CalendarioPrenotazionePage();
		prenotaStrumentoPanel.setBounds(25, 100, 950, 600);
		prenotaStrumentoPanel.setBackground(Color.pink);
		prenotaDotazionePanel.setBounds(25, 100, 950, 600);
		modificaPrenotazionePanel.setBounds(25, 100, 950, 600);
		cancellaPrenotazionePanel.setBounds(25, 100, 950, 600);
		calendarioPrenotazionePanel.setBounds(25, 100, 950, 600);
		
		add(prenotaStrumentoPanel);
		add(prenotaDotazionePanel);
		add(modificaPrenotazionePanel);
		add(cancellaPrenotazionePanel);
		add(calendarioPrenotazionePanel);

		prenotaStrumentoBtn = new JButton("Prenota strumento");
		prenotaStrumentoBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		prenotaStrumentoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prenotaStrumentoPanel.setVisible(true);
				prenotaDotazionePanel.setVisible(false);
				modificaPrenotazionePanel.setVisible(false);
				cancellaPrenotazionePanel.setVisible(false);
				calendarioPrenotazionePanel.setVisible(false);
			}
		});
		prenotaStrumentoBtn.setBounds(25, 60, 150, 30);
		add(prenotaStrumentoBtn);

		prenotaDotazioneBtn = new JButton("Prenota dotazione");
		prenotaDotazioneBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		prenotaDotazioneBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
			}
		});
		prenotaDotazioneBtn.setBounds(225, 60, 150, 30);
		add(prenotaDotazioneBtn);

		modificaPrenotazioneBtn = new JButton("Modifica");
		modificaPrenotazioneBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		modificaPrenotazioneBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
			}
		});
		modificaPrenotazioneBtn.setBounds(425, 60, 150, 30);
		add(modificaPrenotazioneBtn);

		cancellaPrenotazioneBtn = new JButton("Cancella");
		cancellaPrenotazioneBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cancellaPrenotazioneBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
			}
		});
		cancellaPrenotazioneBtn.setBounds(625, 60, 150, 30);
		add(cancellaPrenotazioneBtn);

		calendarioPrenotazioneBtn = new JButton("Calendario");
		calendarioPrenotazioneBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		calendarioPrenotazioneBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
			}
		});
		calendarioPrenotazioneBtn.setBounds(825, 60, 150, 30);
		add(calendarioPrenotazioneBtn);
	}

}
