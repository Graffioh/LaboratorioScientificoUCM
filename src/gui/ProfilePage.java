package gui;

import javax.swing.JPanel;

import dao.PersonaleImpl;
import model.Personale;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.LayoutManager;
import java.util.ArrayList;

import javax.swing.BoxLayout;

public class ProfilePage extends JPanel {

	private JLabel nomeEcognome, laboratorio, ruolo, numeroTelefono, email, recapitoAziendale, dataNascita, residenza;
	private JPanel textPanelHeader, textPanelNormal;
	private LayoutManager layout1, layout2;

	PersonaleImpl personaleImpl = new PersonaleImpl();
	ArrayList<Personale> personaleArray = personaleImpl.populate();

	LoginPage loginpageobj = new LoginPage(); // We need this to access the getters for matricola and codice static variables
	
	Personale filteredPersonale;

	public ProfilePage() {
		// debug
		/*System.out.println(personaleArray.toString());
		System.out.println("Matricola:");
		System.out.println(loginpageobj.getMatricolaTextField());
		System.out.println("Codice:");
		System.out.println(loginpageobj.getCodiceTextField());
		System.out.println("Personale filtrato:");
		System.out.println(filterBasedOnMatricolaCodice(personaleArray, loginpageobj.getMatricolaTextField(),loginpageobj.getCodiceTextField()));*/

		filteredPersonale = filterBasedOnMatricolaCodice(personaleArray, loginpageobj.getMatricolaTextField(),loginpageobj.getCodiceTextField());
		
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

		nomeEcognome = new JLabel(filteredPersonale.getNome() + " " + filteredPersonale.getCognome());
		nomeEcognome.setAlignmentX(CENTER_ALIGNMENT);
		nomeEcognome.setFont(new Font("Tahoma", Font.BOLD, 45));
		textPanelHeader.add(nomeEcognome);

		laboratorio = new JLabel("Sede + Laboratorio");
		laboratorio.setAlignmentX(CENTER_ALIGNMENT);
		laboratorio.setFont(new Font("Tahoma", Font.PLAIN, 35));
		textPanelHeader.add(laboratorio);

		ruolo = new JLabel(filteredPersonale.getTipoPers().toString());
		ruolo.setAlignmentX(CENTER_ALIGNMENT);
		ruolo.setFont(new Font("Tahoma", Font.PLAIN, 28));
		textPanelHeader.add(ruolo);
		
		numeroTelefono = new JLabel("recapito telefonico: " + filteredPersonale.getRecapitoTel());
		textPanelNormal.add(numeroTelefono);
		
		email = new JLabel("email: " + filteredPersonale.getEmail());
		textPanelNormal.add(email);
		
		recapitoAziendale = new JLabel("recapito aziendale: " + filteredPersonale.getRecapitoTelAziendale());
		textPanelNormal.add(recapitoAziendale);
		
		dataNascita = new JLabel("data di nascita: " + filteredPersonale.getDataNascita());
		textPanelNormal.add(dataNascita);
		
		residenza = new JLabel("residenza: " + filteredPersonale.getVia() + ", " + filteredPersonale.getRegione());
		textPanelNormal.add(residenza);
	}


	private Personale filterBasedOnMatricolaCodice(ArrayList<Personale> personaleArray, String matricola, int codice){
		Personale tmpPersonale = new Personale("", "", "", "", "", "", null, "", "", "", "", 0, null, null);

		for (Personale p : personaleArray){
			if(matricola.equals(p.getMatricola()) && codice == p.getCodice()){
				tmpPersonale = p;
			}
		}

		return tmpPersonale;
	}

}
