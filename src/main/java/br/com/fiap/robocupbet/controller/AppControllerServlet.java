package br.com.fiap.robocupbet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.fiap.robocupbet.connection.ConnectionPool;
import br.com.fiap.robocupbet.dao.PartidaDAO;
import br.com.fiap.robocupbet.dao.UsuarioDAO;
import br.com.fiap.robocupbet.models.Usuario;
import br.com.fiap.robocupbet.util.Encode;


@WebServlet(urlPatterns = {"/index", "/login", "/logout" ,"/criaConta", ""})
public class AppControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UsuarioDAO usuarioDao = new UsuarioDAO(ConnectionPool.getConnection());
	private PartidaDAO partidaDao = new PartidaDAO(ConnectionPool.getConnection());
    
    public AppControllerServlet() {
        super();
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String metodo = request.getMethod();
		String caminho = request.getRequestURI();
		System.out.println(caminho);
		System.out.println(metodo);
		
		if (metodo.equalsIgnoreCase("GET")) {
			if(caminho.equals("/robocupbet/")) {
				getHomePage(request, response);
			}
			if(caminho.equals("/robocupbet/index")) {
				getRobobet(request, response);
			}
			if(caminho.equals("/robocupbet/logout")) {
				logoutUsuario(request, response);
			}
		} else if(metodo.equalsIgnoreCase("POST")) {
			if (caminho.equals("/robocupbet/login")) {
				postLogin(request, response);
			}
			if(caminho.equals("/robocupbet/criaConta")) {
				postCriaConta(request, response);
			}
		}
	}
	
	private void logoutUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		request.getRequestDispatcher("/homePage.jsp").forward(request, response);
	}

	private void getHomePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/homePage.jsp").forward(request, response);
	}

	private void postLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuarioEmail = request.getParameter("usuarioEmail");
		String usuarioSenha = request.getParameter("usuarioSenha");
	
		if(usuarioDao.validate(usuarioEmail, Encode.sha256(usuarioSenha))) {
			Usuario u = usuarioDao.findByEmail(usuarioEmail);
			
			request.getSession().setAttribute("usuario", u);
			getRobobet(request, response);
		} else {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
	}
	
	protected void postCriaConta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario u = new Usuario();
		u.setNome(request.getParameter("usuarioNome"));
		u.setEmail(request.getParameter("usuarioEmail"));
		u.setSenha(Encode.sha256(request.getParameter("usuarioSenha")));
		
		usuarioDao.insert(u);
		
		request.setAttribute("usuario", u);
		getRobobet(request, response);
	}
	
	private void getRobobet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		carregaRobos(request, response);
		request.getRequestDispatcher("/robobet.jsp").forward(request, response);
	}
	
	
	private void carregaRobos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("lutas", partidaDao.findAllRobosInPartida());
	}
}
