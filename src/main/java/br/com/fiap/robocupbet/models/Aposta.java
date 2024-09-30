package br.com.fiap.robocupbet.models;

public class Aposta {
	private int id;
	private int idUsuario;
	private int idPartida;
	private int idEquipe;
	private int valor;
	
	public Aposta(int idUsuario, int idPartida, int idEquipe, int valor) {
		this.idUsuario = idUsuario;
		this.idPartida = idPartida;
		this.idEquipe = idEquipe;
		this.valor = valor;
	}
	
	public Aposta() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdPartida() {
		return idPartida;
	}

	public void setIdPartida(int idPartida) {
		this.idPartida = idPartida;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public int getIdEquipe() {
		return idEquipe;
	}

	public void setIdEquipe(int idEquipe) {
		this.idEquipe = idEquipe;
	}

	
}
