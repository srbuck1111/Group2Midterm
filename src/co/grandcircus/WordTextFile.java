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

	public static void createOurFile() {

		String fileName = "Words.txt";
		Path path = Paths.get(fileName);

		if (Files.notExists(path)) {
			try {
				Files.createFile(path);
				System.out.println("The file was created successfully");
			} catch (IOException e) {
				System.out.println("Something went wrong...file not created.");
			}
		} else {
			System.out.println("The file already exists!");
		}

	}

	public static void writeWord(Word word) {

		String fileName = "Words.txt";
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

	public static ArrayList<Word> readFromFile() {
		ArrayList<Word> wordsInFile = new ArrayList<>();
		String fileName = "Words.txt";
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
			createOurFile();
		} catch (IOException e) {
			System.out.println("Something went wrong when we tried to read from the file");
		} finally {

		}
		return wordsInFile;

	}
}
