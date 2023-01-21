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
	
	private JTextArea listaDotazioni;
	private JLabel listaDotazioniLabel;
	
	private JButton consumoMensileBtn, consumoAnnualeBtn;
	
	public RiepilogoDotazioniPage() {
		setBackground(new Color(171, 191, 244));
		setLayout(null);
		
		listaDotazioni = new JTextArea();
		listaDotazioni.setBackground(new Color(213, 223, 255));
		listaDotazioni.setBounds(50, 168, 895, 500);
		add(listaDotazioni);

		listaDotazioniLabel = new JLabel("GRAFICO");
		listaDotazioniLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		listaDotazioniLabel.setBounds(432, 37, 136, 54);
		add(listaDotazioniLabel);
		
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
		consumoMensileBtn.setBounds(351, 94, 125, 63);
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
		consumoAnnualeBtn.setBounds(500, 94, 125, 63);
		consumoAnnualeBtn.setOpaque(true);
		consumoAnnualeBtn.setBorderPainted(true);
		consumoAnnualeBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(consumoAnnualeBtn);
	}
}