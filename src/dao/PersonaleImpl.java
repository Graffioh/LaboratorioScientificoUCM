package dao;

import java.sql.Statement;
import java.util.ArrayList;

import database.DB;
import model.Personale;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonaleImpl implements PersonaleDAO {

	private Connection connection = null;

	public PersonaleImpl() {
		connection = DB.getDB().getConnection();
	}

	
	@Override
	public ArrayList<Personale> populate() {
		ArrayList<Personale> alPersonale = new ArrayList<Personale>();

		try {

			String query = "SELECT * FROM Personale";
			Statement statementQuery = connection.createStatement();
			ResultSet rs = statementQuery.executeQuery(query);

			while(rs.next()) {
				//for(int i = 1; i <= 4; i++){           
					alPersonale.add(new Personale(rs.getString("nome"), rs.getString("cognome"), rs.getString("via"), rs.getString("CAP"), rs.getString("regione"), rs.getString("email"), rs.getDate("data_nascita").toLocalDate(),rs.getString("recapito_tel"), rs.getString("recapito_tel_aziendale"), rs.getString("matricola"), rs.getString("tipo_personale"),  rs.getInt("codPers"), null, null));
				//} 
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return alPersonale;
	}

	@Override
	public boolean logIn(String matricola, int codice) {
		boolean check = false;

		try { 	
			String queryMatricola = "SELECT matricola, codpers FROM Personale WHERE matricola = '" + matricola + "' AND codpers = " + codice + "";
			Statement statementQueryMatricola = connection.createStatement();
			ResultSet rsMatricola = statementQueryMatricola.executeQuery(queryMatricola);

			// If there is at least one result row from the query then its ok, otherwise return false
			if(!rsMatricola.next()) {
				return false;
			}

			check = true;

			connection.close();
		} catch (SQLException e) {
			e.getStackTrace();
		}

		return check;
	}

}