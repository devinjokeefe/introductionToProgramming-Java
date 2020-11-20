import java.lang.Object;
import java.util.Random;
import java.util.Scanner;

public class cipher {

	public static final String ALPHABET_STRING = "abcdefghijklmnopqrstuvwxyz ";
	public static final char[] CIPHER = createCipher();
	
	public static void main(String[] args) {
		char [] cipher = createCipher();
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.print("Enter a string to be encrypted : ");
			String stringToEncrypt = input.nextLine();
			if(stringToEncrypt.matches("[\\sa-zA-z]+")) {
				String encryptedString = encrypt(stringToEncrypt);
				System.out.println("Encrypted String : " + encryptedString);
				String decryptedString = decrypt(encryptedString);
				System.out.println("Decrypted String : " + decryptedString + "\n");
			}
			
			else {
				System.out.println("You do not appear to have entered an appropriate value. Please try again!");
			}
		}
	}
	
	public static char[] createCipher () {
		char [] alphabet = ALPHABET_STRING.toCharArray();
		Random generator = new Random();
		for (int index = 0; index < alphabet.length; index ++) {
			int altIndex = generator.nextInt(alphabet.length);
			char temp = alphabet[index];
			alphabet[index] = alphabet[altIndex];
			alphabet[altIndex] = temp;
		}
		
		return alphabet;
		
	}
	
	public static String encrypt (String input) {
		char[] characterArray = input.toLowerCase().toCharArray();
		
		for (int index = 0; index < characterArray.length; index ++) {
			int correspondingIndex = (characterArray[index] >= 'a') ? characterArray[index] - 'a' : CIPHER.length - 1;
			characterArray[index] = CIPHER[correspondingIndex];
		}
		
		String encryptedString = new String(characterArray);
		return encryptedString;
	}
	
	public static String decrypt (String input) {
		char[] characterArray = input.toCharArray();
		String cipher = new String(CIPHER);
		
		for (int index = 0; index < characterArray.length; index ++) {
			int correspondingIndex = cipher.indexOf(characterArray[index]);
			characterArray[index] = ALPHABET_STRING.toCharArray()[correspondingIndex];
		}
		
		String decryptedString = new String(characterArray);
		return decryptedString;
	}
}
