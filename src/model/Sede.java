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

	public void setNome(String nome) {
		this.nome = nome;
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

	public void setCAP(String CAP) {
		this.CAP = CAP;
	}

	public String getCittà() {
		return città;
	}

	public void setCittà(String città) {
		this.città = città;
	}

	public String getRegione() {
		return regione;
	}

	public void setRegione(String regione) {
		this.regione = regione;
	}

	public int getCodS() {
		return codS;
	}

	public void setCodS(int codS) {
		this.codS = codS;
	}

	public ArrayList<Personale> getPersonale() {
		return personale;
	}

	public void setPersonale(ArrayList<Personale> personale) {
		this.personale = personale;
	}

	/*@Override
   	public String toString() {
        return ("nome:"+ this.getNome());
   	}*/
}
