package co.grandcircus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HangmanMain {

	public static void main(String[] args) {

		Scanner scnr = new Scanner(System.in);

		List<Word> words = new ArrayList<>();
		List<Player> players = new ArrayList<>();
		Player currentPlayer = null;
		words = WordTextFile.readFromFile();
		players = PlayerTextFile.getPlayers();
		words.add(new Word("Hello"));
		List<String> missedChars = new ArrayList<>();
		int userNum;
		String userName;
		String returningPlayer;
		String cont = "";
		String userGuess;
		String newWord;

		System.out.println("Welcome to Hangman!");

		returningPlayer = Validator.getString(scnr, "Are you a returning player? ");
		if (returningPlayer.equalsIgnoreCase("Yes") || returningPlayer.equalsIgnoreCase("y")) {
			for (int i = 0; i < players.size(); i++) {
				System.out.println((i + 1) + ". " + players.get(i).toPlayer());

			}
			userNum = Validator.getInt(scnr,
					"Welcome back! what was your username? Please enter the corresponding number:  ", 1,
					players.size());
			currentPlayer = players.get(userNum - 1);
			System.out.println();
		} else {
			userName = Validator.getString(scnr, "What would you like me to call you? ");
			currentPlayer = new Player(userName);
			players.add(currentPlayer);
			System.out.println("Welcome " + userName);
		}

		do {

			Word word = selectWord(words);
			System.out.println("Word: " + word.toString());

			do {

				userGuess = Validator.getStringMatchingRegex(scnr, "Guess a letter: ", "^[a-zA-Z]");

				if (!word.hasChar(userGuess)) {
					missedChars.add(userGuess);
				}

				System.out.println(word.toString());

				System.out.println(missedChars);

			} while (!word.wordCompleted(word) && missedChars.size() < 6);

			if (missedChars.size() >= 6) {

				System.out.println("You idiot, the word was " + word.toWordString() + ".");
				currentPlayer.addLoss();

			} else {

				currentPlayer.addWin();

			}

			missedChars.clear();
			word.resetStatus();

			cont = Validator.getString(scnr, "Would you like to play again? (y/n)");

		} while (cont.equalsIgnoreCase("yes") || cont.equalsIgnoreCase("y"));

		newWord = Validator.getString(scnr, "Could you help out by giving us a single word:\n");
		newWord = newWord.toLowerCase();

		WordTextFile.writeWord(new Word(newWord).toWordString());
		PlayerTextFile.writePlayers(players);

		System.out.println("Thank you for playing!");

	}

	public static Word selectWord(List<Word> words) {

		return words.get(Dice.roll(words.size() - 1));

	}

	public Player selectPlayer() {

		return null;

	}

}
