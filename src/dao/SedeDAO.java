package dao;

import java.util.ArrayList;

import model.Sede;

public interface SedeDAO {
    // Populate the arraylist based on database table
	ArrayList<Sede> populate();
}
