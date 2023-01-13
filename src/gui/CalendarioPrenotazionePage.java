package gui;

import javax.swing.JPanel;
import com.toedter.calendar.JDateChooser;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;

public class CalendarioPrenotazionePage extends JPanel {
	
	private JLabel selezionaMeseLabel;
	
	private JDateChooser jDateChooserPrenotazione;
	
	private String[] mesiArray = {"Gennaio", "Febbraio", "Marzo", "Aprile", "Maggio", "Giugno", "Luglio", "Agosto", "Settembre", "Ottobre", "Novembre", "Dicembre"};

	public CalendarioPrenotazionePage() {
		setBackground(new Color(171, 191, 244));
		setLayout(null);
	 
		selezionaMeseLabel = new JLabel("SELEZIONA DATA");
		selezionaMeseLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		selezionaMeseLabel.setBounds(372, 20, 220, 50);
		add(selezionaMeseLabel);
		
		jDateChooserPrenotazione = new JDateChooser();
		jDateChooserPrenotazione = new com.toedter.calendar.JDateChooser();
		jDateChooserPrenotazione.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		jDateChooserPrenotazione.setDateFormatString("dd/MM/yyyy");
		jDateChooserPrenotazione.setBounds(355,80,250,40);
		jDateChooserPrenotazione.getJCalendar().setPreferredSize(new Dimension(600, 460));
		add(jDateChooserPrenotazione);
	}
}

