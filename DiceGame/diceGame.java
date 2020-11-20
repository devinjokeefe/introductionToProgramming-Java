import java.util.Arrays;
import java.util.Scanner;

import Dice.Dice;
import Wallet.Wallet;

public class diceGame {
	
	public static final int NUM_DICES = 3;
	public static final int NUM_DICE_SIDES = 6;
	public static final String MONEY_GAINED = "Congratulations! You won a total of $";
	public static final String MONEY_LOST = "Sorry... You lost a total of $";
	public static int TRIPLE_ODDS = 30;
	public static final int NORMAL_ODDS = 1;
	
	public static void mainline() {
		
		double initCash = 0.0;
		Wallet myWallet = new Wallet();
		String[] acceptableBetTypes = {"Triple", "Field", "High", "Low", "triple", "field", "high", "low"};
		boolean playerQuits = false;
		
		while (initCash == 0.0) {
			Scanner input = new Scanner(System.in);
			System.out.print("How much cash do you have? ");
			if (input.hasNextDouble()) {
				initCash = input.nextDouble();
				if (initCash > 0) {
					myWallet.put(initCash);
				}
				
				else {
					System.out.println("You must enter a positive cash value");
					initCash = 0.0;
				}
			}
			
			else {
				System.out.println("You must enter a valid input");
			}
		}
		
		while (myWallet.check() > 0 && !playerQuits) {
			Scanner input = new Scanner(System.in);
			System.out.print("Type in the bet type you would like to make, or type quit to leave the game. ");
			
			if (input.hasNext()){
				String betType = input.next();
				if (Arrays.stream(acceptableBetTypes).anyMatch(betType::equals)) {
					ResolveBet (betType, myWallet);
				}
				
				else if (betType.equals("quit")) {
					gameOverMessage(initCash, myWallet.check());
					playerQuits = true;
				}
				
				else {
					System.out.println("Your bet must be Triple, Field, High or Low");
				}
			}
			
			else {
				System.out.println("You must enter a valid input");
			}
		}
		
		if (!playerQuits) {
			System.out.println("Unfortunately, you have run out of money!");
			gameOverMessage(initCash, myWallet.check());
		}
	}
	
	public static void ResolveBet (String betType, Wallet myWallet) {
		System.out.println("You have €" + myWallet.check() + " in your wallet.");
		double amountToBet = 0.0;
		
		Dice[] dices = new Dice[NUM_DICES];
		int[] rollResults = new int[NUM_DICES];
		
		for (int i = 0; i < NUM_DICES; i++) {
			dices[i] = new Dice(NUM_DICE_SIDES);	
		}
		
		while (amountToBet == 0.0) {
			Scanner input = new Scanner(System.in);
			System.out.print("How much would you like to bet?");
			if (input.hasNextDouble()) {
				amountToBet = input.nextDouble();
				if (amountToBet <= 0) {
					System.out.println("You must enter a positive cash value.");
					amountToBet = 0;
				}
				
				else if (!myWallet.get(amountToBet)) {
					System.out.println("You have insufficient funds to bet this amount.");
					amountToBet = 0;
				}
				
				else {
					
					String rollString = "The dices rolled were ";
					for (int i = 0; i < NUM_DICES; i++) {
						rollResults[i] = dices[i].roll();
						rollString += rollResults[i] + ", ";
					}
					
					rollString.substring(0, rollString.length()-2);
					System.out.println(rollString);
					
					if (betWon(betType, rollResults)) {
						System.out.println("Congratulations, you won the bet!");
						if (betType == "Triple") myWallet.put(amountToBet*TRIPLE_ODDS);
						else myWallet.put(amountToBet*NORMAL_ODDS);
						
						myWallet.put(amountToBet);
					}
					
					else {
						System.out.println("Unfortunately, you lost the bet!");
					}
				}
			}
			
			else {
				System.out.println("Please enter a valid input");
			}
		}	
	}
	
	public static boolean betWon (String betType, int[] diceResults) {
		int diceTotal;
		
		if (betType.equalsIgnoreCase("Triple")) {
			if (diceResults[0] == diceResults[1] && diceResults[1] == diceResults[2]) return true;
			else return false;
		}
		
		else {
			diceTotal = diceResults[0] + diceResults[1] + diceResults[2];
			
			if (betType.equalsIgnoreCase("Field")) {
				if (diceTotal < 8 || diceTotal > 12) return true;
				else return false;
			}
			
			else if (betType.equalsIgnoreCase("High")) {
				if (diceTotal > 10 && !betWon("Triple", diceResults)) return true;
				else return false;
			}
			
			else if (betType.equalsIgnoreCase("Low")) {
				if (diceTotal < 11 && !betWon("Triple", diceResults)) return true;
				else return false;
			}
			
			else {
				return false;
			}
		}
	}
	
	public static void gameOverMessage (double initCash, double d) {
		System.out.println("You started with €" + initCash);
		System.out.println("You finished with €" + d);
		System.out.println((initCash < d) ? MONEY_GAINED + (d - initCash) : MONEY_LOST + (initCash - d));
	}

	public static void main(String[] args) {
		mainline();
	}

}
