import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

enum TypePersonale{
		tecnico,
		responsabile;
}

public class Personale {
	private String nome;
	private String cognome;
	private String via;
	private String CAP;
	private String regione;
	private String email;
	private LocalDate dataNascita;
	private String recapitoTel;
	private String recapitoTelAziendale;
	private String matricola;
	private TypePersonale tipoPers;

	private UUID codPers = UUID.randomUUID();
	
	ArrayList<Prenotazione> prenotazioni = new ArrayList<Prenotazione>();
}