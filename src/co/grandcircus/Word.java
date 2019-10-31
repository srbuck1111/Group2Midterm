package co.grandcircus;

import java.util.Arrays;

public class Word {

	private char[] characters;

	public Word(String word) {
		super();
		this.characters = word.toCharArray();
	}
	
	public boolean hasChar(char c) {
		
		return false;
		
	}
	
	public boolean charFound(char c) {
		
		return false;
		
	}
	
	public boolean wordCompleted(Word word) {
		
		return false;
		
	}

	@Override
	public String toString() {

		String word = "";
		
		for (char c : characters) {
			
			if (charFound(c)) {
				
				word += c + " ";
				
			} else {
				
				word += "_ ";
				
			}
			
		}
		
		return word;
		
	}
	
}
