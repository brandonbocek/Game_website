public class Board{
	
	final int ROWS=11;
	final int COLUMNS=11;
	public String[][] grid = new String[ROWS][COLUMNS];
	Ship carrier, battleship, submarine, destroyer, patrol;
	
	//the constructor sets the lengths automatically
	public Board(){
		carrier = new Ship(5);
		battleship = new Ship(4);
		submarine = new Ship(3);
		destroyer = new Ship(3);
		patrol = new Ship(2);
	}
	
	//getters for the ships
	public Ship getCarrier(){return carrier;}
	public Ship getBattleship(){return battleship;}
	public Ship getSubmarine(){ return submarine; }
	public Ship getDestroyer(){ return destroyer; }
	public Ship getPatrol(){ return patrol; }
	
	public int getRows(){
		return ROWS;
	}
	public int getColumns(){
		return COLUMNS;
	}
	//set an individual square on the board's grid
	public void setSquare(int row, int column, String value){
		grid[row][column] = value;
	}
	
	//get the game board's String array
	public String[][] getBoard(){
		return grid;
	}
	
}