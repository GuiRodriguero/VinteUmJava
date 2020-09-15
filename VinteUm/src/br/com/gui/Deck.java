package br.com.gui;

import java.security.SecureRandom;
import java.util.ArrayList;

public class Deck {
	
	private Card[] deck; // array do objeto card
    private int currentCard;
    private static final int NUMBER_OF_CARDS = 52;
    private static final SecureRandom randomNumber = new SecureRandom();

    ArrayList<Card> cartas = new ArrayList<Card>();
    
    public Deck(){
        String[] faces = {"Ás", "Dois", "Três", "Quatro", "Cinco", "Seis", "Sete", "Oito", "Nove", "Dez", "Valete", "Dama", "Rei" };
        String[] naipe = { "Copas", "Ouro", "Paus", "Espada" };
        deck = new Card[NUMBER_OF_CARDS];

        currentCard = 0; //primeira carta a ser distribuida vai ser a deck[0]

        for(int count = 0; count < deck.length; count++){
            deck[count] = new Card(faces[count%13], naipe[count / 13]);
        }
    }

   public void shuffle(){
        currentCard = 0;

        for (int first = 0; first<deck.length; first++){
            int second = randomNumber.nextInt(NUMBER_OF_CARDS);

            Card temp = deck[first];
            deck[first] = deck[second];
            deck[second] = temp;
        }
    }
   
   public int contarPontuacao(String cartaFace, Usuario usuario) {
	   System.out.println(cartaFace);
	   int ponto = 0;
	   
	   switch(cartaFace) {
	   case "Ás":
		   ponto = 1;
		   break;
	   case "Dois":
		   ponto = 2;
		   break;
	   case "Três":
		   ponto = 3;
		   break;
	   case "Quatro":
		   ponto = 4;
		   break;
	   case "Cinco":
		   ponto = 5;
		   break;
	   case "Seis":
		   ponto = 6;
		   break;
	   case "Sete":
		   ponto = 7;
		   break;
	   case "Oito":
		   ponto = 8;
		   break;
	   case "Nove":
		   ponto = 9;
		   break;
	   default:
		   ponto = 10;
		   break;
	   }
	   
	   usuario.setPontuacao(usuario.getPontuacao() + ponto);
	   return usuario.getPontuacao();
   }

    public Card dealCard(){
        if (currentCard < deck.length){
            return deck[currentCard++];
        }else {
            return null;
        }
    }

	public ArrayList<Card> getCartas() {
		return cartas;
	}

	public void setCartas(ArrayList<Card> cartas) {
		this.cartas = cartas;
	}
}
