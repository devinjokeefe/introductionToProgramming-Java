import java.util.Scanner;

public class NoughtsAndCrosses {

	public static final char BLANK = ' ';
	public static final char NOUGHT = 'O';
	public static final char CROSS = 'X';
	public static final int BOARD_SIZE = 3;
	
	public static void main(String[] args) {
		
		char[][] board = new char[BOARD_SIZE][BOARD_SIZE];
		clearBoard( board );
		char currentPlayerPiece = CROSS;
		Scanner input = new Scanner(System.in);
		
		while ((!isBoardFull(board)) && (winner(board) == BLANK)) {
			printBoard(board);
			int row=-1;
			int column=-1;
			
			do {
				System.out.print("Enter move for " + currentPlayerPiece + ": ");
				char[] inputCharacters = input.next().toCharArray();
				if ((inputCharacters.length >= 2) &&
					(inputCharacters[0] >= 'A') && (inputCharacters[0] <= 'C') &&
					(inputCharacters[1] >= '1') && (inputCharacters[1] <= '3')) {
						row = (int) (inputCharacters[0]-'A');
						column = (int) (inputCharacters[1]-'1');
						
						if (!canMakeMove(board,row,column)) System.out.println(" Invalid entry. This location is already occupied.");
				}
	 
				else System.out.println(" Invalid entry. You must enter a row and column (e.g. B2 is the center piece on the board).");
			} while ((row == -1) || (!canMakeMove(board,row,column)));
	 
			makeMove(board,currentPlayerPiece,row,column);
			currentPlayerPiece = (currentPlayerPiece==CROSS)?NOUGHT:CROSS;
		}
	
	printBoard(board);
	
	if (winner(board) == BLANK) System.out.println("It was a draw.");
	else System.out.println("The winner was " + winner(board));
	
	input.close();
	
	}
	
	public static final char[] LETTER_INDEXES = {'A', 'B', 'C'};
	public static final String NEW_ROW_SEPARATOR = "   ---|---|---";
	public static final String BOTTOM_ROW = "      1   2  3";
	public static final int MIDDLE_LOCATION = 1;
	
	public static char[][] clearBoard (char[][] board) {
		for (int i = 0; i < BOARD_SIZE; i ++) {
			for (int j = 0; j < BOARD_SIZE; j ++) {
				board[i][j] = BLANK;
			}
		}
		
		return board;
	}
	
	public static void printBoard (char[][] board) {
		for (int i = 0; i < BOARD_SIZE; i ++) {
			
			System.out.print(LETTER_INDEXES[i]);
			
			for (int j = 0; j < BOARD_SIZE; j ++) {
				System.out.print("  ");
				if (board[i][j] != BLANK) System.out.print(board[i][j]);
				else System.out.print(" ");
				System.out.print("  ");
			}
			System.out.println();
			System.out.println(NEW_ROW_SEPARATOR);
		}
		System.out.println(BOTTOM_ROW);
	}
	
	public static boolean canMakeMove (char[][] board, int row, int column) {
		if (board[row][column] != (BLANK)) return false;
		
		return true;
	}
	
	public static void makeMove (char[][] board, char currentPlayerPiece, int row, int column) {
		System.out.println("ROW: " + row);
		System.out.println("Column: " + column);
		board[row][column] = currentPlayerPiece;
	}
	
	public static boolean isBoardFull (char [][] board) {
		boolean boardIsFull = true;
		
		for (int i = 0; i < BOARD_SIZE; i ++) {
			for (int j = 0; j < BOARD_SIZE; j ++) {
				if (board[i][j] == BLANK) boardIsFull = false;
			}
		}
		
		return boardIsFull;
	}
	
	public static char winner (char[][] board) {
		for (int i = 0; i < BOARD_SIZE; i ++) {
			for (int j = 0; j < BOARD_SIZE; j ++) {
				
				if (i == MIDDLE_LOCATION) {
					if (board[i][j] == board[i-1][j] && board[i][j] == board[i+1][j]) return board[i][j];
					
					if (j == MIDDLE_LOCATION) {
						if (board[i][j] == board[i-1][j-1] && board[i][j] == board[i+1][j+1]) return board[i][j];
						if (board[i][j] == board[i-1][j+1] && board[i][j] == board[i+1][j-1]) return board[i][j];
					}
				}
				
				if (j == MIDDLE_LOCATION) {
					if (board[i][j] == board[i][j-1] && board[i][j] == board[i][j+1]) return board[i][j];
				}
				
			}
		}
		
		return BLANK;
	}

}

