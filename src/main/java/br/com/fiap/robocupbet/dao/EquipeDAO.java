package br.com.fiap.robocupbet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.robocupbet.models.Equipe;

public class EquipeDAO {
	
	private Connection con;
	
	public EquipeDAO (Connection con) {
		this.con = con;
	}
	
	public void insert(Equipe equipe) {
		String sql = "INSERT INTO equipes (nome_equipe) values (?)";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, equipe.getNome());
			stmt.execute();
			stmt.close();
			con.close();
		} catch (SQLException e){
			throw new RuntimeException (e);
		}
	}
	
	public void update(Equipe equipe) {
		String sql = "UPDATE equipes SET id_equipe = ?, id_partida = ?, id_robo = ?, nome_equipe = ? WHERE id_equipe = ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, equipe.getId());
			stmt.setInt(2, equipe.getIdPartida());
			stmt.setInt(3, equipe.getIdRobo());
			stmt.setString(4, equipe.getNome());
			stmt.execute();
			stmt.close();
			con.close();
		} catch (SQLException e){
			throw new RuntimeException (e);
		}
	}
	
	public void delete(Equipe equipe) {
		String sql = "DELETE FROM equipes WHERE id_equipe = ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, equipe.getId());
			stmt.execute();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			throw new RuntimeException (e);
		}
	}
	
	public List<Equipe> findAll() {
		try {
			List<Equipe> equipes = new ArrayList<>();
			String sql = "SELECT * FROM equipes";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Equipe equipe = new Equipe();
				equipe.setId(rs.getInt(1));
				equipe.setIdPartida(rs.getInt(2));
				equipe.setIdRobo(rs.getInt(3));
				equipe.setNome(rs.getString(4));
				equipes.add(equipe);
			}
			
			rs.close();
			stmt.close();
			con.close();
			return equipes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void findById (Equipe equipe) {
		try {
			String sql = "SELECT * FROM equipes WHERE id_equipe = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			stmt.setInt(1, equipe.getId());
			
			while (rs.next()) {
				equipe.setId(rs.getInt(1));
				equipe.setIdPartida(rs.getInt(2));
				equipe.setIdRobo(rs.getInt(3));
				equipe.setNome(rs.getString(4));
			}
			
			stmt.execute();
			stmt.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
