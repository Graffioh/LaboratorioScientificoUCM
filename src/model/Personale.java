package model;
import java.time.LocalDate;
import java.util.ArrayList;

public class Personale {

	public enum TypePersonale{
		tecnico,
		responsabile;
	}
	
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
			String tipoPersStr, int codPers, ArrayList<Sede> sediDoveLavora, ArrayList<Prenotazione> prenotazioni) {
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
		this.tipoPers = TypePersonale.valueOf(tipoPersStr);
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

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getVia() {
		return via;
	}

	public String getCAP() {
		return CAP;
	}

	public String getRegione() {
		return regione;
	}
	
	public String getEmail() {
		return email;
	}

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public String getRecapitoTel() {
		return recapitoTel;
	}

	public String getRecapitoTelAziendale() {
		return recapitoTelAziendale;
	}

	public TypePersonale getTipoPers() {
		return tipoPers;
	}

	public ArrayList<Sede> getSediDoveLavora() {
		return sediDoveLavora;
	}
	
	public void setSediDoveLavora(ArrayList<Sede> sedi) {
		this.sediDoveLavora = sedi;
	}

	public ArrayList<Prenotazione> getPrenotazioni() {
		return prenotazioni;
	}

	@Override
   	public String toString() {
        return ("nome:"+ this.getNome() +
                    " cognome: "+ this.getCognome() +
                    " via: "+ this.getVia() +
                    " CAP: " + this.getCAP() + 
					" regione: " + this.getRegione() +
					" email: " + this.getEmail() +
					" dataNascita: " + this.getDataNascita() +
					" recapitoTel: " + this.getRecapitoTel() +
					" matricola: " + this.getMatricola() + 
					" codice: " + this.getCodice() +
        			"tipo: " + this.getTipoPers());
   	}
}