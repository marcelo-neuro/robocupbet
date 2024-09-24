package br.com.fiap.robocupbet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	public void delete(Robo robo) {
		String sql = "DELETE FROM robos WHERE id_robo = ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, robo.getId());
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
				robo.setId(rs.getInt(1));
				robo.setNome(rs.getString(2));
				robo.setPeso(rs.getDouble(3));
				robo.setAltura(rs.getDouble(4));
				robo.setLargura(rs.getDouble(5));
				robo.setComprimento(rs.getDouble(6));
				robo.setUrlFoto(rs.getString(7));
				robos.add(robo);
			}
			
			rs.close();
			stmt.close();
			
			return robos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void findById (Robo robo) {
		try {
			String sql = "SELECT * FROM robos WHERE id_robo = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			stmt.setInt(1, robo.getId());
			
			while (rs.next()) {
				robo.setId(rs.getInt(1));
				robo.setNome(rs.getString(2));
				robo.setPeso(rs.getDouble(3));
				robo.setAltura(rs.getDouble(4));
				robo.setLargura(rs.getDouble(5));
				robo.setComprimento(rs.getDouble(6));
				robo.setUrlFoto(rs.getString(7));
			}
			
			stmt.execute();
			stmt.close();
			rs.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
