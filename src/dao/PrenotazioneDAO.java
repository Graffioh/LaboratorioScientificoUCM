package dao;

//import java.sql.Date;
import java.time.*;
import java.util.ArrayList;

import model.Prenotazione;
import model.Strumento;
import model.DotazioneAccessoria;

import java.sql.Timestamp;

public interface PrenotazioneDAO {
	// Populate the arraylist based on database table
	ArrayList<Prenotazione> populate();
	
	// Get strumenti based on sede selected in combobox and based on filtered personale
	ArrayList<Prenotazione> getPrenotazioneBasedOnSede(int codPers, String nomeSede);
	
	
	<T> String getNomeBasedOnPrenotazione(T pr);
	
	int getMaxCodP();

	// Prenotazione functionality
	void prenotazione(LocalDate data, LocalTime localTime, int tempoPrenotazione, int daOra, int aOra, int codP, int codStr, int codD, int codPers);

	void eliminaPrenotazione(int codP);
}
