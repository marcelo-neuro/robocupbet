package br.com.fiap.robocupbet.models;

public class Usuario {
	private int id;
	private int pontos;
	private String nome;
	private String email;
	private String senha;
	
	public Usuario(int pontos, String nome, String email, String senha) {
		this.pontos = pontos;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}
	
	public Usuario() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
