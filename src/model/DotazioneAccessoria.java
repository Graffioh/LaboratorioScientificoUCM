package model;
import java.util.UUID;


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
	private int codP;
	private int codStr;
	
	public DotazioneAccessoria(String nome, String descrizione, Integer quantità, String tipoDStr, int codD, int codP, int codStr) {
		super();
		this.nome = nome;
		this.descrizione = descrizione;
		this.quantità = quantità;
		this.tipoD = TypeDotazione.valueOf(tipoDStr);
		this.codD = codD;
		this.codP = codP;
		this.codStr = codStr;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Integer getQuantità() {
		return quantità;
	}

	public void setQuantità(Integer quantità) {
		this.quantità = quantità;
	}

	public TypeDotazione getTipoD() {
		return tipoD;
	}

	public void setTipoD(TypeDotazione tipoD) {
		this.tipoD = tipoD;
	}

	public Integer getCodD() {
		return codD;
	}

	public void setCodD(int codD) {
		this.codD = codD;
	}
	
	public int getCodP() {
		return codP;
	}

	public void setCodP(int codP) {
		this.codP = codP;
	}
	
	public int getCodStr() {
		return codStr;
	}

	public void setCodStr(int codStr) {
		this.codStr = codStr;
	}
	
}
