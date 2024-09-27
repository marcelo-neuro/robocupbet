package br.com.fiap.robocupbet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.robocupbet.models.Equipe;

public class PartidaDAO {

	private Connection con;

	public PartidaDAO(Connection con) {
		this.con = con;
	}

	public void create(Equipe... equipes) {
		//cria partida
		String sqlPartida = """
				INSERT INTO partidas (id_equipe_vencedora)
				VALUES (NULL)
				""";

		//cria item partida
		String sqlItemPartida = """
				INSERT INTO partidas (id_equipe, id_partida)
				VALUES (?, ?)
				""";

		try {
			PreparedStatement ps = con.prepareStatement(sqlPartida);
			ps.execute();
			ps.close();

			int lastPartidaId = getLastId();

			for (int i = 0; i < 1; i++) {
				ps = con.prepareStatement(sqlItemPartida); // substitui a ps por uma nova
				ps.setInt(1, equipes[i].getId());
				ps.setInt(2, lastPartidaId);
				ps.close();
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private List<List<Equipe>> findAll() {
		List<List<Equipe>> lutas = new ArrayList<>();
		
		String sql = """
				SELECT e.id_equipe, e.id_robo, e.nome_equipe FROM itens_partidas ip
				JOIN equipes e
				ON ip.id_equipe = e.id_equipe
				ORDER BY ip.id_partida
				""";
	
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				List<Equipe> luta = new ArrayList<Equipe>();
				
				for(int j = 0; j < 2; j++) {
					Equipe equipe = new Equipe();
					equipe.setId(rs.getInt("id_equipe"));
					equipe.setIdRobo(rs.getInt("id_robo"));
					equipe.setNome(rs.getString("nome_equipe"));
					luta.add(equipe);
				}
				lutas.add(luta);
			}
			ps.close();
			rs.close();
			
			return lutas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	private int getLastId() {
		int res = 0;
		String sql = """
				SELECT max(id_partida) FROM partidas
				""";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			rs.next();
			res = rs.getInt(1);

			rs.close();
			ps.close();

			return res;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
