import java.util.Scanner;

public class Connect4Game {
	
	public static final int HUMAN_PLAYER = 0;
	public static final int CPU_PLAYER = 1;
	public static final int PLAYER_ONE = 1;
	public static final int PLAYER_TWO = 2;

	public static void main(String[] args) {
		
		ConnectPlayer playerOne;
		ConnectPlayer playerTwo;
		int playerTurn = PLAYER_ONE;
		
		Scanner input = new Scanner(System.in);
		
		int playerOneType = playerType(input, PLAYER_ONE);
		if (playerOneType == HUMAN_PLAYER) {
			playerOne = new C4HumanPlayer(PLAYER_ONE);
		}
		else {
			playerOne = new C4RandomAIPlayer(PLAYER_ONE);
		}
		
		int playerTwoType = playerType(input, PLAYER_TWO);
		if (playerTwoType == HUMAN_PLAYER) {
			playerTwo = new C4HumanPlayer(PLAYER_TWO);
		}
		else {
			playerTwo = new C4RandomAIPlayer(PLAYER_TWO);
		}
		
		Connect4Grid2DArray grid = new Connect4Grid2DArray();
		
		boolean userQuit = false;
		while (!userQuit) {
			grid.emptyGrid();
			boolean gameOver = false;
			while (!grid.isGridFull() && !gameOver) {
				if (playerTurn == PLAYER_ONE) {
					gameOver = playerAction (playerOne, grid);
					playerTurn = PLAYER_TWO;
				}
				
				else {
					gameOver = playerAction (playerTwo, grid);
					playerTurn = PLAYER_ONE;
				}
			}
			System.out.println("Would you like to play another game? Please input yes or no.");
			boolean answered = false;
			while (!answered) {
				if (input.hasNext()) {
					String answer = input.next();
					if (answer.equalsIgnoreCase("Yes")) {
						answered = true;
						System.out.println("A new game will begin.");
					}
					
					else if (answer.equalsIgnoreCase("No")) {
						answered = true;
						userQuit = true;
						System.out.println("This game has now ended.");
					}
					
					else {
						System.out.println("You must enter yes or no.");
					}
				}
			}
			
		}
		
	}
	
	public static boolean playerAction (ConnectPlayer player, Connect4Grid2DArray grid) {
		playerMoves (player, grid);
		System.out.println(grid.toString());
		if (grid.didLastPieceConnect4()) {
			System.out.println("Player " + player.playerNumber + " has won this game of Connect Four");
			player.playerWins();
			return true;
		}
		
		else {
			return false;
		}
	}
	
	public static void playerMoves (ConnectPlayer player, Connect4Grid2DArray grid) {
		
		boolean moveMade = false;
		
		while (!moveMade) {
			int columnSelected = player.selectColumn();
			if (grid.isValidColumn(columnSelected)) {
				if (!grid.isColumnFull(columnSelected)) {
					grid.dropPiece(player, columnSelected);
					moveMade = true;
				}
				
				else {
					System.out.println("Unfortunately, this column is full");
				}
			}
			
			else {
				System.out.println("You must input a valid column (0-5)");
			}
		}
	}
	
	public static int playerType (Scanner input, int playerNumber) {
		String inputtedType;
		
		System.out.print("Would you like player " + playerNumber + " to be Human or CPU? ");
		while (true) {
			if (input.hasNext()) {
				inputtedType = input.next();
				if (inputtedType.equalsIgnoreCase("Human")) {
					return HUMAN_PLAYER;
				}
				
				else if (inputtedType.equalsIgnoreCase("CPU")) {
					return CPU_PLAYER;
				}
				
				else {
					System.out.println("You must enter either Human or CPU!");
				}
			}
		}
	}

}
