package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import dao.DotazioneAccessoriaImpl;
import dao.StrumentoImpl;
import model.DotazioneAccessoria;
import model.Strumento;

import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Color;
import java.awt.Font;
import javax.swing.DefaultListModel;
import java.lang.String;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.Controller;

public class HomePage extends JPanel {
	
	private JLabel listaStrumentiLabel, listaDotazioniLabel;
	private JTable strumentiTable, dotazioniTable;
	private JScrollPane strumentiScrollPane, dotazioniScrollPane;
	
	private StrumentoImpl strumentoDAO;
	private ArrayList<Strumento> strumentoArray;
	
	private DotazioneAccessoriaImpl dotazioneDAO;
	private ArrayList<DotazioneAccessoria> dotazioneArray;
	
	private Controller controller;

	public HomePage() {
		setBackground(new Color(171, 191, 244));
		setLayout(null);
		
		controller = new Controller();
		
		strumentoDAO = new StrumentoImpl();
		strumentoArray = strumentoDAO.populate();
		
		listaStrumentiLabel = new JLabel("STRUMENTI");
		listaStrumentiLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		listaStrumentiLabel.setBounds(180, 59, 171, 36);
		add(listaStrumentiLabel);
		
		strumentiTable = new JTable();
		strumentiTable.setBackground(new Color(213, 223, 255));
		strumentiTable.setBounds(30, 100, 450, 500);
		strumentiTable.setFont(new Font("Tahoma", Font.PLAIN, 15));
		strumentiTable.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 14));
		strumentiTable.setDefaultEditor(Object.class, null);
		
		strumentiScrollPane = new JScrollPane(strumentiTable);
		strumentiScrollPane.setBounds(30, 100, 450, 500);
		strumentiScrollPane.getViewport().setBackground(new Color(213, 223, 255));
		add(strumentiScrollPane);
		
		controller.populateHomepageTable(strumentoArray, strumentiTable);
		
		dotazioneDAO = new DotazioneAccessoriaImpl();
		dotazioneArray = dotazioneDAO.populate();
		
		listaDotazioniLabel = new JLabel("DOTAZIONI ACCESSORIE");
		listaDotazioniLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		listaDotazioniLabel.setBounds(589, 59, 321, 36);
		add(listaDotazioniLabel);
		
		dotazioniTable = new JTable();
		dotazioniTable.setBackground(new Color(213, 223, 255));
		dotazioniTable.setBounds(520, 100, 450, 500);
		dotazioniTable.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dotazioniTable.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 14));
		dotazioniTable.setDefaultEditor(Object.class, null);
		
		dotazioniScrollPane = new JScrollPane(dotazioniTable);
		dotazioniScrollPane.setBounds(520, 100, 450, 500);
		dotazioniScrollPane.getViewport().setBackground(new Color(213, 223, 255));
		add(dotazioniScrollPane);
		
		controller.populateHomepageTable(dotazioneArray, dotazioniTable);

	}
	
}
