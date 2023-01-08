package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Date;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.toedter.calendar.JDateChooser;

import controller.Controller;
import dao.PersonaleImpl;
import dao.PrenotazioneImpl;
import dao.StrumentoImpl;
import model.DotazioneAccessoria;
import model.Personale;
import model.Prenotazione;
import model.Sede;
import model.Strumento;

public class ModificaPrenotazionePage extends JPanel {

	private JLabel selezionaPrenotazioneLabel, selezionaSedeLabel, calendarioLabel, daOraLabel, aOraLabel;
	private JButton eliminaBtn, modificaBtn;
	private JTextArea descrizioneFieldPrenotazione;
	
	private ArrayList<Personale> personaleArray;
	private ArrayList<Prenotazione> prenotazioneArray;
	
	ArrayList<String> sedi, dotazioni, prenotazioni;
	String[] sediStringArray = {"none"}, prenotazioniStringArray = {"none"}, dotazioniStringArray = {"none"};
	
	private String descrizioneTextPrenotazione = "Ciao";
	
	private PersonaleImpl personaleDAO;
	private PrenotazioneImpl prenotazioneDAO;

	private Controller controller;
	
	private Personale filteredPersonale;
	
	private JDateChooser jDateChooserPrenotazione; 

	public ModificaPrenotazionePage() {
		personaleDAO = new PersonaleImpl();
		personaleArray = personaleDAO.populate();

		prenotazioneDAO = new PrenotazioneImpl();
		
		controller = new Controller();
		filteredPersonale = controller.filterBasedOnMatricolaCodice(personaleArray, LoginPage.getMatricolaTextField(), LoginPage.getCodiceTextField());
		
		setBackground(new Color(171, 191, 244));
		setLayout(null);

		// SELEZIONA SEDE
		selezionaSedeLabel = new JLabel("Seleziona sede");
		selezionaSedeLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		selezionaSedeLabel.setBounds(400, 20, 220, 50);
		add(selezionaSedeLabel);
		
		sediStringArray = controller.fromArrayListToStringArray(filteredPersonale.getSediDoveLavora());
		
		final JComboBox<String> sediComboBoxModifica = new JComboBox<String>(sediStringArray);
		sediComboBoxModifica.setBounds(355,80,250,40);
    	sediComboBoxModifica.setVisible(true);
		add(sediComboBoxModifica);

		// SELEZIONA PRENOTAZIONE
		selezionaPrenotazioneLabel = new JLabel("Seleziona prenotazione");
		selezionaPrenotazioneLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		selezionaPrenotazioneLabel.setBounds(360, 160, 260, 50);
		selezionaPrenotazioneLabel.setVisible(true);
		add(selezionaPrenotazioneLabel);
		
		prenotazioneArray = prenotazioneDAO.getPrenotazioneBasedOnSede(filteredPersonale.getCodice(), sediComboBoxModifica.getSelectedItem().toString());
	
		prenotazioniStringArray = controller.fromArrayListToStringArray(prenotazioneArray);
		
		final JComboBox<String> prenotazioniComboBox = new JComboBox<String>(prenotazioniStringArray);
		prenotazioniComboBox.setBounds(355,220,250,40);
    	prenotazioniComboBox.setVisible(true);
		add(prenotazioniComboBox);

		descrizioneFieldPrenotazione = new JTextArea();
		descrizioneFieldPrenotazione.setText(descrizioneTextPrenotazione);
		//descrizioneField.setBounds(650, 240, 270, 100);
		descrizioneFieldPrenotazione.setLineWrap(true);
		descrizioneFieldPrenotazione.setWrapStyleWord(true);
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		descrizioneFieldPrenotazione.setBorder(BorderFactory.createCompoundBorder(border,
	            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		JScrollPane descrizionePrenotazioneTextScroll = new JScrollPane (descrizioneFieldPrenotazione, 
				   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		descrizionePrenotazioneTextScroll.setBounds(650, 240, 270, 100);
		
		add(descrizionePrenotazioneTextScroll);

		// CALENDARIO (per data prenotazione)
		calendarioLabel = new JLabel("Seleziona data");
		calendarioLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		calendarioLabel.setBounds(420, 265, 150, 100);
		add(calendarioLabel);
		
		jDateChooserPrenotazione = new JDateChooser();
		jDateChooserPrenotazione = new com.toedter.calendar.JDateChooser();
		jDateChooserPrenotazione.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		jDateChooserPrenotazione.setDateFormatString("dd/MM/yyyy");
		jDateChooserPrenotazione.setBounds(420, 350, 120, 20);
		add(jDateChooserPrenotazione);
		
		// DA - A
		daOraLabel = new JLabel("DA:");
		daOraLabel.setBounds(400, 370, 50, 50);
		add(daOraLabel);
		
		aOraLabel = new JLabel("A:");
		aOraLabel.setBounds(520, 370, 50, 50);
		add(aOraLabel);
		
		String[] daOra = {"9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19"};
		String[] aOra = {"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
		
		final JComboBox<String> cbDaOra = new JComboBox<String>(daOra);
		cbDaOra.setBounds(400, 410, 50, 30);
    	cbDaOra.setVisible(true);
		add(cbDaOra);
		
		final JComboBox<String> cbAOra = new JComboBox<String>(aOra);
		cbAOra.setBounds(520, 410, 50, 30);
    	cbAOra.setVisible(true);
		add(cbAOra);

		// MODIFICA
		modificaBtn = new JButton("Modifica");
		modificaBtn.setFont(new Font("Tahoma", Font.BOLD, 24));
		modificaBtn.setBounds(396, 490, 180, 40);
		add(modificaBtn);

		modificaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				System.out.println(jDateChooserPrenotazione.getDate().toString());
			}
		});
		
		// ELIMINA
		eliminaBtn = new JButton("Elimina");
		eliminaBtn.setFont(new Font("Tahoma", Font.BOLD, 24));
		eliminaBtn.setBounds(396, 550, 180, 40);
		add(eliminaBtn);

		// PRESET PART
		// used for the first start of the app
		
		prenotazioneArray = prenotazioneDAO.getPrenotazioneBasedOnSede(filteredPersonale.getCodice(), sediComboBoxModifica.getSelectedItem().toString());
		
		prenotazioniStringArray = controller.fromArrayListToStringArray(prenotazioneArray);
		
		prenotazioniComboBox.setModel(new DefaultComboBoxModel<String>(prenotazioniStringArray));
		
		descrizioneFieldPrenotazione.setText(descrizioneTextPrenotazione);
		
		// DYNAMIC PART
		addComponentListener(new ComponentAdapter () {
			public void componentShown ( ComponentEvent e ) {
				prenotazioneArray = prenotazioneDAO.getPrenotazioneBasedOnSede(filteredPersonale.getCodice(), sediComboBoxModifica.getSelectedItem().toString());
				
				prenotazioniStringArray = controller.fromArrayListToStringArray(prenotazioneArray);
				
				prenotazioniComboBox.setModel(new DefaultComboBoxModel<String>(prenotazioniStringArray));
				
				descrizioneFieldPrenotazione.setText(descrizioneTextPrenotazione);
			}
		});

		sediComboBoxModifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				prenotazioneArray = prenotazioneDAO.getPrenotazioneBasedOnSede(filteredPersonale.getCodice(), sediComboBoxModifica.getSelectedItem().toString());
				
				prenotazioniStringArray = controller.fromArrayListToStringArray(prenotazioneArray);
				
				prenotazioniComboBox.setModel(new DefaultComboBoxModel<String>(prenotazioniStringArray));
				
				descrizioneFieldPrenotazione.setText(descrizioneTextPrenotazione);
			}
		});

		eliminaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				// Delete prenotazione
				prenotazioneDAO.eliminaPrenotazione(Integer.parseInt(prenotazioniComboBox.getSelectedItem().toString()));

				// Update the combo box
				prenotazioneArray = prenotazioneDAO.getPrenotazioneBasedOnSede(filteredPersonale.getCodice(), sediComboBoxModifica.getSelectedItem().toString());
				
				prenotazioniStringArray = controller.fromArrayListToStringArray(prenotazioneArray);
				
				prenotazioniComboBox.setModel(new DefaultComboBoxModel<String>(prenotazioniStringArray));
				
				descrizioneFieldPrenotazione.setText(descrizioneTextPrenotazione);
			}
		});
	}

}
