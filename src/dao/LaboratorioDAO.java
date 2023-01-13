package dao;

import java.util.ArrayList;

import model.Laboratorio;

public interface LaboratorioDAO {

	// Populate the arraylist based on database table
	ArrayList<Laboratorio> populate();

    String getLaboratorioBasedOnPersonale(int codPers);
    
    String getDescrizioneBasedOnPersonale(int codPers);
   
}
