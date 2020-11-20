import java.lang.Math;
import java.util.Scanner;

public class SieveOfEratosthenes {
	
	public static final int MINIMUM_VALUE = 2;
	public static final int SKIP_FIRST_VALUE = 2;
	public static final int NUM_END_CHARACTERS = 2;
	
	public static int[][] createSequence (int N) {
		
		if (N == 0) {
			N = MINIMUM_VALUE;
		}
		
		int [][] seq = new int[N-1][2];
		for (int i = 0; i < N-1; i++) {
			seq[i][0] = i+2;
			seq[i][1] = 1;
		}
		return seq;
	}
	
	public static int[][] crossOutHigherMultiples (int[][] delta, int multiple) {
		if (delta != null && multiple >= MINIMUM_VALUE && multiple <= delta.length) {
			int firstVal = multiple * SKIP_FIRST_VALUE;
			
			for (int i = firstVal-MINIMUM_VALUE; i < delta.length; i+= multiple) {
				delta[i][1] = 0;
			}
			
			System.out.println(sequenceToString(delta));

			return delta;
		}
		
		else {
			System.out.println("An error has occured.");
			return null;
		}
		
	}

	public static int[][] sieve (int N) {
		int[][] sequence = createSequence (N);
		for (int i = MINIMUM_VALUE; i <= Math.sqrt(N); i++) {
			sequence = crossOutHigherMultiples (sequence, i);
		}
		return sequence;
	}
	
	public static String sequenceToString (int[][] sequence) {
		if (sequence != null) {
			String strSeq = "";
			
			for (int i = 0; i < sequence.length; i++) {
				if (sequence[i][1] == 0) {
					strSeq += "[" + sequence[i][0] + "], ";
				}
				
				else {
					strSeq += sequence[i][0] + ", ";
				}	
			}
			
			strSeq = strSeq.substring(0, strSeq.length() - NUM_END_CHARACTERS);
			return strSeq;
		}
		
		else {
			System.out.println("An error has occured.");
			return null;
		}
	}
	
	public static String nonCrossedOutSubseqToString (int[][] sequence) {
		
		if (sequence != null) {
			String strSeq = "";
			
			for (int i = 0; i < sequence.length; i++) {
				if (sequence[i][1] == 1) {
					strSeq += sequence[i][0] + ", ";
				}	
			}
			
			strSeq = strSeq.substring(0, strSeq.length() - NUM_END_CHARACTERS);
			return strSeq;
		}
			
		else {
			System.out.println("An error has occured.");
			return null;
		}
	}
	
	public static void main(String[] args) {
			
		int inputN;
		
		while (true) {
			Scanner input = new Scanner(System.in);
			System.out.print("Enter int >= 2 : ");

			if (input.hasNextInt()) {
				inputN = input.nextInt();
				if (inputN >= 2) {
					int[][] seq = sieve(inputN);
					System.out.println(nonCrossedOutSubseqToString(seq));
				}
				
				else {
					System.out.println("You must enter an integer greater than 2.");
				}
			}
				
			else {
				System.out.println("You appear to have entered invalid input, please input again.");
			}
		}
	}

}
