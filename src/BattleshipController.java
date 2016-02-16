
public class BattleshipController {

	private Board board;
	private BattleshipView view;
	
	public BattleshipController(Board board, BattleshipView view){
		this.board=board;
		this.view=view;
	
	}
	public Board getBoard(){
		return board;
	}
	public void setBoardSquare(int row, int column, String value){
		board.setSquare(row, column, value);
	}
	public BattleshipView getBattleshipView(){
		return view;
	}
	public String[][] getGameBoard(){
		return board.getBoard();
	}
	public void setBlankBoard(){
		setBoardSideLabels();
		for(int i=1; i<board.getRows(); i++){
			for(int j=1; j<board.getColumns(); j++){
				setBoardSquare(i, j, "|__");
			}
		}
	}
	public boolean setCarrierOnBoard(int startRow, int startCol, char orient, String[][] grid){
		return board.getCarrier().setShip(startRow, startCol, orient, grid);
	}
	public boolean setBattleshipOnBoard(int startRow, int startCol, char orient, String[][] grid){
		return board.getBattleship().setShip(startRow, startCol, orient, grid);
	}
	public boolean setSubmarineOnBoard(int startRow, int startCol, char orient, String[][] grid){
		return board.getSubmarine().setShip(startRow, startCol, orient, grid);
	}
	public boolean setDestroyerOnBoard(int startRow, int startCol, char orient, String[][] grid){
		return board.getDestroyer().setShip(startRow, startCol, orient, grid);
	}
	public boolean setPatrolOnBoard(int startRow, int startCol, char orient, String[][] grid){
		return board.getPatrol().setShip(startRow, startCol, orient, grid);
	}
	//putting all of the ships on the board and getting user input from the view
	public void setAllShipsOnBoard() {
		int f, s;
		char t;
		String str;
		String[] sr;
		//carrier
		do {
			str = view.getShipPlacement(5);
			sr = str.split(" ");
			f = Integer.parseInt(sr[0]);
			s = Integer.parseInt(sr[1]);
			t = sr[2].charAt(0);
		} while (!setCarrierOnBoard(f, s, t, getGameBoard()));
		view.showTheBoard(getGameBoard());
		//the battleship
		do {
			str = view.getShipPlacement(4);
			sr = str.split(" ");
			f = Integer.parseInt(sr[0]);
			s = Integer.parseInt(sr[1]);
			t = sr[2].charAt(0);
		} while (!setBattleshipOnBoard(f, s, t, getGameBoard()));
		view.showTheBoard(getGameBoard());
		//the submarine
		do {
			str = view.getShipPlacement(3);
			sr = str.split(" ");
			f = Integer.parseInt(sr[0]);
			s = Integer.parseInt(sr[1]);
			t = sr[2].charAt(0);
		} while (!setSubmarineOnBoard(f, s, t, getGameBoard()));
		view.showTheBoard(getGameBoard());
		//the destroyer
		do {
			str = view.getShipPlacement(3);
			sr = str.split(" ");
			f = Integer.parseInt(sr[0]);
			s = Integer.parseInt(sr[1]);
			t = sr[2].charAt(0);
		} while (!setDestroyerOnBoard(f, s, t, getGameBoard()));
		view.showTheBoard(getGameBoard());
		//the patrol ship
		do {
			str = view.getShipPlacement(2);
			sr = str.split(" ");
			f = Integer.parseInt(sr[0]);
			s = Integer.parseInt(sr[1]);
			t = sr[2].charAt(0);
		} while (!setPatrolOnBoard(f, s, t, getGameBoard()));
		view.showTheBoard(getGameBoard());

		
	}
	//setting the A-J and 1-10 labels on the side of the grid
	private void setBoardSideLabels(){
		setBoardSquare(0,0," ");
		for(int i=1; i<11; i++){
			setBoardSquare(i,0,String.valueOf(Character.toChars(i+64)));
			setBoardSquare(0, i, String.valueOf(" "+i+" "));
		}
	}
	
	public void updateView(){
		setBlankBoard();
		setAllShipsOnBoard();
		
		view.showTheBoard(this.getGameBoard());
	}
}
