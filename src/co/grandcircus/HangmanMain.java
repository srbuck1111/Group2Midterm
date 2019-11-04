package co.grandcircus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HangmanMain {

	public static void main(String[] args) {

		WordTextFile.createOurFile();

		Scanner scnr = new Scanner(System.in);

		List<Word> words = new ArrayList<>();
		List<Player> players = new ArrayList<>();
		Player currentPlayer = null;
		players = PlayerTextFile.getPlayers();
		List<String> missedChars = new ArrayList<>();
		int userNum;
		String userName;
		String returningPlayer;
		String cont = "";
		String userGuess;
		String newWord;

		System.out.println("Welcome to Hangman!");

		returningPlayer = Validator.getString(scnr, "Are you a returning player? (y/n)");
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
			int difficultyChoice = Validator.getInt(scnr,
					"What difficulty would you like to play?\n1.Easy\n2.Medium\n3.Hard", 1, 3);
			words = WordTextFile.readFromFile(difficultyChoice - 1);

			if (difficultyChoice == 1) {
				System.out.println("Typical.");
			}

			Word word = selectWord(words);

			do {
//Start UI
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				
				HangMan.printMan(missedChars.size());

				System.out.println(word.toString());

				System.out.print("missed letters:");
				for (String l : missedChars) {
					System.out.print(" " + l);
				}
				System.out.println("\n");

				userGuess = Validator.getStringMatchingRegex(scnr, "Guess a letter: ", "^[a-zA-Z]");
				System.out.println();

				if (!word.hasChar(userGuess)) {
					missedChars.add(userGuess);
				}
//End UI
			} while (!word.wordCompleted(word) && missedChars.size() < 6);

			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

			HangMan.printMan(missedChars.size());

			System.out.println(word.toString());

			System.out.print("missed letters:");
			for (String l : missedChars) {
				System.out.print(" " + l);
			}
			System.out.println("\n");

			if (missedChars.size() >= 6) {

				System.out.println("You idiot, the word was " + word.toWordString() + ".");
				currentPlayer.addLoss();

			} else {

				System.out.println(
						"Wow. you actually guessed " + "'" + word.toWordString() + "'" + ". Color me suprised.");
				currentPlayer.addWin();

			}

			missedChars.clear();
			word.resetStatus();

			cont = Validator.getString(scnr, "Would you like to play again? (y/n)");

		} while (cont.equalsIgnoreCase("yes") || cont.equalsIgnoreCase("y"));

		newWord = Validator.getStringMatchingRegex(scnr, "Could you help out by giving us a single word: (or enter no if you're uncreative)\n",
				"^[a-zA-Z]{3,}|(no)");
		
		if (!newWord.equals("no")) {
			newWord = newWord.toLowerCase();
		}
		
		WordTextFile.writeWord(new Word(newWord).toWordString());
		PlayerTextFile.writePlayers(players);

		System.out.println("Thank you for playing!");

	}

	public static Word selectWord(List<Word> words) {

		return words.get(Dice.roll(words.size()) - 1);

	}

	public Player selectPlayer() {

		return null;

	}

}
