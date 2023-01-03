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
import dao.PersonaleImpl;
import dao.StrumentoImpl;
import model.Personale;
import model.Sede;
import model.Strumento;

public class EffettuaPrenotazionePage extends JPanel {

	private JLabel selezionaStrumentoLabel, selezionaDotazioneLabel, selezionaSedeLabel, calendarioLabel, daOraLabel, aOraLabel;
	private JButton confermaBtn;
	private JTextArea descrizioneField;
	
	private ArrayList<Strumento> strumentoArray;
	private ArrayList<Personale> personaleArray;
	
	private String[] sedi;
	private String[] strumenti = {"ulala","stoh","SonoGhali"};
	private String[] dotazioni = {"ciao","ciao2","SonoGeolier"};
	
	private PersonaleImpl personaleDAO;
	private StrumentoImpl strumentoDAO;

	private Controller controller;
	
	private Personale filteredPersonale;
	
	private int countSedi = 0;
	private int countStrumenti = 0;
	private JDateChooser jDateChooser1; 
	
	private boolean isStrumento = false, isDotazione = false;

	public EffettuaPrenotazionePage() {
		personaleDAO = new PersonaleImpl();
		personaleArray = personaleDAO.populate();
		
		strumentoDAO = new StrumentoImpl();
		strumentoArray = new ArrayList<Strumento>();
		
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
		
		final JComboBox<String> cb1 = new JComboBox<String>(sedi);
		cb1.setBounds(355,80,250,40);
    	cb1.setVisible(true);
		add(cb1);
		
		cb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				strumentoArray = strumentoDAO.getStrumentiBasedOnSede(filteredPersonale.getCodice(), cb1.getSelectedItem().toString());
			}
		});

		JRadioButton strumentoRadioBtn = new JRadioButton("Strumento");
		strumentoRadioBtn.setBounds(365, 140, 100, 50);
		add(strumentoRadioBtn);
		
		strumentoRadioBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
					isStrumento = true;
					isDotazione = false;
					
					System.out.println("ciao1");
			}
		});
		
		JRadioButton dotazioneRadioBtn = new JRadioButton("Dotazione");
		dotazioneRadioBtn.setBounds(500, 140, 100, 50);
		add(dotazioneRadioBtn);
		
		dotazioneRadioBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
					isStrumento = false;
					isDotazione = true;

					System.out.println("ciao2");
			}
		});

		// SELEZIONA STRUMENTO
		selezionaStrumentoLabel = new JLabel("Seleziona strumento");
		selezionaStrumentoLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		selezionaStrumentoLabel.setBounds(375, 200, 220, 50);
		add(selezionaStrumentoLabel);
		
		//strumentoArray = strumentoDAO.getStrumentiBasedOnSede(filteredPersonale.getCodice());
		
		/*for(DotazioneAccessoria d : dotazioneArray) {
			countStrumenti += 1;
		}

		dotazione = new String[countStrumenti];
		for(int i = 0; i < strumentoArray.size(); ++i) {
			strumenti[i] = strumentoArray.get(i).getNome();
		}*/
		
		final JComboBox<String> cb2 = new JComboBox<String>(strumenti);
		cb2.setBounds(355,260,250,40);
		add(cb2);

		// SELEZIONA DOTAZIONE
		selezionaDotazioneLabel = new JLabel("Seleziona dotazione");
		selezionaDotazioneLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		selezionaDotazioneLabel.setBounds(375, 200, 220, 50);
		add(selezionaDotazioneLabel);
		
		//strumentoArray = strumentoDAO.getStrumentiBasedOnSede(filteredPersonale.getCodice());
		
		/*for(DotazioneAccessoria d : dotazioneArray) {
			countStrumenti += 1;
		}

		dotazione = new String[countStrumenti];
		for(int i = 0; i < strumentoArray.size(); ++i) {
			strumenti[i] = strumentoArray.get(i).getNome();
		}*/
		
		final JComboBox<String> cb3 = new JComboBox<String>(dotazioni);
		cb3.setBounds(355,260,250,40);
		add(cb3);

		strumentoRadioBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				selezionaStrumentoLabel.setVisible(true);
				cb2.setVisible(true);
				selezionaDotazioneLabel.setVisible(false);
				cb3.setVisible(false);
			}
		});

		dotazioneRadioBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				selezionaStrumentoLabel.setVisible(false);
				cb2.setVisible(false);
				selezionaDotazioneLabel.setVisible(true);
				cb3.setVisible(true);
			}
		});
		
		selezionaStrumentoLabel.setVisible(false);
		cb2.setVisible(false);
		selezionaDotazioneLabel.setVisible(false);
		cb3.setVisible(false);

		// CALENDARIO (per data prenotazione)
		calendarioLabel = new JLabel("Seleziona data");
		calendarioLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		calendarioLabel.setBounds(420, 285, 150, 100);
		add(calendarioLabel);
		
		jDateChooser1 = new JDateChooser();
		jDateChooser1 = new com.toedter.calendar.JDateChooser();
		jDateChooser1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		jDateChooser1.setDateFormatString("dd/MM/yyyy");
		jDateChooser1.setBounds(420, 370, 120, 20);
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

		// CONFERMA
		confermaBtn = new JButton("Conferma");
		confermaBtn.setFont(new Font("Tahoma", Font.BOLD, 24));
		confermaBtn.setBounds(396, 530, 180, 40);
		add(confermaBtn);

		confermaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				System.out.println(jDateChooser1.getDate().toString());
				
				System.out.println(isStrumento);
			}
		});
	}

}
