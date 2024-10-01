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
			
		} catch (SQLException e){
			throw new RuntimeException (e);
		}
	}
	
	public void delete(int id) {
		String sql = "DELETE FROM premio WHERE id_premio = ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
			
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
				premio.setId(rs.getInt("id_premio"));
				premio.setNome(rs.getString("nome_premio"));
				premio.setDesc(rs.getString("desc_premio"));
				premio.setValor(rs.getInt("valor_premio"));
				premio.setQuantidade(rs.getInt("quantidade_premio"));
				premio.setUrlFoto(rs.getNString("url_foto_premio"));
				premios.add(premio);
			}
			
			rs.close();
			stmt.close();
			
			return premios;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Premio findById (int id) {
		try {
			String sql = "SELECT * FROM premio WHERE id_premio = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			stmt.setInt(1, id);
			Premio premio = new Premio();
			
			while (rs.next()) {
				premio.setId(rs.getInt("id_premio"));
				premio.setNome(rs.getString("nome_premio"));
				premio.setDesc(rs.getString("desc_premio"));
				premio.setValor(rs.getInt("valor_premio"));
				premio.setQuantidade(rs.getInt("quantidade_premio"));
				premio.setUrlFoto(rs.getNString("url_foto_premio"));
			}
			
			stmt.execute();
			stmt.close();
			rs.close();
			
			return premio;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
}
