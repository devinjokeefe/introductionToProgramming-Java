import java.io.*;
import java.util.*;

public class WordLinks {

	public static void main (String[] args) throws Exception {
		
		boolean userQuits = false;
		while (!userQuits) {
			ArrayList<String> inputtedWords = readWordList();
			if (inputtedWords != null) {
				if (isWordChain(inputtedWords)) System.out.println("Valid chain of words from Lewis Carroll's word-links game.");
				else System.out.println("Not a valid chain of words from Lewis Carroll's word-links game.");
			}
			
			else {
				userQuits = true;
			}
		}
	}
	
	public static ArrayList<String> readDictionary() throws Exception {
		
		ArrayList<String> words = new ArrayList<String>();
		
		FileReader fr = new FileReader("words.txt");
		BufferedReader br = new BufferedReader(fr);
		
		String line;
		
		while ((line = br.readLine()) != null) {
			words.add(line);
		}
		
		br.close();
		fr.close();
		
		return words;
	}

	public static ArrayList<String> readWordList () throws Exception {
		System.out.print("Enter a comma separated list of words (or an empty list to quit):");
		Scanner input = new Scanner(System.in);
		String acceptableInputRegex = "[A-Za-z, /,]+";
		ArrayList<String> dictionary = readDictionary();
		
		while (true) {		
			String textInputted = input.nextLine();
			
			if (textInputted.isEmpty()) {
				System.out.println("You have chosen to end this program");
				return null;
			}
			
			if (textInputted.matches(acceptableInputRegex)) {
				String exploded[] = textInputted.split(",");
				ArrayList<String> wordsList = new ArrayList<String>();
				
				for (int i = 0; i < exploded.length; i ++) {
					wordsList.add(exploded[i].replaceAll(" ", ""));
				}
				
				if (wordsList.size() <= 1) {
					System.out.println("You must enter more than one word");
				}
					
				else {
					
					if (!isUniqueList(wordsList)) System.out.println("All words entered must be unique");
					else {
						
						boolean allWordsEnglish = true;
							
						for (int i = 0; i < wordsList.size(); i ++) {
							if (!isEnglishWord(wordsList.get(i), dictionary)) allWordsEnglish = false;
						}
						
						if (allWordsEnglish) return wordsList;
						else System.out.println("All words must be English words");
					}
				}
			}
		}
	}
	
	public static boolean isUniqueList (ArrayList<String> words) {
		Set<String> wordsSet = new HashSet<>();
		
		for (int i = 0; i < words.size(); i++) {
			if (wordsSet.add(words.get(i)) == false) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean isEnglishWord (String word, ArrayList<String> wordsList) {
		if (wordsList.contains(word)) return true;
		else return false;
	}
	
	public static boolean isDifferentByOne (String wordOne, String wordTwo) {
		if (wordOne.length() != wordTwo.length()) return false;
		
		char[] wordOneChars = wordOne.toCharArray();
		char[] wordTwoChars = wordTwo.toCharArray();
		int numCharsDifferent = 0;
		
		for (int i = 0; i < wordOneChars.length; i ++) {
			if (wordOneChars[i] != wordTwoChars[i]) {
				numCharsDifferent++;
				if (numCharsDifferent > 1) return false;
			}
		}
		
		if (numCharsDifferent == 1) return true;
		else return false;
	}
	
	public static boolean isWordChain (ArrayList<String> wordsList) {
		for (int i = 0; i < wordsList.size() - 1; i ++) {
			if (!isDifferentByOne(wordsList.get(i),wordsList.get(i+1))) return false;
		}
		
		return true;
	}
}
