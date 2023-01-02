package gui;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Strumento;

public class PrenotaStrumentoPage extends JPanel {

	private JLabel selezionaStrumentoLabel;
	private JLabel selezionaSedeLabel;
	private JButton confermaBtn;
	private JTextField descrizioneField;
	
	private String[] choices1 = { "CHOICE 1","CHOICE 2", "CHOICE 3","CHOICE 4","CHOICE 5","CHOICE 6"};
	private String[] choices2 = { "CHOICE 1","CHOICE 2", "CHOICE 3","CHOICE 4","CHOICE 5","CHOICE 6"};
	
	private ArrayList<Strumento> strumentoArray;

	public PrenotaStrumentoPage() {
		setLayout(null);

		selezionaSedeLabel = new JLabel("Seleziona sede");
		selezionaSedeLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		selezionaSedeLabel.setBounds(400, 20, 220, 50);
		add(selezionaSedeLabel);

		final JComboBox<String> cb1 = new JComboBox<String>(choices1);
		cb1.setBounds(355,80,250,40);
    	cb1.setVisible(true);
		add(cb1);

		selezionaStrumentoLabel = new JLabel("Seleziona strumento");
		selezionaStrumentoLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		selezionaStrumentoLabel.setBounds(375, 125, 220, 50);
		add(selezionaStrumentoLabel);

		final JComboBox<String> cb2 = new JComboBox<String>(choices2);
		cb2.setBounds(355,185,250,40);
    	cb2.setVisible(true);
		add(cb2);

		descrizioneField = new JTextField();
		descrizioneField.setText("Ahahahahah Ehi, gir pe Secondiglian (p Secondiglian) Rind a n'Audi ner opac (rind a n'Audi ner opac) \n Ca m par n'astronav (ca m par n'astronav) Sceng o per na Balenciag (Bale) \n Ess vo nata Balenciag (Bale, Bale)");
		descrizioneField.setBounds(344, 250, 270, 100);
		add(descrizioneField);

		// CALENDARIO

		// DA - A

		confermaBtn = new JButton("Conferma");
		confermaBtn.setFont(new Font("Tahoma", Font.BOLD, 24));
		confermaBtn.setBounds(396, 530, 180, 40);
		add(confermaBtn);

	}

}
