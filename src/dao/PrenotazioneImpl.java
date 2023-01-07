package dao;

import java.sql.Connection;
//import java.sql.Date;
import java.time.*;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;

import database.DB;
import model.DotazioneAccessoria;
import model.Prenotazione;
import model.Strumento;

public class PrenotazioneImpl implements PrenotazioneDAO {
	
	private Connection connection = null;
	
	public PrenotazioneImpl() {
		connection = DB.getDB().getConnection();
	}
	
	public ArrayList<Prenotazione> populate(){
		ArrayList<Prenotazione> prenotazioneArray = new ArrayList<Prenotazione>();

		try {

			String query = "SELECT * FROM Prenotazione";
			Statement statementQuery = connection.createStatement();
			ResultSet rs = statementQuery.executeQuery(query);

			while(rs.next()) {   
				prenotazioneArray.add(new Prenotazione(rs.getDate("datap").toLocalDate(), rs.getTime("ora").toLocalTime(), rs.getInt("tempo_prenotazione"), rs.getInt("daora"), rs.getInt("aora"), rs.getInt("codp"), rs.getInt("codstr"), rs.getInt("codd"), rs.getInt("codpers")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return prenotazioneArray;
	}
	
	public ArrayList<Prenotazione> getPrenotazioneBasedOnSede(int codPers, String nomeSede){
		
		ArrayList<Prenotazione> prenotazioneArray = new ArrayList<Prenotazione>();

		try {

			String query = "SELECT PR.datap, PR.ora, PR.tempo_prenotazione, PR.codP, PR.codPers, PR.codStr, PR.codD, PR.DaOra, PR.AOra"
			+ " FROM PersonaleSede as P"
			+ " JOIN Sede as S ON P.CodS = S.CodS"
			+ " JOIN Personale as PE ON P.CodPers = PE.CodPers"
			+ " JOIN Prenotazione AS PR ON PE.CodPers = PR.CodPers"
            + " WHERE P.CodPers = ? AND S.nome LIKE ?";
    
			PreparedStatement prepStatementQuery = connection.prepareStatement(query);

			prepStatementQuery.setInt(1,codPers);
			prepStatementQuery.setString(2,nomeSede);

			ResultSet rs = prepStatementQuery.executeQuery();

			while(rs.next()) {
				prenotazioneArray.add(new Prenotazione(rs.getDate("datap").toLocalDate(), rs.getTime("ora").toLocalTime(), rs.getInt("tempo_prenotazione"), rs.getInt("daora"), rs.getInt("aora"), rs.getInt("codp"), rs.getInt("codstr"), rs.getInt("codd"), rs.getInt("codpers")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return prenotazioneArray;
	}

	public String getNomeBasedOnPrenotazione(Prenotazione pr){
		String nomeStrumento = "";

		/*try {

			String query = ;

			PreparedStatement prepStatementQuery = connection.prepareStatement(query);

			prepStatementQuery.setInt(1,codPers);
			prepStatementQuery.setString(2,nomeSede);

			ResultSet rs = prepStatementQuery.executeQuery();

			nomeStrumento = rs.getString("nome");

		} catch (SQLException e) {
			e.printStackTrace();
		}*/

		return nomeStrumento;
	}

	public String getNomeBasedOnPrenotazione(DotazioneAccessoria dot){
		String nomeDotazione = "";

		/*try {

			String query = ;

			PreparedStatement prepStatementQuery = connection.prepareStatement(query);

			prepStatementQuery.setInt(1,codPers);
			prepStatementQuery.setString(2,nomeSede);

			ResultSet rs = prepStatementQuery.executeQuery();

			nomeDotazione = rs.getString("nome");

		} catch (SQLException e) {
			e.printStackTrace();
		}*/

		return nomeDotazione;
	}
	
	
	public void prenotazione(LocalDate data, long timestampLong, int tempoPrenotazione, int daOra, int aOra, int codP, int codStr, int codD, int codPers) {
		try {

			Timestamp timestamp1 = new Timestamp(timestampLong);
			
			String query = "INSERT INTO Prenotazione(datap, ora, tempo_prenotazione, DaOra, AOra, codP, codStr, codD, codPers) VALUES (?,?,?,?,?,?,?,?,?)";

			PreparedStatement prepStatementQuery = connection.prepareStatement(query);

			prepStatementQuery.setDate(1,java.sql.Date.valueOf(data));
			prepStatementQuery.setTimestamp(2,timestamp1);
			prepStatementQuery.setInt(3,tempoPrenotazione);
			prepStatementQuery.setInt(4,daOra);
			prepStatementQuery.setInt(5,aOra);
			prepStatementQuery.setInt(6,codP);
			prepStatementQuery.setInt(7,codStr);
			prepStatementQuery.setInt(8,codD);
			prepStatementQuery.setInt(9,codPers);

			prepStatementQuery.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void eliminaPrenotazione(int codP){
		try {
			
			String query = "DELETE FROM Prenotazione WHERE CodP = ?";

			PreparedStatement prepStatementQuery = connection.prepareStatement(query);

			prepStatementQuery.setInt(1,codP);

			prepStatementQuery.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
