package br.com.fiap.robocupbet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.robocupbet.models.Aposta;

public class ApostaDAO {

	private Connection con;
	
	public ApostaDAO (Connection con) {
		this.con = con;
	}
	
	public void insert(Aposta aposta) {
		String sql = "INSERT INTO apostas (id_usuario, id_partida, id_equipe_apostada, valor_aposta) values (?, ?, ?, ?)";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, aposta.getIdUsuario());
			stmt.setInt(2, aposta.getIdPartida());
			stmt.setInt(3, aposta.getIdEquipe());
			stmt.setInt(4, aposta.getValor());
			stmt.execute();
			stmt.close();
		} catch (SQLException e){
			throw new RuntimeException (e);
		}
	}
	
	public void update(Aposta aposta) {
		String sql = """
				UPDATE apostas 
				SET id_aposta = ?, id_usuario = ?, id_partida = ?, id_equipe_apostada = ?, valor_aposta = ? 
				WHERE id_aposta = ?
				""";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, aposta.getId());
			stmt.setInt(2, aposta.getIdUsuario());
			stmt.setInt(3, aposta.getIdPartida());
			stmt.setInt(4, aposta.getIdEquipe());
			stmt.setInt(5, aposta.getValor());
			stmt.setInt(6, aposta.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e){
			throw new RuntimeException (e);
		}
	}
	
	public void delete(int id) {
		String sql = "DELETE FROM apostas WHERE id_aposta = ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException (e);
		}
	}
	
	public List<Aposta> findAll() {
		try {
			List<Aposta> apostas = new ArrayList<>();
			String sql = "SELECT * FROM apostas";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Aposta aposta = new Aposta();
				aposta.setId(rs.getInt("id_aposta"));
				aposta.setIdUsuario(rs.getInt("id_usuario"));
				aposta.setIdPartida(rs.getInt("id_partida"));
				aposta.setIdEquipe(rs.getInt("id_equipe_apostada"));
				aposta.setValor(rs.getInt("valor_aposta"));
				apostas.add(aposta);
			}
			
			rs.close();
			stmt.close();
			return apostas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Aposta findById (int id) {
		try {
			String sql = "SELECT * FROM apostas WHERE id_aposta = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			stmt.setInt(1, id);
			Aposta aposta = new Aposta();
			
			if (rs.next()) {
				aposta.setId(rs.getInt("id_aposta"));
				aposta.setIdUsuario(rs.getInt("id_usuario"));
				aposta.setIdPartida(rs.getInt("id_partida"));
				aposta.setIdEquipe(rs.getInt("id_equipe_apostada"));
				aposta.setValor(rs.getInt("valor_aposta"));
			}
			
			stmt.execute();
			stmt.close();
			rs.close();
			
			return aposta;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
