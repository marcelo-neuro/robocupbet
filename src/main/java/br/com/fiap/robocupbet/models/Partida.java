package br.com.fiap.robocupbet.models;

import java.time.LocalDateTime;

public class Partida {
	private int id;
	private int idEquipeVencedora;
		
	public Partida() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdEquipeVencedora() {
		return idEquipeVencedora;
	}

	public void setIdEquipeVencedora(int idEquipeVencedora) {
		this.idEquipeVencedora = idEquipeVencedora;
	}

}
