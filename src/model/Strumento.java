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
	}
	
	public String getNome() {
		return nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public String getCaratteristicheTecniche() {
		return caratteristicheTecniche;
	}

	public TypeStrumento getTipoStr() {
		return tipoStr;
	}
	
	public int getTempoUso() {
		return tempoUso;
	}
	
	public int getCodice() {
		return codStr;
	}
	
	public ArrayList<Postazione> getPostazioni() {
		return postazioni;
	}
	
	public ArrayList<DotazioneAccessoria> getDotazioniAccessorie() {
		return dotazioniAccessorie;
	}
}