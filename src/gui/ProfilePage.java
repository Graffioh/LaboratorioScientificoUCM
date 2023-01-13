package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import dao.PersonaleImpl;
import model.Personale;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import controller.*;
import javax.swing.border.Border;

public class ProfilePage extends JPanel {

	private JLabel nomeEcognomeLabel, laboratorioLabel, ruoloLabel, numeroTelefonoLabel, emailLabel, recapitoAziendaleLabel, dataNascitaLabel, residenzaLabel, picLabel;
	private JPanel textPanelHeader, textPanelNormal, profilePicPanel;
	private LayoutManager layout1, layout2;
	
	private ArrayList<Personale> personaleArray;

	private PersonaleImpl personaleDAO;

	private Controller controller;
	
	private Personale filteredPersonale;
	
	private BufferedImage myPicture;
	private JTextArea descrizioneFieldLaboratorio;

	private String descrizioneTextStrumentoDotazione = " Ahahahahah Ehi, gir pe Secondiglian \r\n Rind a n'Audi ner opac (rind a n'Audi ner opac) \r\n Ca m par n'astronav (ca m par n'astronav) \r\n Sceng o per na Balenciag (Bale) \r\n Ess vo nata Balenciag (Bale, Bale)";

	public ProfilePage() {
		// debug
		/*System.out.println(personaleArray.toString());
		System.out.println("Matricola:");
		System.out.println(loginpageobj.getMatricolaTextField());
		System.out.println("Codice:");
		System.out.println(loginpageobj.getCodiceTextField());*/
		
		setBackground(new Color(171, 191, 244));
		setLayout(null);
		
		// Personale dao implementation used to populate personale array list from database datas
		personaleDAO = new PersonaleImpl();
		personaleArray = personaleDAO.populate();
		
		
		controller = new Controller();
		filteredPersonale = controller.filterPersonaleBasedOnMatricolaCodice(personaleArray, LoginPage.getMatricolaTextField(), LoginPage.getCodiceTextField());

		System.out.println(filteredPersonale.getSediDoveLavora().toString());
		
		System.out.println("Personale filtrato:");
		System.out.println(filteredPersonale.toString());
		
		textPanelHeader = new JPanel();
		textPanelHeader.setBounds(0,86,1020,139);
		textPanelHeader.setBackground(new Color(171, 191, 244));
		add(textPanelHeader);
		
		textPanelNormal = new JPanel();
		textPanelNormal.setBounds(515,300,324,125);
		textPanelNormal.setBackground(new Color(171, 191, 244));
		add(textPanelNormal);
		
		layout1 = new BoxLayout(textPanelHeader, BoxLayout.PAGE_AXIS);  
		layout2 = new BoxLayout(textPanelNormal, BoxLayout.PAGE_AXIS);  
	    textPanelHeader.setLayout(layout1);
	    textPanelNormal.setLayout(layout2);

		nomeEcognomeLabel = new JLabel(filteredPersonale.getNome() + " " + filteredPersonale.getCognome());
		nomeEcognomeLabel.setAlignmentX(CENTER_ALIGNMENT);
		nomeEcognomeLabel.setFont(new Font("Tahoma", Font.BOLD, 45));
		textPanelHeader.add(nomeEcognomeLabel);

		laboratorioLabel = new JLabel("Laboratorio"); // "Laboratorio " + laboratorioDAO.getLaboratorioBasedOnSede(filteredPersonale.getSediDoveLavora().first());
		laboratorioLabel.setAlignmentX(CENTER_ALIGNMENT);
		laboratorioLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		textPanelHeader.add(laboratorioLabel);

		ruoloLabel = new JLabel(filteredPersonale.getTipoPers().toString());
		ruoloLabel.setAlignmentX(CENTER_ALIGNMENT);
		ruoloLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		textPanelHeader.add(ruoloLabel);
		
		numeroTelefonoLabel = new JLabel("recapito telefonico: " + filteredPersonale.getRecapitoTel());
		numeroTelefonoLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPanelNormal.add(numeroTelefonoLabel);
		
		emailLabel = new JLabel("email: " + filteredPersonale.getEmail());
		emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPanelNormal.add(emailLabel);
		
		recapitoAziendaleLabel = new JLabel("recapito aziendale: " + filteredPersonale.getRecapitoTelAziendale());
		recapitoAziendaleLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPanelNormal.add(recapitoAziendaleLabel);
		
		dataNascitaLabel = new JLabel("data di nascita: " + filteredPersonale.getDataNascita());
		dataNascitaLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPanelNormal.add(dataNascitaLabel);
		
		residenzaLabel = new JLabel("residenza: " + filteredPersonale.getVia() + ", " + filteredPersonale.getRegione());
		residenzaLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPanelNormal.add(residenzaLabel);
		
		// profile image
		profilePicPanel = new JPanel();
		profilePicPanel.setBounds(330, 253, 175, 172);
		profilePicPanel.setBackground(new Color(171, 191, 244));
		add(profilePicPanel);
		
		try {
			myPicture = ImageIO.read(new File("./img/placeholder-profile-image.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		picLabel = new JLabel(new ImageIcon(myPicture));
		profilePicPanel.add(picLabel);
		
		descrizioneFieldLaboratorio = new JTextArea();
		descrizioneFieldLaboratorio.setBackground(new Color(213, 223, 255));
		descrizioneFieldLaboratorio.setColumns(10);
		descrizioneFieldLaboratorio.setText(descrizioneTextStrumentoDotazione);
		descrizioneFieldLaboratorio.setLineWrap(true);
		descrizioneFieldLaboratorio.setWrapStyleWord(true);
		descrizioneFieldLaboratorio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		descrizioneFieldLaboratorio.setEditable(false);
		add(descrizioneFieldLaboratorio);
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		descrizioneFieldLaboratorio.setBorder(BorderFactory.createCompoundBorder(border,
	            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		JScrollPane descrizioneLaboratorioTextScroll = new JScrollPane (descrizioneFieldLaboratorio, 
				   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		descrizioneLaboratorioTextScroll.setBounds(255, 465, 529, 184);
		add(descrizioneLaboratorioTextScroll);

		JLabel descrizioneLaboratorioLabel = new JLabel("Descrizione Laboratorio");
		descrizioneLaboratorioLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		descrizioneLaboratorioLabel.setBounds(415, 435, 193, 28);
		add(descrizioneLaboratorioLabel);
		
	}
}