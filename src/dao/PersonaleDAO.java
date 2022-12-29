package dao;

import java.util.ArrayList;

import model.Personale;

public interface PersonaleDAO {
	
	//ArrayList<Personale> populate();
	
	// Manage the user login
	boolean logIn(String matricola, int codice); 
	
}