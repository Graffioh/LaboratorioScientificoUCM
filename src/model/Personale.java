package model;
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
	private int codPers;
	
	ArrayList<Sede> sediDoveLavora = new ArrayList<Sede>();
	ArrayList<Prenotazione> prenotazioni = new ArrayList<Prenotazione>();
	
	public Personale(String nome, String cognome, String via, String CAP, String regione, String email,
			LocalDate dataNascita, String recapitoTel, String recapitoTelAziendale, String matricola,
			TypePersonale tipoPers, int codPers, ArrayList<Sede> sediDoveLavora, ArrayList<Prenotazione> prenotazioni) {
		this.nome = nome;
		this.cognome = cognome;
		this.via = via;
		this.CAP = CAP;
		this.regione = regione;
		this.email = email;
		this.dataNascita = dataNascita;
		this.recapitoTel = recapitoTel;
		this.recapitoTelAziendale = recapitoTelAziendale;
		this.matricola = matricola;
		this.tipoPers = tipoPers;
		this.codPers = codPers;
		this.sediDoveLavora = sediDoveLavora;
		this.prenotazioni = prenotazioni;
	}
	
	public String getMatricola() {
		return this.matricola;
	}
	
	public int getCodice() {
		return this.codPers;
	}
	
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	
	public void setCodice(int codice) {
		this.codPers = codice;
	}
}