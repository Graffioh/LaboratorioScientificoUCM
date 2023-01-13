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
}
