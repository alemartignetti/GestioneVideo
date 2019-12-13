package it.unina.newgv.entity;

public class VideoEvento extends Video {

	public VideoEvento() {
		super();
	}

	public VideoEvento(String nome, TipoSport sport) {
		super(nome, sport);
	}
	
	public VideoEvento(int id, String nome, TipoSport sport) {
		super(id,nome,sport);
	}

}
