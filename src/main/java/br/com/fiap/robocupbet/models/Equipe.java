package br.com.fiap.robocupbet.models;

public class Equipe {
	private int id;
	private int idPartida;
	private int idRobo;
	private String nome;
	
	public Equipe(int idRobo, String nome) {
		this.idRobo = idRobo;
		this.nome = nome;
	}
	
	public Equipe() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdRobo() {
		return idRobo;
	}

	public void setIdRobo(int idRobo) {
		this.idRobo = idRobo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdPartida() {
		return idPartida;
	}

	public void setIdPartida(int idPartida) {
		this.idPartida = idPartida;
	}
	
	
}
