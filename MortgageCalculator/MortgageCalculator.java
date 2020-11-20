import java.util.Scanner;

public class MortgageCalculator {

	public static final double MONTHS = 12.0;
	public static final double DIVISOR_FOR_PERCENT = 100.0;
	public static final double DURATION = 20.0;
	public static final String MONTHLY_REPAYMENTS_STATEMENT = "Assuming a 20 year term, the monthly repayments would be ";
	public static final String PAYOFF_TIME_STATEMENT_START= "If you pay ";
	public static final String PAYOFF_TIME_STATEMENT_MIDDLE = " per month, your mortgage would be paid off in ";
	public static final String USE_AGAIN = "Would you like to use the mortgage calculator again (yes/no)";

	public static void main(String[] args) {
		calculations ();
	}
	
	public static void calculations () {
		Scanner input = new Scanner (System.in);
		
		System.out.println("Welcome to the mortgage calculator.");
		System.out.print("Please enter the mortgage amount: ");
			
		double principal = readDoubleFromUser (input);
			
		System.out.print("Please enter the annual interest rate (APR) : ");
			
		double APR = readDoubleFromUser (input);
		double monthlyRepayments = calculateMonthlyRepayment (principal, DURATION, APR);
			
		System.out.println(MONTHLY_REPAYMENTS_STATEMENT + monthlyRepayments);
		System.out.print("How much can you afford to pay per month? ");
			
		double paymentsPerMonth = readDoubleFromUser (input);
		int monthsOfPayment = calculateMonthsToRepayMortgage (principal, paymentsPerMonth, APR);
		int yearsToPay = Math.floorDiv(monthsOfPayment, 12);
		int monthsToPay = 0;
		
		if (yearsToPay != 0) {
			monthsToPay = monthsOfPayment % yearsToPay;
		}
		
		else {
			monthsToPay = monthsOfPayment; 
		}
		
		System.out.println(PAYOFF_TIME_STATEMENT_START + paymentsPerMonth + PAYOFF_TIME_STATEMENT_MIDDLE + yearsToPay + " years and " + monthsToPay + " months");
		System.out.println(USE_AGAIN);
		
		if (input.next().equals("yes") || input.next().equals("Yes")) {
			calculations ();
		}
		
	}

	public static double readDoubleFromUser (Scanner input) {
		if (input.hasNextDouble()) {
			return input.nextDouble();
		}

		else {
			input.nextLine();
			System.out.println("Unfortunately, this is not valid input. Please enter a valid value.");
			return readDoubleFromUser (input);
		}
	}

	public static double calculateMonthlyRepayment (double Principal, double Duration, double APR) {
		double monthlyAPR = APR/MONTHS/DIVISOR_FOR_PERCENT;
		double APRFormula = Math.pow((1 + monthlyAPR), (-1 * MONTHS * Duration));
		double monthlyRepayment = (Principal * monthlyAPR) / (1 - APRFormula);
		monthlyRepayment = Math.round(monthlyRepayment * 100.0) / 100.0;
		return monthlyRepayment;
	}

	public static int calculateMonthsToRepayMortgage (double mortgageAmount, double paymentsPerMonth, double interestRate) {
		int monthsOfPayment = 0;
		double MPR = 1 + (interestRate / MONTHS / DIVISOR_FOR_PERCENT);
		
		while (mortgageAmount > 0) {
			mortgageAmount *= MPR;
			mortgageAmount -= paymentsPerMonth;
			monthsOfPayment ++;
		}
		
		return monthsOfPayment;
	}

}
