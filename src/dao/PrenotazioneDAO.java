package dao;

//import java.sql.Date;
import java.time.*;
import java.util.ArrayList;

import model.Prenotazione;
import model.DotazioneAccessoria;

public interface PrenotazioneDAO {
	// Populate the arraylist based on database table
	ArrayList<Prenotazione> populate();
	
	// Get strumenti based on sede selected in combobox and based on filtered personale
	ArrayList<Prenotazione> getPrenotazioneBasedOnSede(int codPers, String nomeSede);
	
	ArrayList<Prenotazione> getPrenotazioneBasedOnPersonale(int codPers);

	ArrayList<Prenotazione> getPrenotazioneBasedOnStrumentoAndDate(int codStr, LocalDate localDate);
	
	<T> String getNomeBasedOnPrenotazione(T pr);
	
	int getMaxCodP();

	// Prenotazione functionality
	void prenotazione(LocalDate data, LocalTime localTime, int tempoPrenotazione, int daOra, int aOra, int codP, int codStr, int codD, int codPers);

	void eliminaPrenotazione(int codP);

	String[] getRiepilogoStrumentoBasedOnMonth(int codStr);

	String[] getRiepilogoStrumentoBasedOnYear(int codStr);
	
	String[] getRiepilogoUtenteBasedOnMonth(int codStr);
	
	String[] getRiepilogoUtenteBasedOnYear(int codStr);

	int[] getConsumoDotazioneBasedOnMonth(ArrayList<DotazioneAccessoria> alD, String nomeDotazione);

	int[] getConsumoDotazioneBasedOnYear(ArrayList<DotazioneAccessoria> alD, String nomeDotazione);
	
	String getSlotPrenotatiBasedOnStrumentoAndDate(String nomeSede, String nomeStrumento, LocalDate localDate);
}
