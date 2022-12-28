package gui;

import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Font;

public class prova extends JPanel {
	JList listaStrumenti;
	JList listaDotazioni;

	JLabel labelListaStrumenti;
	JLabel labelListaDotazioni;
	
	public prova() {
		setLayout(null);
		
		listaStrumenti = new JList();
		listaStrumenti.setBounds(30, 100, 450, 500);
		add(listaStrumenti);

		labelListaStrumenti = new JLabel("Strumenti");
		labelListaStrumenti.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelListaStrumenti.setBounds(195, 80, 90, 15);
		add(labelListaStrumenti);
		
		listaDotazioni = new JList();
		listaDotazioni.setBounds(515, 100, 450, 500);
		add(listaDotazioni);

		/*labelListaDotazioni = new JLabel("Dotazioni accessorie");
		labelListaDotazioni.setBounds(515, 100, 450, 500);
		add(labelListaDotazioni);*/
	}
}

