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
import model.DotazioneAccessoria;
import model.Personale;
import model.Sede;
import model.Strumento;

public class ModificaPrenotazionePage extends JPanel {

	private JLabel selezionaPrenotazioneLabel, selezionaSedeLabel, calendarioLabel, daOraLabel, aOraLabel;
	private JButton confermaBtn;
	
	private ArrayList<Personale> personaleArray;
	
	private String[] sedi;
	private String[] prenotazioni = {"1","2","69"};
	
	private PersonaleImpl personaleDAO;

	private Controller controller;
	
	private Personale filteredPersonale;
	
	private int countSedi = 0;
	private int countStrumenti = 0;
	private JDateChooser jDateChooser1; 

	public ModificaPrenotazionePage() {
		personaleDAO = new PersonaleImpl();
		personaleArray = personaleDAO.populate();
		
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

		// SELEZIONA PRENOTAZIONE
		selezionaPrenotazioneLabel = new JLabel("Seleziona prenotazione");
		selezionaPrenotazioneLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		selezionaPrenotazioneLabel.setBounds(360, 160, 260, 50);
		selezionaPrenotazioneLabel.setVisible(true);
		add(selezionaPrenotazioneLabel);
		
		final JComboBox<String> cb2 = new JComboBox<String>(prenotazioni);
		cb2.setBounds(355,220,250,40);
    	cb2.setVisible(true);
		add(cb2);

		// CALENDARIO (per data prenotazione)
		calendarioLabel = new JLabel("Seleziona data");
		calendarioLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		calendarioLabel.setBounds(420, 265, 150, 100);
		add(calendarioLabel);
		
		jDateChooser1 = new JDateChooser();
		jDateChooser1 = new com.toedter.calendar.JDateChooser();
		jDateChooser1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		jDateChooser1.setDateFormatString("dd/MM/yyyy");
		jDateChooser1.setBounds(420, 350, 120, 20);
		add(jDateChooser1);
		
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
		confermaBtn = new JButton("Modifica");
		confermaBtn.setFont(new Font("Tahoma", Font.BOLD, 24));
		confermaBtn.setBounds(396, 490, 180, 40);
		add(confermaBtn);

		confermaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				System.out.println(jDateChooser1.getDate().toString());
			}
		});
		
		// ELIMINA
		confermaBtn = new JButton("Elimina");
		confermaBtn.setFont(new Font("Tahoma", Font.BOLD, 24));
		confermaBtn.setBounds(396, 550, 180, 40);
		add(confermaBtn);

		confermaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				System.out.println(jDateChooser1.getDate().toString());
			}
		});
	}

}
