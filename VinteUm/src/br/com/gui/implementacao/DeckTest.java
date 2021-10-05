package br.com.gui.implementacao;

import javax.swing.JOptionPane;
import java.util.ArrayList;

import br.com.gui.*;

public class DeckTest {
	public static void main(String[] args) {

		String escolha[] = {"Sim", "Nao"}; // opcoes do JOptionPane

        Deck myDeck = new Deck();
        myDeck.shuffle(); // embaralha a array de cartas
        
        Usuario jogador = new Usuario();
        
        ArrayList<Card> cartas = new ArrayList<Card>();

        int continua = 0;
        while(continua == 0){ //0 = sim // 1 = nao

        	
        	if (jogador.getPontuacao() == 21) {
        		JOptionPane.showMessageDialog(null, "21!!");
        		break;
        	} else if(jogador.getPontuacao() > 21) {
        		JOptionPane.showMessageDialog(null, "Perdeuu");
        		break;
        	}else {
        		
            	Integer simNao = JOptionPane.showOptionDialog(null, "Deseja Mais uma carta?", "Dealer", 0, 
        				JOptionPane.QUESTION_MESSAGE, null, escolha, escolha[0]);
            	
        		if(simNao == 1) { //nao continuar
            		JOptionPane.showMessageDialog(null, jogador.getPontuacao());
            		break; //serve para nao adicionar mais uma carta apos apertar o nao
            	}else {
            			Card carta = myDeck.dealCard(); //pega uma carta
        	        	JOptionPane.showMessageDialog(null, "Sua carta: " + carta);//mostra a carta
        	        	
        	        	String cartaFace = carta.mostrarFace();//manda so a face para o método de contar pontuacao
        	        	myDeck.contarPontuacao(cartaFace, jogador);//metodo de contar pontuacao
        	        	
                		JOptionPane.showMessageDialog(null, "Pontuação: " + jogador.getPontuacao());//mostra a pontuacao
        	        	
        	        	cartas.add(carta);//manda a carta para a arraylist
        	        	myDeck.setCartas(cartas);//seta a carta para dar o get depois
        	        	
        	        	
        	        	JOptionPane.showMessageDialog(null, "Cartas: " + myDeck.getCartas());//mostra todas as cartas até agora
        	        	continua = jogador.pedirCarta(simNao);
            		}
        	}
        }
	}

}


