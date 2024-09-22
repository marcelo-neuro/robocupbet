package br.com.fiap.robocupbet.models;

public class Premio {
	private int id;
	private int valor;
	private int quantidade;
	private String nome;
	private String desc;
	private String urlFoto;
	
	public Premio(int valor, int quantidade, String nome, String desc, String urlFoto) {
		this.valor = valor;
		this.quantidade = quantidade;
		this.nome = nome;
		this.desc = desc;
		this.urlFoto = urlFoto;
	}
	
	public Premio() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getUrlFoto() {
		return urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}
	
	
}
