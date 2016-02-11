
public class Hand extends Deck {

	public Hand(){
		// constructor does nothing at this point besides call the super's constructor
	}
	
	public void createHand(int numCardsInHand, Deck d) {
		for (int j=0;j<numCardsInHand;j++) {
			this.cards.add(d.cards.get(0));
			d.cards.remove(0);
		}
	}
}
