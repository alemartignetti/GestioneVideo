package it.unina.newgv.db;

import java.sql.*;

import it.unina.newgv.entity.TipoSport;

public abstract class DBManager {

	static public Connection getConnection() throws SQLException {
		Connection c = DriverManager.getConnection("jdbc:h2:C:\\Users\\marti\\IS_java_workspace\\NewGestioneVideo\\database","sa","");
		return c;
	}
	
	static public void inizializza() throws SQLException {
		Connection c = DBManager.getConnection();
		PreparedStatement stmt = c.prepareStatement(
				"CREATE TABLE VIDEO ( "
						+ "ID INT AUTO_INCREMENT PRIMARY KEY,"
						+ "NOME VARCHAR(20),"
						+ "SPORT VARCHAR(10),"
						+ "NOMEGIORN VARCHAR(10),"
						+ "COGNOMEGIORN VARCHAR(15))"
						);
		stmt.executeUpdate();
		c.close();
	}
	
	static public void insert(String nomeVideo, TipoSport sport, String nomeGiorn, String cognomeGiorn) throws SQLException{
		Connection c = DBManager.getConnection();
		PreparedStatement stmt = c.prepareStatement("INSERT INTO VIDEO VALUES (NULL,?,?,?,?)");
		stmt.setString(1, nomeVideo);
		stmt.setString(2, sport.toString());
		stmt.setString(3, nomeGiorn);
		stmt.setString(4, cognomeGiorn);

		stmt.executeUpdate();
		c.close();
	}
	
}
