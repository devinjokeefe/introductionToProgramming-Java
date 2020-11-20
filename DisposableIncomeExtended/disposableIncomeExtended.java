import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class disposableIncomeExtended {

	public static final double TAX_RATE = 0.35;
	public static final double MUCH_GREATER_THAN_AVERAGE_THRESHOLD = 750.0;
	public static final double AVERAGE_THRESHOLD = 500.0;
	public static final double MUCH_LESS_THAN_AVERAGE_THRESHOLD = 250.0;
	
	
	public static void main(String[] args) {
		
		Map<Integer, String> incomeThresholds = new HashMap<Integer, String> ();
		incomeThresholds.put(0, "no");
		incomeThresholds.put(1, "much less than average");
		incomeThresholds.put(2, "less than average");
		incomeThresholds.put(3, "exactly the average");
		incomeThresholds.put(4, "more than average");
		incomeThresholds.put(5, "much more than average");
		
		int incomeBracket = 0;
		
		System.out.println("How much are you paid a month before tax?");
		Scanner input = new Scanner(System.in);
		double incomeUntaxed = input.nextDouble();
		
		System.out.println("How much do you pay in rent/mortgage a month?");
		double rentCost = input.nextDouble();
		
		System.out.println("How much does your commute cost a month?");
		double commuteCost = input.nextDouble();
		
		System.out.println("How much do you spend on food per month?");
		double foodCost = input.nextDouble();
		
		double taxPaid = incomeUntaxed * TAX_RATE;
		
		double netIncome = incomeUntaxed - taxPaid;
		
		double disposableMoney = netIncome - rentCost - commuteCost - foodCost;
		
		double disposablePercentage = (disposableMoney / incomeUntaxed) * 100;
		int disposablePercentageRounded = (int) Math.round(disposablePercentage);
		
		System.out.println("Your monthly disposable income is €" + disposableMoney + " which is " + disposablePercentageRounded + "% of your salary.");
		
		if (disposableMoney == 0) {
			incomeBracket = 0;
		}
		
		else if (disposableMoney < MUCH_LESS_THAN_AVERAGE_THRESHOLD) {
			incomeBracket = 1;
		}
		
		else if (disposableMoney < AVERAGE_THRESHOLD) {
			incomeBracket = 2;
		}
		
		else if (disposableMoney == AVERAGE_THRESHOLD) {
			incomeBracket = 3;
		}
		
		else if (disposableMoney < MUCH_GREATER_THAN_AVERAGE_THRESHOLD) {
			incomeBracket = 4;
		}
		
		else {
			incomeBracket = 5;
		}
		
		System.out.println("You have " + incomeThresholds.get(incomeBracket) + " amount of disposable income");
	}

}
