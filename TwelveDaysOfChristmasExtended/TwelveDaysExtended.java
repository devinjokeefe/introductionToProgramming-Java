public class TwelveDaysExtended {

	public static final String STATEMENT_BEGIN = "On the ";
	public static final String STATEMENT_END = " day of Christmas, my true love sent to me: \n";

	
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
		for (int iter = 1; iter <= 12; iter ++) {
			System.out.println(getVerse(iter));
		}
	}
	
	public static String getVerse (int verseNum) {
		String verse = STATEMENT_BEGIN + getOrdinalString(verseNum) + STATEMENT_END;
		for (int curVerse = verseNum; curVerse >= 1; curVerse --) {
				verse += getChristmasGift(curVerse);
		}
		return verse;
	}
	
	public static String getChristmasGift (int giftNum) {
		switch (giftNum) {
		
		case 1:
			return GIFT_ONE;
			
		case 2:
			return GIFT_TWO;
			
		case 3:
			return GIFT_THREE;
			
		case 4:
			return GIFT_FOUR;
			
		case 5:
			return GIFT_FIVE;
			
		case 6:
			return GIFT_SIX;
			
		case 7:
			return GIFT_SEVEN;
			
		case 8:
			return GIFT_EIGHT;
			
		case 9:
			return GIFT_NINE;
			
		case 10:
			return GIFT_TEN;
			
		case 11:
			return GIFT_ELEVEN;
			
		case 12:
			return GIFT_TWELVE;
		default:
			return null;
		}
	}
	
	public static String getOrdinalString (int ordinalNum) {
		if (ordinalNum == 1) {
			return "first";
		}
		
		else if (ordinalNum == 2) {
			return "second";
		}
		
		else if (ordinalNum == 3) {
			return "third";
		}
		
		else if (ordinalNum == 4) {
			return "fourth";
		}
		
		else if (ordinalNum == 5) {
			return "fifth";
		}
		
		else if (ordinalNum == 6) {
			return "sixth";
		}
		
		else if (ordinalNum == 7) {
			return "seventh";
		}
		
		else if (ordinalNum == 8) {
			return "eight";
		}
		
		else if (ordinalNum == 9) {
			return "ninth";
		}
		
		else if (ordinalNum == 10) {
			return "tenth";
		}
		
		else if (ordinalNum == 11) {
			return "eleventh";
		}
		
		else if (ordinalNum == 12) {
			return "twelfth";
		}
		
		else {
			return null;
		}
		
	}
	
}
