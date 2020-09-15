package br.com.gui;

import javax.swing.JOptionPane;

public class Usuario {
	
	private int pontuacao;

	Deck myDeck = new Deck();
	
	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	
	public int pedirCarta(Integer simNao) {
		if(simNao == 0) { //se sim
			myDeck.dealCard();//pega uma carta
		}else {//se nao
			System.out.println("Pontuação final: ");//mostra os pontos
		}

		return simNao;
	}

	
}
