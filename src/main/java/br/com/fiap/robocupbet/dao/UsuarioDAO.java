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

	public UsuarioDAO(Connection con) {
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

		} catch (SQLException e) {
			throw new RuntimeException(e);
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

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void delete(int id) {
		String sql = "DELETE FROM usuarios WHERE id_usuario = ?";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
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
				usuario.setId(rs.getInt("id_usuario"));
				usuario.setNome(rs.getString("nome_usuario"));
				usuario.setEmail(rs.getString("email_usuario"));
				usuario.setSenha(rs.getString("senha_usuario"));
				usuario.setPontos(rs.getInt("pontos_usuario"));
				usuarios.add(usuario);
			}

			rs.close();
			stmt.close();

			return usuarios;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Usuario findById(int id) {
		try {
			String sql = "SELECT * FROM usuarios WHERE id_usuario = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			stmt.setInt(1, id);
			Usuario usuario = new Usuario();

			while (rs.next()) {
				usuario.setId(rs.getInt("id_usuario"));
				usuario.setNome(rs.getString("nome_usuario"));
				usuario.setEmail(rs.getString("email_usuario"));
				usuario.setSenha(rs.getString("senha_usuario"));
				usuario.setPontos(rs.getInt("pontos_usuario"));
			}

			stmt.execute();
			stmt.close();
			rs.close();
			return usuario;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Usuario findByEmail(String email) {
		try {
			String sql = "SELECT * FROM usuarios WHERE email_usuario = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			
			Usuario usuario = new Usuario();

			while (rs.next()) {
				usuario.setId(rs.getInt("id_usuario"));
				usuario.setNome(rs.getString("nome_usuario"));
				usuario.setEmail(rs.getString("email_usuario"));
				usuario.setSenha(rs.getString("senha_usuario"));
				usuario.setPontos(rs.getInt("pontos_usuario"));
			}

			stmt.execute();
			stmt.close();
			rs.close();
			return usuario;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean validate(String email, String senha) {
		List<Usuario> us = findAll();
		for(Usuario u: us) {
			System.out.println(u.getEmail());
			System.out.println(u.getSenha());
			if(u.getEmail().equals(email) && u.getSenha().equals(senha)) {
				
				return true;
			}
		}
		return true;
	}
}
