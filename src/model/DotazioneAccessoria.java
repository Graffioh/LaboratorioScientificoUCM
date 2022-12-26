package model;
import java.util.UUID;

enum TypeDotazione{
	solventi,
	guantiLattice,
	reagenti,
	altro;
}

public class DotazioneAccessoria {
	private String nome;
	private String descrizione;
	private Integer quantità;
	private TypeDotazione tipoD;
	private UUID codD = UUID.randomUUID();
}
