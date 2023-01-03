package dao;

import java.util.ArrayList;

import model.Postazione;

public interface PostazioneDAO {
    // Populate the arraylist based on database table
	ArrayList<Postazione> populate();
}
