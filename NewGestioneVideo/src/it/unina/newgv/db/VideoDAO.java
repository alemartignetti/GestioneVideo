package it.unina.newgv.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import it.unina.newgv.entity.*;

public abstract class VideoDAO {

	static public Video create(String nomeVideo, TipoSport sport, String nomeGiorn, String cognomeGiorn)
			throws SQLException {
		Video v;

		if (nomeGiorn.equals("") && cognomeGiorn.equals("")) {
			v = new VideoEvento(nomeVideo, sport);
			DBManager.insert(v.getNome(), v.getSport(), "", "");
		} else {
			v = new VideoApprofondimento(nomeVideo, sport, nomeGiorn, cognomeGiorn);
			DBManager.insert(v.getNome(), v.getSport(), nomeGiorn, cognomeGiorn);
		}

		return v;
	}

	static public ArrayList<Video> read(String nome, TipoSport sport) throws SQLException {

		ResultSet res;
		ArrayList<Video> trovati = new ArrayList<Video>();
		Connection c = DBManager.getConnection();

		try {

			if (sport == null) {
				PreparedStatement stmt = c.prepareStatement("SELECT * FROM VIDEO WHERE NOME='" + nome + "';");
				res = stmt.executeQuery();
			} else {
				PreparedStatement stmt = c
						.prepareStatement("SELECT * FROM VIDEO WHERE SPORT='" + sport.toString() + "';");
				res = stmt.executeQuery();
			}

			while (res.next()) {
				String extSport = res.getString(3);
				TipoSport tipo;
				Video v;

				if (extSport.equals(TipoSport.CALCIO.toString()))
					tipo = TipoSport.CALCIO;
				else if (extSport.equals(TipoSport.BASKET.toString()))
					tipo = TipoSport.BASKET;
				else if (extSport.equals(TipoSport.TENNIS.toString()))
					tipo = TipoSport.TENNIS;
				else if (extSport.equals(TipoSport.PALLAVOLO.toString()))
					tipo = TipoSport.PALLAVOLO;
				else
					tipo = TipoSport.GENERICO;

				if (res.getString(4).equals("")) {
					v = new VideoEvento(res.getInt(1), res.getString(2), tipo);
				} else {
					v = new VideoApprofondimento(res.getInt(1), res.getString(2), tipo, res.getString(4),
							res.getString(5));
				}

				trovati.add(v);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		c.close();
		return trovati;
	}

}
