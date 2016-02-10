

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	protected ArrayList<Card> cards;
	
	// constructor, creates an array list of cards 
	// is also used by child class 'hand'
	public Deck() {
		cards = new ArrayList<Card>();	
	}
	
	// create a full deck of 52 cards from the enums
	public void createFullDeck() {
		SuitEnum[] suitEnum = SuitEnum.values();
		RankEnum[] rankEnum = RankEnum.values();
		for (int i=0;i<suitEnum.length;i++) {
			for (int j=0;j<rankEnum.length;j++) {
				Card card = new Card(suitEnum[i].name(),rankEnum[j].ordinal());
				cards.add(card);
			}
		}
	}
	
	// prints the array list of cards in deck/hand to console
	public void printDeck () {
		for (int i=0;i<cards.size();i++){
			System.out.println(cards.get(i).getRankText() + " of " + cards.get(i).suit);
		}
	}
	
	// shuffles the cards in the deck/hand
	public void shuffleDeck() {
		Collections.shuffle(cards);
	}
}





