public class Connect4Grid2DArray implements Connect4Grid{

	public int[][] grid = new int [NUM_COLUMNS][NUM_ROWS];
	int lastDropColumn = 0;
	int lastDropRow = 0;
	
	@Override
	public void emptyGrid() {
		for (int j = 0; j < NUM_ROWS; j++) {
			for (int i = 0; i < NUM_COLUMNS; i++) {
				grid[i][j] = 0;
			}
		}
	}

	@Override
	public String toString() {
		String gridText = "|";
		for (int j = 0; j < NUM_ROWS; j++) {
			for (int i = 0; i < NUM_COLUMNS; i ++) {
				gridText += grid[i][j] + "|";
			}
			gridText += "\n|";
		}
		return gridText.substring(0, gridText.length()-1);
	}
	
	@Override
	public boolean isValidColumn(int column) {
		if (column >= 0 && column < NUM_ROWS) {
			return true;
		}
		
		return false;
	}

	@Override
	public boolean isColumnFull(int column) {
		for (int i = 0; i < NUM_COLUMNS; i++) {
			if (grid[column][i] == 0) {
				return false;
			}
		}
		
		return true;
	}

	@Override
	public void dropPiece(ConnectPlayer player, int column) {
		boolean pieceDropped = false;
		int i = NUM_ROWS-1;
		
		while (!pieceDropped && i >= 0) {
			if (grid[column][i] == 0) {
				grid[column][i] = player.playerNumber;
				lastDropColumn = column;
				lastDropRow = i;
				pieceDropped = true;
			}
			i--;
		}
	}

	@Override
	public boolean didLastPieceConnect4() {

		if (lastDropRow <= 3) {
			if (checkConnectFour (1, 0)) return true;
			
			if (lastDropColumn <= 2) {
				if (checkConnectFour (1, 1)) return true;
				
				if (checkConnectFour (0, 1)) return true;
			}
			
			if (lastDropColumn >= 3) {
				if (checkConnectFour (1, -1)) return true;
				
				if (checkConnectFour (0, -1)) return true;
			}
		}
		
		if (lastDropRow >= 3) {
			if (checkConnectFour (-1, 0)) return true;

			if (lastDropColumn <= 2) {
				if (checkConnectFour (-1, 1)) return true;
				
				if (checkConnectFour (0, 1)) return true;
			}
			
			if (lastDropColumn >= 3) {
				if (checkConnectFour (-1, -1)) return true;
				
				if (checkConnectFour (0, -1)) return true;
			}
		}
		
		return false;
	}
	
	public boolean checkConnectFour (int rowMultiple, int columnMultiple) {
		
		for (int i = 1; i <= 3; i ++) {
			if (grid[lastDropColumn][lastDropRow] != grid[lastDropColumn + i * columnMultiple][lastDropRow + i * rowMultiple]) {
				return false;
			}
		}
		
		return true;
	}

	@Override
	public boolean isGridFull() {
		for (int j = 0; j < NUM_ROWS; j++) {
			for (int i = 0; i < NUM_COLUMNS; i++) {
				if (grid[i][j] == 0) return false;
			}
		}
		return true;
	}
	
}
