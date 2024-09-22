package br.com.fiap.robocupbet.models;

public class Aposta {
	private int id;
	private int idUsuario;
	private int idPartida;
	private int valor;
	private boolean ativa;
	private boolean vencida;
	
	public Aposta(int idUsuario, int idPartida, int valor, boolean ativa, boolean vencida) {
		this.idUsuario = idUsuario;
		this.idPartida = idPartida;
		this.valor = valor;
		this.ativa = ativa;
		this.vencida = vencida;
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

	public boolean isAtiva() {
		return ativa;
	}

	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}

	public boolean isVencida() {
		return vencida;
	}

	public void setVencida(boolean vencida) {
		this.vencida = vencida;
	}
	
	
}
