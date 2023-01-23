package dao;

import java.util.ArrayList;

import model.DotazioneAccessoria;

public interface DotazioneAccessoriaDAO {
	// Populate the arraylist based on database table
	ArrayList<DotazioneAccessoria> populate();
	
	ArrayList<DotazioneAccessoria> getDotazioniBasedOnSede(int codPers, String nomeSede);

	ArrayList<String> getNomiMaterialiConsumabili();
		
	ArrayList<DotazioneAccessoria> getDotazioniAccessorie();
	
	int getCodiceBasedOnNome(String nomeDotazione);

}
