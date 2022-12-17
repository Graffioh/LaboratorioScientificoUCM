import java.util.UUID;	

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
}
