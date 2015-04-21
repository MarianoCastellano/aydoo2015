package fiuba.algo3.ejemplo1;

import java.util.HashMap;

public class CharCounter {

	private String stringToAnalyze;
	private char[] abc = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
			'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
			'x', 'y', 'z' };

	public CharCounter(String stringToAnalyze) {
		this.stringToAnalyze = stringToAnalyze;
	}

	public int howMany(char character) {
		int count = 0;

		if (character == '$') {
			return -1;
		} else if (character == '@') {
			return -2;
		}

		for (int i = 0; i < stringToAnalyze.length(); i++) {
			char charAtString = stringToAnalyze.charAt(i);
			if (charAtString == character) {
				count++;
			}
		}
		return count;
	}

	public HashMap<Character, Integer> countAll() {
		HashMap<Character, Integer> countAll = new HashMap<Character, Integer>();

		for (int i = 0; i < abc.length; i++) {
			char charAtAbc = abc[i];
			Integer occurrence = this.howMany(charAtAbc);
			countAll.put(charAtAbc, occurrence);
		}

		return countAll;
	}
}