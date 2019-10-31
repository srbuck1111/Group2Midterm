package co.grandcircus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HangmanMain {

	public static void main(String[] args) {

		Scanner scnr = new Scanner(System.in);

		List<Word> words = new ArrayList<>();
		List<Player> players = new ArrayList<>();
		players.add(new Player("swithin", 2, 3));
		players.add(new Player("sean", 2, 3));
		players.add(new Player("brandon", 2, 3));
		List<Character> missedChars = new ArrayList<>();
		int userNum;
		String userName;
		String returningPlayer;
		String cont = "";

		System.out.println("Welcome to Hangman!");

		returningPlayer = Validator.getString(scnr, "Are you a returning player? ");
		if (returningPlayer.equalsIgnoreCase("Yes") || returningPlayer.equalsIgnoreCase("y")) {
			for (int i = 0; i < players.size(); i++) {
				System.out.println((i + 1) + ". " + players.get(i));
			}
			userNum = Validator.getInt(scnr,
					"Welcome back! what was your username? Please enter the corresponding number:  ", 1,
					players.size());
			System.out.println();
		} else {
			userName = Validator.getString(scnr, "What would you like me to call you? ");
			players.add(new Player(userName));
			System.out.println("Welcome " + userName);
		}
		do {

			cont = Validator.getString(scnr, "Would you like to play again? (y/n)");

		} while (cont.equalsIgnoreCase("yes") || cont.equalsIgnoreCase("y"));

		System.out.println("Thank you for playing!");

	}

	public Word selectWord() {

		return null;

	}

	public Player selectPlayer() {

		return null;

	}

}
