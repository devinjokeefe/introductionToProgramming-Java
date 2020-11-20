import java.util.Map;
import java.util.HashMap;


public class TwelveDaysOfChristmas {
	
	public static final String STATEMENT_START = "On the ";
	public static final String STATEMENT_END = " day of Christmas my true love sent to me: ";
	public static final int NUM_DAYS = 12;
	public static final int DAY_ONE = 1;
	
	public static final String GIFT_ONE = "a Partridge in a Pear Tree \n";
	public static final String GIFT_TWO = "2 Turtle doves \nand ";
	public static final String GIFT_THREE = "3 French hens, \n";
	public static final String GIFT_FOUR = "4 Calling birds, \n";
	public static final String GIFT_FIVE = "5 Golden rings, \n";
	public static final String GIFT_SIX = "6 Geese a-laying, \n";
	public static final String GIFT_SEVEN = "7 Swans a-swimming, \n";
	public static final String GIFT_EIGHT = "8 Maids a-milking, \n";
	public static final String GIFT_NINE = "9 Ladies dancing, \n";
	public static final String GIFT_TEN = "10 Lords a-leaping, \n";
	public static final String GIFT_ELEVEN = "11 Pipers piping, \n";
	public static final String GIFT_TWELVE = "12 Drummers drumming, \n";
			
	public static void main(String[] args) {

		String dayString = "";
		
		String [] giftsDict = {GIFT_ONE, GIFT_TWO, GIFT_THREE, GIFT_FOUR, GIFT_FIVE, GIFT_SIX, GIFT_SEVEN, GIFT_EIGHT, GIFT_NINE, GIFT_TEN, GIFT_ELEVEN, GIFT_TWELVE}; 
		
		for (int day = DAY_ONE; day <= NUM_DAYS; day ++) {
			
			switch (day) {
			
			case 1: 
					dayString = "first";
					break;
			case 2: 
					dayString = "second";
					break;
				
			case 3: 
					dayString = "third";
					break;
				
			case 4: 
					dayString = "fourth";
					break;
				
			case 5: 
					dayString = "fifth";
					break;
				
			case 6: 
					dayString = "sixth";
					break;
				
			case 7: 
					dayString = "seventh";
					break;
				
			case 8: 
					dayString = "eight";
					break;
				
			case 9: 
					dayString = "ninth";
					break;
				
			case 10: 
					dayString = "tenth";
					break;
				
			case 11: 
					dayString = "eleventh";
					break;
				
			case 12: 
					dayString = "twelfth";
					break;
			}
			
			System.out.println(STATEMENT_START + dayString + STATEMENT_END);
			
			for (int currentGift = day; currentGift >= DAY_ONE; currentGift --) {
				System.out.print(giftsDict[currentGift-1]);
			}
		}
		
	}

}
