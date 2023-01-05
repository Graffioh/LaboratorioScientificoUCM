package dao;

//import java.sql.Date;
import java.time.*;
import java.sql.Timestamp;

public interface PrenotazioneDAO {
	void prenotazione(LocalDate data, long timestampLong, int tempoPrenotazione, int daOra, int aOra, int codP, int codStr, int codPers);
}
