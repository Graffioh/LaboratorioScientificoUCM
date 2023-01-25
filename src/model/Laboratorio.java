package model;
import java.util.UUID;	
import java.util.ArrayList;


public class Laboratorio {
	public enum TypeLaboratorio{
		fisico,
		chimico,
		biomedico,
		altro;
	}

	private String nome;
	private String descrizione;
	private TypeLaboratorio tipoLab;
	private int codL;
	
	ArrayList<Sede> sedi = new ArrayList<Sede>();
	ArrayList<Postazione> postazioni = new ArrayList<Postazione>();
	
	public Laboratorio(String nome, String descrizione, TypeLaboratorio tipoLab, int codL, ArrayList<Sede> sedi,
			ArrayList<Postazione> postazioni) {
		this.nome = nome;
		this.descrizione = descrizione;
		this.tipoLab = tipoLab;
		this.codL = codL;
		this.sedi = sedi;
		this.postazioni = postazioni;
	}
	
	public String getNome() {
		return nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public TypeLaboratorio getTipoLab() {
		return tipoLab;
	}

	public int getCodL() {
		return codL;
	}

	public ArrayList<Sede> getSedi() {
		return sedi;
	}

	public ArrayList<Postazione> getPostazioni() {
		return postazioni;
	}
	
}
