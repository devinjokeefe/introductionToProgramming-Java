import java.util.Scanner;
import java.util.Random;

public class RockPaperScissorsGame {

	public static final int GAMES_TO_PLAY = 5;
	
	public static void main(String[] args) {
		
		Random generator = new Random();
		Scanner input = new Scanner (System.in);
		
		int userWins = 0;
		int computerWins = 0;
		
		for (int gamesPlayed = 0; (gamesPlayed < GAMES_TO_PLAY); gamesPlayed ++) {
			System.out.println("Enter 1 for Rock, 2 for Paper, 3 for Scissors");
			int playerChoice = input.nextInt() - 1;
			int computerChoice = generator.nextInt(3);
			
			if (playerChoice == computerChoice) {
				
				if (playerChoice == 0) {
					System.out.println("This round was a draw, as we both chose Rock");
				}
				
				if (playerChoice == 1) {
					System.out.println("This round was a draw, as we both chose Paper");
				}
				
				if (playerChoice == 2) {
					System.out.println("This round was a draw, as we both chose Scissors");
				}
			}
			
			else if (playerChoice == 0) {
				if (computerChoice == 1) {
					System.out.println("You lost this round, as I chose Paper");
					computerWins ++;
				}
				
				else if (computerChoice == 2){
					System.out.println("You won this round as I chose Scissors");
					userWins ++;
				}
			}
			
			else if (playerChoice == 1) {
				if (computerChoice == 0) {
					System.out.println("You won this round, as I chose Rock");
					userWins ++;
				}
				
				else if (computerChoice == 2){
					System.out.println("You lost this round as I chose Scissors");
					computerWins ++;
				}
			}
			
			else if (playerChoice == 2) {
				if (computerChoice == 0) {
					System.out.println("You lost this round, as I chose Rock");
					computerWins ++;
				}
				
				else if (computerChoice == 1){
					System.out.println("You won this round as I chose Paper");
					userWins ++;
				}
			}
			
		}

		System.out.println("The final score was Computer: " + computerWins + " User: " + userWins);
		
	}

}
