package br.com.fiap.robocupbet.models;

import java.time.LocalDateTime;

public class Partida {
	private int id;
	private int idEquipeVencedora;
	private LocalDateTime inicio;
	private boolean finalizada;
	
	public Partida(LocalDateTime inicio, boolean finalizada) {
		this.inicio = inicio;
		this.finalizada = finalizada;
	}
	
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

	public LocalDateTime getInicio() {
		return inicio;
	}

	public void setInicio(LocalDateTime inicio) {
		this.inicio = inicio;
	}

	public boolean isFinalizada() {
		return finalizada;
	}

	public void setFinalizada(boolean finalizada) {
		this.finalizada = finalizada;
	}
	
	
}
