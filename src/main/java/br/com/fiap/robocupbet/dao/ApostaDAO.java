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
		String sql = "INSERT INTO apostas (valor_aposta, aposta_ativa, venceu_aposta) values (?, ?, ?)";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, aposta.getValor());
			stmt.setBoolean(2, aposta.isAtiva());
			stmt.setBoolean(3, aposta.isVencida());
			stmt.execute();
			stmt.close();
			con.close();
		} catch (SQLException e){
			throw new RuntimeException (e);
		}
	}
	
	public void update(Aposta aposta) {
		String sql = "UPDATE apostas SET id_aposta = ?, valor_aposta = ?, aposta_ativa = ?, venceu_aposta = ? WHERE id_aposta = ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, aposta.getId());
			stmt.setInt(2, aposta.getValor());
			stmt.setBoolean(3, aposta.isAtiva());
			stmt.setBoolean(4, aposta.isVencida());
			stmt.setInt(1, aposta.getId());
			stmt.execute();
			stmt.close();
			con.close();
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
			con.close();
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
				aposta.setId(rs.getInt(1));
				aposta.setIdUsuario(rs.getInt(2));
				aposta.setIdPartida(rs.getInt(3));
				aposta.setValor(rs.getInt(4));
				aposta.setAtiva(rs.getBoolean(5));
				aposta.setVencida(rs.getBoolean(6));
				apostas.add(aposta);
			}
			
			rs.close();
			stmt.close();
			con.close();
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
			
			while (rs.next()) {
				aposta.setId(rs.getInt(1));
				aposta.setIdUsuario(rs.getInt(2));
				aposta.setIdPartida(rs.getInt(3));
				aposta.setValor(rs.getInt(4));
				aposta.setAtiva(rs.getBoolean(5));
				aposta.setVencida(rs.getBoolean(6));
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
