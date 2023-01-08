package model;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.UUID;

public class Prenotazione {
	private LocalDate data;
	private LocalTime oraPrenotazione;
	private int tempoPrenotazione;
	private int daOra;
	private int aOra;
	private int codP;
	private int codStr;
	private int codD;
	private int codPers;
	
	public Prenotazione(LocalDate data, LocalTime oraPrenotazione, int tempoPrenotazione, int daOra, int aOra, int codP, int codStr, int codD, int codPers) {
		super();
		this.data = data;
		this.oraPrenotazione = oraPrenotazione;
		this.tempoPrenotazione = tempoPrenotazione;
		this.daOra = daOra;
		this.aOra = aOra;
		this.codP = codP;
		this.codStr = codStr;
		this.codD = codD;
		this.codPers = codPers;
	}
	
	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getOra() {
		return oraPrenotazione;
	}

	public void setOra(LocalTime oraPrenotazione) {
		this.oraPrenotazione = oraPrenotazione;
	}

	public int getTempoPrenotazione() {
		return tempoPrenotazione;
	}

	public void setTempoPrenotazione(int tempoPrenotazione) {
		this.tempoPrenotazione = tempoPrenotazione;
	}
	
	public int getDaOra() {
		return daOra;
	}

	public void setDaOra(int daOra) {
		this.daOra = daOra;
	}

	public int getAOra() {
		return aOra;
	}

	public void setAOra(int aOra) {
		this.aOra = aOra;
	}
	
	public int getCodice() {
		return codP;
	}

	public void setCodice(int codP) {
		this.codP = codP;
	}

	public int getCodStr() {
		return codStr;
	}

	public void setCodStr(int codStr) {
		this.codStr = codStr;
	}
	
	public int getCodD() {
		return codD;
	}

	public void setCodD(int codD) {
		this.codD = codD;
	}

	public int getCodPers() {
		return codPers;
	}

	public void setCodPers(int codPers) {
		this.codPers = codPers;
	}
	
}