package fiuba.algo3.ejemplo1;

public class CharCounter {

	private String word;

	public CharCounter(String word) {
		this.word = word;
	}

	public int howMany(char character) {
		int count = 0;

		if (character == '$') {
			return -1;
		} else if (character == '@') {
			return -2;
		}

		for (int i = 0; i < word.length(); i++) {
			char charAt = word.charAt(i);
			if (charAt == character) {
				count++;
			}
		}
		return count;
	}
}