package br.com.fiap.robocupbet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.robocupbet.models.Equipe;
import br.com.fiap.robocupbet.models.Robo;

public class PartidaDAO {

	private Connection con;

	public PartidaDAO(Connection con) {
		this.con = con;
	}

	public void create(Equipe... equipes) {
		// cria partida
		String sqlPartida = """
				INSERT INTO partidas (id_equipe_vencedora)
				VALUES (NULL)
				""";

		// cria item partida
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

	public List<List<Robo>> findAllRobosInPartida() {
		List<List<Robo>> lutas = new ArrayList<>();

		String sql = """
				SELECT r.id_robo, r.nome_robo, r.peso_robo, r.altura_robo, r.largura_robo, r.comprimento_robo, r.url_foto_robo 
				FROM itens_partidas ip
				JOIN equipes e
				ON ip.id_equipe = e.id_equipe
				JOIN robos r
				ON r.id_robo = e.id_robo
				ORDER BY ip.id_partida
				""";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Robo> robos = new ArrayList<>();
			while (rs.next()) {
				Robo r = new Robo();
				r.setId(rs.getInt("id_robo"));
				r.setNome(rs.getString("nome_robo"));
				r.setPeso(rs.getDouble("peso_robo"));
				r.setAltura(rs.getDouble("altura_robo"));
				r.setLargura(rs.getDouble("largura_robo"));
				r.setComprimento(rs.getDouble("comprimento_robo"));
				r.setUrlFoto(rs.getString("url_foto_robo"));
				robos.add(r);
			}
			
			for(int i = 0; i < robos.size();) {
				lutas.add(new ArrayList<>());
				for(int j = 0; j < 2; j++) {
					lutas.get(i/2).add(robos.get(i));
					i++;
				}
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
