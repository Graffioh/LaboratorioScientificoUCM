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

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	
	public int getCodice() {
		return this.codPers;
	}
	
	public void setCodice(int codice) {
		this.codPers = codice;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getCAP() {
		return CAP;
	}

	public void setCAP(String cAP) {
		CAP = cAP;
	}

	public String getRegione() {
		return regione;
	}

	public void setRegione(String regione) {
		this.regione = regione;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getRecapitoTel() {
		return recapitoTel;
	}

	public void setRecapitoTel(String recapitoTel) {
		this.recapitoTel = recapitoTel;
	}

	public String getRecapitoTelAziendale() {
		return recapitoTelAziendale;
	}

	public void setRecapitoTelAziendale(String recapitoTelAziendale) {
		this.recapitoTelAziendale = recapitoTelAziendale;
	}

	public TypePersonale getTipoPers() {
		return tipoPers;
	}

	public void setTipoPers(TypePersonale tipoPers) {
		this.tipoPers = tipoPers;
	}

	public ArrayList<Sede> getSediDoveLavora() {
		return sediDoveLavora;
	}

	public void setSediDoveLavora(ArrayList<Sede> sediDoveLavora) {
		this.sediDoveLavora = sediDoveLavora;
	}

	public ArrayList<Prenotazione> getPrenotazioni() {
		return prenotazioni;
	}

	public void setPrenotazioni(ArrayList<Prenotazione> prenotazioni) {
		this.prenotazioni = prenotazioni;
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