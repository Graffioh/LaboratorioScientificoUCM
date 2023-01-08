package gui;

import javax.swing.JPanel;
import javax.swing.JTextArea;

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

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import java.lang.String;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class RiepilogoStrumentiPage extends JPanel {
	
	private JTextArea listaStrumenti, listaDotazioni;
	private JLabel listaStrumentiLabel, listaDotazioniLabel;
	
	private JButton consumoMensileBtn, riepilogoAnnualeBtn, riepilogoMensileBtn, consumoAnnualeBtn;
	
	public RiepilogoStrumentiPage() {
		setBackground(new Color(171, 191, 244));
		setLayout(null);
		
		listaStrumenti = new JTextArea();
		listaStrumenti.setBounds(42, 205, 368, 500);
		add(listaStrumenti);

		listaStrumentiLabel = new JLabel("RIEPILOGO");
		listaStrumentiLabel.setForeground(new Color(0, 0, 0));
//		listaStrumentiLabel.setBackground(new Color(171, 165, 255));
		listaStrumentiLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		listaStrumentiLabel.setBounds(152, 73, 150, 54);
//		listaStrumentiLabel.setOpaque(true);
//		listaStrumentiLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(listaStrumentiLabel);
		
		listaDotazioni = new JTextArea();
		listaDotazioni.setBounds(521, 94, 450, 500);
		add(listaDotazioni);

		listaDotazioniLabel = new JLabel("GRAFICO");
//		listaDotazioniLabel.setBackground(new Color(171, 165, 255));
		listaDotazioniLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		listaDotazioniLabel.setBounds(686, 38, 118, 54);
//		listaDotazioniLabel.setOpaque(true);
//		listaDotazioniLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(listaDotazioniLabel);
		
		riepilogoMensileBtn = new JButton("<html>RIEPILOGO<br />&nbsp;&nbsp;MENSILE</html>");
		riepilogoMensileBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		riepilogoMensileBtn.setBackground(new Color(171, 165, 255));
		riepilogoMensileBtn.setOpaque(true);	
		riepilogoMensileBtn.setBounds(255, 131, 125, 63);
		riepilogoMensileBtn.setBorderPainted(true);
		riepilogoMensileBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		riepilogoMensileBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(riepilogoMensileBtn);
		
		riepilogoAnnualeBtn = new JButton("<html>RIEPILOGO<br />&nbsp;&nbsp;ANNUALE</html>");
		riepilogoAnnualeBtn.setBackground(new Color(171, 165, 255));
		riepilogoAnnualeBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		riepilogoAnnualeBtn.setBounds(72, 131, 125, 63);
		riepilogoAnnualeBtn.setOpaque(true);
		riepilogoAnnualeBtn.setBorderPainted(true);
		riepilogoAnnualeBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		riepilogoAnnualeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(riepilogoAnnualeBtn);
		
		consumoMensileBtn = new JButton("<html>CONSUMO<br />&nbsp;MENSILE</html>");
		consumoMensileBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		consumoMensileBtn.setBackground(new Color(171, 165, 255));
		consumoMensileBtn.setBounds(581, 605, 125, 63);
		consumoMensileBtn.setOpaque(true);
		consumoMensileBtn.setBorderPainted(true);
		consumoMensileBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		consumoMensileBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(consumoMensileBtn);

		consumoAnnualeBtn = new JButton("<html>CONSUMO<br />&nbsp;ANNUALE</html>");
		consumoAnnualeBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		consumoAnnualeBtn.setBackground(new Color(171, 165, 255));
		consumoAnnualeBtn.setBounds(786, 605, 125, 63);
		consumoAnnualeBtn.setOpaque(true);
		consumoAnnualeBtn.setBorderPainted(true);
		consumoAnnualeBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(consumoAnnualeBtn);
	}
}