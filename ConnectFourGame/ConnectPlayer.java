abstract class ConnectPlayer {

	public int columnSelected;
	public int playerNumber;
	public int numWins;
	
	public abstract int selectColumn ();

	public void playerWins() {
		numWins ++;
		System.out.println("Player " + playerNumber + " has won " + numWins + " games of Connect Four.");
	}
}
