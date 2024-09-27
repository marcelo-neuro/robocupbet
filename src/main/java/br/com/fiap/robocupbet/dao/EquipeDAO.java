package br.com.fiap.robocupbet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.robocupbet.models.Equipe;
import br.com.fiap.robocupbet.models.Partida;
import br.com.fiap.robocupbet.models.Robo;

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
		String sql = "UPDATE equipes SET id_equipe = ?, id_robo = ?, nome_equipe = ? WHERE id_equipe = ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, equipe.getId());
			stmt.setInt(2, equipe.getIdRobo());
			stmt.setString(3, equipe.getNome());
			stmt.setInt(4, equipe.getId());
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
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			Equipe equipe = new Equipe();
			
			while (rs.next()) {
				equipe.setId(rs.getInt("id_equipe"));
				equipe.setIdRobo(rs.getInt("id_robo"));
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
	
	public List<Equipe> findByPartida(int idPartida) {
		List<Equipe> es = new ArrayList<Equipe>();
		String sql = """
				SELECT * FROM equipes
				WHERE equipes.id_partida = ?
				""";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, idPartida);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Equipe equipe = new Equipe();
				equipe.setId(rs.getInt("id_equipe"));
				equipe.setIdRobo(rs.getInt("id_robo"));
				equipe.setNome(rs.getString("nome_equipe"));
				es.add(equipe);
			}
			return es;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public List<Partida> findPartida(){		
		List<Partida> partidas = new ArrayList<Partida>();
		String sql = "SELECT \r\n"
				+ "    PARTIDAS.id_partida,\r\n"
				+ "    eqA.nome_equipe AS equipeA,\r\n"
				+ "    eqA.id_equipe as id_equipeA,\r\n"
				+ "    rbA.nome_robo AS roboA,\r\n"
				+ "    rbA.id_robo AS id_roboA,\r\n"
				+ "    rbA.url_foto_robo AS roboA_img,\r\n"
				+ "    eqB.id_equipe as id_equipeB,\r\n"
				+ "    eqB.nome_equipe AS equipeB,\r\n"
				+ "    rbB.id_robo AS id_roboB,\r\n"
				+ "    rbB.nome_robo AS roboB,\r\n"
				+ "    rbB.url_foto_robo AS roboB_img\r\n"
				+ "	FROM PARTIDAS\r\n"
				+ "    INNER JOIN\r\n"
				+ "	ITENS_PARTIDAS ipA ON PARTIDAS.id_partida = ipA.id_partida\r\n"
				+ "	INNER JOIN \r\n"
				+ "	EQUIPES eqA ON ipA.id_equipe = eqA.id_equipe\r\n"
				+ "	INNER JOIN \r\n"
				+ "	ROBOS rbA ON eqA.id_robo = rbA.id_robo\r\n"
				+ "	INNER JOIN \r\n"
				+ "	ITENS_PARTIDAS ipB ON PARTIDAS.id_partida = ipB.id_partida\r\n"
				+ "	INNER JOIN \r\n"
				+ "	EQUIPES eqB ON ipB.id_equipe = eqB.id_equipe\r\n"
				+ "	INNER JOIN \r\n"
				+ "	ROBOS rbB ON eqB.id_robo = rbB.id_robo\r\n"
				+ "	WHERE rbA.id_robo < rbB.id_robo";
					
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
            	Robo roboA = new Robo();
            	roboA.setId(rs.getInt("id_roboA"));
            	roboA.setNome(rs.getString("roboA"));
            	roboA.setUrlFoto(rs.getString("roboA_img"));	
            	
            	Robo roboB = new Robo();
            	roboB.setId(rs.getInt("id_roboB"));
            	roboB.setNome(rs.getString("roboB"));
            	roboB.setUrlFoto(rs.getString("roboB_img"));

            	Equipe equipeA = new Equipe();
            	equipeA.setId(rs.getInt("id_equipeA"));
            	equipeA.setRobo(roboA);
            	equipeA.setNome(rs.getString("equipeA"));

            	Equipe equipeB = new Equipe();
            	equipeB.setId(rs.getInt("id_equipeB"));
            	equipeB.setRobo(roboB);
            	equipeB.setNome(rs.getString("equipeB"));
            	
            	Partida partida = new Partida();
            	partida.setId(rs.getInt("id_partida"));
            	partida.setEquipeA(equipeA);
            	partida.setEquipeB(equipeB);
            	
            	partidas.add(partida);
            }
            
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		return partidas;
		
	}
	
}
