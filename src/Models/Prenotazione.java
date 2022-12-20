package Models;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.UUID;

public class Prenotazione {
	private LocalDate data;
	private LocalTime ora;
	private String tempoUso;
	private UUID codP = UUID.randomUUID();
	
	ArrayList<Strumento> strumenti = new ArrayList<Strumento>();
	ArrayList<DotazioneAccessoria> dotazioniAccessorie = new ArrayList<DotazioneAccessoria>();
}