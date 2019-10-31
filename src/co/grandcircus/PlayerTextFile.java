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
import java.util.List;

public class PlayerTextFile {

	public static void createOurPlayerFile() {

		String fileName = "Players.txt";
		Path path = Paths.get(fileName);

		if (Files.notExists(path)) {
			try {
				Files.createFile(path);
				System.out.println("The file was created successfully");
			} catch (IOException e) {
				System.out.println("Something went wrong...file not created");
			}
		} else {
			System.out.println("The file already exists!");
		}

	}

	public static void writePlayers(List<Player> players) {

		String fileName = "Players.txt";
		Path path1 = Paths.get(fileName);

		File file = path1.toFile();
		PrintWriter output = null;

		try {
			output = new PrintWriter(new FileOutputStream(file, false));
			for (Player p : players) {
				output.println(p);
			}
			output.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found. Creating file.");
			createOurPlayerFile();
		} finally {
			output.close();
		}
	}

	public static ArrayList<Player> getPlayers() {
		ArrayList<Player> playersInFile = new ArrayList<>();
		String fileName = "Players.txt";
		Path path = Paths.get(fileName);
		File file = path.toFile();

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			while (line != null) {
				playersInFile.add(converStringToPlayer(line));
				line = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("File not found. Creating file.");
			createOurPlayerFile();
		} catch (IOException e) {

		} finally {

		}
		return playersInFile;
	}

// need to add players input to the list
	public static Player converStringToPlayer(String p) {
		String[] pArr = p.split(",");
		return new Player(pArr[0], Integer.parseInt(pArr[1]), Integer.parseInt(pArr[2]));
	}
}