package dao;

import java.util.ArrayList;

import model.Strumento;

public interface StrumentoDAO {
	// Populate the arraylist based on database table
	ArrayList<Strumento> populate();
		
	ArrayList<Strumento> getStrumentiBasedOnSede(int codPers, String nomeSede);
}
