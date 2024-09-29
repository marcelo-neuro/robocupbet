package br.com.fiap.robocupbet.services;

public class ApostaService {
	
	public static double betValueResult(double aposta, char timeApostado) {
		int max = 100;
        int min = 1;
        int range = max - min + 1;
		
		double apostaA = (Math.random() * range) + min;
		double apostaB = 100 - apostaA;
		int chances = (int) (Math.random() * 2);
		
		boolean resultado = betResult(apostaA, apostaB, chances);
		return calculaValorRecebido(apostaA, apostaB, aposta, resultado, timeApostado);
	}
	
	public static double calculaValorRecebido(double apostaA, double apostaB, double aposta , boolean resultado, char timeApostado ) {
		if (resultado && timeApostado == 'a') {
			return ((aposta * apostaA) / 100);
		} else if (resultado && timeApostado == 'b') {
			return ((aposta * apostaB) / 100);
		} else if (timeApostado == 'a') {
			return (-((aposta * apostaA) / 100));
		}else {
			return (-((aposta * apostaB) / 100));
		}
	}
	
	
	public static boolean betResult(double apostaA, double apostaB, double chances) {
		if(chances == 1) {
			return true;
		}
		return false;
	}

}
