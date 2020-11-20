import java.util.Scanner;

public class Swap {

	private int inputOne;
	private int inputTwo;
	
	public int [] getInput (Scanner input) {
		
		int[] inputtedNumbers = new int[2];
		
		System.out.println("Enter your first number");
		inputtedNumbers[0] = input.nextInt();
		System.out.println("Enter your second number");
		inputtedNumbers[1] = input.nextInt();
		
		return inputtedNumbers;
	}
	
	public static int[] swapNumbers (int[] inputArray) {
		inputArray[0] = inputArray[0] + inputArray[1];
		inputArray[1] = inputArray[0] - inputArray[1];
		inputArray[0] = inputArray[0] - inputArray[1];
		return inputArray;
	}
	
	public static void main (String[] args) {
		
		Swap example = new Swap();
		Scanner input = new Scanner(System.in);

		int [] numbersToSwap = new int[2];
		numbersToSwap = example.getInput(input);
		numbersToSwap = example.swapNumbers(numbersToSwap);
		System.out.println(numbersToSwap[0] + ", " + numbersToSwap[1]);
	}
	
}
