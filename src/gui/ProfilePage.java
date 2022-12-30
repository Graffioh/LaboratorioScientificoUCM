package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.LayoutManager;
import javax.swing.BoxLayout;

public class ProfilePage extends JPanel {

	private JLabel nomeEcognome, laboratorio, ruolo, numeroTelefono, email, recapitoAziendale, dataNascita, residenza;
	private JPanel textPanelHeader, textPanelNormal;
	private LayoutManager layout1, layout2;
	
	public ProfilePage() {
		setLayout(null);
		
		textPanelHeader = new JPanel();
		textPanelHeader.setBounds(0,86,1020,139);
		add(textPanelHeader);
		
		textPanelNormal = new JPanel();
		textPanelNormal.setBounds(440,250,200,515);
		add(textPanelNormal);
		
		layout1 = new BoxLayout(textPanelHeader, BoxLayout.PAGE_AXIS);  
		layout2 = new BoxLayout(textPanelNormal, BoxLayout.PAGE_AXIS);  
	    textPanelHeader.setLayout(layout1);       
	    textPanelNormal.setLayout(layout2);

		nomeEcognome = new JLabel("Emanuele Palumbo");
		nomeEcognome.setAlignmentX(CENTER_ALIGNMENT);
		nomeEcognome.setFont(new Font("Tahoma", Font.BOLD, 45));
		textPanelHeader.add(nomeEcognome);

		laboratorio = new JLabel("Laboratorio della droga");
		laboratorio.setAlignmentX(CENTER_ALIGNMENT);
		laboratorio.setFont(new Font("Tahoma", Font.PLAIN, 35));
		textPanelHeader.add(laboratorio);

		ruolo = new JLabel("Responsabile");
		ruolo.setAlignmentX(CENTER_ALIGNMENT);
		ruolo.setFont(new Font("Tahoma", Font.PLAIN, 28));
		textPanelHeader.add(ruolo);
		
		numeroTelefono = new JLabel("recapito telefonico: 3896236681");
		textPanelNormal.add(numeroTelefono);
		
		email = new JLabel("email: pincopallino@gmail.com");
		textPanelNormal.add(email);
		
		recapitoAziendale = new JLabel("recapito aziendale: 38962362342");
		textPanelNormal.add(recapitoAziendale);
		
		dataNascita = new JLabel("data di nascita: 6/9/420");
		textPanelNormal.add(dataNascita);
		
		residenza = new JLabel("residenza: casa sua");
		textPanelNormal.add(residenza);
	}

}
