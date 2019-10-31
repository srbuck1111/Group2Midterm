package co.grandcircus;

import java.util.Arrays;

public class Word {

	private char[] characters;

	public Word(String word) {
		super();
		this.characters = word.toCharArray();
	}
	
	public boolean hasChar() {
		
		return false;
		
	}
	
	public boolean charFound() {
		
		return false;
		
	}
	
	public boolean wordCompleted() {
		
		return false;
		
	}

	@Override
	public String toString() {
		return "Word [characters=" + Arrays.toString(characters) + "]";
	}
	
}
