import java.util.Scanner;

public class disposableIncome {

	public static final double TAX_RATE = 0.35;
	
	public static void main(String[] args) {
		
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

	}

}
