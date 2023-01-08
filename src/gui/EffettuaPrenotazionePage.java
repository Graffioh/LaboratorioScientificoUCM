package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.Timestamp;
//import java.sql.Date;
import java.time.*;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.toedter.calendar.JDateChooser;

import controller.Controller;
import dao.DotazioneAccessoriaImpl;
import dao.PersonaleImpl;
import dao.PrenotazioneImpl;
import dao.StrumentoImpl;
import model.DotazioneAccessoria;
import model.Personale;
import model.Prenotazione;
import model.Sede;
import model.Strumento;

public class EffettuaPrenotazionePage extends JPanel {

	private JLabel selezionaStrumentoLabel, selezionaDotazioneLabel, selezionaSedeLabel, calendarioLabel, daOraLabel, aOraLabel, descrizioneLabel;
	private JButton selectStrumentoBtn, selectDotazioneBtn, confermaBtn;
	private JTextArea descrizioneFieldStrumentoDotazione;
	private JDateChooser jDateChooserStrumentoDotazione; 
	
	private ArrayList<Strumento> strumentoArray;
	private ArrayList<DotazioneAccessoria> dotazioneArray;
	private ArrayList<Personale> personaleArray;
	
	ArrayList<String> sedi, strumenti, dotazioni;
	String[] sediStringArray = {"none"}, strumentiStringArray = {"none"}, dotazioniStringArray = {"none"};
	private String descrizioneTextStrumentoDotazione = " Ahahahahah Ehi, gir pe Secondiglian \r\n Rind a n'Audi ner opac (rind a n'Audi ner opac) \r\n Ca m par n'astronav (ca m par n'astronav) \r\n Sceng o per na Balenciag (Bale) \r\n Ess vo nata Balenciag (Bale, Bale)";
	
	private PersonaleImpl personaleDAO;
	private StrumentoImpl strumentoDAO;
	private DotazioneAccessoriaImpl dotazioneDAO;
	private PrenotazioneImpl prenotazioneDAO;

	private Controller controller;
	
	private Personale filteredPersonale;
	
	private int codStr = 0, codD = 0, codP = 1;
	private boolean isStrumento = false, isDotazione = false;

	public EffettuaPrenotazionePage() {
		setLayout(null);
		
		personaleDAO = new PersonaleImpl();
		personaleArray = personaleDAO.populate();
		
		strumentoDAO = new StrumentoImpl();
		strumentoArray = new ArrayList<Strumento>();
		
		dotazioneDAO = new DotazioneAccessoriaImpl();
		dotazioneArray = new ArrayList<DotazioneAccessoria>();
		
		prenotazioneDAO = new PrenotazioneImpl();
		
		controller = new Controller();
		filteredPersonale = controller.filterBasedOnMatricolaCodice(personaleArray, LoginPage.getMatricolaTextField(), LoginPage.getCodiceTextField());
		
		// SELEZIONA SEDE
		selezionaSedeLabel = new JLabel("Seleziona sede");
		selezionaSedeLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		selezionaSedeLabel.setBounds(400, 20, 220, 50);
		add(selezionaSedeLabel);
		
		sedi = new ArrayList<String>();
		
		// Getting names from array<Object>
		sedi = controller.getNomiFromArray(filteredPersonale.getSediDoveLavora());

		sediStringArray = new String[sedi.size()];
		
		// Converting the arraylist into string[] to use it in combo box
		sediStringArray = sedi.toArray(sediStringArray);
		
		final JComboBox<String> sediComboBoxEffettua = new JComboBox<String>(sediStringArray);
		sediComboBoxEffettua.setBounds(355,80,250,40);
    	sediComboBoxEffettua.setVisible(true);
		add(sediComboBoxEffettua);
		
		selectStrumentoBtn = new JButton("Strumento");
		selectStrumentoBtn.setBounds(365, 150, 100, 35);
		add(selectStrumentoBtn);
		
		selectDotazioneBtn = new JButton("Dotazione");
		selectDotazioneBtn.setBounds(500, 150, 100, 35);
		add(selectDotazioneBtn);
		
		// SELEZIONA STRUMENTO
		selezionaStrumentoLabel = new JLabel("Seleziona strumento");
		selezionaStrumentoLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		selezionaStrumentoLabel.setBounds(372, 200, 220, 50);
		add(selezionaStrumentoLabel);
		
		final JComboBox<String> strumentiComboBox = new JComboBox<String>(strumentiStringArray);
		strumentiComboBox.setBounds(355,260,250,40);
		add(strumentiComboBox);

		// SELEZIONA DOTAZIONE
		selezionaDotazioneLabel = new JLabel("Seleziona dotazione");
		selezionaDotazioneLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		selezionaDotazioneLabel.setBounds(375, 200, 220, 50);
		add(selezionaDotazioneLabel);
		
		final JComboBox<String> dotazioniComboBox = new JComboBox<String>(dotazioniStringArray);
		dotazioniComboBox.setBounds(355,260,250,40);
		add(dotazioniComboBox);
		
		// DESCRIZIONE STRUMENTO
		descrizioneLabel = new JLabel("Descrizione");
		descrizioneLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		descrizioneLabel.setBounds(735, 200, 100, 50);
		add(descrizioneLabel);
		
		descrizioneFieldStrumentoDotazione = new JTextArea();
		descrizioneFieldStrumentoDotazione.setText(descrizioneTextStrumentoDotazione);
		descrizioneFieldStrumentoDotazione.setLineWrap(true);
		descrizioneFieldStrumentoDotazione.setWrapStyleWord(true);
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		descrizioneFieldStrumentoDotazione.setBorder(BorderFactory.createCompoundBorder(border,
	            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		JScrollPane descrizioneStrumentoDotazioneTextScroll = new JScrollPane (descrizioneFieldStrumentoDotazione, 
				   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		descrizioneStrumentoDotazioneTextScroll.setBounds(650, 240, 270, 100);
		
		add(descrizioneStrumentoDotazioneTextScroll);

		// CALENDARIO (for prenotazione)
		calendarioLabel = new JLabel("Seleziona data");
		calendarioLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		calendarioLabel.setBounds(420, 285, 150, 100);
		add(calendarioLabel);
		
		jDateChooserStrumentoDotazione = new JDateChooser();
		jDateChooserStrumentoDotazione = new com.toedter.calendar.JDateChooser();
		jDateChooserStrumentoDotazione.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		jDateChooserStrumentoDotazione.setDateFormatString("dd/MM/yyyy");
		jDateChooserStrumentoDotazione.setBounds(420, 360, 120, 20);
		add(jDateChooserStrumentoDotazione);
		
		// DA - A
		daOraLabel = new JLabel("DA:");
		daOraLabel.setBounds(400, 390, 50, 50);
		add(daOraLabel);
		
		aOraLabel = new JLabel("A:");
		aOraLabel.setBounds(520, 390, 50, 50);
		add(aOraLabel);
		
		String[] daOra = {"9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19"};
		String[] aOra = {"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
		
		final JComboBox<String> cbDaOra = new JComboBox<String>(daOra);
		cbDaOra.setBounds(400, 430, 50, 30);
    	cbDaOra.setVisible(true);
		add(cbDaOra);
		
		final JComboBox<String> cbAOra = new JComboBox<String>(aOra);
		cbAOra.setBounds(520, 430, 50, 30);
    	cbAOra.setVisible(true);
		add(cbAOra);

		// CONFERMA
		confermaBtn = new JButton("Conferma");
		confermaBtn.setFont(new Font("Tahoma", Font.BOLD, 24));
		confermaBtn.setBounds(396, 530, 180, 40);
		add(confermaBtn);

		// PRESET PART (SETUP)
		// used for the first start of the app
		selezionaStrumentoLabel.setVisible(false);
		strumentiComboBox.setVisible(false);
		selezionaDotazioneLabel.setVisible(false);
		dotazioniComboBox.setVisible(false);

		strumentoArray = strumentoDAO.getStrumentiBasedOnSede(filteredPersonale.getCodice(), sediComboBoxEffettua.getSelectedItem().toString());
		dotazioneArray = dotazioneDAO.getDotazioniBasedOnSede(filteredPersonale.getCodice(), sediComboBoxEffettua.getSelectedItem().toString());
		
		strumenti = new ArrayList<String>();
		dotazioni = new ArrayList<String>();
		
		strumenti = controller.getNomiFromArray(strumentoArray);
		dotazioni = controller.getNomiFromArray(dotazioneArray);
		
		strumentiStringArray = new String[strumenti.size()];
		dotazioniStringArray = new String[dotazioni.size()];
		
		strumentiStringArray = strumenti.toArray(strumentiStringArray);
		dotazioniStringArray = dotazioni.toArray(dotazioniStringArray);
		
		strumentiComboBox.setModel(new DefaultComboBoxModel<String>(strumentiStringArray));
		dotazioniComboBox.setModel(new DefaultComboBoxModel<String>(dotazioniStringArray));
		

		// DYNAMIC PART

		// DYNAMIC Seleziona+Descrizione
		selectStrumentoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				selezionaStrumentoLabel.setVisible(true);
				strumentiComboBox.setVisible(true);
				selezionaDotazioneLabel.setVisible(false);
				dotazioniComboBox.setVisible(false);
				
				isStrumento = true;
				isDotazione = false;
				
				// Descrizione
				descrizioneTextStrumentoDotazione = controller.getDescrizioneFromNome(strumentoArray, strumentiComboBox.getSelectedItem().toString());
				
				descrizioneFieldStrumentoDotazione.setText(descrizioneTextStrumentoDotazione);
			}
		});

		selectDotazioneBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				selezionaStrumentoLabel.setVisible(false);
				strumentiComboBox.setVisible(false);
				selezionaDotazioneLabel.setVisible(true);
				dotazioniComboBox.setVisible(true);
				
				isStrumento = false;
				isDotazione = true;
				
				// Descrizione
				descrizioneTextStrumentoDotazione = controller.getDescrizioneFromNome(dotazioneArray, dotazioniComboBox.getSelectedItem().toString());
				
				descrizioneFieldStrumentoDotazione.setText(descrizioneTextStrumentoDotazione);
			}
		});
		
		// DYNAMIC strumenti/dotazioni combo box based on sede
		sediComboBoxEffettua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				strumentoArray = strumentoDAO.getStrumentiBasedOnSede(filteredPersonale.getCodice(), sediComboBoxEffettua.getSelectedItem().toString());
				dotazioneArray = dotazioneDAO.getDotazioniBasedOnSede(filteredPersonale.getCodice(), sediComboBoxEffettua.getSelectedItem().toString());
				
				strumentiStringArray = controller.fromArrayListToStringArray(strumentoArray);
				dotazioniStringArray = controller.fromArrayListToStringArray(dotazioneArray);
				
				strumentiComboBox.setModel(new DefaultComboBoxModel<String>(strumentiStringArray));
				dotazioniComboBox.setModel(new DefaultComboBoxModel<String>(dotazioniStringArray));
				
				// Descrizione
				if(isStrumento) {
					descrizioneTextStrumentoDotazione = controller.getDescrizioneFromNome(strumentoArray, strumentiComboBox.getSelectedItem().toString());
				} else {
					descrizioneTextStrumentoDotazione = controller.getDescrizioneFromNome(dotazioneArray, dotazioniComboBox.getSelectedItem().toString());
				}
				
				descrizioneFieldStrumentoDotazione.setText(descrizioneTextStrumentoDotazione);
			}
		});

		// DYNAMIC descrizione (combo box)
		strumentiComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				descrizioneTextStrumentoDotazione = controller.getDescrizioneFromNome(strumentoArray, strumentiComboBox.getSelectedItem().toString());
			
				descrizioneFieldStrumentoDotazione.setText(descrizioneTextStrumentoDotazione);
			}
		});
		
		dotazioniComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				descrizioneTextStrumentoDotazione = controller.getDescrizioneFromNome(dotazioneArray, dotazioniComboBox.getSelectedItem().toString());
				
				descrizioneFieldStrumentoDotazione.setText(descrizioneTextStrumentoDotazione);
			}
		});
		
		// DYNAMIC Da - a ora prenotazione
		cbDaOra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				String[] aOraArray;
				
				aOraArray = controller.getAOraBasedOnDaOra(Integer.parseInt(cbDaOra.getSelectedItem().toString()));
				
				cbAOra.setModel(new DefaultComboBoxModel<String>(aOraArray));
			}
		});
		
		// CONFERMA prenotazione
		confermaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
				strumentoArray = strumentoDAO.getStrumentiBasedOnSede(filteredPersonale.getCodice(), sediComboBoxEffettua.getSelectedItem().toString());
				dotazioneArray = dotazioneDAO.getDotazioniBasedOnSede(filteredPersonale.getCodice(), sediComboBoxEffettua.getSelectedItem().toString());
				
				try {
					codStr = controller.getCodiceFromNome(strumentoArray, strumentiComboBox.getSelectedItem().toString());
					
					codD = controller.getCodiceFromNome(dotazioneArray, dotazioniComboBox.getSelectedItem().toString());
					
					// if prenotazioneArray is empty then codP is 1, otherwise it will calculate it dynamically based on the last codP
					controller.setPrenotazione(jDateChooserStrumentoDotazione.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), jDateChooserStrumentoDotazione.getDate().getTime(), Integer.parseInt(cbAOra.getSelectedItem().toString()) - Integer.parseInt(cbDaOra.getSelectedItem().toString()), Integer.parseInt(cbDaOra.getSelectedItem().toString()), Integer.parseInt(cbAOra.getSelectedItem().toString()), codP, codStr, codD, filteredPersonale.getCodice(), isStrumento);					
					
					JOptionPane.showMessageDialog(null, "Prenotazione riuscita.");
				} catch (Exception ee) {
					ee.printStackTrace();
					JOptionPane.showMessageDialog(null, "Prenotazione non riuscita, riprova.");
				}
				
			}
		});
		
	}

}
