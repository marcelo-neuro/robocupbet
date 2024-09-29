package br.com.fiap.robocupbet.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.robocupbet.connection.ConnectionPool;
import br.com.fiap.robocupbet.dao.ApostaDAO;
import br.com.fiap.robocupbet.dao.EquipeDAO;
import br.com.fiap.robocupbet.dao.IntegranteDAO;
import br.com.fiap.robocupbet.dao.PartidaDAO;
import br.com.fiap.robocupbet.dao.PremioDAO;
import br.com.fiap.robocupbet.dao.RoboDAO;
import br.com.fiap.robocupbet.dao.UsuarioDAO;
import br.com.fiap.robocupbet.models.Aposta;
import br.com.fiap.robocupbet.models.Equipe;
import br.com.fiap.robocupbet.models.Integrante;
import br.com.fiap.robocupbet.models.Partida;
import br.com.fiap.robocupbet.models.Premio;
import br.com.fiap.robocupbet.models.Robo;
import br.com.fiap.robocupbet.models.Usuario;

public class AppController {

	private static AppController instance;
	private Connection connection;
	private UsuarioDAO usuarioDAO;
	private EquipeDAO equipeDAO;
	private IntegranteDAO integranteDAO;
	private PartidaDAO partidaDAO;
	private RoboDAO roboDAO;
	private ApostaDAO apostaDAO;
	private PremioDAO premioDAO;

	public AppController() {
		super();
		this.connection = ConnectionPool.getConnection();
		this.usuarioDAO = new UsuarioDAO(connection);
		this.equipeDAO = new EquipeDAO(connection);
		this.integranteDAO = new IntegranteDAO(connection);
		this.partidaDAO = new PartidaDAO(connection);
		this.roboDAO = new RoboDAO(connection);
		this.apostaDAO = new ApostaDAO(connection);
		this.premioDAO = new PremioDAO(connection);
	}

	public static AppController getInstance() {
		if (instance == null) {
			instance = new AppController();
		}
		return instance;
	}

	public void closeConnection() throws SQLException {
		if (connection != null && !connection.isClosed()) {
			connection.close();
		}
	}

	// Metodos do Usuario
	public void adicionarUsuario(Usuario usuario) {
		usuarioDAO.insert(usuario);
	}

	public Usuario buscarUsuarioPorId(int id) throws SQLException {
		return usuarioDAO.findById(id);
	}

	public void atualizarUsuario(Usuario usuario) throws SQLException {
		usuarioDAO.update(usuario);
	}
	
	public void atualizarPontos(int id, int pontos) throws SQLException {
		usuarioDAO.updatePoints(id, pontos);
	}

	public void removerUsuario(int id) throws SQLException {
		usuarioDAO.delete(id);
	}

	public List<Usuario> listarUsuarios() throws SQLException {
		return usuarioDAO.findAll();
	}

	public Usuario listarUsuariosPorEmail(String email) {
		return usuarioDAO.findByEmail(email);
	}
	
	public boolean validaUsuario(String email, String senha) {
		return usuarioDAO.validate(email, senha);
	}

	// metodos do robo
	public void adicionarRobo(Robo robo) throws SQLException {
		roboDAO.insert(robo);
	}

	public Robo buscarRoboPorId(int id) throws SQLException {
		return roboDAO.findById(id);
	}

	public void atualizarRobo(Robo robo) throws SQLException {
		roboDAO.update(robo);
	}

	public void removerRobo(int id) throws SQLException {
		roboDAO.delete(id);
	}

	public List<Robo> listarRobos() throws SQLException {
		return roboDAO.findAll();
	}

	// metodos do premio
	public void adicionarPremio(Premio premio) throws SQLException {
		premioDAO.insert(premio);
	}

	public Premio buscarPremioPorId(int id) throws SQLException {
		return premioDAO.findById(id);
	}

	public void atualizarPremio(Premio premio) throws SQLException {
		premioDAO.update(premio);
	}

	public void removerPremio(int id) throws SQLException {
		premioDAO.delete(id);
	}

	public List<Premio> listarPremios() throws SQLException {
		return premioDAO.findAll();
	}

	// metodos da Partida
	//public void adicionarPartida(Partida partida) throws SQLException {
	//	partidaDAO.insert(partida);
	//}

	//public Partida buscarPartidaPorId(int id) throws SQLException {
	//	return partidaDAO.findById(id);
	//}

	//public void atualizarPartida(Partida partida) throws SQLException {
	//	premioDAO.update(premio);
	//}

	//public void removerPremio(int id) throws SQLException {
	//	partidaDAO.delete(id);
	//}

	//public List<Partida> listarPartidas() throws SQLException {
	//	return partidaDAO.findAll();
	//}
	
	public List<Partida> listarPartidas1() throws SQLException {
		return equipeDAO.findPartida();
	}

	// metodos dos Integrantes
	public void adicionarIntegrante(Integrante integrante) throws SQLException {
		integranteDAO.insert(integrante);
	}

	public Integrante buscarIntegrantesPorId(int id) throws SQLException {
		return integranteDAO.findById(id);
	}

	public void atualizarPartida(Integrante integrante) throws SQLException {
		integranteDAO.update(integrante);
	}

	public void removerIntegrantes(int id) throws SQLException {
		integranteDAO.delete(id);
	}

	public List<Integrante> listarIntegrantes() throws SQLException {
		return integranteDAO.findAll();
	}
	
	public List<Integrante> listarIntegrantesPorEquipe(int id) throws SQLException {
		return integranteDAO.findByEquipe(id);
	}

	// metodos das equipes
	public void adicionarIntegrante(Equipe equipe) throws SQLException {
		equipeDAO.insert(equipe);
	}

	public Equipe buscarEquipePorId(int id) throws SQLException {
		return equipeDAO.findById(id);
	}

	public void atualizarEquipes(Equipe equipe) throws SQLException {
		equipeDAO.update(equipe);
	}

	public void removerEquipes(int id) throws SQLException {
		equipeDAO.delete(id);
	}

	public List<Equipe> listarEquipes() throws SQLException {
		return equipeDAO.findAll();
	}
	
	// metodos das apostas
	public void adicionarAposta(Aposta aposta) throws SQLException {
		apostaDAO.insert(aposta);
	}

	public Aposta buscarApostaPorId(int id) throws SQLException {
		return apostaDAO.findById(id);
	}

	public void atualizarAposta(Aposta aposta) throws SQLException {
		apostaDAO.update(aposta);
	}

	public void removerAposta(int id) throws SQLException {
		apostaDAO.delete(id);
	}

	public List<Aposta> listarPartidas() throws SQLException {
		return apostaDAO.findAll();
	}
	

}


