

public class Card {
	public String suit;
	private int rank;
	
	// constructor
	public Card(String suit, int rank) {
		this.suit = suit;
		this.rank = rank;	
	}
	
	// getter for rank enum
	public String getRankText() {
		return RankEnum.values()[this.rank].name();
	}
	
	public int getRankValue() {
		return rank;
	}
	// we dont need this
	//public String getSuitText() {
	//	return SuitEnum.values()[this.suit].name();
	//}
}