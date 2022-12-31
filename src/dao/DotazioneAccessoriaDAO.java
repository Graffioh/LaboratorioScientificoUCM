package dao;

import java.util.ArrayList;

import model.DotazioneAccessoria;

public interface DotazioneAccessoriaDAO {
	// Populate the arraylist based on database table
	ArrayList<DotazioneAccessoria> populate();
}
