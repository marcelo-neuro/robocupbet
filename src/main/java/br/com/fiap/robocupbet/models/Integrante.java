package br.com.fiap.robocupbet.models;

public class Integrante {
	private int id;
	private int idEquipe;
	private String nome;
	private String rm;
	private String urlFoto;
	
	public Integrante(int idEquipe, String nome, String rm, String urlFoto) {
		this.idEquipe = idEquipe;
		this.nome = nome;
		this.rm = rm;
		this.urlFoto = urlFoto;
	}
	
	public Integrante() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdEquipe() {
		return idEquipe;
	}

	public void setIdEquipe(int idEquipe) {
		this.idEquipe = idEquipe;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRm() {
		return rm;
	}

	public void setRm(String rm) {
		this.rm = rm;
	}

	public String getUrlFoto() {
		return urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}
	
	
}
