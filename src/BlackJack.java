
public class BlackJack {
	public Deck deckOf21;
	public Hand player, dealer;
	
	// constructor, creates a deck of 52 cards, creates dealer
	// hand and player hand (but does not deal)
	public BlackJack() {
		deckOf21 = new Deck();
		deckOf21.createFullDeck();
		deckOf21.shuffleDeck();
		player = new Hand();
		dealer = new Hand();
	}
	
	// method to deal from the deck to player/dealer 
	// hands (occurs multiple times throughout game)
	public void dealCards() {
		int handSize = 2;
		player.createHand(handSize, deckOf21);
		dealer.createHand(handSize, deckOf21);
	}
	
	public void playBlackJack() {
		
		dealCards();
		
		// prints out the deck, and each hand for debugging purposes
		deckOf21.printDeck();
		System.out.println("\nplayer");
		player.printDeck();
		System.out.println("\ndealer");
		dealer.printDeck();
	}
}
