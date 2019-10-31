package co.grandcircus;

public class Letter {
	
	private char letter;
	private boolean found;
	
	public Letter(char letter) {
		this.letter = letter;
		found = false;
	}
	
	public char getLetter() {
		return letter;
	}

	public void setLetter(char letter) {
		this.letter = letter;
	}

	public boolean isFound() {
		return found;
	}

	public void setFound(boolean found) {
		this.found = found;
	}
	
}
