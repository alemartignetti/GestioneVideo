package it.unina.newgv.entity;


public abstract class Video implements Comparable<Video> {

	private int id;
	private String nome;
	private TipoSport sport;
	
	
	public Video() {
		id = -1;
		nome = "";
		sport = TipoSport.GENERICO;
	}

	public Video(String nome, TipoSport sport) {
		super();
		this.nome = nome;
		this.sport = sport;
	}
	
	public Video(int id, String nome, TipoSport sport) {
		super();
		this.id = id;
		this.nome = nome;
		this.sport = sport;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoSport getSport() {
		return sport;
	}

	public void setSport(TipoSport sport) {
		this.sport = sport;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "[" + sport.toString() + "] " + nome; 
	}
	
	public int compareTo(Video v) {
		return Integer.compare(this.id, v.getId());
	}

}
