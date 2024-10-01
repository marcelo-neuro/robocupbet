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
		String sql = "INSERT INTO equipes (nome_equipe, id_robo) values (?, ?)";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, equipe.getNome());
			stmt.setInt(2, equipe.getIdRobo());
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e){
			throw new RuntimeException (e);
		}
	}
	
	public void update(Equipe equipe) {
		String sql = "UPDATE equipes SET id_equipe = ?, id_robo = ?, id_partida_atual = ?, nome_equipe = ? WHERE id_equipe = ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, equipe.getId());
			stmt.setInt(2, equipe.getIdRobo());
			stmt.setInt(3, equipe.getIdPartidaAtual());
			stmt.setString(4, equipe.getNome());
			stmt.setInt(5, equipe.getId());
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e){
			throw new RuntimeException (e);
		}
	}
	
	public void delete(int id) {
		String sql = "DELETE FROM equipes WHERE id_equipe = ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
			
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
				equipe.setId(rs.getInt("id_equipe"));
				equipe.setIdRobo(rs.getInt("id_robo"));
				equipe.setIdPartidaAtual(rs.getInt("id_partida_atual"));
				equipe.setNome(rs.getString("nome_equipe"));
				equipes.add(equipe);
			}
			
			rs.close();
			stmt.close();
			
			return equipes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Equipe findById (int id) {
		try {
			String sql = "SELECT * FROM equipes WHERE id_equipe = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			stmt.setInt(1, id);
			Equipe equipe = new Equipe();
			
			while (rs.next()) {
				equipe.setId(rs.getInt("id_equipe"));
				equipe.setIdRobo(rs.getInt("id_robo"));
				equipe.setIdPartidaAtual(rs.getInt("id_partida_atual"));
				equipe.setNome(rs.getString("nome_equipe"));
			}
			
			stmt.execute();
			stmt.close();
			rs.close();
			
			return equipe;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public Equipe findByIdRobo(int idRobo) {
		String sql = """
				SELECT * FROM equipes
				WHERE id_robo = ?
				""";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, idRobo);
			ResultSet rs = ps.executeQuery();
			
			Equipe e = new Equipe();
			if(rs.next()) {
				e.setId(rs.getInt("id_equipe"));
				e.setIdRobo(rs.getInt("id_robo"));
				e.setIdPartidaAtual(rs.getInt("id_partida"));
				e.setNome(rs.getString("nome_equipe"));
			}
			return e;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
