 /*
Name: Jason Nguyen
Date: 10/28/22
Description: creates a deck for the game War.
Sources Cited:
*/ 
package cardGame;

import java.util.Random;

public class Deck {
	private Card[] deck;
	private int top;

	//This creates the Deck with the 52 cards.
	public Deck() {
		System.out.println("Creating the Deck.");
		
		deck = new Card[52];
		int pos = 0;
		char[] suit = { 'S', 'H', 'C', 'D' };
		for (char a : suit) {
			for (int i = 2; i < 15; i++) {
				deck[pos] = new Card(i, a);
				pos++;
			}
			top = deck.length - 1;

		}

	}
	//This function shuffles the deck.
	public void shuffle() {
		System.out.println("Shuffling the Deck.");
		
		for (int i = 0; i < deck.length; i++) {
			int randCard = (int) (Math.random()* deck.length);
			swap(i,randCard);
			
		}
			

	}
	//This draws a card from the deck and then removes it.
	public Card draw(){
		if (top <= 0) {
			System.out.println("There are no cards to be drawn.");
			return null;
		}
		else {	
			Card toBeDrawn = deck[top];
			top  -= 1;
			System.out.println("This is the card drawn." + toBeDrawn.getSuit() + "," + toBeDrawn.getRank());
			return toBeDrawn;
		}
	}
	//This checks if the deck is empty.
	public boolean isEmpty() {
		if (deck.length == 0) {
			return true;
		}
		else {
			return false;
		}

	}
	//This swaps two cards from the deck.
	private void swap(int i, int j) {
		Card temp = deck[i];
		deck [i] = deck[j];
		deck[j] = temp;

	}

}