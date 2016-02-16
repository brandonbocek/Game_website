
public class Ship{

	private int startRow;
	private int startColumn;
	private int length;
	private char orient;
	private String[][] grid;
	
	//constructor for a ship with its length built into it
	public Ship(int length){
		this.length=length;
	}
	
	//returns true if the ship is successfully placed on the board
	public boolean setShip(int startRow, int startColumn, char orient, String[][] grid) {
		this.startRow=startRow;
		this.startColumn=startColumn;
		this.orient=orient;
		this.grid=grid;
		
		//placing the ships if they can be placed
		if(shipCanBePlaced() &&  orient=='H'){
			for(int i=0; i<length; i++){
				grid[startRow][startColumn + i] = "| @";
			}
			return true;
		}else if(shipCanBePlaced() &&  orient=='V'){
			for(int i=0; i<length; i++){
				grid[startRow+i][startColumn] = "| @";
			}
			return true;
		}else{
			return false;
		}
	}
	//making sure that the ship can fit on the board
	private boolean shipCanBePlaced(){
		if(startRow<1 || startRow>11)
			return false;
		if(startColumn<1 || startColumn>11)
			return false;
		if(orient=='V' && (startRow+length)>11)
			return false;
		if(orient=='H' && (startColumn+length)>11)
			return false;
		if(shipWillOverlap()){
			return false;
		}
		return true;
	}
	//making sure the ship won't overlap another ship when it's set
	private boolean shipWillOverlap(){
		if(orient=='H'){
			for(int i=0; i<length; i++){
				if(grid[startRow][startColumn+i].equals("| @")){
					return true;
				}
			}
		}else if(orient=='V'){
			for(int i=0; i<length; i++){
				if(grid[startRow+i][startColumn].equals("| @")){
					return true;
				}
			}
		}
		return false;
	}
	
}
