package it.unina.newgv;


import java.sql.SQLException;

import it.unina.newgv.control.*;
import it.unina.newgv.db.DBManager;
import it.unina.newgv.entity.TipoSport;
import it.unina.newgv.entity.Video;

public class Main {

	public static void main(String[] args) {
		
		
		try {
		DBManager.inizializza();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		/*
		GestoreVideo.caricaVideo("Lozano", TipoSport.CALCIO, "", "");
		GestoreVideo.caricaVideo("Analisi", TipoSport.CALCIO, "Daniele", "Adani");
		GestoreVideo.caricaVideo("Dunk", TipoSport.BASKET, "", "");
		GestoreVideo.caricaVideo("Berrettini", TipoSport.TENNIS, "Mario", "Sconcerti");
		GestoreVideo.caricaVideo("Galli", TipoSport.PALLAVOLO, "", "");
		
		
		GestoreVideo.caricaVideo("Gattuso", TipoSport.CALCIO, "", "");
		GestoreVideo.caricaVideo("Intervista", TipoSport.CALCIO, "Beppe", "Bergomi");
		GestoreVideo.caricaVideo("Williams", TipoSport.TENNIS, "", "");
		GestoreVideo.caricaVideo("Eurolega", TipoSport.BASKET, "", "");
		
		GestoreVideo.caricaVideo("Fognini", TipoSport.TENNIS, "", "");
		*/
		
		GestoreVideo.caricaVideo("Lazio", TipoSport.CALCIO, "", "");
		
		
		for (Video v : GestoreVideo.ricerca("Berrettini", null)) {
			System.out.println(v.toString());
		}
		
		System.out.println("******* FINE *******");
		
		for (Video v : GestoreVideo.ricerca("Dunk", null)) {
			System.out.println(v.toString());
		}
		
		System.out.println("******* FINE *******");
		
		for (Video v : GestoreVideo.ricerca("Galli", null)) {
			System.out.println(v.toString());
		}
		
		System.out.println("******* FINE *******");
		
		
		for (Video v : GestoreVideo.ricerca("", TipoSport.CALCIO)) {
			System.out.println(v.toString());
		}
		
		System.out.println("******* FINE *******");
		
		for (Video v : GestoreVideo.ricerca("", TipoSport.TENNIS)) {
			System.out.println(v.toString());
		}
		
		System.out.println("******* FINE *******");

	}

}
