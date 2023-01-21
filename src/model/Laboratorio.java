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
		super();
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

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public TypeLaboratorio getTipoLab() {
		return tipoLab;
	}

	public void setTipoLab(TypeLaboratorio tipoLab) {
		this.tipoLab = tipoLab;
	}

	public int getCodL() {
		return codL;
	}

	public void setCodL(int codL) {
		this.codL = codL;
	}

	public ArrayList<Sede> getSedi() {
		return sedi;
	}

	public void setSedi(ArrayList<Sede> sedi) {
		this.sedi = sedi;
	}

	public ArrayList<Postazione> getPostazioni() {
		return postazioni;
	}

	public void setPostazioni(ArrayList<Postazione> postazioni) {
		this.postazioni = postazioni;
	}
	
}
