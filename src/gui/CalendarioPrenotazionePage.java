package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.toedter.calendar.JDateChooser;

import controller.Controller;
import dao.PersonaleImpl;
import dao.PrenotazioneImpl;
import model.Personale;
import model.Prenotazione;

import java.awt.Color;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class CalendarioPrenotazionePage extends JPanel {
	
	private JLabel selezionaMeseLabel;
	private JTable prenotazioniTable;
	private JScrollPane prenotazioniScrollPane;
	
	private JDateChooser jDateChooserPrenotazione;
	
	private PersonaleImpl personaleDAO;
	private ArrayList<Personale> personaleArray;
	
	private PrenotazioneImpl prenotazioneDAO;
	private ArrayList<Prenotazione> prenotazioneArray;
	
	private Personale filteredPersonale;
	
	private Controller controller;

	public CalendarioPrenotazionePage() {
		setBackground(new Color(171, 191, 244));
		setLayout(null);
		
		personaleDAO = new PersonaleImpl();
		personaleArray = personaleDAO.populate();
		
		controller = new Controller();
		filteredPersonale = controller.filterPersonaleBasedOnMatricolaCodice(personaleArray, LoginPage.getMatricolaTextField(), LoginPage.getCodiceTextField());
	 
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
		
		prenotazioniTable = new JTable();
		prenotazioniTable.setBackground(new Color(213, 223, 255));
		prenotazioniTable.setBounds(73, 200, 772, 441);
		prenotazioniTable.setDefaultEditor(Object.class, null);
		
		prenotazioniScrollPane = new JScrollPane(prenotazioniTable);
		prenotazioniScrollPane.setBounds(73, 200, 772, 441);
		prenotazioniScrollPane.getViewport().setBackground(new Color(213, 223, 255));
		add(prenotazioniScrollPane);
		
		prenotazioniScrollPane.setVisible(false);
		
		prenotazioneDAO = new PrenotazioneImpl();
		
		addComponentListener(new ComponentAdapter () {
			@Override
			public void componentShown ( ComponentEvent e ) {
					prenotazioneArray = prenotazioneDAO.getPrenotazioneBasedOnPersonale(filteredPersonale.getCodice());
				}
			});
		
		// Action listener but for JCalendar
		jDateChooserPrenotazione.getDateEditor().addPropertyChangeListener(		
			new PropertyChangeListener() {
		        @Override
		        public void propertyChange(PropertyChangeEvent e) {
		        	if ("date".equals(e.getPropertyName())) {
		        		
		        		prenotazioniScrollPane.setVisible(true);
		        		
		        		LocalDate date = ((Date)e.getNewValue()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		        		
		        		controller.populateCalendarioTable(prenotazioneArray, prenotazioniTable, date);
		        	}
		        }
			});
	}
		
}

