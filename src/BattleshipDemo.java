
public class BattleshipDemo {
	
	public static void main(String[] args){
		
		
		Board board = new Board();
		BattleshipView view = new BattleshipView();
		BattleshipController controller = new BattleshipController(board, view);
		controller.updateView();
		
		
		
	
		
	}
}
