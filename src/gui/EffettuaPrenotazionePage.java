package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import controller.Controller;
import dao.DotazioneAccessoriaImpl;
import dao.PersonaleImpl;
import dao.StrumentoImpl;
import model.DotazioneAccessoria;
import model.Personale;
import model.Sede;
import model.Strumento;

public class EffettuaPrenotazionePage extends JPanel {

	private JLabel selezionaStrumentoLabel, selezionaDotazioneLabel, selezionaSedeLabel, calendarioLabel, daOraLabel, aOraLabel;
	private JButton selectStrumentoBtn, selectDotazioneBtn, confermaBtn;
	private JTextArea descrizioneField;
	private JDateChooser jDateChooser1; 
	
	private ArrayList<Strumento> strumentoArray;
	private ArrayList<DotazioneAccessoria> dotazioneArray;
	private ArrayList<Personale> personaleArray;
	
	private String[] sedi;
	private String[] strumenti = {"ulala","stoh","SonoGhali"};
	private String[] dotazioni = {"ciao","ciao2","SonoGeolier"};
	
	private PersonaleImpl personaleDAO;
	private StrumentoImpl strumentoDAO;
	private DotazioneAccessoriaImpl dotazioneDAO;

	private Controller controller;
	
	private Personale filteredPersonale;
	
	private int countSedi = 0, countStrumenti = 0, countDotazioni = 0, countOra = 0;
	private boolean isStrumento = false, isDotazione = false;

	public EffettuaPrenotazionePage() {
		personaleDAO = new PersonaleImpl();
		personaleArray = personaleDAO.populate();
		
		strumentoDAO = new StrumentoImpl();
		strumentoArray = new ArrayList<Strumento>();
		
		dotazioneDAO = new DotazioneAccessoriaImpl();
		dotazioneArray = new ArrayList<DotazioneAccessoria>();
		
		controller = new Controller();
		filteredPersonale = controller.filterBasedOnMatricolaCodice(personaleArray, LoginPage.getMatricolaTextField(), LoginPage.getCodiceTextField());
		
		setLayout(null);

		// SELEZIONA SEDE
		selezionaSedeLabel = new JLabel("Seleziona sede");
		selezionaSedeLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		selezionaSedeLabel.setBounds(400, 20, 220, 50);
		add(selezionaSedeLabel);
		
		for(Sede s : filteredPersonale.getSediDoveLavora()) {
			countSedi += 1;
		}

		sedi = new String[countSedi];
		for(int i = 0; i < filteredPersonale.getSediDoveLavora().size(); ++i) {
			sedi[i] = filteredPersonale.getSediDoveLavora().get(i).getNome();
		}
		
		final JComboBox<String> sediComboBox = new JComboBox<String>(sedi);
		sediComboBox.setBounds(355,80,250,40);
    	sediComboBox.setVisible(true);
		add(sediComboBox);
		
		selectStrumentoBtn = new JButton("Strumento");
		selectStrumentoBtn.setBounds(365, 140, 100, 35);
		add(selectStrumentoBtn);
		
		selectDotazioneBtn = new JButton("Dotazione");
		selectDotazioneBtn.setBounds(500, 140, 100, 35);
		add(selectDotazioneBtn);
		
		// SELEZIONA STRUMENTO
		selezionaStrumentoLabel = new JLabel("Seleziona strumento");
		selezionaStrumentoLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		selezionaStrumentoLabel.setBounds(372, 200, 220, 50);
		add(selezionaStrumentoLabel);
		
		final JComboBox<String> strumentiComboBox = new JComboBox<String>(strumenti);
		strumentiComboBox.setBounds(355,260,250,40);
		add(strumentiComboBox);

		// SELEZIONA DOTAZIONE
		selezionaDotazioneLabel = new JLabel("Seleziona dotazione");
		selezionaDotazioneLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		selezionaDotazioneLabel.setBounds(375, 200, 220, 50);
		add(selezionaDotazioneLabel);
		
		final JComboBox<String> dotazioniComboBox = new JComboBox<String>(dotazioni);
		dotazioniComboBox.setBounds(355,260,250,40);
		add(dotazioniComboBox);
		
		// PRESET used for the first start of the app
		selezionaStrumentoLabel.setVisible(false);
		strumentiComboBox.setVisible(false);
		selezionaDotazioneLabel.setVisible(false);
		dotazioniComboBox.setVisible(false);

		strumentoArray = strumentoDAO.getStrumentiBasedOnSede(filteredPersonale.getCodice(), sediComboBox.getSelectedItem().toString());
		dotazioneArray = dotazioneDAO.getDotazioniBasedOnSede(filteredPersonale.getCodice(), sediComboBox.getSelectedItem().toString());
		
		countStrumenti = 0;
		for(Strumento s : strumentoArray) {
			countStrumenti += 1;
		}

		strumenti = new String[countStrumenti];
		for(int i = 0; i < strumentoArray.size(); ++i) {
			strumenti[i] = strumentoArray.get(i).getNome();
		}

		countDotazioni = 0;
		for(DotazioneAccessoria d : dotazioneArray) {
			countDotazioni += 1;
		}

		dotazioni = new String[countDotazioni];
		for(int i = 0; i < dotazioneArray.size(); ++i) {
			dotazioni[i] = dotazioneArray.get(i).getNome();
		}
		
		strumentiComboBox.setModel(new DefaultComboBoxModel<String>(strumenti));
		dotazioniComboBox.setModel(new DefaultComboBoxModel<String>(dotazioni));

		// ACTION LISTENERS for dynamic content
		selectStrumentoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				selezionaStrumentoLabel.setVisible(true);
				strumentiComboBox.setVisible(true);
				selezionaDotazioneLabel.setVisible(false);
				dotazioniComboBox.setVisible(false);
				
				isStrumento = true;
				isDotazione = false;
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
			}
		});

		// Change dynamically the content of strumento/dotazione combo box based on selected sede
		sediComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				strumentoArray = strumentoDAO.getStrumentiBasedOnSede(filteredPersonale.getCodice(), sediComboBox.getSelectedItem().toString());
				dotazioneArray = dotazioneDAO.getDotazioniBasedOnSede(filteredPersonale.getCodice(), sediComboBox.getSelectedItem().toString());
				
				countStrumenti = 0;
				for(Strumento s : strumentoArray) {
					countStrumenti += 1;
				}

				strumenti = new String[countStrumenti];
				for(int i = 0; i < strumentoArray.size(); ++i) {
					strumenti[i] = strumentoArray.get(i).getNome();
				}
				
				countDotazioni = 0;
				for(DotazioneAccessoria d : dotazioneArray) {
					countDotazioni += 1;
				}

				dotazioni = new String[countDotazioni];
				for(int i = 0; i < dotazioneArray.size(); ++i) {
					dotazioni[i] = dotazioneArray.get(i).getNome();
				}
				
				strumentiComboBox.setModel(new DefaultComboBoxModel<String>(strumenti));
				dotazioniComboBox.setModel(new DefaultComboBoxModel<String>(dotazioni));
			}
		});
		
		// DESCRIZIONE STRUMENTO
		descrizioneField = new JTextArea();
		descrizioneField.setText(" Ahahahahah Ehi, gir pe Secondiglian \r\n Rind a n'Audi ner opac (rind a n'Audi ner opac) \r\n Ca m par n'astronav (ca m par n'astronav) \r\n Sceng o per na Balenciag (Bale) \r\n Ess vo nata Balenciag (Bale, Bale)");
		descrizioneField.setBounds(650, 240, 270, 100);
		add(descrizioneField);

		// CALENDARIO (per data prenotazione)
		calendarioLabel = new JLabel("Seleziona data");
		calendarioLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		calendarioLabel.setBounds(420, 285, 150, 100);
		add(calendarioLabel);
		
		jDateChooser1 = new JDateChooser();
		jDateChooser1 = new com.toedter.calendar.JDateChooser();
		jDateChooser1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		jDateChooser1.setDateFormatString("dd/MM/yyyy");
		jDateChooser1.setBounds(420, 360, 120, 20);
		add(jDateChooser1);
		
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
		
		
		cbDaOra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				String[] aOraArray;
				
				countOra = 0;
				for(Integer i = Integer.parseInt(cbDaOra.getSelectedItem().toString()); i < 21; ++i) {
					countOra += 1;
				}
				
				System.out.println(countOra);
				
				aOraArray = new String[countOra - 1];
				Integer daOra = Integer.parseInt(cbDaOra.getSelectedItem().toString());
				for(Integer i = daOra + 1; i < 21; ++i) {
					aOraArray[i - daOra - 1] = i.toString();
				}
				
				cbAOra.setModel(new DefaultComboBoxModel<String>(aOraArray));
			}
		});

		// CONFERMA
		confermaBtn = new JButton("Conferma");
		confermaBtn.setFont(new Font("Tahoma", Font.BOLD, 24));
		confermaBtn.setBounds(396, 530, 180, 40);
		add(confermaBtn);

		confermaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				//
			}
		});
	}

}
