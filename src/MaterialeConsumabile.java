import java.util.ArrayList;
import java.util.UUID;

enum TypeMateriale{
	solventi,
	guantiLattice,
	reagenti,
	altro;
}

public class MaterialeConsumabile {
	private String nome;
	private String descrizione;
	private String quantità;
	private TypeMateriale tipoM;
	private UUID codM = UUID.randomUUID();
}
