package dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DB;
import model.Postazione;

public class PostazioneImpl implements PostazioneDAO {
	
    private Connection connection = null;

	public PostazioneImpl() {
		connection = DB.getDB().getConnection();
	}

	@Override
	public ArrayList<Postazione> populate() {
		
		ArrayList<Postazione> postazioneArray = new ArrayList<Postazione>();

		try {
			String query = "SELECT * FROM Postazione";
			Statement statementQuery = connection.createStatement();
			ResultSet rs = statementQuery.executeQuery(query);

			while(rs.next()) {
				postazioneArray.add(new Postazione());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return postazioneArray;
	}
}
