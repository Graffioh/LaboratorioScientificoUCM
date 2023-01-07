package dao;

import java.util.ArrayList;

import model.Strumento;

public interface StrumentoDAO {
	// Populate the arraylist based on database table
	ArrayList<Strumento> populate();
		
	// Get strumenti based on sede selected in combobox and based on filtered personale
	ArrayList<Strumento> getStrumentiBasedOnSede(int codPers, String nomeSede);
}
