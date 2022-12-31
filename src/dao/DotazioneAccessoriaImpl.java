package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.DB;
import model.DotazioneAccessoria;

public class DotazioneAccessoriaImpl implements DotazioneAccessoriaDAO {
	
	private Connection connection = null;
	
	public DotazioneAccessoriaImpl() {
		connection = DB.getDB().getConnection();
	}
	
	@Override
	public ArrayList<DotazioneAccessoria> populate(){
		ArrayList<DotazioneAccessoria> strumentoArray = new ArrayList<DotazioneAccessoria>();

		try {
			String query = "SELECT * FROM Dotazione_Accessoria";
			Statement statementQuery = connection.createStatement();
			ResultSet rs = statementQuery.executeQuery(query);

			while(rs.next()) {       
				strumentoArray.add(new DotazioneAccessoria(rs.getString("nome"), rs.getString("descrizione"), rs.getInt("quantita"), null, rs.getInt("codD"), rs.getInt("codP"),rs.getInt("codStr")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return strumentoArray;
	}
}
