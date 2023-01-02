package dao;

import java.util.ArrayList;

import database.DB;
import model.Personale;
import model.Sede;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonaleImpl implements PersonaleDAO {

	private Connection connection = null;

	public PersonaleImpl() {
		connection = DB.getDB().getConnection();
	}

	
	@Override
	public ArrayList<Personale> populate() {
		ArrayList<Personale> personaleArray = new ArrayList<Personale>();

		//SedeImpl sedeDAO = new SedeImpl();
		ArrayList<Sede> sedeArray = new ArrayList<Sede>();

		//sedeArray = sedeDAO.populate();

		try {
			String query = "SELECT * FROM Personale";
			Statement statementQuery = connection.createStatement();
			ResultSet rs = statementQuery.executeQuery(query);

			while(rs.next()) {
				personaleArray.add(new Personale(rs.getString("nome"), rs.getString("cognome"), rs.getString("via"), rs.getString("CAP"), rs.getString("regione"), rs.getString("email"), rs.getDate("data_nascita").toLocalDate(),rs.getString("recapito_tel"), rs.getString("recapito_tel_aziendale"), rs.getString("matricola"), rs.getString("tipo_personale"),  rs.getInt("codPers"), null, null));
			}

			/*String query2 = "SELECT * FROM PersonaleSede as P JOIN Sede as S ON S.CodS = P.CodS WHERE P.CodPers = ?";
			Statement statementQuery2 = connection.createStatement();
			ResultSet rs2 = statementQuery2.executeQuery(query);*/

			// set di array list sede
			for(Personale p : personaleArray){
				String query2 = "SELECT * FROM PersonaleSede as P JOIN Sede as S ON S.CodS = P.CodS WHERE P.CodPers = ?";
				PreparedStatement prepStatementQuery = connection.prepareStatement(query2);

				prepStatementQuery.setInt(1,p.getCodice());

				ResultSet rs2 = prepStatementQuery.executeQuery();

				while(rs2.next()) {
					sedeArray.add(new Sede(rs2.getString("nome"), rs2.getString("via"), rs2.getString("CAP"), rs2.getString("città"), rs2.getString("regione"), rs2.getInt("cods"), null));
				}

				p.setSediDoveLavora(sedeArray);

				//sedeArray.clear();

				//System.out.println("+++++++++++");
				//System.out.println(p.getCodice());
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return personaleArray;
	}

	@Override
	public boolean logIn(String matricola, int codice) {
		boolean check = false;

		try { 	
			String queryLogin = "SELECT matricola, codpers FROM Personale WHERE matricola = '" + matricola + "' AND codpers = " + codice + "";
			Statement statementQueryLogin = connection.createStatement();
			ResultSet rsLogin = statementQueryLogin.executeQuery(queryLogin);

			// If there is at least one result row from the query then its ok, otherwise return false
			if(!rsLogin.next()) {
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