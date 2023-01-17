package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class SegnalaMaterialiConsumabiliPage extends JPanel {
	
	JComboBox segnalaMaterialiConsumabiliComboBox;
	
	JLabel segnalaMaterialiConsumabiliLabel;
	
	JButton aggiungiMCBtn, confermaMCBtn;
	
	public SegnalaMaterialiConsumabiliPage() {

		setBackground(new Color(171, 191, 244));
		setLayout(null);
		
		segnalaMaterialiConsumabiliLabel = new JLabel("SELEZIONA MATERIALI CONSUMABILI");
		segnalaMaterialiConsumabiliLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		segnalaMaterialiConsumabiliLabel.setBounds(246, 80, 566, 50);
		add(segnalaMaterialiConsumabiliLabel);
		
		segnalaMaterialiConsumabiliComboBox = new JComboBox();
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
		
		confermaMCBtn = new JButton("CONFERMA");
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
	}
}