package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

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

		prenotaBtn = new JButton("PRENOTA");
		prenotaBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				prenotaBtn.setBackground(new Color(157,149,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				prenotaBtn.setBackground(new Color(171, 165, 255));
			}
		});
		prenotaBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		prenotaBtn.setBackground(new Color(171, 165, 255));
		prenotaBtn.setOpaque(true);
		prenotaBtn.setBorderPainted(true);
		prenotaBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		prenotaBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				emptyPanel.setVisible(false);
				prenotaStrumentoPanel.setVisible(true);
				modificaPrenotazionePanel.setVisible(false);
				calendarioPrenotazionePanel.setVisible(false);
			}
		});
		prenotaBtn.setBounds(220, 59, 150, 30);
		add(prenotaBtn);

		modificaPrenotazioneBtn = new JButton("MODIFICA");
		modificaPrenotazioneBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				modificaPrenotazioneBtn.setBackground(new Color(157,149,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				modificaPrenotazioneBtn.setBackground(new Color(171, 165, 255));
			}
		});
		modificaPrenotazioneBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		modificaPrenotazioneBtn.setBackground(new Color(171, 165, 255));
		modificaPrenotazioneBtn.setOpaque(true);
		modificaPrenotazioneBtn.setBorderPainted(true);
		modificaPrenotazioneBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		modificaPrenotazioneBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				emptyPanel.setVisible(false);
				prenotaStrumentoPanel.setVisible(false);
				modificaPrenotazionePanel.setVisible(true);
				calendarioPrenotazionePanel.setVisible(false);
			}
		});
		modificaPrenotazioneBtn.setBounds(426, 59, 150, 30);
		add(modificaPrenotazioneBtn);

		calendarioPrenotazioneBtn = new JButton("CALENDARIO");
		calendarioPrenotazioneBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		calendarioPrenotazioneBtn.setBackground(new Color(171, 165, 255));
		calendarioPrenotazioneBtn.setOpaque(true);
		calendarioPrenotazioneBtn.setBorderPainted(true);
		calendarioPrenotazioneBtn.setBorder(new LineBorder(new Color(0, 0, 0)));		
		calendarioPrenotazioneBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				calendarioPrenotazioneBtn.setBackground(new Color(157,149,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				calendarioPrenotazioneBtn.setBackground(new Color(171, 165, 255));
			}
		});
		calendarioPrenotazioneBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				emptyPanel.setVisible(false);
				prenotaStrumentoPanel.setVisible(false);
				modificaPrenotazionePanel.setVisible(false);
				calendarioPrenotazionePanel.setVisible(true);
			}
		});
		calendarioPrenotazioneBtn.setBounds(630, 59, 150, 30);
		add(calendarioPrenotazioneBtn);
	}

}
