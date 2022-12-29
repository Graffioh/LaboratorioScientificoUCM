package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class ProfilePage extends JPanel {

	JLabel nomeEcognome, laboratorio, ruolo, numeroTelefono, email, recapitoAziendale, dataNascita, residenza;
	
	public ProfilePage() {
		setLayout(null);

		nomeEcognome = new JLabel("Emanuele Palumbo");
		nomeEcognome.setFont(new Font("Tahoma", Font.BOLD, 45));
		nomeEcognome.setBounds(300, 100, 600, 50);
		add(nomeEcognome);

		laboratorio = new JLabel("Laboratorio della droga");
		laboratorio.setFont(new Font("Tahoma", Font.PLAIN, 35));
		laboratorio.setBounds(330, 160, 600, 50);
		add(laboratorio);

		ruolo = new JLabel("Responsabile");
		ruolo.setFont(new Font("Tahoma", Font.PLAIN, 28));
		ruolo.setBounds(420, 220, 350, 40);
		add(ruolo);
		
		numeroTelefono = new JLabel("recapito telefonico: 3896236681");
		//numeroTelefono.setBounds(ALLBITS, ABORT, WIDTH, HEIGHT);
		add(numeroTelefono);
		
		email = new JLabel("email: pincopallino@gmail.com");
		//email.setBounds(ALLBITS, ABORT, WIDTH, HEIGHT);
		add(email);
		
		recapitoAziendale = new JLabel("recapito aziendale: 38962362342");
		//recapitoAziendale.setBounds(ALLBITS, ABORT, WIDTH, HEIGHT);
		add(recapitoAziendale);
		
		dataNascita = new JLabel("data di nascita: 6/9/420");
		//dataNascita.setBounds(ALLBITS, ABORT, WIDTH, HEIGHT);
		add(dataNascita);
		
		residenza = new JLabel("residenza: casa sua");
		//residenza.setBounds(ALLBITS, ABORT, WIDTH, HEIGHT);
		add(residenza);
	}

}
