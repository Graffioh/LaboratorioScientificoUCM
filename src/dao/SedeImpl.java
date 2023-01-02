package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.DB;
import model.Sede;

public class SedeImpl implements SedeDAO {
    private Connection connection = null;

	public SedeImpl() {
		connection = DB.getDB().getConnection();
	}

	
	@Override
	public ArrayList<Sede> populate() {
		ArrayList<Sede> sedeArray = new ArrayList<Sede>();

		try {
			String query = "SELECT * FROM Sede";
			Statement statementQuery = connection.createStatement();
			ResultSet rs = statementQuery.executeQuery(query);

			while(rs.next()) {
				sedeArray.add(new Sede(rs.getString("nome"), rs.getString("via"), rs.getString("CAP"), rs.getString("città"), rs.getString("regione"), rs.getInt("cods"), null));
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}

		return sedeArray;
	}
}
