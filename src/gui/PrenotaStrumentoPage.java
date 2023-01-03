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
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import controller.Controller;
import dao.PersonaleImpl;
import dao.StrumentoImpl;
import model.Personale;
import model.Sede;
import model.Strumento;

public class PrenotaStrumentoPage extends JPanel {

	private JLabel selezionaStrumentoLabel, selezionaSedeLabel, calendarioLabel, daOraLabel, aOraLabel;
	private JButton confermaBtn;
	private JTextArea descrizioneField;
	
	private ArrayList<Strumento> strumentoArray;
	private ArrayList<Personale> personaleArray;
	
	private String[] sedi;
	private String[] strumenti;
	
	private PersonaleImpl personaleDAO;
	private StrumentoImpl strumentoDAO;

	private Controller controller;
	
	private Personale filteredPersonale;
	
	private int countSedi = 0;
	private int countStrumenti = 0;
	private JDateChooser jDateChooser1; 

	public PrenotaStrumentoPage() {
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

		// SELEZIONA STRUMENTO
		selezionaStrumentoLabel = new JLabel("Seleziona strumento");
		selezionaStrumentoLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		selezionaStrumentoLabel.setBounds(375, 125, 220, 50);
		add(selezionaStrumentoLabel);
		
		//strumentoArray = strumentoDAO.getStrumentiBasedOnSede(filteredPersonale.getCodice());
		
		for(Strumento s : strumentoArray) {
			countStrumenti += 1;
		}

		strumenti = new String[countStrumenti];
		for(int i = 0; i < strumentoArray.size(); ++i) {
			strumenti[i] = strumentoArray.get(i).getNome();
		}
		
		final JComboBox<String> cb2 = new JComboBox<String>(strumenti);
		cb2.setBounds(355,185,250,40);
    	cb2.setVisible(true);
		add(cb2);

		descrizioneField = new JTextArea();
		descrizioneField.setText(" Ahahahahah Ehi, gir pe Secondiglian \r\n Rind a n'Audi ner opac (rind a n'Audi ner opac) \r\n Ca m par n'astronav (ca m par n'astronav) \r\n Sceng o per na Balenciag (Bale) \r\n Ess vo nata Balenciag (Bale, Bale)");
		descrizioneField.setBounds(346, 250, 270, 100);
		add(descrizioneField);

		// CALENDARIO (per data prenotazione)
		calendarioLabel = new JLabel("Seleziona data");
		calendarioLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		calendarioLabel.setBounds(420, 335, 150, 100);
		add(calendarioLabel);
		
		jDateChooser1 = new JDateChooser();
		jDateChooser1 = new com.toedter.calendar.JDateChooser();
		jDateChooser1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		jDateChooser1.setDateFormatString("dd/MM/yyyy");
		jDateChooser1.setBounds(420, 410, 120, 20);
		add(jDateChooser1);
		
		// DA - A
		daOraLabel = new JLabel("DA:");
		daOraLabel.setBounds(400, 430, 50, 50);
		add(daOraLabel);
		
		aOraLabel = new JLabel("A:");
		aOraLabel.setBounds(520, 430, 50, 50);
		add(aOraLabel);
		
		String[] daOra = {"9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19"};
		String[] aOra = {"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
		
		final JComboBox<String> cbDaOra = new JComboBox<String>(daOra);
		cbDaOra.setBounds(400, 470, 50, 30);
    	cbDaOra.setVisible(true);
		add(cbDaOra);
		
		final JComboBox<String> cbAOra = new JComboBox<String>(aOra);
		cbAOra.setBounds(520, 470, 50, 30);
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
			}
		});
	}

}
