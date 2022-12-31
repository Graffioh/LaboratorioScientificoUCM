package controller;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import dao.PersonaleImpl;
import gui.MainGUI;
import model.Personale;

public class Controller {
	// Switch to the main page when login button is pressed & the login is successful
	public void switchToMainPage(String matricola, int codice, JFrame loginFrame, MainGUI mainPage) {
		PersonaleImpl personaleDAO = new PersonaleImpl();

		if(personaleDAO.logIn(matricola,codice)) {
			loginFrame.setVisible(false);
			mainPage = new MainGUI();
			mainPage.setVisible(true);
		} 
		else{
			JOptionPane.showMessageDialog(null, "Login non riuscito, riprovare");
		}
	}
	
	// Filter personale based on matricola and codice from login
	public Personale filterBasedOnMatricolaCodice(ArrayList<Personale> personaleArray, String matricola, int codice){
		Personale tmpPersonale = new Personale("", "", "", "", "", "", null, "", "", "", "tecnico", 0, null, null);

		// For each personale object inside the array list, check for the one with the same matricola and codice as the one in the login phase
		for (Personale p : personaleArray){
			if(matricola.equals(p.getMatricola()) && codice == p.getCodice()) {
				tmpPersonale = p;
			}
		}

		return tmpPersonale;
	}
}
