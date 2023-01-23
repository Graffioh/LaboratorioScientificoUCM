package dao;

import java.sql.Connection;
import java.sql.Date;
//import java.sql.Date;
import java.time.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controller.Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;

import database.DB;
import model.DotazioneAccessoria;
import model.Prenotazione;

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
	
	public ArrayList<Prenotazione> getPrenotazioneBasedOnPersonale(int codPers){
		
		ArrayList<Prenotazione> prenotazioneArray = new ArrayList<Prenotazione>();

		try {

			String query = "SELECT DISTINCT PR.datap, PR.ora, PR.tempo_prenotazione, PR.codP, PR.codPers, PR.codStr, PR.codD, PR.DaOra, PR.AOra"
				+ " FROM PersonaleSede AS P JOIN Sede AS S ON P.CodS = S.CodS"
                + " JOIN Postazione AS PO ON PO.CodS = S.CodS"
                + " JOIN StrumentoPostazione AS SP ON PO.CodPos = SP.CodPos"
                + " JOIN Strumento AS STR ON SP.CodStr = STR.CodStr"
                + " JOIN Prenotazione AS PR ON STR.CodStr = PR.CodStr"
                + " WHERE PR.CodPers = ?"
				+ " ORDER BY(PR.codP)";
    
			PreparedStatement prepStatementQuery = connection.prepareStatement(query);

			prepStatementQuery.setInt(1,codPers);

			ResultSet rs = prepStatementQuery.executeQuery();

			while(rs.next()) {
				prenotazioneArray.add(new Prenotazione(rs.getDate("datap").toLocalDate(), rs.getTime("ora").toLocalTime(), rs.getInt("tempo_prenotazione"), rs.getInt("daora"), rs.getInt("aora"), rs.getInt("codp"), rs.getInt("codstr"), rs.getInt("codd"), rs.getInt("codpers")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return prenotazioneArray;
	}

	public ArrayList<Prenotazione> getPrenotazioneBasedOnStrumentoAndDate(int codStr, LocalDate localDate) {
		ArrayList<Prenotazione> prenotazioneArray = new ArrayList<Prenotazione>();
		
		Date date = Date.valueOf(localDate);

		try {

			String query = "SELECT DISTINCT PR.datap, PR.ora, PR.tempo_prenotazione, PR.codP, PR.codPers, PR.codStr, PR.codD, PR.DaOra, PR.AOra"
				+ " FROM PersonaleSede AS P JOIN Sede AS S ON P.CodS = S.CodS"
                + " JOIN Postazione AS PO ON PO.CodS = S.CodS"
                + " JOIN StrumentoPostazione AS SP ON PO.CodPos = SP.CodPos"
                + " JOIN Strumento AS STR ON SP.CodStr = STR.CodStr"
                + " JOIN Prenotazione AS PR ON STR.CodStr = PR.CodStr"
                + " WHERE PR.CodStr = ? AND PR.datap = ?"
				+ " ORDER BY(PR.codP)";
    
			PreparedStatement prepStatementQuery = connection.prepareStatement(query);

			prepStatementQuery.setInt(1,codStr);
			prepStatementQuery.setDate(2, date);

			ResultSet rs = prepStatementQuery.executeQuery();

			while(rs.next()) {
				prenotazioneArray.add(new Prenotazione(rs.getDate("datap").toLocalDate(), rs.getTime("ora").toLocalTime(), rs.getInt("tempo_prenotazione"), rs.getInt("daora"), rs.getInt("aora"), rs.getInt("codp"), rs.getInt("codstr"), rs.getInt("codd"), rs.getInt("codpers"))); // rs.getInt("codd")
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return prenotazioneArray;
	}
	
	public ArrayList<Prenotazione> getPrenotazioneBasedOnDotazioneAndDate(int codD, LocalDate localDate) {
		ArrayList<Prenotazione> prenotazioneArray = new ArrayList<Prenotazione>();
		
		Date date = Date.valueOf(localDate);

		try {

			String query = "SELECT DISTINCT PR.datap, PR.ora, PR.tempo_prenotazione, PR.codP, PR.codPers, PR.codStr, PR.codD, PR.DaOra, PR.AOra"
				+ " FROM PersonaleSede AS P JOIN Sede AS S ON P.CodS = S.CodS"
                + " JOIN Postazione AS PO ON PO.CodS = S.CodS"
                + " JOIN StrumentoPostazione AS SP ON PO.CodPos = SP.CodPos"
                + " JOIN Strumento AS STR ON SP.CodStr = STR.CodStr"
                + " JOIN Prenotazione AS PR ON STR.CodStr = PR.CodStr"
                + " WHERE PR.CodD = ? AND PR.datap = ?"
				+ " ORDER BY(PR.codP)";
    
			PreparedStatement prepStatementQuery = connection.prepareStatement(query);

			prepStatementQuery.setInt(1, codD);
			prepStatementQuery.setDate(2, date);

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
	
	public int getMaxCodP() {
		int codP = 0;
		
		try {
			String query = "SELECT MAX(P.codP) as max_cod_p FROM Prenotazione AS P";
			Statement statementQueryLogin = connection.createStatement();
			ResultSet rs = statementQueryLogin.executeQuery(query);
			
			if(rs.next()) {
				codP = rs.getInt("max_cod_p");
			}
			
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
		return codP;
	}
	
	public void prenotazione(LocalDate data, LocalTime localTime, int tempoPrenotazione, int daOra, int aOra, int codP, int codStr, int codD, int codPers) {
		try {

			Time time = Time.valueOf(localTime);
			
			String query = "INSERT INTO Prenotazione(datap, ora, tempo_prenotazione, DaOra, AOra, codP, codStr, codD, codPers) VALUES (?,?,?,?,?,?,?,?,?)";

			PreparedStatement prepStatementQuery = connection.prepareStatement(query);

			prepStatementQuery.setDate(1,java.sql.Date.valueOf(data));
			prepStatementQuery.setTime(2,time);
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

	public String[] getRiepilogoStrumentoBasedOnMonth(int codStr) {

		String[] riepilogo = new String[13];
		
		try {
			String query = "SELECT COUNT(P.codStr) AS COUNT_STRUMENTO"
						+ " FROM Prenotazione AS P"
						+ " WHERE P.codStr = ? AND EXTRACT(MONTH FROM P.DataP) = ?"; //AND EXTRACT(YEAR FROM P.DataP) = 2023;

			PreparedStatement prepStatementQuery = connection.prepareStatement(query);

			prepStatementQuery.setInt(1,codStr);

			for(int i = 0; i < 12; i++) {
				prepStatementQuery.setInt(2,i + 1);

				prepStatementQuery.executeQuery();

				ResultSet rs = prepStatementQuery.executeQuery();

				if(rs.next())
					riepilogo[i] = Integer.valueOf(rs.getInt("COUNT_STRUMENTO")).toString();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return riepilogo;
	}

	public String[] getRiepilogoStrumentoBasedOnYear(int codStr) {

		String[] riepilogo = new String[10];
		
		try {
			String query = "SELECT COUNT(P.codStr) AS COUNT_STRUMENTO"
						+ " FROM Prenotazione AS P"
						+ " WHERE P.codStr = ? AND EXTRACT(YEAR FROM P.DataP) = ?";

			PreparedStatement prepStatementQuery = connection.prepareStatement(query);

			prepStatementQuery.setInt(1,codStr);

			for(int i = 0; i < 8; i++) {
				prepStatementQuery.setInt(2,i + 2023);

				prepStatementQuery.executeQuery();

				ResultSet rs = prepStatementQuery.executeQuery();

				if(rs.next())
					riepilogo[i] = Integer.valueOf(rs.getInt("COUNT_STRUMENTO")).toString();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return riepilogo;
	}
	
	public String[] getRiepilogoUtenteBasedOnMonth(int codStr) {

		String[] riepilogo = new String[13];
		
		try {
			String query = "SELECT PE.nome, PE.cognome, MAX(P.codPers)"
					+ " FROM Prenotazione as P JOIN Personale as PE ON P.codPers = PE.codPers"
					+ " WHERE P.codStr = ? AND EXTRACT(MONTH FROM P.DataP) = ?"
					+ " GROUP BY PE.nome, PE.cognome";

			PreparedStatement prepStatementQuery = connection.prepareStatement(query);

			prepStatementQuery.setInt(1,codStr);

			for(int i = 0; i < 12; i++) {
				prepStatementQuery.setInt(2,i + 1);

				prepStatementQuery.executeQuery();

				ResultSet rs = prepStatementQuery.executeQuery();

				if(rs.next())
					riepilogo[i] = rs.getString("nome") + " " + rs.getString("cognome");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return riepilogo;
	}
	
	public String[] getRiepilogoUtenteBasedOnYear(int codStr) {

		String[] riepilogo = new String[10];
		
		try {
			String query = "SELECT PE.nome, PE.cognome, MAX(P.codPers)"
					+ " FROM Prenotazione as P JOIN Personale as PE ON P.codPers = PE.codPers"
					+ " WHERE P.codStr = ? AND EXTRACT(YEAR FROM P.DataP) = ?"
					+ " GROUP BY PE.nome, PE.cognome";

			PreparedStatement prepStatementQuery = connection.prepareStatement(query);

			prepStatementQuery.setInt(1,codStr);

			for(int i = 0; i < 8; i++) {
				prepStatementQuery.setInt(2,i + 2023);

				prepStatementQuery.executeQuery();

				ResultSet rs = prepStatementQuery.executeQuery();

				if(rs.next())
					riepilogo[i] = rs.getString("nome") + " " + rs.getString("cognome");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return riepilogo;
	}

	public int[] getConsumoDotazioneBasedOnMonth(ArrayList<DotazioneAccessoria> alD, String nomeDotazione) {

		int[] riepilogo = new int[13];

		Controller controller = new Controller();
		
		int codD = controller.getCodiceFromNome(alD, nomeDotazione);

		try {
			String query = "SELECT COUNT(P.codD) AS COUNT_DOTAZIONE"
						+ " FROM Prenotazione AS P"
						+ " WHERE P.codD = ? AND EXTRACT(MONTH FROM P.DataP) = ?"; //AND EXTRACT(YEAR FROM P.DataP) = 2023;

			PreparedStatement prepStatementQuery = connection.prepareStatement(query);

			prepStatementQuery.setInt(1,codD);

			for(int i = 0; i < 12; i++) {
				prepStatementQuery.setInt(2,i + 1);

				prepStatementQuery.executeQuery();

				ResultSet rs = prepStatementQuery.executeQuery();

				if(rs.next())
					riepilogo[i] = rs.getInt("COUNT_DOTAZIONE");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return riepilogo;
	}

	public int[] getConsumoDotazioneBasedOnYear(ArrayList<DotazioneAccessoria> alD, String nomeDotazione) {

		int[] riepilogo = new int[10];

		Controller controller = new Controller();
		
		int codD = controller.getCodiceFromNome(alD, nomeDotazione);
		
		try {
			String query = "SELECT COUNT(P.codD) AS COUNT_DOTAZIONE"
						+ " FROM Prenotazione AS P"
						+ " WHERE P.codD = ? AND EXTRACT(YEAR FROM P.DataP) = ?";

			PreparedStatement prepStatementQuery = connection.prepareStatement(query);

			prepStatementQuery.setInt(1,codD);

			for(int i = 0; i < 8; i++) {
				prepStatementQuery.setInt(2,i + 2023);

				prepStatementQuery.executeQuery();

				ResultSet rs = prepStatementQuery.executeQuery();

				if(rs.next())
					riepilogo[i] = rs.getInt("COUNT_DOTAZIONE");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return riepilogo;
	}
}
