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

			String query = "SELECT * FROM Strumento";
			Statement statementQuery = connection.createStatement();
			ResultSet rs = statementQuery.executeQuery(query);

			while(rs.next()) {    
				strumentoArray.add(new Strumento(rs.getString("nome"), rs.getString("descrizione"), rs.getString("caratteristiche_tecniche"), rs.getString("categoria"), rs.getInt("codstr"), null, null, rs.getInt("codp")));
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

			String query = "SELECT STR.nome, STR.descrizione, STR.caratteristiche_tecniche, STR.categoria, STR.codstr, STR.codp"
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
				strumentoArray.add(new Strumento(rs.getString("nome"), rs.getString("descrizione"), rs.getString("caratteristiche_tecniche"), rs.getString("categoria"), rs.getInt("codstr"), null, null, rs.getInt("codp")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return strumentoArray;
	}
}
