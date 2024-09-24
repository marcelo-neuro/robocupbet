package br.com.fiap.robocupbet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.robocupbet.models.Usuario;

public class UsuarioDAO {
	
	private Connection con;
	
	public UsuarioDAO (Connection con) {
		this.con = con;
	}
	
	public void insert(Usuario usuario) {
		String sql = "INSERT INTO usuarios (nome_usuario, email_usuario, senha_usuario) values (?, ?, ?)";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getSenha());
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e){
			throw new RuntimeException (e);
		}
	}
	
	public void update(Usuario usuario) {
		String sql = "UPDATE usuarios SET usuario_nome = ?, email_usuario = ?, senha_usuario = ?, pontos_usuario = ? WHERE id_usuario = ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getSenha());
			stmt.setInt(4, usuario.getPontos());
			stmt.setInt(5, usuario.getId());
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e){
			throw new RuntimeException (e);
		}
	}
	
	public void delete(Usuario usuario) {
		String sql = "DELETE FROM usuarios WHERE id_usuario = ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, usuario.getId());
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException (e);
		}
	}
	
	public List<Usuario> findAll() {
		try {
			List<Usuario> usuarios = new ArrayList<>();
			String sql = "SELECT * FROM usuarios";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt(1));
				usuario.setNome(rs.getString(2));
				usuario.setEmail(rs.getString(3));
				usuario.setSenha(rs.getString(4));
				usuario.setPontos(rs.getInt(5));
				usuarios.add(usuario);
			}
			
			rs.close();
			stmt.close();
			
			return usuarios;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void findById (Usuario usuario) {
		try {
			String sql = "SELECT * FROM usuarios WHERE id_usuario = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			stmt.setInt(1, usuario.getId());
			
			while (rs.next()) {
				usuario.setId(rs.getInt(1));
				usuario.setNome(rs.getString(2));
				usuario.setEmail(rs.getString(3));
				usuario.setSenha(rs.getString(4));
				usuario.setPontos(rs.getInt(5));
			}
			
			stmt.execute();
			stmt.close();
			rs.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void findByEmail (Usuario usuario) {
		try {
			String sql = "SELECT * FROM usuarios WHERE email_usuario = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			stmt.setString(1, usuario.getEmail());
			
			while (rs.next()) {
				usuario.setId(rs.getInt(1));
				usuario.setNome(rs.getString(2));
				usuario.setEmail(rs.getString(3));
				usuario.setSenha(rs.getString(4));
				usuario.setPontos(rs.getInt(5));
			}
			
			stmt.execute();
			stmt.close();
			rs.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
