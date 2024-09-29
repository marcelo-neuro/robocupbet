package br.com.fiap.robocupbet.models;

public class Partida {
	private int id;
	private int idEquipeVencedora;
	private Equipe equipeA;
	private Equipe equipeB;
		
	public Equipe getEquipeA() {
		return equipeA;
	}

	public void setEquipeA(Equipe equipeA) {
		this.equipeA = equipeA;
	}

	public Equipe getEquipeB() {
		return equipeB;
	}

	public void setEquipeB(Equipe equipeB) {
		this.equipeB = equipeB;
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

}
