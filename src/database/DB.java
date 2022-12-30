package database;
import java.io.*;
import java.sql.*;

public class DB {
	// Static istance for singleton design pattern
	private static DB dbcon = null;
	
	private Connection conn = null;

	// Private constructor for singleton design pattern
	private DB(){}

	// Public method to retrieve an istance of the singleton outside this class
	public static DB getDB() {   

		if (dbcon == null) {
			dbcon = new DB();
		}

		return dbcon;
	}

	// Get the connection to the database
	public Connection getConnection() {
		String pwd = "";
		BufferedReader b = null;
		try {   

			if(conn==null || conn.isClosed()) {   
				// Reading password from file for security reasons
				try {
					b = new BufferedReader(new FileReader(new File("C:\\Users\\chiar\\OneDrive\\Desktop\\PROGETTO\\pwd_database.txt")));
					pwd = b.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}

				// Getting postgres driver
				Class.forName("org.postgresql.Driver");
				
				// Connecting to the database via database name, username, password
				conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LaboratorioScientifico", "postgres", pwd);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return conn;
	}

}