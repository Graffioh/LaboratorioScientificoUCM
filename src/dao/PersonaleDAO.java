package dao;

import java.util.ArrayList;

import model.Personale;

public interface PersonaleDAO {
	
	// Populate the arraylist based on database table
	ArrayList<Personale> populate();
	
	// Manage the user login
	boolean logIn(String matricola, int codice); 
	
}