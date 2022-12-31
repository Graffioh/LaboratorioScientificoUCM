package gui;

import javax.swing.JPanel;

import dao.DotazioneAccessoriaImpl;
import dao.PersonaleImpl;
import dao.StrumentoImpl;
import model.DotazioneAccessoria;
import model.Personale;
import model.Strumento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.DefaultListModel;
import java.lang.String;
import java.util.ArrayList;

public class HomePage extends JPanel {
	
	private JList listaStrumenti, listaDotazioni;
	private JLabel labelListaStrumenti, labelListaDotazioni;
	
	private DefaultListModel<String> l1;
	private DefaultListModel<String> l2;
	
	private StrumentoImpl strumentoDAO;
	private ArrayList<Strumento> strumentoArray;
	
	private DotazioneAccessoriaImpl dotazioneDAO;
	private ArrayList<DotazioneAccessoria> dotazioneArray;
	
	public HomePage() {
		setLayout(null);
		
		strumentoDAO = new StrumentoImpl();
		strumentoArray = strumentoDAO.populate();
		
		l1 = new DefaultListModel<String>();
		for(int i = 0; i < strumentoArray.size(); ++i) {
			l1.add(i, strumentoArray.get(i).getNome());
		}
		
		listaStrumenti = new JList<String>(l1);
		listaStrumenti.setBounds(30, 100, 450, 500);
		add(listaStrumenti);

		labelListaStrumenti = new JLabel("Strumenti");
		labelListaStrumenti.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelListaStrumenti.setBounds(220, 80, 90, 15);
		add(labelListaStrumenti);
		
		dotazioneDAO = new DotazioneAccessoriaImpl();
		dotazioneArray = dotazioneDAO.populate();
		
		l2 = new DefaultListModel<String>();
		for(int i = 0; i < dotazioneArray.size(); ++i) {
			l2.add(i, dotazioneArray.get(i).getNome());
		}
		
		listaDotazioni = new JList<String>(l2);
		listaDotazioni.setBounds(520, 100, 450, 500);
		add(listaDotazioni);

		labelListaDotazioni = new JLabel("Dotazioni Accessorie");
		labelListaDotazioni.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelListaDotazioni.setBounds(675, 80, 200, 15);
		add(labelListaDotazioni);
	}
}
