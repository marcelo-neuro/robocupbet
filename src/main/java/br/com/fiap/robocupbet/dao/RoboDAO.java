package br.com.fiap.robocupbet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.robocupbet.models.Integrante;
import br.com.fiap.robocupbet.models.Robo;

public class RoboDAO {

	private Connection con;
	
	public RoboDAO (Connection con) {
		this.con = con;
	}
	
	public void insert(Robo robo) {
		String sql = "INSERT INTO robos (nome_robo, peso_robo, altura_robo, largura_robo, largura_robo, comprimento_robo, url_foto_robo) values (?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, robo.getNome());
			stmt.setDouble(2, robo.getPeso());
			stmt.setDouble(3, robo.getAltura());
			stmt.setDouble(4, robo.getLargura());
			stmt.setDouble(5, robo.getComprimento());
			stmt.setString(6, robo.getUrlFoto());
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e){
			throw new RuntimeException (e);
		}
	}
	
	public void update(Robo robo) {
		String sql = "UPDATE robos SET nome_robo = ?, peso_robo = ?, altura_robo = ?, largura_robo = ?, comprimento_robo = ?, url_foto_robo = ? WHERE id_robo = ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, robo.getNome());
			stmt.setDouble(2, robo.getPeso());
			stmt.setDouble(3, robo.getAltura());
			stmt.setDouble(4, robo.getLargura());
			stmt.setDouble(5, robo.getComprimento());
			stmt.setString(6, robo.getUrlFoto());
			stmt.setInt(7, robo.getId());
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e){
			throw new RuntimeException (e);
		}
	}
	
	public void delete(int id) {
		String sql = "DELETE FROM robos WHERE id_robo = ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException (e);
		}
	}
	
	public List<Robo> findAll() {
		try {
			List<Robo> robos = new ArrayList<>();
			String sql = "SELECT * FROM robos";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Robo robo = new Robo();
				robo.setId(rs.getInt("id_robo"));
				robo.setNome(rs.getString("nome_robo"));
				robo.setPeso(rs.getDouble("peso_robo"));
				robo.setAltura(rs.getDouble("altura_robo"));
				robo.setLargura(rs.getDouble("largura_robo"));
				robo.setComprimento(rs.getDouble("comprimento_robo"));
				robo.setUrlFoto(rs.getString("url_foto_robo"));
				robos.add(robo);
			}
			
			rs.close();
			stmt.close();
			
			return robos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Robo findById (int id) {
		try {
			String sql = "SELECT * FROM robos WHERE id_robo = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			stmt.setInt(1, id);
			Robo robo = new Robo();
			
			while (rs.next()) {
				robo.setId(rs.getInt("id_robo"));
				robo.setNome(rs.getString("nome_robo"));
				robo.setPeso(rs.getDouble("peso_robo"));
				robo.setAltura(rs.getDouble("altura_robo"));
				robo.setLargura(rs.getDouble("largura_robo"));
				robo.setComprimento(rs.getDouble("comprimento_robo"));
				robo.setUrlFoto(rs.getString("url_foto_robo"));
			}
			
			stmt.execute();
			stmt.close();
			rs.close();
			return robo;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
