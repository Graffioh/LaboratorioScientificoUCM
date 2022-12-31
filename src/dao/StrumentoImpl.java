package dao;

import java.util.ArrayList;

import database.DB;
import model.Personale;
import model.Strumento;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StrumentoImpl implements StrumentoDAO{
	
	private Connection connection = null;
	
	public StrumentoImpl() {
		connection = DB.getDB().getConnection();
	}
	
	@Override
	public ArrayList<Strumento> populate(){
		ArrayList<Strumento> strumentoArray = new ArrayList<Strumento>();

		try {

			String query = "SELECT * FROM Strumento";
			Statement statementQuery = connection.createStatement();
			ResultSet rs = statementQuery.executeQuery(query);

			while(rs.next()) {    
				strumentoArray.add(new Strumento(rs.getString("nome"), rs.getString("descrizione"), rs.getString("caratteristiche_tecniche"), null, rs.getInt("codstr"), null, null, rs.getInt("codp")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return strumentoArray;
	}
}
