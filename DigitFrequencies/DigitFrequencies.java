import java.util.Scanner;

public class DigitFrequencies {

	public static final int NUM_DIGITS = 10;
	public static int [] freq = new int [10];
	
	public static void main(String[] args) {

		Scanner input = new Scanner (System.in);
		while (true) {
			System.out.print("Enter a number > ");
			int number = input.nextInt();
			String numString = Integer.toString(number);
		
			for (int curLetter = 0; curLetter < numString.length(); curLetter ++) {
				int curNum = Character.getNumericValue(numString.charAt(curLetter));
				countDigitFrequencies (curNum, freq);
			}
			printDigitFrequencies (freq);
		}
	}

	public static void countDigitFrequencies (int number, int [] frequencies) {
		frequencies[number] ++;
		freq = frequencies;
	}
	
	public static void printDigitFrequencies (int [] frequencies) {
		
		String output = "Digit frequencies : ";
		
		for (int iter = 0; iter < NUM_DIGITS; iter ++) {
			if (frequencies[iter] > 0) {
				output += iter + "(" + frequencies[iter] +") ";
			}
		}
		
		System.out.println(output);
	}
	
}
