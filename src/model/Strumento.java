package model;
import java.util.ArrayList;
import java.util.UUID;

enum TypeStrumento{
		misurazione,
		miscelazione,
		analisi,
		riscaldanti,
		fisicaAtomica,
		trasferimentoSostanze,
		altro;
}

public class Strumento {
	private String nome;
	private String descrizione;
	private String caratteristicheTecniche;
	private TypeStrumento tipoStr;
	private int codStr;
	private int codP;
	ArrayList<Postazione> postazioni = new ArrayList<Postazione>();
	ArrayList<DotazioneAccessoria> dotazioniAccessorie = new ArrayList<DotazioneAccessoria>();
	
	public Strumento(String nome, String descrizione, String caratteristicheTecniche, TypeStrumento tipoStr, int codStr,
			ArrayList<Postazione> postazioni, ArrayList<DotazioneAccessoria> dotazioniAccessorie, int codP) {
		this.nome = nome;
		this.descrizione = descrizione;
		this.caratteristicheTecniche = caratteristicheTecniche;
		this.tipoStr = tipoStr;
		this.codStr = codStr;
		this.postazioni = postazioni;
		this.dotazioniAccessorie = dotazioniAccessorie;
		this.codP = codP;
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
	public int getCodStr() {
		return codStr;
	}
	public void setCodStr(int codStr) {
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
}