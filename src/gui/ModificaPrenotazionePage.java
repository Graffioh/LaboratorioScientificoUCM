package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.time.ZoneId;
import java.util.Date;
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
import javax.swing.border.LineBorder;

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
		selezionaSedeLabel = new JLabel("SELEZIONA SEDE");
		selezionaSedeLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		selezionaSedeLabel.setBounds(372, 20, 220, 50);
		add(selezionaSedeLabel);
		
		sediStringArray = controller.fromArrayListToStringArray(filteredPersonale.getSediDoveLavora());
		
		final JComboBox<String> sediComboBoxModifica = new JComboBox<String>(sediStringArray);
		sediComboBoxModifica.setBackground(new Color(213, 223, 255));
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
		
		if(!prenotazioneArray.isEmpty()) {
			prenotazioniStringArray = controller.fromArrayListToStringArray(prenotazioneArray);
		}
		
		final JComboBox<String> prenotazioniComboBox = new JComboBox<String>(prenotazioniStringArray);
		prenotazioniComboBox.setBackground(new Color(213, 223, 255));
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
		calendarioLabel = new JLabel("Seleziona nuova data");
		calendarioLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		calendarioLabel.setBounds(420, 265, 150, 100);
		add(calendarioLabel);
		
		jDateChooserPrenotazione = new JDateChooser();
		jDateChooserPrenotazione = new com.toedter.calendar.JDateChooser();
		jDateChooserPrenotazione.setBackground(new Color(213, 223, 255));
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
		cbDaOra.setBackground(new Color(213, 223, 255));
		cbDaOra.setBounds(400, 410, 50, 30);
    	cbDaOra.setVisible(true);
		add(cbDaOra);
		
		final JComboBox<String> cbAOra = new JComboBox<String>(aOra);
		cbAOra.setBackground(new Color(213, 223, 255));
		cbAOra.setBounds(520, 410, 50, 30);
    	cbAOra.setVisible(true);
		add(cbAOra);

		// MODIFICA
		modificaBtn = new JButton("Modifica");
		modificaBtn.setFont(new Font("Tahoma", Font.BOLD, 24));
		modificaBtn.setBackground(new Color(171, 165, 255));
		modificaBtn.setOpaque(true);
		modificaBtn.setBorderPainted(true);
		modificaBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		modificaBtn.setBounds(396, 490, 180, 40);
		add(modificaBtn);
		
		// ELIMINA
		eliminaBtn = new JButton("Elimina");
		eliminaBtn.setFont(new Font("Tahoma", Font.BOLD, 24));
		eliminaBtn.setBackground(new Color(171, 165, 255));
		eliminaBtn.setOpaque(true);
		eliminaBtn.setBorderPainted(true);
		eliminaBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		eliminaBtn.setBounds(396, 550, 180, 40);
		add(eliminaBtn);

		// PRESET PART
		// used for the first start of the app
		
		prenotazioneArray = prenotazioneDAO.getPrenotazioneBasedOnSede(filteredPersonale.getCodice(), sediComboBoxModifica.getSelectedItem().toString());
		
		if(!prenotazioneArray.isEmpty()) {
			prenotazioniStringArray = controller.fromArrayListToStringArray(prenotazioneArray);
			
			prenotazioniComboBox.setModel(new DefaultComboBoxModel<String>(prenotazioniStringArray));
			
			descrizioneFieldPrenotazione.setText(descrizioneTextPrenotazione);
		}
		
		// DYNAMIC PART
		addComponentListener(new ComponentAdapter () {
			public void componentShown ( ComponentEvent e ) {
				prenotazioneArray = prenotazioneDAO.getPrenotazioneBasedOnSede(filteredPersonale.getCodice(), sediComboBoxModifica.getSelectedItem().toString());
				
				if(!prenotazioneArray.isEmpty()) {
					prenotazioniStringArray = controller.fromArrayListToStringArray(prenotazioneArray);
					
					prenotazioniComboBox.setModel(new DefaultComboBoxModel<String>(prenotazioniStringArray));
					
					descrizioneFieldPrenotazione.setText(descrizioneTextPrenotazione);
				}
				
			}
		});

		sediComboBoxModifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				prenotazioneArray = prenotazioneDAO.getPrenotazioneBasedOnSede(filteredPersonale.getCodice(), sediComboBoxModifica.getSelectedItem().toString());
				
				if(!prenotazioneArray.isEmpty()) {
					prenotazioniStringArray = controller.fromArrayListToStringArray(prenotazioneArray);
					
					prenotazioniComboBox.setModel(new DefaultComboBoxModel<String>(prenotazioniStringArray));
					
					descrizioneFieldPrenotazione.setText(descrizioneTextPrenotazione);
				}
			}
		});
		
		modificaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				try {
					// Modifica prenotazione
					prenotazioneDAO.modificaPrenotazione(Integer.parseInt(prenotazioniComboBox.getSelectedItem().toString()), jDateChooserPrenotazione.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), jDateChooserPrenotazione.getDate().getTime(), Integer.parseInt(cbAOra.getSelectedItem().toString()) - Integer.parseInt(cbDaOra.getSelectedItem().toString()), Integer.parseInt(cbDaOra.getSelectedItem().toString()), Integer.parseInt(cbAOra.getSelectedItem().toString()));
				} catch (Exception ee) {
					ee.printStackTrace();
					JOptionPane.showMessageDialog(null, "Campi obbligatori mancanti, riprova.");
				}
			}
		});

		eliminaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){	
				prenotazioneArray = prenotazioneDAO.getPrenotazioneBasedOnSede(filteredPersonale.getCodice(), sediComboBoxModifica.getSelectedItem().toString());
			
				if(!prenotazioneArray.isEmpty()) {
					// Delete prenotazione
					prenotazioneDAO.eliminaPrenotazione(Integer.parseInt(prenotazioniComboBox.getSelectedItem().toString()));
					// Update the combo box
					prenotazioneArray = prenotazioneDAO.getPrenotazioneBasedOnSede(filteredPersonale.getCodice(), sediComboBoxModifica.getSelectedItem().toString());
					
					// if eliminaBtn delete the last prenotazione, then show an empty combobox otherwise update it
					if(prenotazioneArray.isEmpty()) {
						prenotazioniComboBox.setModel(new DefaultComboBoxModel<String>());
					} else {
						prenotazioniStringArray = controller.fromArrayListToStringArray(prenotazioneArray);
						prenotazioniComboBox.setModel(new DefaultComboBoxModel<String>(prenotazioniStringArray));
					}
					
					descrizioneFieldPrenotazione.setText(descrizioneTextPrenotazione);
				}
			}
		});
	}

}
