package br.com.fiap.robocupbet.dao;

import java.sql.Connection;

public class ApostaDAO {

	private Connection con;
	
	public ApostaDAO (Connection con) {
		this.con = con;
	}
}
