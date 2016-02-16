import java.util.Scanner;

public class BattleshipView {

	Scanner input = new Scanner(System.in);
	
	public void showTheBoard(String[][] theGrid){
		System.out.println("__________________________________\n");
		for(int i=0; i<11; i++){
			for(int j=0; j<11; j++){
				System.out.print(theGrid[i][j]);
			}
			System.out.println();
		}
		System.out.println("__________________________________\n");
	}
	
	//this should later be changed so that the user enters a char for the row
	public String getShipPlacement(int length){
		System.out.println("Please enter your row, column, and orienation for a ship of size "+length);
		System.out.println("Example would be (4 1 H) or (8 10 V): ");
		return input.nextLine();
	}
}
