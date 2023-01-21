package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
		ArrayList<DotazioneAccessoria> dotazioneArray = new ArrayList<DotazioneAccessoria>();

		try {
			String query = "SELECT * FROM Dotazione_Accessoria ORDER BY(codD)";
			Statement statementQuery = connection.createStatement();
			ResultSet rs = statementQuery.executeQuery(query);

			while(rs.next()) {       
				dotazioneArray.add(new DotazioneAccessoria(rs.getString("nome"), rs.getString("descrizione"), rs.getInt("quantita"), rs.getString("tipo"), rs.getInt("codD"), rs.getInt("codStr")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dotazioneArray;
	}
	
	@Override
	public ArrayList<DotazioneAccessoria> getDotazioniBasedOnSede(int codPers, String nomeSede){
		
		ArrayList<DotazioneAccessoria> dotazioneArray = new ArrayList<DotazioneAccessoria>();

		try {

			String query = "SELECT DISTINCT D.nome, D.codD, D.tipo, D.descrizione, D.quantita, D.codStr"
					+ " FROM PersonaleSede AS P JOIN Sede AS S ON S.CodS = P.CodS"
					+ " JOIN Postazione AS PO ON PO.CodS = S.CodS"
					+ " JOIN StrumentoPostazione AS SP ON PO.CodPos = SP.CodPos"
					+ " JOIN Strumento AS STR ON SP.CodStr = STR.CodStr"
					+ " JOIN Dotazione_accessoria AS D ON D.CodStr = STR.CodStr"
					+ " WHERE P.CodPers = ? AND S.nome LIKE ? AND D.tipo = 'altro'";

			PreparedStatement prepStatementQuery = connection.prepareStatement(query);

			prepStatementQuery.setInt(1,codPers);
			prepStatementQuery.setString(2,nomeSede);

			ResultSet rs = prepStatementQuery.executeQuery();

			while(rs.next()) {
				dotazioneArray.add(new DotazioneAccessoria(rs.getString("nome"), rs.getString("descrizione"), rs.getInt("quantita"), rs.getString("tipo"), rs.getInt("codD"), rs.getInt("codStr")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dotazioneArray;
	}

	@Override
	public ArrayList<String> getMaterialiConsumabili() {

		ArrayList<String> materialiConsumabiliArray = new ArrayList<String>();

		try {
			String query = "SELECT D.nome"
							+ " FROM Dotazione_Accessoria as D"
							+ " WHERE D.tipo <> 'altro'";

			Statement statementQuery = connection.createStatement();
			ResultSet rs = statementQuery.executeQuery(query);

			while(rs.next()) {       
				materialiConsumabiliArray.add(rs.getString("nome"));
				System.out.println(rs.getString("nome"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return materialiConsumabiliArray;
	}
}
