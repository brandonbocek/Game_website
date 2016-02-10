
public class Test {

	public static void main(String[] args) {
		
		int selection = 1;
		
		switch (selection) {
		case 1:
			War warGame = new War();
			warGame.playWarGame();
			break;
		case 2:
			BlackJack blackJack = new BlackJack();
			blackJack.playBlackJack();
			break;
		}
		
	}

}
