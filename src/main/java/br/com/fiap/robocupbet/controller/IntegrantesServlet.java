package br.com.fiap.robocupbet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.robocupbet.models.Equipe;
import br.com.fiap.robocupbet.models.Integrante;

@WebServlet("/IntegrantesServlet")
public class IntegrantesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AppController appController = AppController.getInstance();

    public IntegrantesServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			int id = Integer.valueOf(request.getParameter("equipeId"));
			List<Integrante> integrantes = appController.listarIntegrantesPorEquipe(id);
			Equipe equipe = appController.buscarEquipePorId(id);
			request.setAttribute("integrantes", integrantes);
			request.setAttribute("equipes", equipe);
			request.getRequestDispatcher("/integrantes.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
