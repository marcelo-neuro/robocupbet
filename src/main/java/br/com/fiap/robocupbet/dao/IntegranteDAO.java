package br.com.fiap.robocupbet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.robocupbet.models.Integrante;

public class IntegranteDAO {

	private Connection con;
	
	public IntegranteDAO (Connection con) {
		this.con = con;
	}
	
	public void insert(Integrante integrante) {
		String sql = "INSERT INTO integrantes (id_equipe, nome_integrante, rm_integrante, url_foto_integrante) values (?, ?, ?, ?)";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, integrante.getIdEquipe());
			stmt.setString(2, integrante.getNome());
			stmt.setString(3, integrante.getRm());
			stmt.setString(4, integrante.getUrlFoto());
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e){
			throw new RuntimeException (e);
		}
	}
	
	public void update(Integrante integrante) {
		String sql = "UPDATE integrantes SET id_equipe = ?, nome_integrante = ?, rm_integrante = ?, url_foto_integrante = ? WHERE id_integrantes = ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, integrante.getIdEquipe());
			stmt.setString(2, integrante.getNome());
			stmt.setString(3, integrante.getRm());
			stmt.setString(4, integrante.getUrlFoto());
			stmt.setInt(5, integrante.getId());
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e){
			throw new RuntimeException (e);
		}
	}
	
	public void delete(int id) {
		String sql = "DELETE FROM integrantes WHERE id_integrantes = ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException (e);
		}
	}
	
	public List<Integrante> findAll() {
		try {
			List<Integrante> integrantes = new ArrayList<>();
			String sql = "SELECT * FROM integrantes";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Integrante integrante = new Integrante();
				integrante.setId(rs.getInt("id_integrantes"));
				integrante.setIdEquipe(rs.getInt("id_equipe"));
				integrante.setNome(rs.getString("nome_integrante"));
				integrante.setRm(rs.getString("rm_integrante"));
				integrante.setUrlFoto(rs.getString("url_foto_integrante"));
				integrantes.add(integrante);
			}
			
			rs.close();
			stmt.close();
			
			return integrantes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Integrante findById (int id) {
		try {
			String sql = "SELECT * FROM integrantes WHERE id_integrantes = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			stmt.setInt(1, id);
			Integrante integrante = new Integrante();
			
			while (rs.next()) {
				integrante.setId(rs.getInt("id_integrantes"));
				integrante.setIdEquipe(rs.getInt("id_equipe"));
				integrante.setNome(rs.getString("nome_integrante"));
				integrante.setRm(rs.getString("rm_integrante"));
				integrante.setUrlFoto(rs.getString("url_foto_integrante"));
			}
			
			stmt.execute();
			stmt.close();
			rs.close();
			
			return integrante;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
