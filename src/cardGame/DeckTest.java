package cardGame;

public class DeckTest {

	public static void main(String[] args) {
		Deck d = new Deck();
		d.shuffle();
		
		while(!(d.isEmpty())) {
			Card c = d.draw();
			if (c!= null) {
				System.out.println("Here is the card: " + c.getSuit() + ", " + c.getRank());
			}
		}
	}
}
