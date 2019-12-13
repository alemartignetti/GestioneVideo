package it.unina.newgv.entity;


public class VideoApprofondimento extends Video {

	private Giornalista giorn;
	
	public VideoApprofondimento() {
		super();
		giorn = Giornalista.DEFAULT;
	}

	public VideoApprofondimento(String nomeVideo, TipoSport sport, String nomeGiorn, String cognomeGiorn) {
		super(nomeVideo, sport);
		giorn = new Giornalista(nomeGiorn, cognomeGiorn);
	}
	
	public VideoApprofondimento(int id, String nomeVideo, TipoSport sport, String nomeGiorn, String cognomeGiorn) {
		super(id, nomeVideo, sport);
		giorn = new Giornalista(nomeGiorn, cognomeGiorn);
	}

	public String getGiornalista() {
		return giorn.getNome() + " " + giorn.getCognome();
	}
	
	@Override
	public String toString() {
		return super.toString() + " - " + this.getGiornalista();
	}
	
}
