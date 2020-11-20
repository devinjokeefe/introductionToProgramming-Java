import java.util.Scanner;

public class C4HumanPlayer extends ConnectPlayer {

	private Scanner input = new Scanner(System.in);

	public C4HumanPlayer(int playerNumber) {
		this.playerNumber = playerNumber;
	}

	@Override
	public int selectColumn() {
		
		System.out.println("Please enter a column in which to drop your piece. This must be a number between 0 and 5.");
		int numInputted;
		
		while (true) {
			if (input.hasNextInt()) {
				numInputted = input.nextInt();
				if (numInputted >= 0 && numInputted <= 5) {
					return numInputted;					
				}
				
				else {
					System.out.println("You must enter a number between 0 and 5.");
				}
			}
			
			else {
				System.out.println("You must enter a number between 0 and 5.");
			}
		}
	}
}
