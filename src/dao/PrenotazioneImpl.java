package dao;

import java.sql.Connection;
//import java.sql.Date;
import java.time.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

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

			String query = "SELECT DISTINCT PR.datap, PR.ora, PR.tempo_prenotazione, PR.codP, PR.codPers, PR.codStr, PR.codD, PR.DaOra, PR.AOra"
				+ " FROM PersonaleSede AS P JOIN Sede AS S ON P.CodS = S.CodS"
                + " JOIN Postazione AS PO ON PO.CodS = S.CodS"
                + " JOIN StrumentoPostazione AS SP ON PO.CodPos = SP.CodPos"
                + " JOIN Strumento AS STR ON SP.CodStr = STR.CodStr"
                + " JOIN Prenotazione AS PR ON STR.CodStr = PR.CodStr"
                + " WHERE PR.CodPers = ? AND S.nome LIKE ?"
				+ " ORDER BY(PR.codP)";
    
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

	public <T> String getNomeBasedOnPrenotazione(T pr){
		String nome = "";
		
		// get nome based on strumento OR dotazione
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

		return nome;
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
			if(codD == 0)
				prepStatementQuery.setObject(8, null);
			else
				prepStatementQuery.setInt(8,codD);
			prepStatementQuery.setInt(9,codPers);

			prepStatementQuery.executeUpdate();

			JOptionPane.showMessageDialog(null, "Prenotazione riuscita.");
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Prenotazione non riuscita, riprova.");
		}
	}

	public void eliminaPrenotazione(int codP){
		try {
			
			String query = "DELETE FROM Prenotazione WHERE CodP = ?";

			PreparedStatement prepStatementQuery = connection.prepareStatement(query);

			prepStatementQuery.setInt(1,codP);

			prepStatementQuery.executeUpdate();

			JOptionPane.showMessageDialog(null, "Operazione riuscita.");
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Operazione non riuscita, riprova.");
		}
	}

	public void modificaPrenotazione(int codP, LocalDate data, long timestampLong, int tempoPrenotazione, int daOra, int aOra) {
		try {

			Timestamp timestamp1 = new Timestamp(timestampLong);
			
			String query = "UPDATE Prenotazione"
			+ " SET datap = ?, ora = ?, tempo_prenotazione = ?, daOra = ?, aOra = ?"
			+ " WHERE codP = ?";


			PreparedStatement prepStatementQuery = connection.prepareStatement(query);

			prepStatementQuery.setDate(1,java.sql.Date.valueOf(data));
			prepStatementQuery.setTimestamp(2,timestamp1);
			prepStatementQuery.setInt(3,tempoPrenotazione);
			prepStatementQuery.setInt(4,daOra);
			prepStatementQuery.setInt(5,aOra);
			prepStatementQuery.setInt(6,codP);

			prepStatementQuery.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Operazione riuscita.");
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Operazione non riuscita, riprova.");
		}
	}
}
