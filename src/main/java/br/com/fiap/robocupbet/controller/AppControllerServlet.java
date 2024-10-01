package br.com.fiap.robocupbet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import br.com.fiap.robocupbet.models.Partida;
import br.com.fiap.robocupbet.models.Usuario;
import br.com.fiap.robocupbet.util.Encode;

@WebServlet(urlPatterns = { "/index", "/login", "/logout", "/criaConta", "/integrantes", "/apostar", "/loja", "/adm", "/criaPartida", "/finalizaPartida", "" })
public class AppControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsuarioDAO usuarioDao = new UsuarioDAO(ConnectionPool.getConnection());
	private PartidaDAO partidaDao = new PartidaDAO(ConnectionPool.getConnection());
	private IntegranteDAO integranteDao = new IntegranteDAO(ConnectionPool.getConnection());
	private EquipeDAO equipeDao = new EquipeDAO(ConnectionPool.getConnection());
	private PremioDAO premioDao = new PremioDAO(ConnectionPool.getConnection());
	private RoboDAO roboDao = new RoboDAO(ConnectionPool.getConnection());
	private ApostaDAO apostaDao = new ApostaDAO(ConnectionPool.getConnection());

	public AppControllerServlet() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String metodo = request.getMethod();
		String caminho = request.getRequestURI();
		System.out.println(caminho);
		System.out.println(metodo);

		if (metodo.equalsIgnoreCase("GET")) {
			if (caminho.equals("/robocupbet/")) {
				getHomePage(request, response);
			}
			if (caminho.equals("/robocupbet/index")) {
				getRobobet(request, response);
			}
			if (caminho.equals("/robocupbet/integrantes")) {
				getIntegrantes(request, response);
			}
			if (caminho.equals("/robocupbet/logout")) {
				logoutUsuario(request, response);
			}
			if (caminho.equals("/robocupbet/loja")) {
				getLoja(request, response);
			}
			if (caminho.equals("/robocupbet/adm")) {
				getAdm(request, response);
			}
		} else if (metodo.equalsIgnoreCase("POST")) {
			if (caminho.equals("/robocupbet/login")) {
				postLogin(request, response);
			}
			if (caminho.equals("/robocupbet/criaConta")) {
				postCriaConta(request, response);
			}
			if (caminho.equals("/robocupbet/apostar")) {
				postAposta(request, response);
			}
			if (caminho.equals("/robocupbet/loja")) {
				buyPremio(request, response);
			}
			if (caminho.equals("/robocupbet/criaPartida")) {
				postMatch(request, response);
			}
			if (caminho.equals("/robocupbet/finalizaPartida")) {
				finishMatch(request, response);
			}
		}
	}

	private void getHomePage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/homePage.jsp").forward(request, response);
	}

	private void postLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String usuarioEmail = request.getParameter("usuarioEmail");
		String usuarioSenha = request.getParameter("usuarioSenha");

		if (usuarioDao.validate(usuarioEmail, Encode.sha256(usuarioSenha))) {
			Usuario u = usuarioDao.findByEmail(usuarioEmail);
			System.out.println(u.getPontos());
			request.getSession().setAttribute("usuario", u);
			getRobobet(request, response);
		} else {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}

	}

	private void logoutUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().invalidate();
		getHomePage(request, response);
	}

	private void postCriaConta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Usuario u = new Usuario();
		u.setNome(request.getParameter("usuarioNome"));
		u.setEmail(request.getParameter("usuarioEmail"));
		u.setSenha(Encode.sha256(request.getParameter("usuarioSenha")));

		usuarioDao.insert(u);
		
		request.getSession().setAttribute("usuario", usuarioDao.findByEmail(u.getEmail()));
		getRobobet(request, response);
	}

	private void postAposta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession httpSession = request.getSession();
		int idRobo = Integer.valueOf(request.getParameter("roboAposta"));
		int valorAposta = Integer.valueOf(request.getParameter("valorAposta"));

		Equipe equipe = equipeDao.findByIdRobo(idRobo);
		Usuario usuario = (Usuario) httpSession.getAttribute("usuario");

		Aposta aposta = new Aposta();
		aposta.setIdEquipe(equipe.getId());
		aposta.setIdPartida(equipe.getIdPartidaAtual());
		aposta.setIdUsuario(usuario.getId());
		aposta.setValor(valorAposta);

		usuario.setPontos(usuario.getPontos() - valorAposta);
		usuarioDao.update(usuario);
		apostaDao.insert(aposta);
		
		carregaRobos(request, response);
		
		httpSession.setAttribute("usuario", usuario);
		
		request.getRequestDispatcher("/robobet.jsp").forward(request, response);
	}

	private void postMatch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	    String strRoboA= request.getParameter("apostaA");
	    String strRoboB = request.getParameter("apostaB");
	    
	    if (strRoboA == null || strRoboB == null) {
	    	getAdm(request, response);
	        return;
	    }

		
	    int idRoboA = Integer.parseInt(strRoboA);
	    int idRoboB = Integer.parseInt(strRoboB);
		
		if(idRoboA == idRoboB) {
	        response.sendRedirect("adm"); 
			return;
		}
		
		Equipe [] equipes = new Equipe[] {equipeDao.findByIdRobo(idRoboA),equipeDao.findByIdRobo(idRoboB) };
		
		if(checkEquipesInPartida(equipes)) {
			request.setAttribute("errorMessage", "Uma das equipes já está em uma partida.");
			getAdm(request, response);
		}else {			
			partidaDao.create(equipes);
			int idPartidaCriada = partidaDao.getLastId();
			equipes[0].setIdPartidaAtual(idPartidaCriada);
			equipes[1].setIdPartidaAtual(idPartidaCriada);
			
			equipeDao.update(equipes[0]);
			equipeDao.update(equipes[1]);
			
			getAdm(request, response);
		}

	}
	
	private void finishMatch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String vencedorId = request.getParameter("vencedor"); 
				
	    int idVencedor = Integer.parseInt(vencedorId);
	    
	    Equipe idEquipe = equipeDao.findByIdRobo(idVencedor);
	    
	    Partida partida = partidaDao.findPartidaByEquipeVencedora(idEquipe.getId());
	    partidaDao.updatePartida(partida);
	    
	    List<Equipe> equipes = partidaDao.findEquipeByPartida(idVencedor);
	    equipeDao.updateFinishPartida(equipes.get(0));
	    equipeDao.updateFinishPartida(equipes.get(1));
	    
	    List<Aposta> apostas = apostaDao.findApostasByPartidaEquipe(partida.getId(), idVencedor);
	    apostas.forEach(a -> {
	    	Usuario u = usuarioDao.findById(a.getIdUsuario());
	    	u.setPontos(u.getPontos() + a.getValor() * 2);
	    	
	    	usuarioDao.update(u);
	    });
	    
	    getAdm(request, response);
	}
	
	private boolean checkEquipesInPartida(Equipe [] equipes) {
		return partidaDao.checkEquipes(equipes);
	}

	private void getRobobet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		carregaRobos(request, response);
		request.getRequestDispatcher("/robobet.jsp").forward(request, response);
	}

	private void getLoja(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("premios", premioDao.findAll());
		request.getAttribute("usuario");
		request.getRequestDispatcher("/loja.jsp").forward(request, response);
	}

	private void buyPremio(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    Usuario u = (Usuario) request.getSession().getAttribute("usuario");
	    int pontosComprados = Integer.parseInt(request.getParameter("v"));

	    if (u.getPontos() < pontosComprados) {
	    	 request.setAttribute("errorMessage", "Você não tem pontos suficientes!");
	         getLoja(request, response);
	    }

	    usuarioDao.insertBoughtReward(Integer.parseInt(request.getParameter("p")), u.getId());
	    u.setPontos(u.getPontos() - pontosComprados);
	    usuarioDao.update(u);
	    request.getSession().setAttribute("usuario", u);

	    request.getRequestDispatcher("/win.jsp").forward(request, response);
	}


	private void getIntegrantes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idRobo = Integer.valueOf(request.getParameter("eid"));
		request.setAttribute("integrantes", integranteDao.findByIdRobo(idRobo));
		request.setAttribute("equipe", equipeDao.findByIdRobo(idRobo));
		request.getRequestDispatcher("/integrantes.jsp").forward(request, response);
	}

	private void getAdm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		carregaCriacaoDeRobos(request, response);
		request.setAttribute("lutas", partidaDao.findAllLutasAtivas());
		request.getRequestDispatcher("/adm.jsp").forward(request, response);
	}

	private void carregaCriacaoDeRobos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("robos", roboDao.findAll());
	}

	private void carregaRobos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		int idUsuario = usuario.getId();
		request.setAttribute("lutas", partidaDao.findLutasAtivasNaoApostadasByIdUsuario(idUsuario));
	}
}
