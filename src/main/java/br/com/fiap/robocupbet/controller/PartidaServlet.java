package br.com.fiap.robocupbet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.robocupbet.models.Partida;

@WebServlet("/PartidaServlet")
public class PartidaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AppController appController = AppController.getInstance();

       
    public PartidaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			List<Partida> partidas = appController.listarPartidas1();
			request.setAttribute("partidas", partidas);
			request.getRequestDispatcher("/robobet.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
