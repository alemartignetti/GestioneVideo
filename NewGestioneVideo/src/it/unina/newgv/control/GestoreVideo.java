package it.unina.newgv.control;

import java.sql.SQLException;
import java.util.ArrayList;

import it.unina.newgv.db.VideoDAO;
import it.unina.newgv.entity.*;

public abstract class GestoreVideo {
	

	static public void caricaVideo(String nomeVideo, TipoSport sport, String nomeGiorn, String cognomeGiorn) {
		try {
		VideoDAO.create(nomeVideo, sport, nomeGiorn, cognomeGiorn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	static public ArrayList<Video> ricerca(String nome, TipoSport sport) {
		ArrayList<Video> v = new ArrayList<Video>();
		
		try {
			v = VideoDAO.read(nome, sport);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return v;
	}
	
	

}
