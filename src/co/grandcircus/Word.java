package co.grandcircus;

import java.util.ArrayList;

public class Word {

	private ArrayList<Letter> characters = new ArrayList<>();;

	public Word() {
		super();
	}
	
	public Word(String word) {
		super();
		
		char[] wordArr = word.toCharArray();
		
		for (char c : wordArr) {
			
			characters.add(new Letter(c));
			
		}

	}
	
	public void hasChar(String s) {
		
		char c = s.charAt(0);
		
		for (Letter i : characters) {
			
			if (c == i.getLetter()) {
				
				i.setFound(true);;
				
			}
			
		}
		
	}
	
	public boolean wordCompleted(Word word) {
		
		for (Letter c: characters) {
			
			if (!c.isFound()) {
				
				return false;
				
			}
			
		}
		
		return true;
		
	}

	@Override
	public String toString() {

		String word = "";
		
		for (Letter c : characters) {
			
			if (c.isFound()) {
				
				word += c + " ";
				
			} else {
				
				word += "_ ";
				
			}
			
		}
		
		return word;
		
	}
	
}
