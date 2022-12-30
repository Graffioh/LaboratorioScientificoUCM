package controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import dao.PersonaleImpl;
import gui.MainGUI;

public class Controller {
	public void switchToMainPage(String matricola, int codice, JFrame page, MainGUI mainPage) {
		PersonaleImpl prova11 = new PersonaleImpl();

		if(prova11.logIn(matricola,codice)) {
			page.setVisible(false);
			mainPage = new MainGUI();
			mainPage.setVisible(true);
		} 
		else{
			JOptionPane.showMessageDialog(null, "Login non riuscito, riprovare");
		}
	}
}
