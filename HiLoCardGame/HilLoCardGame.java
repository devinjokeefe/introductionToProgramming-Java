import java.util.Scanner;
import java.util.Random;
import java.util.Map;
import java.util.HashMap;

public class HiLoCardGame {

public static final int GAMES_TO_WIN = 4;
public static final int NUM_POSSIBLE_VALUES = 13;
public static final int MIN_VALUE = 2;
public static final int HIGHER = 2;
public static final int LOWER = 0;
public static final int EQUAL = 1;
public static final String CARD_DEC = "The card is a "; 
public static final String QUESTION = "Do you think the next card will be higher, lower or equal?"; 

  public static void main(String[] args) {

    Map<Integer, String> cardDict = new HashMap<Integer, String> ();
    cardDict.put(11, "Jack");
    cardDict.put(12, "Queen");
    cardDict.put(13, "King");
    cardDict.put(14, "Ace");

    int gamesWon = 0;
    Scanner input = new Scanner(System.in);

    Random generator = new Random();
    int currentCard = generator.nextInt(NUM_POSSIBLE_VALUES) + MIN_VALUE;
    int newCard = 0;

    String response = "";
    int respInt = 0;

    int correctResponse = 0;

    while (gamesWon < GAMES_TO_WIN) {

      if (currentCard > 10) {
        System.out.println(CARD_DEC + cardDict.get(currentCard));
      }

      else {
        System.out.println(CARD_DEC + currentCard);
      }

      System.out.println(QUESTION);
      response = input.next();
      
      if (response.toLowerCase().equals("higher")) {
        respInt = HIGHER;
      }

      else if (response.toLowerCase().equals("lower")) {
        respInt = LOWER;
      }

      else if (response.toLowerCase().equals("equal")) {
        respInt = EQUAL;
      }

      else {
        System.out.println("You appear to have entered an incorrect value. Try again.");
        continue;
      }

      newCard = generator.nextInt(NUM_POSSIBLE_VALUES) + MIN_VALUE;

      if (newCard > currentCard) {
        correctResponse = HIGHER;
      }

      else if (newCard < currentCard) {
        correctResponse = LOWER;
      }

      else {
        correctResponse = EQUAL;
      }

      if (correctResponse == respInt) {
        gamesWon ++;
      }

      else {
        gamesWon = 0;
        System.out.println("Unfortunately, you guessed wrong. You must guess correctly four times in a row to win.");
      }

      currentCard = newCard;

    }

    System.out.println("Congratulations! You correctly guessed 4 in a row.");
    
  }
}
