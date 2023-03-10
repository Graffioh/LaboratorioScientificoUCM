package dao;

import java.util.ArrayList;

import database.DB;
import model.Personale;
import model.Strumento;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

			String query = "SELECT * FROM Strumento ORDER BY(codStr)";
			Statement statementQuery = connection.createStatement();
			ResultSet rs = statementQuery.executeQuery(query);

			while(rs.next()) {    
				strumentoArray.add(new Strumento(rs.getString("nome"), rs.getString("descrizione"), rs.getString("caratteristiche_tecniche"), rs.getString("categoria"), rs.
				getInt("tempo_uso"), rs.getInt("codstr"), null, null));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return strumentoArray;
	}
	
	@Override
	public ArrayList<Strumento> getStrumentiBasedOnSede(int codPers, String nomeSede){
		
		ArrayList<Strumento> strumentoArray = new ArrayList<Strumento>();

		try {

			String query = "SELECT DISTINCT STR.nome, STR.descrizione, STR.caratteristiche_tecniche, STR.tempo_uso, STR.categoria, STR.codstr"
					+ " FROM PersonaleSede as P JOIN Sede as S ON S.CodS = P.CodS"
					+ " JOIN Postazione as PO ON PO.CodS = S.CodS"
					+ " JOIN StrumentoPostazione as SP ON PO.CodPos = SP.CodPos"
					+ " JOIN Strumento as STR ON SP.CodStr = STR.CodStr"
					+ " WHERE P.CodPers = ? AND S.nome LIKE ?";

			PreparedStatement prepStatementQuery = connection.prepareStatement(query);

			prepStatementQuery.setInt(1,codPers);
			prepStatementQuery.setString(2,nomeSede);

			ResultSet rs = prepStatementQuery.executeQuery();

			while(rs.next()) {
				strumentoArray.add(new Strumento(rs.getString("nome"), rs.getString("descrizione"), rs.getString("caratteristiche_tecniche"), rs.getString("categoria"), rs.getInt("tempo_uso"), rs.getInt("codstr"), null, null));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return strumentoArray;
	}

	public int getCodiceBasedOnNome(String nomeStrumento) {
		int codice = 0;

		try {

			String query = "SELECT STR.CodStr FROM Strumento AS STR WHERE STR.nome LIKE ?";
			PreparedStatement prepStatementQuery = connection.prepareStatement(query);

			prepStatementQuery.setString(1,nomeStrumento);

			ResultSet rs = prepStatementQuery.executeQuery();

			if(rs.next()) {    
				codice = rs.getInt("codStr");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return codice;
	}
	
	public String getNomeBasedOnCodice(int codice) {
		String nome = "";
		
		try {

			String query = "SELECT STR.nome FROM Strumento AS STR WHERE STR.CodStr = ?";
			PreparedStatement prepStatementQuery = connection.prepareStatement(query);

			prepStatementQuery.setInt(1,codice);

			ResultSet rs = prepStatementQuery.executeQuery();

			if(rs.next()) {    
				nome = rs.getString("nome");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return nome;
	}
}
