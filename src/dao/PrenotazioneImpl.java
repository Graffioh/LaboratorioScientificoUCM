package dao;

import java.sql.Connection;
//import java.sql.Date;
import java.time.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import database.DB;
import model.Strumento;

public class PrenotazioneImpl implements PrenotazioneDAO {
	
	private Connection connection = null;
	
	public PrenotazioneImpl() {
		connection = DB.getDB().getConnection();
	}
	
	public void prenotazione(LocalDate data, long timestampLong, int tempoPrenotazione, int daOra, int aOra, int codP, int codStr, int codPers) {
		try {

			Timestamp timestamp1 = new Timestamp(timestampLong);
			
			String query = "INSERT INTO Prenotazione(datap, ora, tempo_prenotazione, DaOra, AOra, codP, codStr, codPers) VALUES (?,?,?,?,?,?,?,?)";

			PreparedStatement prepStatementQuery = connection.prepareStatement(query);

			prepStatementQuery.setDate(1,java.sql.Date.valueOf(data));
			prepStatementQuery.setTimestamp(2,timestamp1);
			prepStatementQuery.setInt(3,tempoPrenotazione);
			prepStatementQuery.setInt(4,daOra);
			prepStatementQuery.setInt(5,aOra);
			prepStatementQuery.setInt(6,codP);
			prepStatementQuery.setInt(7,codStr);
			prepStatementQuery.setInt(8,codPers);

			prepStatementQuery.executeQuery();

			/*while(rs.next()) {
				strumentoArray.add(new Strumento(rs.getString("nome"), rs.getString("descrizione"), rs.getString("caratteristiche_tecniche"), rs.getString("categoria"), rs.getInt("tempo_uso"), rs.getInt("codstr"), null, null));
			}*/

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
