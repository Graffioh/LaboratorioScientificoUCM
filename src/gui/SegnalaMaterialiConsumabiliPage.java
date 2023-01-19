package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.border.LineBorder;

import model.DotazioneAccessoria;
import dao.DotazioneAccessoriaImpl;

import javax.swing.JOptionPane;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import controller.Controller;

public class SegnalaMaterialiConsumabiliPage extends JPanel {
	
	JComboBox segnalaMaterialiConsumabiliComboBox;
	
	JLabel segnalaMaterialiConsumabiliLabel;

	JList listMaterialiConsumabiliAggiunti;
	DefaultListModel<String> dfl;
	
	JButton aggiungiMCBtn, confermaMCBtn;

	ArrayList<String> materialeConsumabileArray;
	DotazioneAccessoriaImpl dotazioneDAO;

	Controller controller;

	String[] materialiConsumabiliStrArray;
	
	public SegnalaMaterialiConsumabiliPage() {

		setBackground(new Color(171, 191, 244));
		setLayout(null);
		
		segnalaMaterialiConsumabiliLabel = new JLabel("SELEZIONA MATERIALI CONSUMABILI");
		segnalaMaterialiConsumabiliLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		segnalaMaterialiConsumabiliLabel.setBounds(246, 80, 566, 50);
		add(segnalaMaterialiConsumabiliLabel);

		controller = new Controller();
		materialeConsumabileArray = new ArrayList<String>();

		dotazioneDAO = new DotazioneAccessoriaImpl();
		materialeConsumabileArray = dotazioneDAO.getMaterialiConsumabili();

		materialiConsumabiliStrArray = controller.fromArrayListToStringArray(materialeConsumabileArray);
		
		segnalaMaterialiConsumabiliComboBox = new JComboBox<String>(materialiConsumabiliStrArray);
		segnalaMaterialiConsumabiliComboBox.setBounds(355,140,250,40);
		segnalaMaterialiConsumabiliComboBox.setBackground(new Color(213, 223, 255));
		segnalaMaterialiConsumabiliComboBox.setVisible(true);
    	segnalaMaterialiConsumabiliComboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				segnalaMaterialiConsumabiliComboBox.setBackground(new Color(200, 215, 245));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				segnalaMaterialiConsumabiliComboBox.setBackground(new Color(213, 223, 255));
			}
		});
		add(segnalaMaterialiConsumabiliComboBox);
		
		aggiungiMCBtn = new JButton("AGGIUNGI");
		aggiungiMCBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		aggiungiMCBtn.setBackground(new Color(171, 165, 255));
		aggiungiMCBtn.setOpaque(true);
		aggiungiMCBtn.setBorderPainted(true);
		aggiungiMCBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		aggiungiMCBtn.setBounds(615, 149, 142, 25);
		aggiungiMCBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				aggiungiMCBtn.setBackground(new Color(157,149,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				aggiungiMCBtn.setBackground(new Color(171, 165, 255));
			}
		});
		add(aggiungiMCBtn);

		listMaterialiConsumabiliAggiunti = new JList<String>();
		listMaterialiConsumabiliAggiunti.setBounds(200, 300, 600, 300);
		listMaterialiConsumabiliAggiunti.setBackground(new Color(213, 223, 255));
		add(listMaterialiConsumabiliAggiunti);
		
		confermaMCBtn = new JButton("SEGNALA");
		confermaMCBtn.setFont(new Font("Tahoma", Font.BOLD, 24));
		confermaMCBtn.setBackground(new Color(171, 165, 255));
		confermaMCBtn.setOpaque(true);
		confermaMCBtn.setBorderPainted(true);
		confermaMCBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		confermaMCBtn.setBounds(396, 630, 180, 40);
		confermaMCBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				confermaMCBtn.setBackground(new Color(157,149,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				confermaMCBtn.setBackground(new Color(171, 165, 255));
			}
		});
		add(confermaMCBtn);
		
		dfl = new DefaultListModel<String>();
		
		addComponentListener(new ComponentAdapter () {
			@Override
			public void componentShown ( ComponentEvent e ) {
				dfl.clear();
			}
		});

		aggiungiMCBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				controller.updateDflBasedOnComboBox(dfl, segnalaMaterialiConsumabiliComboBox.getSelectedItem().toString());
				
				listMaterialiConsumabiliAggiunti.setModel(dfl);
			}
		});
		
		confermaMCBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				controller.writeSegnalazioneInFile(dfl);
			}
		});
	}
	
}