package model;
import java.util.ArrayList;

public class Strumento {
	
	public enum TypeStrumento{
		misurazione,
		miscelazione,
		analisi,
		riscaldanti,
		fisicaAtomica,
		trasferimento_sostanze,
		altro;
	}
	
	private String nome;
	private String descrizione;
	private String caratteristicheTecniche;
	private TypeStrumento tipoStr;
	private int tempoUso;
	private int codStr;
	
	ArrayList<Postazione> postazioni = new ArrayList<Postazione>();
	ArrayList<DotazioneAccessoria> dotazioniAccessorie = new ArrayList<DotazioneAccessoria>();
	//ArrayList<Prenotazione> prenotazioni = new ArrayList<Prenotazione>();
	
	public Strumento(String nome, String descrizione, String caratteristicheTecniche, String tipoStrumentoStr, int tempoUso, int codStr,
			ArrayList<Postazione> postazioni, ArrayList<DotazioneAccessoria> dotazioniAccessorie) {
		this.nome = nome;
		this.descrizione = descrizione;
		this.caratteristicheTecniche = caratteristicheTecniche;
		this.tipoStr = TypeStrumento.valueOf(tipoStrumentoStr);
		this.tempoUso = tempoUso;
		this.codStr = codStr;
		this.postazioni = postazioni;
		this.dotazioniAccessorie = dotazioniAccessorie;
		//this.prenotazioni = prenotazioni;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getCaratteristicheTecniche() {
		return caratteristicheTecniche;
	}
	public void setCaratteristicheTecniche(String caratteristicheTecniche) {
		this.caratteristicheTecniche = caratteristicheTecniche;
	}
	public TypeStrumento getTipoStr() {
		return tipoStr;
	}
	public void setTipoStr(TypeStrumento tipoStr) {
		this.tipoStr = tipoStr;
	}
	public int getTempoUso() {
		return tempoUso;
	}
	public void setTempoUso(int tempoUso) {
		this.tempoUso = tempoUso;
	}
	public int getCodice() {
		return codStr;
	}
	public void setCodice(int codStr) {
		this.codStr = codStr;
	}
	public ArrayList<Postazione> getPostazioni() {
		return postazioni;
	}
	public void setPostazioni(ArrayList<Postazione> postazioni) {
		this.postazioni = postazioni;
	}
	public ArrayList<DotazioneAccessoria> getDotazioniAccessorie() {
		return dotazioniAccessorie;
	}
	public void setDotazioniAccessorie(ArrayList<DotazioneAccessoria> dotazioniAccessorie) {
		this.dotazioniAccessorie = dotazioniAccessorie;
	}
	/*public ArrayList<Prenotazione> getPrenotazioni() {
		return prenotazioni;
	}
	public void setPrenotazioni(ArrayList<Prenotazione> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}*/
}