package dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DB;
import model.Laboratorio;

public class LaboratorioImpl implements LaboratorioDAO {

    private Connection connection = null;

	public LaboratorioImpl() {
		connection = DB.getDB().getConnection();
	}

    @Override
	public ArrayList<Laboratorio> populate() {
		ArrayList<Laboratorio> laboratorioArray = new ArrayList<Laboratorio>();

		try {
			String query = "SELECT * FROM Laboratorio";
			Statement statementQuery = connection.createStatement();
			ResultSet rs = statementQuery.executeQuery(query);

			while(rs.next()) {
				laboratorioArray.add(new Laboratorio());
            }

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return laboratorioArray;
	}

     @Override
	public String getLaboratorioBasedOnSede() {
		String str = new String();

		try { 	
			String query = "SELECT DISTINCT L.nome"
                            +  " FROM Laboratorio as L JOIN Sede as S On L.codL = S.codL"
                            +  " JOIN PersonaleSede as P ON S.codS = P.codS"
                            +  " WHERE P.codPers = ?";
			Statement statementQuery = connection.createStatement();
			ResultSet rs = statementQuery.executeQuery(query);

			if(rs.next()) {
				str = rs.getString("nome");
			}

		} catch (SQLException e) {
			e.getStackTrace();
		}

		return str;
	}

}
