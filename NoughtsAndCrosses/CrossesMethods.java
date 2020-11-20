public class CrossesMethods {

	public static final char[] LETTER_INDEXES = {'A', 'B', 'C'};
	public static final String NEW_ROW_SEPARATOR = "---|---|---";
	public static final String BOTTOM_ROW = "   1    2    3";
	public static final char BLANK = ' ';
	
	public char[][] clearBoard (char[][] board) {
		for (int i = 0; i < board[0].length; i ++) {
			for (int j = 0; j < board[1].length; j ++) {
				board[i][j] = BLANK;
			}
		}
		
		return board;
	}
	
	public void printBoard (char[][] board) {
		for (int i = 0; i < board[0].length; i ++) {
			
			System.out.println(LETTER_INDEXES[i]);
			
			for (int j = 0; j < board[1].length; j ++) {
				System.out.print(board[i][j]);
				if (j < board[i].length - 1) System.out.print("|");
			}
			
			System.out.println(NEW_ROW_SEPARATOR);
		}
		System.out.println(BOTTOM_ROW);
	}
	
	public boolean canMakeMove (char[][] board, int row, int column) {
		if (row >= board[0].length || row < 0) return false;
		if (column >= board[1].length || column < 0) return false;
		
		for (int i = 0; i < board[0].length; i ++) {
			for (int j = 0; j < board[1].length; j ++) {
				if (board[i][j] != (BLANK)) return false;
			}
		}
		
		return true;
	}
	
	public void makeMove (char[][] board, char currentPlayerPiece, int row, int column) {
		board[row][column] = currentPlayerPiece;
	}
	
	public boolean isBoardFull (char [][] board) {
		boolean boardIsFull = true;
		
		for (int i = 0; i < board[0].length; i ++) {
			for (int j = 0; j < board[1].length; j ++) {
				if (board[i][j] == BLANK) boardIsFull = false;
			}
		}
		
		return boardIsFull;
	}
	
	public char winner (char[][] board) {
		for (int i = 0; i < board[0].length; i ++) {
			for (int j = 0; j < board[1].length; j ++) {
				if (board[i][j] == board[i-1][j] && board[i][j] == board[i+1][j]) return board[i][j];
				if (board[i][j] == board[i][j-1] && board[i][j] == board[i][j+1]) return board[i][j];
				if (board[i][j] == board[i-1][j-1] && board[i][j] == board[i+1][j+1]) return board[i][j];
				if (board[i][j] == board[i-1][j+1] && board[i][j] == board[i+1][j-1]) return board[i][j];
			}
		}
		
		return BLANK;
	}

}
