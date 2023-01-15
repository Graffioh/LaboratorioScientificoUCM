package controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import dao.PersonaleImpl;
import dao.PrenotazioneImpl;
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
	
	public void switchPage(JPanel panelVisible, JPanel panelNotVisible) {
		panelVisible.setVisible(true);
		panelNotVisible.setVisible(false);
	}
	
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
		}
		
		return nomi;
	}
	
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
		
		System.out.println(countOra);
		
		aOraArray = new String[countOra - 1];
		Integer daOra = selectedItem;
		for(Integer i = daOra + 1; i <= 20; ++i) {
			aOraArray[i - daOra - 1] = i.toString();
		}
		
		return aOraArray;
	}
	
	public String getInformazioniFromPrenotazione(ArrayList<Prenotazione> al, int comboBoxCodice) {

		String info = new String();
		
		DateTimeFormatter formatoDate = DateTimeFormatter.ofPattern("DD/MM/YYYY");
		
		for(Prenotazione el : al) {
			if(el.getCodice() == comboBoxCodice) {
				if(el.getCodD() == 0) {
					info = "Codice strumento:" + el.getCodStr() + "\n\r" + "Data prenotazione:" + el.getData().format(formatoDate);
				} else {
					info = "Codice dotazione:" + el.getCodD() + "\n\r" + "Data prenotazione:" + el.getData().format(formatoDate);
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
		
		if(al.get(0) instanceof Prenotazione)
			alString = controller.getCodiciFromArrayList(al);
		else
			alString = controller.getNomiFromArrayList(al);
		
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
					codiceStrumento = "non associato";
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
		
		tableModel.addColumn("Codice prenotazione");
		tableModel.addColumn("Codice strumento/dotazione");
		tableModel.addColumn("daOra");
		tableModel.addColumn("aOra");
		
		for (Prenotazione el : al) {
			if(el.getData().equals(data)) {
				if(el.getCodD() == 0)
					tableModel.addRow(new Object[] {el.getCodice(), el.getCodStr() + " (strumento)", el.getDaOra(), el.getAOra()});
				else
					tableModel.addRow(new Object[] {el.getCodice(), el.getCodD() + " (dotazione)", el.getDaOra(), el.getAOra()});
			}
		}
			
		jt.setModel(tableModel);
	}
}
