package controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import org.jfree.data.general.DefaultPieDataset;

import com.toedter.calendar.JDateChooser;

import dao.DotazioneAccessoriaImpl;
import dao.PersonaleImpl;
import dao.PrenotazioneImpl;
import dao.StrumentoImpl;
import gui.MainGUI;
import model.DotazioneAccessoria;
import model.Personale;
import model.Prenotazione;
import model.Sede;
import model.Strumento;

public class Controller {
	// Switch to the main page when login button is pressed & the login is successful
	public void goToMainPageBasedOnLoginData(String matricola, int codice, JFrame loginFrame, MainGUI mainPage) {
		PersonaleImpl personaleDAO = new PersonaleImpl();

		if(personaleDAO.logIn(matricola,codice)) {
			loginFrame.setVisible(false);
			mainPage = new MainGUI();
			mainPage.setVisible(true);
		} 
		else{
			JOptionPane.showMessageDialog(null, "Login non riuscito, riprovare");
		}
	}
	
	// Filter personale based on matricola and codice from login
	public Personale filterPersonaleBasedOnMatricolaCodice(ArrayList<Personale> personaleArray, String matricola, int codice){
		Personale tmpPersonale = new Personale("", "", "", "", "", "", null, "", "", "", "tecnico", 0, null, null);

		// For each personale object inside the array list, check for the one with the same matricola and codice as the one in the login phase
		for (Personale p : personaleArray){
			if(matricola.equals(p.getMatricola()) && codice == p.getCodice()) {
				tmpPersonale = p;
			}
		}

		return tmpPersonale;
	}
	
	// Generic function to get Nomi based on Array List type
	public <T> ArrayList<String> getNomiFromArrayList(ArrayList<T> al) {

		ArrayList<String> nomi = new ArrayList<String>();
		for(T el : al) {
			// Based on the instance of el, cast it to get the desired method.
			if(el instanceof Strumento)
				nomi.add(((Strumento)el).getNome());
			else if(el instanceof DotazioneAccessoria)
				nomi.add(((DotazioneAccessoria)el).getNome());
			else if(el instanceof Sede)
				nomi.add(((Sede)el).getNome());
			else
				nomi.add((String)el);
		}
		
		return nomi;
	}
	
	// Generic function to get codici based on Array List type
	public <T> ArrayList<String> getCodiciFromArrayList(ArrayList<T> al) {
		ArrayList<String> codici = new ArrayList<String>();
		for(T el : al) {
			// Based on the instance of d, cast it to get the desired method.
			if(el instanceof Strumento)
				codici.add(Integer.valueOf(((Strumento)el).getCodice()).toString());
			else if(el instanceof DotazioneAccessoria)
				codici.add(Integer.valueOf(((DotazioneAccessoria)el).getCodice()).toString());
			else if(el instanceof Sede)
				codici.add(Integer.valueOf(((Sede)el).getCodice()).toString());
			else if(el instanceof Prenotazione)
				codici.add(Integer.valueOf(((Prenotazione)el).getCodice()).toString());
		}
		
		return codici;
	}
	
	public <T> String getDescrizioneFromNome(ArrayList<T> al, String comboBoxStr) {
		String descrizione = new String();
		
		for(T el : al) {
			if(el instanceof Strumento) {
				if(((Strumento)el).getNome().equals(comboBoxStr)) {
					descrizione = ((Strumento)el).getDescrizione();
				}
			}
			
			else if(el instanceof DotazioneAccessoria) {
				if(((DotazioneAccessoria)el).getNome().equals(comboBoxStr)) {
					descrizione = ((DotazioneAccessoria)el).getDescrizione();
				}
			}
		}
		
		return descrizione;
	}
	
	public <T> int getCodiceFromNome(ArrayList<T> al, String comboBoxStr) {

		int codice = 0;
		
		for(T el : al) {
			if(el instanceof Strumento) {
				if(((Strumento)el).getNome().equals(comboBoxStr)) {
					 codice = ((Strumento)el).getCodice();
				}
			}
			
			else if(el instanceof DotazioneAccessoria) {
				if(((DotazioneAccessoria)el).getNome().equals(comboBoxStr)) {
					codice = ((DotazioneAccessoria)el).getCodice();
				}
			}
		}
		
		return codice;
	}
	
	public void effettuaPrenotazione(LocalDate data, LocalTime localTime, int tempoPrenotazione, int daOra, int aOra, int codP, int codStr, int codD, int codPers, boolean isStrumento) {
		
		PrenotazioneImpl prenotazioneDAO = new PrenotazioneImpl();
		
		ArrayList<Prenotazione> prenotazioneArray = new ArrayList<Prenotazione>();
		prenotazioneArray = prenotazioneDAO.populate();
		
		if(isStrumento) {
			// if prenotazioneArray is empty then codP is 1, otherwise it will calculate it dynamically based on the last codP
			if(prenotazioneArray.isEmpty()) {
				prenotazioneDAO.prenotazione(data, localTime, tempoPrenotazione, daOra, aOra, codP, codStr, 0, codPers);
			} else {
				codP = prenotazioneDAO.getMaxCodP() + 1;
				prenotazioneDAO.prenotazione(data, localTime, tempoPrenotazione, daOra, aOra, codP, codStr, 0, codPers);
			}
		} else {
			if(prenotazioneArray.isEmpty()) {
				prenotazioneDAO.prenotazione(data, localTime, tempoPrenotazione, daOra, aOra, codP, codStr, codD, codPers);
			} else {
				codP = prenotazioneDAO.getMaxCodP() + 1;
				prenotazioneDAO.prenotazione(data, localTime, tempoPrenotazione, daOra, aOra, codP, codStr, codD, codPers);
			}
		}
		
	}
	
	public String[] getAOraBasedOnDaOra(int selectedItem) {
		String[] aOraArray;
		
		int countOra = 0;
		for(Integer i = selectedItem; i <= 20; ++i) {
			countOra += 1;
		}
		
		aOraArray = new String[countOra - 1];
		Integer daOra = selectedItem;
		for(Integer i = daOra + 1; i <= 20; ++i) {
			aOraArray[i - daOra - 1] = i.toString();
		}
		
		return aOraArray;
	}
	
	public String getInformazioniFromPrenotazione(ArrayList<Prenotazione> al, int comboBoxCodice) {

		String info = new String();
		
		for(Prenotazione el : al) {
			if(el.getCodice() == comboBoxCodice) {
				if(el.getCodD() == 0) {
					info = "Codice strumento:" + el.getCodStr() + "\n\r" + "Data prenotazione:" + el.getData();
				} else {
					info = "Codice dotazione:" + el.getCodD() + "\n\r" + "Data prenotazione:" + el.getData();
				}
			}
		}
		
		return info;
	}
	
	// Used for combobox items
	public <T> String[] fromArrayListToStringArray(ArrayList<T> al) {
		
		Controller controller = new Controller();
		ArrayList<String> alString = new ArrayList<String>();
		String[] stringArray;
		
		try {
			if(al.get(0) instanceof Prenotazione)
				alString = controller.getCodiciFromArrayList(al);
			else
				alString = controller.getNomiFromArrayList(al);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		stringArray = new String[alString.size()];
		
		stringArray = alString.toArray(stringArray);
		
		
		return stringArray;
	}
	
	public <T> void populateHomepageTable(ArrayList<T> al, JTable jt) {
		DefaultTableModel tableModel = new DefaultTableModel();
		String codiceStrumento = new String();
		
		tableModel.addColumn("Nome");
		tableModel.addColumn("Codice");
		
		if(al.get(0) instanceof DotazioneAccessoria)
			tableModel.addColumn("CodiceStr associato");
		else
			tableModel.addColumn("Tipo strumento");
		
		for (T el : al) {
			if(el instanceof Strumento) {
				tableModel.addRow(new Object[] {((Strumento)el).getNome(), ((Strumento)el).getCodice(), ((Strumento)el).getTipoStr()});
			}
			else if (el instanceof DotazioneAccessoria)  {
				// Dynamic codStr associato, if its or not associated with a strumento
				if (((DotazioneAccessoria)el).getCodStr() == 0) {
					codiceStrumento = "consumabile";
				} else {
					codiceStrumento = Integer.toString(((DotazioneAccessoria)el).getCodStr());
				}
				
				tableModel.addRow(new Object[] {((DotazioneAccessoria)el).getNome(), ((DotazioneAccessoria)el).getCodice(), codiceStrumento});
			}
				
		}
		
		jt.setModel(tableModel);
	}
	
	public void populateCalendarioTable(ArrayList<Prenotazione> al, JTable jt, LocalDate data) {
		DefaultTableModel tableModel = new DefaultTableModel();
		
		StrumentoImpl strumentoDAO = new StrumentoImpl();
		DotazioneAccessoriaImpl dotazioneDAO = new DotazioneAccessoriaImpl();
		
		tableModel.addColumn("Codice prenotazione");
		tableModel.addColumn("Strumento/Dotazione");
		tableModel.addColumn("daOra");
		tableModel.addColumn("aOra");
		
		for (Prenotazione el : al) {
			if(el.getData().equals(data)) {
				if(el.getCodD() == 0) {
					String nomeStr = strumentoDAO.getNomeBasedOnCodice(el.getCodStr());
					tableModel.addRow(new Object[] {el.getCodice(), "codice: " + el.getCodStr() + " | " + nomeStr + " (strumento)", el.getDaOra(), el.getAOra()});
				} else {
					String nomeDotazione = dotazioneDAO.getNomeBasedOnCodice(el.getCodD());
					tableModel.addRow(new Object[] {el.getCodice(), "codice: " +  el.getCodD() + " | " + nomeDotazione + " (dotazione)", el.getDaOra(), el.getAOra()});
				}
			}
		}
			
		jt.setModel(tableModel);
	}
	
	public void populateRiepilogoMensileStrumentiTable(ArrayList<Strumento> al, PrenotazioneImpl prenotazioneDAO, JTable jt) {
		
		DefaultTableModel tableModel = new DefaultTableModel();
		
		tableModel.addColumn("Gen");
		tableModel.addColumn("Feb");
		tableModel.addColumn("Mar");
		tableModel.addColumn("Apr");
		tableModel.addColumn("Mag");
		tableModel.addColumn("Giu");
		tableModel.addColumn("Lug");
		tableModel.addColumn("Ago");
		tableModel.addColumn("Sett");
		tableModel.addColumn("Ott");
		tableModel.addColumn("Nov");
		tableModel.addColumn("Dic");
		
		for(int i = 0; i < al.size(); i++) {
			String[] row1 = prenotazioneDAO.getRiepilogoStrumentoBasedOnMonth(i + 1);
		
			tableModel.addRow(row1);
		}
			
		jt.setModel(tableModel);
	}
	
	public void populateRiepilogoAnnualeStrumentiTable(ArrayList<Strumento> al, PrenotazioneImpl prenotazioneDAO, JTable jt) {
		DefaultTableModel tableModel = new DefaultTableModel();
		
		tableModel.addColumn("2023");
		tableModel.addColumn("2024");
		tableModel.addColumn("2025");
		tableModel.addColumn("2026");
		tableModel.addColumn("2027");
		tableModel.addColumn("2028");
		tableModel.addColumn("2029");
		tableModel.addColumn("2030");
		
		for(int i = 0; i < al.size(); i++) {
			String[] row1 = prenotazioneDAO.getRiepilogoStrumentoBasedOnYear(i + 1);
		
			tableModel.addRow(row1);
		}
			
		jt.setModel(tableModel);
	}
	
	public void populateRiepilogoMensileUtenteTable(ArrayList<Strumento> al, PrenotazioneImpl prenotazioneDAO, JTable jt) {
		DefaultTableModel tableModel = new DefaultTableModel();
		
		tableModel.addColumn("Gen");
		tableModel.addColumn("Feb");
		tableModel.addColumn("Mar");
		tableModel.addColumn("Apr");
		tableModel.addColumn("Mag");
		tableModel.addColumn("Giu");
		tableModel.addColumn("Lug");
		tableModel.addColumn("Ago");
		tableModel.addColumn("Sett");
		tableModel.addColumn("Ott");
		tableModel.addColumn("Nov");
		tableModel.addColumn("Dic");

		for(int i = 0; i < al.size(); i++) {
			String[] row1 = prenotazioneDAO.getRiepilogoUtenteBasedOnMonth(i + 1);
		
			tableModel.addRow(row1);
		}
			
		jt.setModel(tableModel);
	}
	
	public void populateRiepilogoAnnualeUtenteTable(ArrayList<Strumento> al, PrenotazioneImpl prenotazioneDAO, JTable jt) {
		DefaultTableModel tableModel = new DefaultTableModel();
		
		tableModel.addColumn("2023");
		tableModel.addColumn("2024");
		tableModel.addColumn("2025");
		tableModel.addColumn("2026");
		tableModel.addColumn("2027");
		tableModel.addColumn("2028");
		tableModel.addColumn("2029");
		tableModel.addColumn("2030");
		
		for(int i = 0; i < al.size(); i++) {
			String[] row1 = prenotazioneDAO.getRiepilogoUtenteBasedOnYear(i + 1);
		
			tableModel.addRow(row1);
		}
			
		jt.setModel(tableModel);
	}
	
	// Used for updating the list in segnala materiali consumabili
	public void updateDflBasedOnComboBox(DefaultListModel<String> dfl, String comboBoxStr) {
		boolean check = false;
		for(int i = 0; i < dfl.size(); i++) {
			if(dfl.contains(comboBoxStr) && !check) 
				check = true;
		}
			
		if(!check) {
			dfl.addElement(comboBoxStr);
		}
	}
	
	public void writeSegnalazioneInFile(DefaultListModel<String> dfl) {
		try {
			ArrayList<String> mats = new ArrayList<String>();
			boolean check = false;
			for(int i = 0; i < dfl.size(); i++) {
				mats.add(dfl.getElementAt(i));
			}
			
			for(String str : mats) {
				// Check if a materiale is already in the file, if not you can write it
				if(Files.lines(Paths.get("./misc/segnalazioni_materiali.txt")).anyMatch(l -> l.contains(str)) && !check) {
					check = true;
				}
				
				if(!check) {
					Files.write(Paths.get("./misc/segnalazioni_materiali.txt"), (str + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
					JOptionPane.showMessageDialog(null, "Segnalazione effettuata.");
				} else {
					JOptionPane.showMessageDialog(null, "Uno dei " + mats.size() + " materiali è già segnalato.");
				}
			}
			
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}
	
	public void switchPage(JPanel panelVisible, JPanel panelNotVisible) {
		panelVisible.setVisible(true);
		panelNotVisible.setVisible(false);
	}
	
	public void switchRiepilogoTable(JTable jtVisible, JTable jtNotVisible1, JTable jtNotVisible2, JTable jtNotVisible3,  
			JScrollPane jspVisible, JScrollPane jspNotVisible1, JScrollPane jspNotVisible2, JScrollPane jspNotVisible3) {
		jtVisible.setVisible(true);
		jspVisible.setVisible(true);
		jtNotVisible1.setVisible(false);
		jspNotVisible1.setVisible(false);
		jtNotVisible2.setVisible(false);
		jspNotVisible2.setVisible(false);
		jtNotVisible3.setVisible(false);
		jspNotVisible3.setVisible(false);
	}
	
	public void switchBookingPage(JPanel panelVisible, JPanel panelNotVisible1, JPanel panelNotVisible2, JPanel panelNotVisible3) {
		panelVisible.setVisible(true);
		panelNotVisible1.setVisible(false);
		panelNotVisible2.setVisible(false);
		panelNotVisible3.setVisible(false);
	}
	
	public void switchComboBoxBasedOnButton(JLabel labelVisible, JLabel labelNotVisible, JComboBox<String> cbVisible, JComboBox<String> cbNotVisible) {
		labelVisible.setVisible(true);
		cbVisible.setVisible(true);
		labelNotVisible.setVisible(false);
		cbNotVisible.setVisible(false);
	}
	
	public <T> void switchDescrizioneBasedOnArrayList(ArrayList<T> al, JTextArea descrizioneTxtArea, JComboBox<String> cb) {
		Controller controller = new Controller();
		
		String descrizione = "";
		
		if(!al.isEmpty())
			descrizione = controller.getDescrizioneFromNome(al, cb.getSelectedItem().toString());
		
		descrizioneTxtArea.setText(descrizione);
	}
	
	public void switchDescrizioneBasedOnSede(boolean isStrumento, ArrayList<Strumento> alStr, ArrayList<DotazioneAccessoria> alD, 
			JComboBox<String> cbStr, JComboBox<String> cbD, JTextArea descrizioneTxtArea) {
		Controller controller = new Controller();
		
		String descrizione = "";
		
		// Descrizione
		if(isStrumento && !alStr.isEmpty()) {
			descrizione = controller.getDescrizioneFromNome(alStr, cbStr.getSelectedItem().toString());
		} else if (!isStrumento && !alD.isEmpty()) {
			descrizione = controller.getDescrizioneFromNome(alD, cbD.getSelectedItem().toString());
		}
		
		descrizioneTxtArea.setText(descrizione);
	}
	
	public void changeComboBoxItemsBasedOnSede(ArrayList<Strumento> alStr, ArrayList<DotazioneAccessoria> alD, JComboBox<String> cbStr, JComboBox<String> cbD) {
		Controller controller = new Controller();
		
		String[] strumenti, dotazioni;
		
		if(!alStr.isEmpty()) {
			strumenti = controller.fromArrayListToStringArray(alStr);
			cbStr.setModel(new DefaultComboBoxModel<String>(strumenti));
		} else {
			cbStr.setModel(new DefaultComboBoxModel<String>());
		}
		 
		if(!alD.isEmpty()) {
			dotazioni = controller.fromArrayListToStringArray(alD);
			cbD.setModel(new DefaultComboBoxModel<String>(dotazioni));
		} else {
			cbD.setModel(new DefaultComboBoxModel<String>());
		}
	}
	
	public void changeAOraBasedOnDaOra(JComboBox<String> cbDaOra, JComboBox<String> cbAOra) {
		Controller controller = new Controller();
		
		String[] aOraArray;	
		aOraArray = controller.getAOraBasedOnDaOra(Integer.parseInt(cbDaOra.getSelectedItem().toString()));
		cbAOra.setModel(new DefaultComboBoxModel<String>(aOraArray));
	}
	
	public void changeInformazioniPrenotazioneBasedOnPrenotazione(ArrayList<Prenotazione> alPr, JComboBox<String> cbPr, JTextArea informazioniArea) {
		Controller controller = new Controller();
		
		String descrizioneTextPrenotazione = controller.getInformazioniFromPrenotazione(alPr, Integer.parseInt(cbPr.getSelectedItem().toString()));
		
		informazioniArea.setText(descrizioneTextPrenotazione);
	}

	// Used for pie chart consumo dotazioni
	public DefaultPieDataset setDatasetMonth(ArrayList<DotazioneAccessoria> alD, String nomeDotazione) {
		Controller controller = new Controller();
		
		PrenotazioneImpl prenotazioneDAO = new PrenotazioneImpl();

		int[] consumo = new int[13];

		consumo = prenotazioneDAO.getConsumoDotazioneBasedOnMonth(alD, nomeDotazione);

		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue( "Gennaio", consumo[0]);
		dataset.setValue( "Febbraio", consumo[1]);
		dataset.setValue( "Marzo", consumo[2]);
		dataset.setValue( "Aprile", consumo[3]);
		dataset.setValue( "Maggio", consumo[4]);
		dataset.setValue( "Giugno", consumo[5]);
		dataset.setValue( "Luglio", consumo[6]);
		dataset.setValue( "Agosto", consumo[7]);
		dataset.setValue( "Settembre", consumo[8]);
		dataset.setValue( "Ottobre", consumo[9]);
		dataset.setValue( "Novembre", consumo[10]);
		dataset.setValue( "Dicembre", consumo[11]);

		return dataset;
	}

	public DefaultPieDataset setDatasetYear(ArrayList<DotazioneAccessoria> alD, String nomeDotazione) {
		Controller controller = new Controller();

		PrenotazioneImpl prenotazioneDAO = new PrenotazioneImpl();

		int[] consumo = new int[10];

		consumo = prenotazioneDAO.getConsumoDotazioneBasedOnYear(alD, nomeDotazione);
		
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue( "2023", consumo[0]);
		dataset.setValue( "2024", consumo[1]);
		dataset.setValue( "2025", consumo[2]);
		dataset.setValue( "2026", consumo[3]);
		dataset.setValue( "2027", consumo[4]);
		dataset.setValue( "2028", consumo[5]);
		dataset.setValue( "2029", consumo[6]);
		dataset.setValue( "2030", consumo[7]);

		return dataset;
	}
	
}
