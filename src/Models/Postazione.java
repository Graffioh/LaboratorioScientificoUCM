package Models;
import java.util.ArrayList;
import java.util.UUID;

public class Postazione {
	private String numero;
	private UUID codPos = UUID.randomUUID();
	
	ArrayList<Personale> personale = new ArrayList<Personale>();
	ArrayList<Strumento> strumenti = new ArrayList<Strumento>();
}
