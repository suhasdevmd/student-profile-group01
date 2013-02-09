package iiitb.student.service;

public class Encryptor {
	public static String encrypt(String input) {
		int increment = 1;
		byte[] characters = input.getBytes();
		String encrypted = "";

		for (int i = 0; i < characters.length; i++) {
			characters[i] += (increment++);
			encrypted += (characters[i] < 100) ? ("0" + characters[i])
					: characters[i];
		}
		return encrypted;
	}

	public static String decrypt(String input) {
		int decrement = 1;
		String decrypted = "";
		char character;

		for (int i = 0; i < input.length(); i += (int) Math.exp(1.1)) {
			character = (char) Integer.parseInt(input.substring(i, i
					+ (int) Math.exp(1.1)));
			character -= (decrement++);
			decrypted += character;
		}
		return decrypted;
	}

	
}
