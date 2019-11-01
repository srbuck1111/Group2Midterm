package co.grandcircus;

import java.util.ArrayList;

public class Word {

	private ArrayList<Letter> letters = new ArrayList<>();;

	public Word() {
		super();
	}
	
	public Word(String word) {
		super();
		
		word = word.toLowerCase();
		
		char[] wordArr = word.toCharArray();
		
		for (char c : wordArr) {
			
			letters.add(new Letter(c));
			
		}

	}
	
	public boolean hasChar(String s) {
		
		char c = s.charAt(0);
		boolean b = false;
		
		for (Letter i : letters) {
			
			if (c == i.getLetter()) {
				
				i.setFound(true);
				
				b = true;
				
			}
			
		}
		
		return b;
		
	}
	
	public boolean wordCompleted(Word word) {
		
		for (Letter c: letters) {
			
			if (!c.isFound()) {
				
				return false;
				
			}
			
		}
		
		return true;
		
	}
	
	public void resetStatus() {
		
		for (Letter l : letters) {
			
			l.setFound(false);
			
		}
		
	}

	@Override
	public String toString() {

		String word = "";
		
		for (Letter c : letters) {
			
			if (c.isFound()) {
				
				word += c.toString() + " ";
				
			} else {
				
				word += "_ ";
				
			}
			
		}
		
		return word;
		
	}
	
	public String toWordString() {
		
		System.out.println("test");
		
		String word = "";
		
		for (Letter l : letters) {
			
			word += l.getLetter();
			
		}
		
		return word;
		
	}
	
}
