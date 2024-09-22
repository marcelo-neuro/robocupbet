package br.com.fiap.robocupbet.models;

public class Robo {
	private int id;
	private String nome;
	private String urlFoto;
	private double peso;
	private double altura;
	private double largura;
	private double comprimento;
	
	public Robo(String nome, String urlFoto, double peso, double altura, double largura, double comprimento) {
		this.nome = nome;
		this.urlFoto = urlFoto;
		this.peso = peso;
		this.altura = altura;
		this.largura = largura;
		this.comprimento = comprimento;
	}
	
	public Robo() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUrlFoto() {
		return urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getLargura() {
		return largura;
	}

	public void setLargura(double largura) {
		this.largura = largura;
	}

	public double getComprimento() {
		return comprimento;
	}

	public void setComprimento(double comprimento) {
		this.comprimento = comprimento;
	}
	
	
}
