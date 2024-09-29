package br.com.fiap.robocupbet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.robocupbet.models.Aposta;
import br.com.fiap.robocupbet.models.Partida;
import br.com.fiap.robocupbet.models.Usuario;
import br.com.fiap.robocupbet.services.ApostaService;

@WebServlet("/ApostaServlet")
public class ApostaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AppController appController = AppController.getInstance();

    public ApostaServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Aposta aposta = new Aposta();
		Partida partida = new Partida();
		
	    partida.setId(Integer.valueOf(request.getParameter("partidaId")));
	    
	    String betOnAParam = request.getParameter("betOnA");
	    String betOnBParam = request.getParameter("betOnB");
	    	
	    int inputOnA = betOnAParam == null ? 0 : Integer.valueOf(request.getParameter("betOnA"));
	    int inputOnB = betOnBParam == null ? 0 : Integer.valueOf(request.getParameter("betOnB"));

		double pontosGanhos;
		int id = (int)request.getSession().getAttribute("usuario-id");
		Usuario user = null;
		
		try {
			user = appController.buscarUsuarioPorId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(inputOnA > 0) {			
			pontosGanhos = ApostaService.betValueResult(inputOnA, 'a');
			try {
				appController.atualizarPontos(id, (int) pontosGanhos);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			aposta.setIdPartida(partida.getId()); 	
			aposta.setIdUsuario(id);
			aposta.setAtiva(false);
			aposta.setValor(betOnAParam == null ? inputOnB : inputOnA);
			boolean vencida = pontosGanhos > 0 ? true : false; 
			aposta.setVencida(vencida);
			try {
				appController.adicionarAposta(aposta);
				request.getSession().setAttribute("usuario-pontos", user.getPontos());
				request.setAttribute("pontos", user.getPontos());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}else {
			pontosGanhos = ApostaService.betValueResult(inputOnA, 'b');
			aposta.setIdPartida(partida.getId());
			aposta.setIdUsuario(id);
			aposta.setValor(inputOnB);
			boolean vencida = pontosGanhos > 0 ? true : false; 
			aposta.setVencida(vencida);
			try {
				appController.adicionarAposta(aposta);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		try {
			List<Partida>partidas = appController.listarPartidas1();
			request.setAttribute("partidas", partidas);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		
		request.getRequestDispatcher("/robobet.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
