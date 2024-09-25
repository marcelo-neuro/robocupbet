package br.com.fiap.robocupbet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.robocupbet.models.Usuario;
import br.com.fiap.robocupbet.util.Encode;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AppController appController = AppController.getInstance();
	
    
    public LoginServlet() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuarioEmail = request.getParameter("usuarioEmail");
		String usuarioSenha = request.getParameter("usuarioSenha");
	
		if(appController.validaUsuario(usuarioEmail, Encode.sha256(usuarioSenha))) {
			Usuario u = appController.listarUsuariosPorEmail(usuarioEmail);
			request.setAttribute("usuario", u);
			request.getRequestDispatcher("/robobet.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
	}

}
