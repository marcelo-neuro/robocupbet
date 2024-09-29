package br.com.fiap.robocupbet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.robocupbet.models.Usuario;
import br.com.fiap.robocupbet.util.Encode;

@WebServlet("/criaConta")
public class CriarContaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private AppController appController = AppController.getInstance();
    
    public CriarContaServlet() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario u = new Usuario();
		u.setNome(request.getParameter("usuarioNome"));
		u.setEmail(request.getParameter("usuarioEmail"));
		u.setSenha(Encode.sha256(request.getParameter("usuarioSenha")));
		
		appController.adicionarUsuario(u);
		
		request.setAttribute("usuario", u);
		request.getRequestDispatcher("/robobet.jsp").forward(request, response);
	}

}
