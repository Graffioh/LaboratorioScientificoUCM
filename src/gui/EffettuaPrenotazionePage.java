package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.*;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

import controller.Controller;
import dao.DotazioneAccessoriaImpl;
import dao.PersonaleImpl;
import dao.PrenotazioneImpl;
import dao.StrumentoImpl;
import model.DotazioneAccessoria;
import model.Personale;
import model.Strumento;
import model.Prenotazione;

public class EffettuaPrenotazionePage extends JPanel {

	private JLabel selezionaStrumentoLabel, selezionaDotazioneLabel, selezionaSedeLabel, calendarioLabel, daOraLabel, aOraLabel, descrizioneLabel;
	private JButton selectStrumentoBtn, selectDotazioneBtn, confermaBtn;
	private JTextArea descrizioneFieldStrumentoDotazione;
	private JDateChooser jDateChooserStrumentoDotazione; 
	
	private ArrayList<Strumento> strumentoArray;
	private ArrayList<DotazioneAccessoria> dotazioneArray;
	private ArrayList<Personale> personaleArray;
	private ArrayList<Prenotazione> prenotazioneArray;
	
	ArrayList<String> sedi, strumenti, dotazioni;
	String[] sediStringArray = {"none"}, strumentiStringArray = {"none"}, dotazioniStringArray = {"none"};
	private String descrizioneTextStrumentoDotazione = " ";
	
	private PersonaleImpl personaleDAO;
	private StrumentoImpl strumentoDAO;
	private DotazioneAccessoriaImpl dotazioneDAO;
	private PrenotazioneImpl prenotazioneDAO;

	private Controller controller;
	
	private Personale filteredPersonale;
	
	private int codStr = 0, codD = 0, codP = 1;
	private boolean isStrumento = false;

	public EffettuaPrenotazionePage() {
		// GUI
		setBackground(new Color(171, 191, 244));
		setLayout(null);
		
		personaleDAO = new PersonaleImpl();
		personaleArray = personaleDAO.populate();
		
		new PrenotazioneImpl();
		
		controller = new Controller();
		filteredPersonale = controller.filterPersonaleBasedOnMatricolaCodice(personaleArray, LoginPage.getMatricolaTextField(), LoginPage.getCodiceTextField());
		
		// SELEZIONA SEDE
		selezionaSedeLabel = new JLabel("SELEZIONA SEDE");
		selezionaSedeLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		selezionaSedeLabel.setBounds(372, 20, 220, 50);
		add(selezionaSedeLabel);
		
		sediStringArray = controller.fromArrayListToStringArray(filteredPersonale.getSediDoveLavora());
		
		final JComboBox<String> sediComboBoxEffettua = new JComboBox<String>(sediStringArray);
		sediComboBoxEffettua.setBackground(new Color(213, 223, 255));
		sediComboBoxEffettua.setBounds(355,80,250,40);
    	sediComboBoxEffettua.setVisible(true);
    	sediComboBoxEffettua.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				sediComboBoxEffettua.setBackground(new Color(200, 215, 245));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				sediComboBoxEffettua.setBackground(new Color(213, 223, 255));
			}
		});
		add(sediComboBoxEffettua);
			
		selectStrumentoBtn = new JButton("STRUMENTO");
		selectStrumentoBtn.setBackground(new Color(171, 165, 255));
		selectStrumentoBtn.setOpaque(true);
		selectStrumentoBtn.setBorderPainted(true);
		selectStrumentoBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		selectStrumentoBtn.setBounds(365, 150, 100, 35);
		selectStrumentoBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				selectStrumentoBtn.setBackground(new Color(157,149,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				selectStrumentoBtn.setBackground(new Color(171, 165, 255));
			}
		});
		add(selectStrumentoBtn);
		
		selectDotazioneBtn = new JButton("DOTAZIONE");
		selectDotazioneBtn.setBackground(new Color(171, 165, 255));
		selectDotazioneBtn.setOpaque(true);
		selectDotazioneBtn.setBorderPainted(true);
		selectDotazioneBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		selectDotazioneBtn.setBounds(500, 150, 100, 35);
		selectDotazioneBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				selectDotazioneBtn.setBackground(new Color(157,149,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				selectDotazioneBtn.setBackground(new Color(171, 165, 255));
			}
		});
		add(selectDotazioneBtn);
		
		// SELEZIONA STRUMENTO
		selezionaStrumentoLabel = new JLabel("SELEZIONA STRUMENTO");
		selezionaStrumentoLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		selezionaStrumentoLabel.setBounds(342, 200, 314, 50);
		add(selezionaStrumentoLabel);
		
		final JComboBox<String> strumentiComboBox = new JComboBox<String>(strumentiStringArray);
		strumentiComboBox.setBackground(new Color(213, 223, 255));
		strumentiComboBox.setBounds(355,260,250,40);
		strumentiComboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				strumentiComboBox.setBackground(new Color(200, 215, 245));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				strumentiComboBox.setBackground(new Color(213, 223, 255));
			}
		});
		add(strumentiComboBox);

		// SELEZIONA DOTAZIONE
		selezionaDotazioneLabel = new JLabel("SELEZIONA DOTAZIONE");
		selezionaDotazioneLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		selezionaDotazioneLabel.setBounds(342, 200, 298, 50);
		add(selezionaDotazioneLabel);
		
		final JComboBox<String> dotazioniComboBox = new JComboBox<String>(dotazioniStringArray);
		dotazioniComboBox.setBackground(new Color(213, 223, 255));
		dotazioniComboBox.setBounds(355,260,250,40);
		dotazioniComboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				dotazioniComboBox.setBackground(new Color(200, 215, 245));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				dotazioniComboBox.setBackground(new Color(213, 223, 255));
			}
		});
		add(dotazioniComboBox);
		
		// DESCRIZIONE STRUMENTO
		descrizioneLabel = new JLabel("Descrizione");
		descrizioneLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		descrizioneLabel.setBounds(735, 200, 100, 50);
		add(descrizioneLabel);
		
		descrizioneFieldStrumentoDotazione = new JTextArea();
		descrizioneFieldStrumentoDotazione.setText(descrizioneTextStrumentoDotazione);
		descrizioneFieldStrumentoDotazione.setLineWrap(true);
		descrizioneFieldStrumentoDotazione.setWrapStyleWord(true);
		descrizioneFieldStrumentoDotazione.setFont(new Font("Tahoma", Font.PLAIN, 13));
		descrizioneFieldStrumentoDotazione.setBackground(new Color(213,223,255));
		descrizioneFieldStrumentoDotazione.setEditable(false);
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		descrizioneFieldStrumentoDotazione.setBorder(BorderFactory.createCompoundBorder(border,
	            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		JScrollPane descrizioneStrumentoDotazioneTextScroll = new JScrollPane (descrizioneFieldStrumentoDotazione, 
				   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		descrizioneStrumentoDotazioneTextScroll.setBounds(650, 240, 270, 100);
		
		add(descrizioneStrumentoDotazioneTextScroll);

		// CALENDARIO (for prenotazione)
		calendarioLabel = new JLabel("SELEZIONA DATA");
		calendarioLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		calendarioLabel.setBounds(400, 291, 172, 100);
		add(calendarioLabel);
		
		jDateChooserStrumentoDotazione = new JDateChooser();
		jDateChooserStrumentoDotazione = new com.toedter.calendar.JDateChooser();
		jDateChooserStrumentoDotazione.getJCalendar().setMinSelectableDate(new Date());
		jDateChooserStrumentoDotazione.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		jDateChooserStrumentoDotazione.setDateFormatString("dd/MM/yyyy");
		jDateChooserStrumentoDotazione.setBounds(420, 360, 120, 20);
		add(jDateChooserStrumentoDotazione);
		
		// DA - A
		daOraLabel = new JLabel("DA:");
		daOraLabel.setBounds(400, 390, 50, 50);
		daOraLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(daOraLabel);
		
		aOraLabel = new JLabel("A:");
		aOraLabel.setBounds(520, 390, 50, 50);
		aOraLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(aOraLabel);
		
		String[] daOra = {"9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19"};
		String[] aOra = {"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
		
		final JComboBox<String> cbDaOra = new JComboBox<String>(daOra);
		cbDaOra.setBackground(new Color(213, 223, 255));
		cbDaOra.setBounds(400, 430, 50, 30);
    	cbDaOra.setVisible(true);
    	cbDaOra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				cbDaOra.setBackground(new Color(200, 215, 245));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				cbDaOra.setBackground(new Color(213, 223, 255));
			}
		});
		add(cbDaOra);
		
		final JComboBox<String> cbAOra = new JComboBox<String>(aOra);
		cbAOra.setBackground(new Color(213, 223, 255));
		cbAOra.setBounds(520, 430, 50, 30);
    	cbAOra.setVisible(true);
    	cbAOra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				cbAOra.setBackground(new Color(200, 215, 245));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				cbAOra.setBackground(new Color(213, 223, 255));
			}
		});
		add(cbAOra);

		// CONFERMA
		confermaBtn = new JButton("CONFERMA");
		confermaBtn.setFont(new Font("Tahoma", Font.BOLD, 24));
		confermaBtn.setBackground(new Color(171, 165, 255));
		confermaBtn.setOpaque(true);
		confermaBtn.setBorderPainted(true);
		confermaBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		confermaBtn.setBounds(396, 530, 180, 40);
		confermaBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				confermaBtn.setBackground(new Color(157,149,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				confermaBtn.setBackground(new Color(171, 165, 255));
			}
		});
		add(confermaBtn);

		// PRESET PART (combo box SETUP)
		// used for the first start of the app
		selezionaStrumentoLabel.setVisible(false);
		strumentiComboBox.setVisible(false);
		selezionaDotazioneLabel.setVisible(false);
		dotazioniComboBox.setVisible(false);
		
		strumentoDAO = new StrumentoImpl();
		dotazioneDAO = new DotazioneAccessoriaImpl();
		
		strumentoArray = new ArrayList<Strumento>();
		dotazioneArray = new ArrayList<DotazioneAccessoria>();

		strumentoArray = strumentoDAO.getStrumentiBasedOnSede(filteredPersonale.getCodice(), sediComboBoxEffettua.getSelectedItem().toString());
		dotazioneArray = dotazioneDAO.getDotazioniBasedOnSede(filteredPersonale.getCodice(), sediComboBoxEffettua.getSelectedItem().toString());
		
		strumentiStringArray = controller.fromArrayListToStringArray(strumentoArray);
		dotazioniStringArray = controller.fromArrayListToStringArray(dotazioneArray);
		
		strumentiComboBox.setModel(new DefaultComboBoxModel<String>(strumentiStringArray));
		dotazioniComboBox.setModel(new DefaultComboBoxModel<String>(dotazioniStringArray));
		
		// DYNAMIC

		// Show Strumento / Dotazione combo box based on button pressed
		selectStrumentoBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				isStrumento = true;
				
				controller.switchComboBoxBasedOnButton(selezionaStrumentoLabel, selezionaDotazioneLabel, strumentiComboBox, dotazioniComboBox);
				controller.switchDescrizioneBasedOnArrayList(strumentoArray, descrizioneFieldStrumentoDotazione, strumentiComboBox);
			
				if(jDateChooserStrumentoDotazione.getDate() != null)
					controller.changeAOraAndDaOraAfterPrenotazione(isStrumento, jDateChooserStrumentoDotazione.getDate(), strumentiComboBox, cbDaOra, cbAOra);
			}
		});

		selectDotazioneBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				isStrumento = false;
				
				controller.switchComboBoxBasedOnButton(selezionaDotazioneLabel, selezionaStrumentoLabel, dotazioniComboBox, strumentiComboBox);
				controller.switchDescrizioneBasedOnArrayList(dotazioneArray, descrizioneFieldStrumentoDotazione, dotazioniComboBox);
			
				if(jDateChooserStrumentoDotazione.getDate() != null)
					controller.changeAOraAndDaOraAfterPrenotazione(isStrumento, jDateChooserStrumentoDotazione.getDate(), dotazioniComboBox, cbDaOra, cbAOra);
			}
		});
		
		// Strumenti / Dotazioni combo box based on sede
		sediComboBoxEffettua.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				strumentoArray = strumentoDAO.getStrumentiBasedOnSede(filteredPersonale.getCodice(), sediComboBoxEffettua.getSelectedItem().toString());
				dotazioneArray = dotazioneDAO.getDotazioniBasedOnSede(filteredPersonale.getCodice(), sediComboBoxEffettua.getSelectedItem().toString());
				
				controller.changeComboBoxItemsBasedOnSede(strumentoArray, dotazioneArray, strumentiComboBox, dotazioniComboBox);
				controller.switchDescrizioneBasedOnSede(isStrumento, strumentoArray, dotazioneArray, 
						strumentiComboBox, dotazioniComboBox, descrizioneFieldStrumentoDotazione);
				
				if(jDateChooserStrumentoDotazione.getDate() != null)
					controller.changeAOraAndDaOraAfterPrenotazione(isStrumento, jDateChooserStrumentoDotazione.getDate(), strumentiComboBox, cbDaOra, cbAOra);
			}
		});

		prenotazioneDAO = new PrenotazioneImpl();
		prenotazioneArray = new ArrayList<Prenotazione>();

		// Descrizione based on combo box
		strumentiComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				descrizioneTextStrumentoDotazione = controller.getDescrizioneFromNome(strumentoArray, strumentiComboBox.getSelectedItem().toString());	
				descrizioneFieldStrumentoDotazione.setText(descrizioneTextStrumentoDotazione);
				
				if(jDateChooserStrumentoDotazione.getDate() != null)
					controller.changeAOraAndDaOraAfterPrenotazione(isStrumento, jDateChooserStrumentoDotazione.getDate(), strumentiComboBox, cbDaOra, cbAOra);
			}
		});
		
		dotazioniComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				descrizioneTextStrumentoDotazione = controller.getDescrizioneFromNome(dotazioneArray, dotazioniComboBox.getSelectedItem().toString());
				descrizioneFieldStrumentoDotazione.setText(descrizioneTextStrumentoDotazione);
				
				if(jDateChooserStrumentoDotazione.getDate() != null)
					controller.changeAOraAndDaOraAfterPrenotazione(isStrumento, jDateChooserStrumentoDotazione.getDate(), dotazioniComboBox, cbDaOra, cbAOra);
			}
		});
		
		// Change aOra based on daOra
		cbDaOra.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				controller.changeAOraBasedOnDaOra(cbDaOra, cbAOra);
			}
		});
		
		// CONFERMA prenotazione
		confermaBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				strumentoArray = strumentoDAO.getStrumentiBasedOnSede(filteredPersonale.getCodice(), sediComboBoxEffettua.getSelectedItem().toString());
				dotazioneArray = dotazioneDAO.getDotazioniBasedOnSede(filteredPersonale.getCodice(), sediComboBoxEffettua.getSelectedItem().toString());
				
				//controller.setCodStrAndCodDBasedOnSelectedItem(codStr, codD, strumentoArray, dotazioneArray, strumentiComboBox, dotazioniComboBox); NOT WORKING
				codStr = controller.getCodiceFromNome(strumentoArray, strumentiComboBox.getSelectedItem().toString());
				if(dotazioniComboBox.getSelectedItem() != null)
					codD = controller.getCodiceFromNome(dotazioneArray, dotazioniComboBox.getSelectedItem().toString());
				else
					codD = 0;
				
				controller.effettuaPrenotazione(jDateChooserStrumentoDotazione.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalTime.now(), 
						Integer.parseInt(cbAOra.getSelectedItem().toString()) - Integer.parseInt(cbDaOra.getSelectedItem().toString()), 
						Integer.parseInt(cbDaOra.getSelectedItem().toString()), Integer.parseInt(cbAOra.getSelectedItem().toString()), 
						codP, codStr, codD, filteredPersonale.getCodice(), isStrumento);							
				
				if(isStrumento)
					controller.changeAOraAndDaOraAfterPrenotazione(isStrumento, jDateChooserStrumentoDotazione.getDate(), strumentiComboBox, cbDaOra, cbAOra);
				else
					controller.changeAOraAndDaOraAfterPrenotazione(isStrumento, jDateChooserStrumentoDotazione.getDate(), dotazioniComboBox, cbDaOra, cbAOra);
			}
		});
		
		// Change daOra based on already booked "time-zone"
		jDateChooserStrumentoDotazione.getDateEditor().addPropertyChangeListener(
			new PropertyChangeListener() {
		        @Override
		        public void propertyChange(PropertyChangeEvent e) {
		        	if ("date".equals(e.getPropertyName())) {		
		        		controller.changeAOraAndDaOraAfterPrenotazione(isStrumento, (Date)e.getNewValue(), strumentiComboBox, cbDaOra, cbAOra);
		        	}
		        }
			});
	}

}
