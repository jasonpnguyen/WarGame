/*
Name: Jason Nguyen
Date: 10/28/22
Description: creates a deck and plays the game War.
Sources Cited:
*/ 

package cardGame;

import java.io.IOException;
import java.util.Objects;

public class War {
	public static void promptEnterKey(){
		try {
			System.in.read(new byte[2]);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	//War is a function that determines the outcome of a round- win,loss,draw.
	public static int war(Deck w) {
		//I used a try and catch block in order to resolve my NullPointerException,
		//that came from my Deck Class since if there are no cards to be drawn I set it to "null".
		//I was trying to make pCardInHand == null and IsNull() but it didn't work so I resolved it
		//a try and catch block.
		try {
			//Player draws a card.
			Card pCardInHand = w.draw();
			System.out.println("Player card is: " + pCardInHand.getRank() + pCardInHand.getSuit());
			System.out.println("Please enter the 'Enter' key to continue.");
			promptEnterKey();
			
			//Computer draws a card.
			Card cCardInHand = w.draw();
			System.out.println("The computers card is: " + cCardInHand.getRank() + cCardInHand.getSuit());
			System.out.println("Please enter the 'Enter' key to continue.");
			promptEnterKey();
			
			//If the player(user) wins the round then it returns option 1. 
			if (pCardInHand.getRank() > cCardInHand.getRank()) {
				return 1;
				
			}
			//If the Computer wins the round it returns option 2.
			else if (pCardInHand.getRank() < cCardInHand.getRank()) {
				return 2;
			}
			//If it runs this else statement, then the "war" happens
			//Player and Computer draws 2 cards
			//Returns a 3, which causes the war function to repeat.
			else {
				w.draw();
				System.out.println("Player draws a card.");
				System.out.println("Please enter the 'Enter' key to continue.");
				promptEnterKey();
				
				w.draw();
				System.out.println("The Computer draws a card.");
				System.out.println("Please enter the 'Enter' key to continue.");
				promptEnterKey();
				
				w.draw();
				System.out.println("Player draws a card.");
				System.out.println("Please enter the 'Enter' key to continue.");
				promptEnterKey();
				
				w.draw();
				System.out.println("The Computer draws a card.");
				System.out.println("Please enter the 'Enter' key to continue.");
				promptEnterKey();
				
				return 3;	
			}
		}
		//This will end the game and loop through returning a -1 by using the catch block.
		catch(NullPointerException e) {
			return -1;
		}
		
	}

	public static void main(String[] args) {
		//These are my initializers. Playerscore, Computerscore, and when to end the game, and also the deck.
		Deck d = new Deck();
		int pScore = 0;
		int cScore = 0;
		int end = 0;
		
		//This shuffles the deck.
		d.shuffle();
		
		//While end does not equal -1 the loop runs and game continues.
		while((end != -1)) {
			
			//This calls the war function.
			int winner = war(d);
			
			//If war equals -1 then the game ends.
			if (winner == -1)
			{
				end = -1;
			}
			
			//If war equals 1 then the player has won.Adds the score.
			else if (winner == 1) {
				pScore++;
				System.out.println("Player win! Player's score is now: " + pScore);
			}
			
			//If the war equals 2 then the computer has won.Adds the score.
			else if (winner == 2){
				cScore++;
				System.out.println("Player lost! The Computer's score is now: " + cScore);
			}
			
			//This runs because there has been a tie and war is called again.
			else if (winner == 3){
				int afterWinner = war(d);
				
				//Player has won if war equal 1. Adds score.
				if (afterWinner == 1) {
					pScore += 3;
					System.out.println("Player win! Computer's score is now: " + pScore);
				}
				
				//Computer has won if war equals 2. Adds score.
				else if (afterWinner == 2){
					cScore += 3;
					System.out.println("Player lost! The Computer's score is now: " + cScore);
				}
				
				//This means there was another tie. No winner. And no score is added.
				else if (afterWinner == 3)
					System.out.println("No Winner! The score is: Player: " + pScore + " Computer: " + cScore);
				else
					System.out.println("Player's Score: " + pScore + " The Computer's Score: " + cScore);
			}
			
		}
		//This means game over and program is finished.
		System.out.println("The Game has ended!");
		System.out.println("Player's Score: " + pScore + " The Computer's Score: " + cScore);
		
	}
	


}
