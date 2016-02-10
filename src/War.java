
public class War {
	public Deck warDeck;
	public Hand hand1, hand2;
	public Table table;
	
	public War() {
		warDeck = new Deck();
		warDeck.createFullDeck();
		warDeck.shuffleDeck();

		int handSize = 26;
		hand1 = new Hand();
		hand1.createHand(handSize, warDeck);

		hand2 = new Hand();
		hand2.createHand(handSize, warDeck);
		
		table = new Table();
		
		
	}
	
	public void playWarGame() {
		
		// prints out the deck, and each hand for debugging purposes
		this.warDeck.printDeck();
		System.out.println("\nplayer 1");
		this.hand1.printDeck();
		System.out.println("\nplayer 2");
		this.hand2.printDeck();
		
		
		boolean resultIsWar;		
		while (hand1.cards.size()>0 && hand2.cards.size()>0) {			
			resultIsWar = haveBattle();			// true (battle has resulted in war), false (battle had a winner)
			while (resultIsWar) {				
				resultIsWar = haveWar();		// true (war has resulted in war), false (war had a winner)
			}
		}	
		// game over
		if (hand1.cards.size()>0) {
			System.out.println("player 2 won");
		} else {
			System.out.println("player 1 won");
		}
		
	}
	
	public boolean haveBattle(){
		int battleWinner = playBattleCardsToTable();
		switch (battleWinner) {
			case 1:
				takeTableCards(hand1);						// P1 wins
				return false;
			case 2:
				takeTableCards(hand2);					// P2 wins
				return false;
			default:									// WAR (battle was a draw)
				return true;	// this return value tells the program to initiate a war	
		}
	}
	
	public int playBattleCardsToTable() {
		table.cards.add(hand1.cards.get(0));	// put player 1's top card on the table
		table.cards.add(hand2.cards.get(0));	// put player 2's top card on the table
		hand1.cards.remove(0);			// remove player 1's card from hand 
		hand2.cards.remove(0);			// remove player 2's card from hand
		
		// TO DO LATER make cards appear on table
		// remove cards from players hand (if last card)
		
		// returns 1 if player 1 wins the battle, 2 if player 2 wins, 3 if its a tie
		return table.cards.get(0).getRankValue() > table.cards.get(1).getRankValue() ? 1 : 
			table.cards.get(0).getRankValue() < table.cards.get(1).getRankValue() ? 2 : 3;
	}
	
	public void takeTableCards(Hand hand) {	
		table.shuffleDeck(); 							// shuffle the table cards (to better simulate real life)
		for (int counter=0; counter<table.cards.size(); counter++) {
			hand.cards.add(table.cards.get(counter));	// add the table cards to the players hand
		}
		table.cards.clear();							// now sweep off the table	
	}
	
	public boolean haveWar(){
		if (hand1.cards.size()<4 || hand2.cards.size()<4) {		// one or both players don't have enough cards to war 
			return false;
		} else {						
			int warWinner = playWarCardsToTable();				// FIGHT THE WAR HERE
			switch (warWinner) {
			case 1:
				takeTableCards(hand1);							// P1 wins
				return false;
			case 2:
				takeTableCards(hand2);					// P2 wins
				return false;										
			default:								// WAR (battle was a draw)
				return true;	// this return value tells the program to initiate another war	
			}
		}
	}
	
	public int playWarCardsToTable() {
		for (int counter=0; counter<4; counter++) {
			table.cards.add(hand1.cards.get(counter));	// put player 1's top card on the table x 4
			table.cards.add(hand2.cards.get(counter));	// put player 2's top card on the table x 4
		}
		for (int counter=3; counter>=0; counter--) {
			hand1.cards.remove(counter);			// remove player 1's card from hand x 4
			hand2.cards.remove(counter);			// remove player 2's card from hand x 4
		}
		if (table.cards.get(table.cards.size()-2).getRankValue() > table.cards.get(table.cards.size()-1).getRankValue()) {
			return 1; 								// player 1 wins war
		} else if (table.cards.get(table.cards.size()-2).getRankValue() < table.cards.get(table.cards.size()-1).getRankValue()) {
			return 2;								// player 2 wins war
		} else {
			return 0;								// war results in another war
		}
		
	}
}
