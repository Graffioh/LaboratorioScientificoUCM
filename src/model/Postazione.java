package model;
import java.util.ArrayList;
import java.util.UUID;

public class Postazione {
	private String numero;
	private int codPos;
	ArrayList<Personale> personale = new ArrayList<Personale>();
	ArrayList<Strumento> strumenti = new ArrayList<Strumento>();
	
	public String getNumero() {
		return numero;
	}

	public int getCodPos() {
		return codPos;
	}

	public ArrayList<Personale> getPersonale() {
		return personale;
	}

	public ArrayList<Strumento> getStrumenti() {
		return strumenti;
	}
}
