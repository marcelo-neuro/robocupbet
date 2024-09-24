package br.com.fiap.robocupbet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.robocupbet.models.Premio;

public class PremioDAO {

	private Connection con;
	
	public PremioDAO (Connection con) {
		this.con = con;
	}
	
	public void insert(Premio premio) {
		String sql = "INSERT INTO premio (nome_premio, desc_premio, valor_premio, quantidade_premio, url_foto_premio) values (?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, premio.getNome());
			stmt.setString(2, premio.getDesc());
			stmt.setInt(3, premio.getValor());
			stmt.setInt(4, premio.getQuantidade());
			stmt.setString(5, premio.getUrlFoto());
			stmt.execute();
			stmt.close();
			con.close();
		} catch (SQLException e){
			throw new RuntimeException (e);
		}
	}
	
	public void update(Premio premio) {
		String sql = "UPDATE premio SET nome_premio = ?, desc_premio = ?, valor_premio = ?, quantidade_premio = ?, url_foto_premio = ? WHERE id_premio = ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, premio.getNome());
			stmt.setString(2, premio.getDesc());
			stmt.setInt(3, premio.getValor());
			stmt.setInt(4, premio.getQuantidade());
			stmt.setString(5, premio.getUrlFoto());
			stmt.setInt(6, premio.getId());
			stmt.execute();
			stmt.close();
			con.close();
		} catch (SQLException e){
			throw new RuntimeException (e);
		}
	}
	
	public void delete(Premio premio) {
		String sql = "DELETE FROM premio WHERE id_premio = ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, premio.getId());
			stmt.execute();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			throw new RuntimeException (e);
		}
	}
	
	public List<Premio> findAll() {
		try {
			List<Premio> premios = new ArrayList<>();
			String sql = "SELECT * FROM premio";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Premio premio = new Premio();
				premio.setId(rs.getInt(1));
				premio.setNome(rs.getString(2));
				premio.setDesc(rs.getString(3));
				premio.setValor(rs.getInt(4));
				premio.setQuantidade(rs.getInt(5));
				premio.setUrlFoto(rs.getNString(6));
				premios.add(premio);
			}
			
			rs.close();
			stmt.close();
			con.close();
			return premios;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void findById (Premio premio) {
		try {
			String sql = "SELECT * FROM premio WHERE id_premio = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			stmt.setInt(1, premio.getId());
			
			while (rs.next()) {
				premio.setId(rs.getInt(1));
				premio.setNome(rs.getString(2));
				premio.setDesc(rs.getString(3));
				premio.setValor(rs.getInt(4));
				premio.setQuantidade(rs.getInt(5));
				premio.setUrlFoto(rs.getNString(6));
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
