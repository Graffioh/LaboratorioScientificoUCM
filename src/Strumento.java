import java.util.UUID;

enum TypeStrumento{
		misurazione,
		miscelazione,
		analisi,
		riscaldanti,
		fisicaAtomica,
		trasferimentoSostanze,
		altro;
}

public class Strumento {
	private String nome;
	private String descrizione;
	private String caratteristicheTecniche;
	private TypeStrumento tipoStr;

	private UUID codStr = UUID.randomUUID();
}
