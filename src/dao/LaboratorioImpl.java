package dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DB;
import model.Laboratorio;
import model.Postazione;
import model.Sede;
import model.Laboratorio.TypeLaboratorio;

public class LaboratorioImpl implements LaboratorioDAO {

    private Connection connection = null;

	public LaboratorioImpl() {
		connection = DB.getDB().getConnection();
	}
/*
    @Override
	public ArrayList<Laboratorio> populate() {
		ArrayList<Laboratorio> laboratorioArray = new ArrayList<Laboratorio>();

		try {
			String query = "SELECT * FROM Laboratorio";
			Statement statementQuery = connection.createStatement();
			ResultSet rs = statementQuery.executeQuery(query);

			while(rs.next()) {
				laboratorioArray.add(new Laboratorio(rs.getString("nome"), rs.getString("descrizione"), TypeLaboratorio tipoLab, int codL, ArrayList<Sede> sedi,
						ArrayList<Postazione> postazioni));
            }

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return laboratorioArray;
	}*/

    @Override
	public String getLaboratorioBasedOnPersonale(int codPers) {
		String str = new String();

		try { 	
			String query = "SELECT DISTINCT L.nome, L.tipo"
                            +  " FROM Laboratorio as L JOIN Sede as S On L.codL = S.codL"
                            +  " JOIN PersonaleSede as P ON S.codS = P.codS"
                            +  " WHERE P.codPers = ?";
			PreparedStatement prepStatementQuery = connection.prepareStatement(query);
			
			prepStatementQuery.setInt(1,codPers);
			
			ResultSet rs = prepStatementQuery.executeQuery();
			
			
			if(rs.next()) {
				str = rs.getString("nome") + " (" + rs.getString("tipo") + ")";
			}

		} catch (SQLException e) {
			e.getStackTrace();
		}

		return str;
	}
    
    @Override
	public String getDescrizioneBasedOnPersonale(int codPers) {
		String str = new String();

		try { 	
			String query = "SELECT DISTINCT L.descrizione"
                            +  " FROM Laboratorio as L JOIN Sede as S On L.codL = S.codL"
                            +  " JOIN PersonaleSede as P ON S.codS = P.codS"
                            +  " WHERE P.codPers = ?";
			PreparedStatement prepStatementQuery = connection.prepareStatement(query);
			
			prepStatementQuery.setInt(1,codPers);
			
			ResultSet rs = prepStatementQuery.executeQuery();
			
			
			if(rs.next()) {
				str = rs.getString("descrizione");
			}

		} catch (SQLException e) {
			e.getStackTrace();
		}

		return str;
	}

}
