package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

import controller.Controller;
import dao.PersonaleImpl;
import dao.PrenotazioneImpl;
import model.Personale;
import model.Prenotazione;

public class ModificaPrenotazionePage extends JPanel {

	private JLabel selezionaPrenotazioneLabel, selezionaSedeLabel, calendarioLabel, daOraLabel, aOraLabel, infoPrenotazioneLabel;
	private JButton eliminaBtn, modificaBtn;
	private JTextArea descrizioneFieldPrenotazione;
	
	private PersonaleImpl personaleDAO;
	private ArrayList<Personale> personaleArray;
	
	private PrenotazioneImpl prenotazioneDAO;
	private ArrayList<Prenotazione> prenotazioneArray;
	
	private String[] sediStringArray = {"none"}, prenotazioniStringArray = {"none"};
	
	private String descrizioneTextPrenotazione = "Ciao";
	
	private Controller controller;
	
	private Personale filteredPersonale;
	
	private JDateChooser jDateChooserPrenotazione; 

	public ModificaPrenotazionePage() {
		// GUI
		setBackground(new Color(171, 191, 244));
		setLayout(null);
		
		personaleDAO = new PersonaleImpl();
		personaleArray = personaleDAO.populate();

		prenotazioneDAO = new PrenotazioneImpl();
		
		controller = new Controller();
		filteredPersonale = controller.filterPersonaleBasedOnMatricolaCodice(personaleArray, LoginPage.getMatricolaTextField(), LoginPage.getCodiceTextField());

		selezionaSedeLabel = new JLabel("SELEZIONA SEDE");
		selezionaSedeLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		selezionaSedeLabel.setBounds(372, 20, 220, 50);
		add(selezionaSedeLabel);
		
		sediStringArray = controller.fromArrayListToStringArray(filteredPersonale.getSediDoveLavora());
		
		final JComboBox<String> sediComboBoxModifica = new JComboBox<String>(sediStringArray);
		sediComboBoxModifica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				sediComboBoxModifica.setBackground(new Color(200, 215, 245));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				sediComboBoxModifica.setBackground(new Color(213, 223, 255));
			}
		});
		sediComboBoxModifica.setBackground(new Color(213, 223, 255));
		sediComboBoxModifica.setBounds(355,80,250,40);
    	sediComboBoxModifica.setVisible(true);
		add(sediComboBoxModifica);

		selezionaPrenotazioneLabel = new JLabel("SELEZIONA PRENOTAZIONE");
		selezionaPrenotazioneLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		selezionaPrenotazioneLabel.setBounds(315, 160, 371, 50);
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
    	prenotazioniComboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				prenotazioniComboBox.setBackground(new Color(200, 215, 245));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				prenotazioniComboBox.setBackground(new Color(213, 223, 255));
			}
		});
		add(prenotazioniComboBox);

		descrizioneFieldPrenotazione = new JTextArea();
		descrizioneFieldPrenotazione.setText(descrizioneTextPrenotazione);
		descrizioneFieldPrenotazione.setFont(new Font("Tahoma", Font.PLAIN, 13));
		descrizioneFieldPrenotazione.setBackground(new Color(213,223,255));
		descrizioneFieldPrenotazione.setLineWrap(true);
		descrizioneFieldPrenotazione.setWrapStyleWord(true);
		descrizioneFieldPrenotazione.setEditable(false);
		
		JScrollPane descrizionePrenotazioneTextScroll = new JScrollPane (descrizioneFieldPrenotazione, 
				   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		descrizionePrenotazioneTextScroll.setBounds(650, 210, 270, 100);
		
		add(descrizionePrenotazioneTextScroll);

		calendarioLabel = new JLabel("SELEZIONA NUOVA DATA");
		calendarioLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		calendarioLabel.setBounds(363, 281, 242, 100);
		add(calendarioLabel);
		
		jDateChooserPrenotazione = new JDateChooser();
		jDateChooserPrenotazione = new com.toedter.calendar.JDateChooser();
		jDateChooserPrenotazione.getJCalendar().setMinSelectableDate(new Date());
		jDateChooserPrenotazione.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		jDateChooserPrenotazione.setDateFormatString("dd/MM/yyyy");
		jDateChooserPrenotazione.setBounds(420, 350, 120, 20);
		add(jDateChooserPrenotazione);

		daOraLabel = new JLabel("DA:");
		daOraLabel.setBounds(400, 370, 50, 50);
		daOraLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(daOraLabel);
		
		aOraLabel = new JLabel("A:");
		aOraLabel.setBounds(520, 370, 50, 50);
		aOraLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(aOraLabel);
		
		String[] daOra = {"9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19"};
		String[] aOra = {"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
		
		final JComboBox<String> cbDaOra = new JComboBox<String>(daOra);
		cbDaOra.setBackground(new Color(213, 223, 255));
		cbDaOra.setBounds(400, 410, 50, 30);
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
		cbAOra.setBounds(520, 410, 50, 30);
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

		modificaBtn = new JButton("MODIFICA");
		modificaBtn.setFont(new Font("Tahoma", Font.BOLD, 24));
		modificaBtn.setBackground(new Color(171, 165, 255));
		modificaBtn.setOpaque(true);
		modificaBtn.setBorderPainted(true);
		modificaBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		modificaBtn.setBounds(396, 490, 180, 40);
		modificaBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				modificaBtn.setBackground(new Color(157,149,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				modificaBtn.setBackground(new Color(171, 165, 255));
			}
		});
		add(modificaBtn);

		eliminaBtn = new JButton("ELIMINA");
		eliminaBtn.setFont(new Font("Tahoma", Font.BOLD, 24));
		eliminaBtn.setBackground(new Color(171, 165, 255));
		eliminaBtn.setOpaque(true);
		eliminaBtn.setBorderPainted(true);
		eliminaBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		eliminaBtn.setBounds(396, 550, 180, 40);
		eliminaBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				eliminaBtn.setBackground(new Color(157,149,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				eliminaBtn.setBackground(new Color(171, 165, 255));
			}
		});
		add(eliminaBtn);
		
		infoPrenotazioneLabel = new JLabel("Informazioni Prenotazione");
		infoPrenotazioneLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		infoPrenotazioneLabel.setBounds(696, 170, 194, 50);
		add(infoPrenotazioneLabel);
		
		// DYNAMIC 
		
		// Get prenotazioni when the panel is visible
		addComponentListener(new ComponentAdapter () {
			@Override
			public void componentShown ( ComponentEvent e ) {
				prenotazioneArray = prenotazioneDAO.getPrenotazioneBasedOnSede(filteredPersonale.getCodice(), sediComboBoxModifica.getSelectedItem().toString());
				
				if(!prenotazioneArray.isEmpty()) {
					prenotazioniStringArray = controller.fromArrayListToStringArray(prenotazioneArray);
					
					prenotazioniComboBox.setModel(new DefaultComboBoxModel<String>(prenotazioniStringArray));
					
					controller.changeInformazioniPrenotazioneBasedOnPrenotazione(prenotazioneArray, prenotazioniComboBox, descrizioneFieldPrenotazione);
				} else {
					prenotazioniComboBox.setModel(new DefaultComboBoxModel<String>());
					
					descrizioneFieldPrenotazione.setText("");
				}
				
			}
		});

		// Change prenotazioni based on sede
		sediComboBoxModifica.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				prenotazioneArray = prenotazioneDAO.getPrenotazioneBasedOnSede(filteredPersonale.getCodice(), sediComboBoxModifica.getSelectedItem().toString());

				if(!prenotazioneArray.isEmpty()) {
					prenotazioniStringArray = controller.fromArrayListToStringArray(prenotazioneArray);
					
					prenotazioniComboBox.setModel(new DefaultComboBoxModel<String>(prenotazioniStringArray));
					
					controller.changeInformazioniPrenotazioneBasedOnPrenotazione(prenotazioneArray, prenotazioniComboBox, descrizioneFieldPrenotazione);
				} else {
					prenotazioniComboBox.setModel(new DefaultComboBoxModel<String>());
					
					descrizioneFieldPrenotazione.setText("");
				}
			}
		});
		
		// Change descrizione based on prenotazione
		prenotazioniComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){				
				if(!prenotazioneArray.isEmpty()) {
					controller.changeInformazioniPrenotazioneBasedOnPrenotazione(prenotazioneArray, prenotazioniComboBox, descrizioneFieldPrenotazione);
				}
			}
		});
		
		modificaBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				try {
					prenotazioneDAO.modificaPrenotazione(Integer.parseInt(prenotazioniComboBox.getSelectedItem().toString()), jDateChooserPrenotazione.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), jDateChooserPrenotazione.getDate().getTime(), Integer.parseInt(cbAOra.getSelectedItem().toString()) - Integer.parseInt(cbDaOra.getSelectedItem().toString()), Integer.parseInt(cbDaOra.getSelectedItem().toString()), Integer.parseInt(cbAOra.getSelectedItem().toString()));
				
					prenotazioneArray = prenotazioneDAO.getPrenotazioneBasedOnSede(filteredPersonale.getCodice(), sediComboBoxModifica.getSelectedItem().toString());
				if(!prenotazioneArray.isEmpty()) {				
					controller.changeInformazioniPrenotazioneBasedOnPrenotazione(prenotazioneArray, prenotazioniComboBox, descrizioneFieldPrenotazione);
				} else {
					prenotazioniComboBox.setModel(new DefaultComboBoxModel<String>());
					
					descrizioneFieldPrenotazione.setText("");
				}
				
				} catch (Exception ee) {
					ee.printStackTrace();
					JOptionPane.showMessageDialog(null, "Campi obbligatori mancanti, riprova.");
				}
			}
		});

		eliminaBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){	
				
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
					
					controller.switchDescrizioneBasedOnArrayList(prenotazioneArray, descrizioneFieldPrenotazione, prenotazioniComboBox);
				}
			}
		});
	}

}
