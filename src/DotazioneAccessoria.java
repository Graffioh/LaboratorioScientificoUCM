import java.util.UUID;

enum TypeDotazione{
	//?,
	//?,
	altro;
}

public class DotazioneAccessoria {
	private String nome;
	private String descrizione;
	private TypeDotazione tipoD;
	private UUID codD = UUID.randomUUID();
}
