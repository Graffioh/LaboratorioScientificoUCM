package model;


public class DotazioneAccessoria {
	public enum TypeDotazione{
		solventi,
		guantiLattice,
		reagenti,
		altro;
	}
	
	private String nome;
	private String descrizione;
	private Integer quantità;
	private TypeDotazione tipoD;
	private int codD;
	private int codStr;
	
	public DotazioneAccessoria(String nome, String descrizione, Integer quantità, String tipoDStr, int codD, int codStr) {
		this.nome = nome;
		this.descrizione = descrizione;
		this.quantità = quantità;
		this.tipoD = TypeDotazione.valueOf(tipoDStr);
		this.codD = codD;
		this.codStr = codStr;
	}
	
	public String getNome() {
		return nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public Integer getQuantità() {
		return quantità;
	}

	public TypeDotazione getTipoD() {
		return tipoD;
	}

	public Integer getCodice() {
		return codD;
	}
	
	public int getCodStr() {
		return codStr;
	}
	
}
