import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

public class HighScores {

	public static final String HIGH_SCORES_STATEMENT = "The high scores are "; 
	
	public static void main(String[] args) {	

		Scanner input = new Scanner(System.in);
		
		System.out.println("How many scores do you want to maintain?");
		int numScores = input.nextInt();
		int [] scores = initialiseHighScores (numScores);
		while (true) {
			
			System.out.println("What is your new score");
			
			int newScore = input.nextInt();
			boolean isHighScore = higherThan(scores, newScore);
			
			if (isHighScore) {
				insertScore(scores, newScore);
			}
			
			printHighScores(scores);
			
		}
		
	}
	
	public static int [] initialiseHighScores (int numScores) {
		int[] scores = new int[numScores];
		for (int scoreIndex = 0; scoreIndex < numScores; scoreIndex ++) {
			scores[scoreIndex] = 0;
		}
		return scores;
	}
	
	public static void printHighScores (int [] scores) {
		
		String scoresStr = HIGH_SCORES_STATEMENT;
		Arrays.sort(scores);

		for (int scoreIndex = scores.length - 1; scoreIndex >= 0; scoreIndex --) {
			if (scores[scoreIndex] != 0) {
				scoresStr += String.valueOf(scores[scoreIndex]) + ", "; 
			}
		}
		
		System.out.println(scoresStr);
	}
	
	public static boolean higherThan (int [] scores, int newScore) {
		if (newScore > scores[0]) {
			return true;
		}
		
		else {
			return false;
		}
	}
	
	public static int [] insertScore (int [] scores, int newScore) {
		scores [0] = newScore;
		Arrays.sort(scores);
		return scores;
	}

}
