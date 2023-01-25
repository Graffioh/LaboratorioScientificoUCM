package model;
import java.util.ArrayList;
import java.util.UUID;

public class Sede {
	
	private String nome;
	private String via;
	private String CAP;
	private String città;
	private String regione;
	private int codS;
	private ArrayList<Personale> personale;

	public Sede(String nome, String via, String CAP, String città, String regione, int codS,
			ArrayList<Personale> personale) {
		this.nome = nome;
		this.via = via;
		this.CAP = CAP;
		this.città = città;
		this.regione = regione;
		this.codS = codS;
		this.personale = personale;
	}

	public String getNome() {
		return nome;
	}

	public String getVia() {
		return via;
	}

	public String getCAP() {
		return CAP;
	}

	public String getCittà() {
		return città;
	}

	public String getRegione() {
		return regione;
	}

	public int getCodice() {
		return codS;
	}

	public ArrayList<Personale> getPersonale() {
		return personale;
	}
}
