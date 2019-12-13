package it.unina.newgv.entity;

public class Giornalista {

	static public Giornalista DEFAULT = new Giornalista();
	private String nome;
	private String cognome;
	
	public Giornalista() {
		nome = "";
		cognome = "";
	}
	
	public Giornalista (String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

}
