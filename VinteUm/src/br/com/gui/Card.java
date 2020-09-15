package br.com.gui;

public class Card {
	
    private final String face;
    private final String naipe;

    public Card(String cardFace, String cardNaipe){
        this.face = cardFace;
        this.naipe = cardNaipe;
    }

    public String toString(){
        return face + " de " + naipe;
    }
    
    public String mostrarFace(){
        return face;
    }
}

