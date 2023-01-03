package gui;

import javax.swing.JPanel;

import dao.PersonaleImpl;
import model.Personale;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import controller.*;

public class ProfilePage extends JPanel {

	private JLabel nomeEcognomeLabel, laboratorioLabel, ruoloLabel, numeroTelefonoLabel, emailLabel, recapitoAziendaleLabel, dataNascitaLabel, residenzaLabel, picLabel;
	private JPanel textPanelHeader, textPanelNormal, profilePicPanel;
	private LayoutManager layout1, layout2;
	
	private ArrayList<Personale> personaleArray;

	private PersonaleImpl personaleDAO;

	private Controller controller;
	
	private Personale filteredPersonale;
	
	private BufferedImage myPicture;


	public ProfilePage() {
		// debug
		/*System.out.println(personaleArray.toString());
		System.out.println("Matricola:");
		System.out.println(loginpageobj.getMatricolaTextField());
		System.out.println("Codice:");
		System.out.println(loginpageobj.getCodiceTextField());*/
		
		
		setLayout(null);
		
		// Personale dao implementation used to populate personale array list from database datas
		personaleDAO = new PersonaleImpl();
		personaleArray = personaleDAO.populate();
		
		
		controller = new Controller();
		filteredPersonale = controller.filterBasedOnMatricolaCodice(personaleArray, LoginPage.getMatricolaTextField(), LoginPage.getCodiceTextField());

		System.out.println(filteredPersonale.getSediDoveLavora().toString());
		
		System.out.println("Personale filtrato:");
		System.out.println(filteredPersonale.toString());
		
		textPanelHeader = new JPanel();
		textPanelHeader.setBounds(0,86,1020,139);
		add(textPanelHeader);
		
		textPanelNormal = new JPanel();
		textPanelNormal.setBounds(515,300,300,172);
		add(textPanelNormal);
		
		layout1 = new BoxLayout(textPanelHeader, BoxLayout.PAGE_AXIS);  
		layout2 = new BoxLayout(textPanelNormal, BoxLayout.PAGE_AXIS);  
	    textPanelHeader.setLayout(layout1);
	    textPanelNormal.setLayout(layout2);

		nomeEcognomeLabel = new JLabel(filteredPersonale.getNome() + " " + filteredPersonale.getCognome());
		nomeEcognomeLabel.setAlignmentX(CENTER_ALIGNMENT);
		nomeEcognomeLabel.setFont(new Font("Tahoma", Font.BOLD, 45));
		textPanelHeader.add(nomeEcognomeLabel);

		laboratorioLabel = new JLabel("Sede + Laboratorio");
		laboratorioLabel.setAlignmentX(CENTER_ALIGNMENT);
		laboratorioLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		textPanelHeader.add(laboratorioLabel);

		ruoloLabel = new JLabel(filteredPersonale.getTipoPers().toString());
		ruoloLabel.setAlignmentX(CENTER_ALIGNMENT);
		ruoloLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		textPanelHeader.add(ruoloLabel);
		
		numeroTelefonoLabel = new JLabel("recapito telefonico: " + filteredPersonale.getRecapitoTel());
		textPanelNormal.add(numeroTelefonoLabel);
		
		emailLabel = new JLabel("email: " + filteredPersonale.getEmail());
		textPanelNormal.add(emailLabel);
		
		recapitoAziendaleLabel = new JLabel("recapito aziendale: " + filteredPersonale.getRecapitoTelAziendale());
		textPanelNormal.add(recapitoAziendaleLabel);
		
		dataNascitaLabel = new JLabel("data di nascita: " + filteredPersonale.getDataNascita());
		textPanelNormal.add(dataNascitaLabel);
		
		residenzaLabel = new JLabel("residenza: " + filteredPersonale.getVia() + ", " + filteredPersonale.getRegione());
		textPanelNormal.add(residenzaLabel);
		
		// profile image
		profilePicPanel = new JPanel();
		profilePicPanel.setBounds(330, 253, 175, 172);
		add(profilePicPanel);
		
		try {
			myPicture = ImageIO.read(new File("./img/placeholder-profile-image.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		picLabel = new JLabel(new ImageIcon(myPicture));
		profilePicPanel.add(picLabel);
		
	}

}
