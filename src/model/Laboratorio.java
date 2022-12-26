package model;
import java.util.UUID;	
import java.util.ArrayList;
enum TypeLaboratorio{
		fisico,
		chimico,
		biomedico,
		altro;
}

public class Laboratorio {
	private String nome;
	private String descrizione;
	private TypeLaboratorio tipoLab;
	private UUID codL = UUID.randomUUID();
	
	ArrayList<Sede> sedi = new ArrayList<Sede>();
	ArrayList<Postazione> postazioni = new ArrayList<Postazione>();
}
