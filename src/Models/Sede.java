package Models;
import java.util.ArrayList;
import java.util.UUID;

public class Sede {
	private String nome;
	private String via;
	private String CAP;
	private String città;
	private String regione;
	private UUID codS = UUID.randomUUID();
	
	ArrayList<Personale> personale = new ArrayList<Personale>();
}
