package gui;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RiepilogoDotazioniPage extends JPanel {
	
	private JTextArea listaStrumenti, listaDotazioni;
	private JLabel listaStrumentiLabel, listaDotazioniLabel;
	
	private JButton consumoMensileBtn, riepilogoAnnualeBtn, riepilogoMensileBtn, consumoAnnualeBtn;
	
	public RiepilogoDotazioniPage() {
		setBackground(new Color(171, 191, 244));
		setLayout(null);
		
		listaStrumenti = new JTextArea();
		listaStrumenti.setBackground(new Color(213, 223, 255));
		listaStrumenti.setBounds(50, 168, 368, 500);
		add(listaStrumenti);

		listaStrumentiLabel = new JLabel("RIEPILOGO DOTAZIONI");
		listaStrumentiLabel.setForeground(new Color(0, 0, 0));
//		listaStrumentiLabel.setBackground(new Color(171, 165, 255));
		listaStrumentiLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		listaStrumentiLabel.setBounds(90, 38, 308, 54);
//		listaStrumentiLabel.setOpaque(true);
//		listaStrumentiLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(listaStrumentiLabel);
		
		listaDotazioni = new JTextArea();
		listaDotazioni.setBackground(new Color(213, 223, 255));
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
		riepilogoMensileBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				riepilogoMensileBtn.setBackground(new Color(157,149,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				riepilogoMensileBtn.setBackground(new Color(171, 165, 255));
			}
		});
		riepilogoMensileBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		riepilogoMensileBtn.setBackground(new Color(171, 165, 255));
		riepilogoMensileBtn.setOpaque(true);	
		riepilogoMensileBtn.setBounds(263, 94, 125, 63);
		riepilogoMensileBtn.setBorderPainted(true);
		riepilogoMensileBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		riepilogoMensileBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(riepilogoMensileBtn);
		
		riepilogoAnnualeBtn = new JButton("<html>RIEPILOGO<br />&nbsp;&nbsp;ANNUALE</html>");
		riepilogoAnnualeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				riepilogoAnnualeBtn.setBackground(new Color(157,149,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				riepilogoAnnualeBtn.setBackground(new Color(171, 165, 255));
			}
		});
		riepilogoAnnualeBtn.setBackground(new Color(171, 165, 255));
		riepilogoAnnualeBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		riepilogoAnnualeBtn.setBounds(80, 94, 125, 63);
		riepilogoAnnualeBtn.setOpaque(true);
		riepilogoAnnualeBtn.setBorderPainted(true);
		riepilogoAnnualeBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		riepilogoAnnualeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(riepilogoAnnualeBtn);
		
		consumoMensileBtn = new JButton("<html>CONSUMO<br />&nbsp;MENSILE</html>");
		consumoMensileBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				consumoMensileBtn.setBackground(new Color(157,149,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				consumoMensileBtn.setBackground(new Color(171, 165, 255));
			}
		});
		consumoMensileBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		consumoMensileBtn.setBackground(new Color(171, 165, 255));
		consumoMensileBtn.setBounds(581, 605, 125, 63);
		consumoMensileBtn.setOpaque(true);
		consumoMensileBtn.setBorderPainted(true);
		consumoMensileBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		consumoMensileBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(consumoMensileBtn);

		consumoAnnualeBtn = new JButton("<html>CONSUMO<br />&nbsp;ANNUALE</html>");
		consumoAnnualeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				consumoAnnualeBtn.setBackground(new Color(157,149,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				consumoAnnualeBtn.setBackground(new Color(171, 165, 255));
			}
		});
		consumoAnnualeBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		consumoAnnualeBtn.setBackground(new Color(171, 165, 255));
		consumoAnnualeBtn.setBounds(786, 605, 125, 63);
		consumoAnnualeBtn.setOpaque(true);
		consumoAnnualeBtn.setBorderPainted(true);
		consumoAnnualeBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(consumoAnnualeBtn);
	}
}