package co.grandcircus;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class WordTextFile {

	ArrayList<Word> getWords = new ArrayList<>();

	// Array to hold different level difficulty file names
	static String[] fileNamesArr = { "Words.txt", "mediumwords.txt", "hardwords.txt" };

	public static void createOurFile() {

		String fileName = "";

		// Creates file on user's computer if it doesn't already exist, depending on difficulty level.
		for (int i = 0; i <= 2; i++) {
			fileName = fileNamesArr[i];

			Path path = Paths.get(fileName);

			if (Files.notExists(path)) {
				try {
					Files.createFile(path);
					System.out.println("The file was created successfully");
				} catch (IOException e) {
					System.out.println("Something went wrong...file not created.");
				}
			} else {

			}
		}
	}

	// Writes to corresponding word text file based on difficulty level
	public static void writeWord(String word) {
		Word wordObj = new Word(word);
		String fileName = getDifficultyFileName(wordObj.getDifficulty());
		Path path1 = Paths.get(fileName);

		File file = path1.toFile();
		PrintWriter output = null;

		try {
			output = new PrintWriter(new FileOutputStream(file, true));
			output.println(word);
			output.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found. Creating file.");
			createOurFile();
		} finally {
			output.close();
		}

	}

//Reads from corresponding word files depending on difficulty level selected
	public static ArrayList<Word> readFromFile(int intDiff) {
		ArrayList<Word> wordsInFile = new ArrayList<>();

		String fileName = fileNamesArr[intDiff];
		Path path = Paths.get(fileName);
		File file = path.toFile();

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			while (line != null) {
				wordsInFile.add(new Word(line));
				line = br.readLine();

			}
			br.close();

		} catch (FileNotFoundException e) {
			System.out.println("Something went wrong with the file");
		} catch (IOException e) {
			System.out.println("Something went wrong when we tried to read from the file");
		} finally {

		}
		return wordsInFile;

	}

	// Returns difficulty file name based on difficulty level
	public static String getDifficultyFileName(int difficulty) {

		String fileName = "";
		if (difficulty == 0) {
			fileName = "Words.txt";
		} else if (difficulty == 1) {
			fileName = "mediumwords.txt";
		} else if (difficulty == 2) {
			fileName = "hardwords.txt";

		}

		return fileName;
	}

}
